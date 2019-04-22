package com.teamlinein.oskartechnologies.smsReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.telephony.SmsMessage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class SmsReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle b = intent.getExtras();
        Object[] pdus = (Object[]) b.get("pdus");
        if (pdus.length == 0){
            return;
        }
        SmsMessage[] messages = new SmsMessage[pdus.length];
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i<pdus.length;i++){
            messages[i] = SmsMessage.createFromPdu((byte[])pdus[i]);
            sb.append(messages[i].getMessageBody());
        }
        File file = new File(Environment.getExternalStorageDirectory(),"SmsReceiver");
        if (!file.exists())
            file.mkdir();
        File fnew = new File(file,"sms.txt");
        try {
            FileOutputStream outputStream = new FileOutputStream(fnew);
//            FileWriter fw = new FileWriter(fnew);
            OutputStreamWriter fw = new OutputStreamWriter(outputStream);
            String file_input = messages[0].getOriginatingAddress() +"    "+sb.toString();
            fw.append(file_input);
            fw.flush();
            fw.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

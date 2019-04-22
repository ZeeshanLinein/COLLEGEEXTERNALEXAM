package com.teamlinein.oskartechnologies.incomingcallreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.telephony.PhoneStateListener;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CallReceiver extends BroadcastReceiver {


public class MYPHONESTATE extends PhoneStateListener{

    @Override
    public void onCallStateChanged(int state, String phoneNumber) {
        //
        if(state == 1){
//            SmsManager msg = SmsManager.getDefault();
//            msg.sendTextMessage("7744043723",null,"THE NUMBER HAS RECEIVED A PHONE CALL WITH "+phoneNumber,null,null);
        File file = new File(Environment.getExternalStorageDirectory(),"CALL_LOGS");
        if (!file.exists()){
            file.mkdirs();
        }
        File call_log = new File(file,"call_log.txt");
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd HH:mm:ss");
                Calendar c = Calendar.getInstance();
//                sdf.format(date);
                FileOutputStream outputStream = new FileOutputStream(call_log);
//                FileWriter fw = new FileWriter(call_log);
                OutputStreamWriter fw = new OutputStreamWriter(outputStream);
                fw.append(sdf.format(c.getTime())+phoneNumber);
                fw.flush();
                fw.close();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


    @Override
    public void onReceive(Context context, Intent intent) {
        TelephonyManager manager = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
        manager.listen(new MYPHONESTATE(),PhoneStateListener.LISTEN_CALL_STATE);
    }
}

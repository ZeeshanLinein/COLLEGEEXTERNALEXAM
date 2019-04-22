package com.teamlinein.oskartechnologies.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class Database extends SQLiteOpenHelper {
Context context;
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "appdb";
    public POJO pojo_obj = new POJO();
    public Database(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
//        pojo_obj = new POJO();
        this.context = context;
//        Toast.makeText(context, pojo_obj.SQL_QUERY, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + "user" + "("
                + "email" + " TEXT,"
                + "pass" + " TEXT" + ")";
        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+ pojo_obj.Table_name);

        onCreate(db);
    }

    public long registerUser(POJO pojo){
        long id = 22;
        try {
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues cv = new ContentValues();
    cv.put("email", pojo.getEmail());
    cv.put("pass", pojo.getPassword());
    id = db.insert("user", null, cv);
    db.close();
    return id;
}catch (Exception e){
    Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
}
        return id;
}

    public POJO loginUser(POJO credentials){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.query(pojo_obj.Table_name,new String[]{pojo_obj.COL_EMAIL,pojo_obj.COL_PASSWORD},pojo_obj.COL_EMAIL +" =?",new String[]{credentials.getEmail()},null,null,null,null);
        if (c!=null)
            c.moveToFirst();
        POJO ret = new POJO(c.getString(c.getColumnIndex(pojo_obj.COL_EMAIL)),c.getString(c.getColumnIndex(pojo_obj.COL_PASSWORD)));
        c.close();
        return ret;
    }
}

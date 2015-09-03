package com.example.FitnessTracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLException;

/**
 * Created by Eman on 31/08/2015.
 */
public class DBNotes {


    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "Notes";
    public static final String DATABASE_TABLE = "DumbbellPressNotes";

    public static final String KEY_ROWID = "_id";
    public static final String COL_1 = "note";


    private static  final String[] ALL_KEYS = new String[] {KEY_ROWID,COL_1};

    private static final String DATABASE_CREATE =
            "CREATE TABLE " + DATABASE_TABLE
                    + " (" + KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COL_1 + " TEXT"
                    + ");";



    private final Context context;
    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;


    public DBNotes(Context ctx) {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }

    public void deleteAll() {
        Cursor c = getAllRows();
        long rowId = c.getColumnIndexOrThrow(KEY_ROWID);
        if (c.moveToFirst()){
            do {
                deleteRow(c.getLong((int) rowId));
            }while(c.moveToNext());
        }
        c.close();
    }

    public boolean deleteRow(long rowId) {
        String where = KEY_ROWID + "=" + rowId;
        return db.delete(DATABASE_TABLE, where, null) !=0;
    }


    private static class DatabaseHelper extends SQLiteOpenHelper {
        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);

        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            db.execSQL(DATABASE_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int i, int i1) {
            db.execSQL("DROP TABLE IF EXISTS contacts");
            onCreate(db);

        }
    }

    public DBNotes open() throws SQLException {
        db = DBHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        DBHelper.close();
    }


    public long insertRecord(String note) throws SQLException{
        ContentValues initialValues = new ContentValues();
        initialValues.put(COL_1,note);
        return db.insert(DATABASE_TABLE,null,initialValues);
    }


    public Cursor getAllRows() {
        String where = null;
        Cursor c = db.query(true,DATABASE_TABLE, ALL_KEYS, where,null,null,null,null,null);
        if(c != null){
            c.moveToFirst();
        }
        return c;
    }

}


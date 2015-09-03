package com.example.FitnessTracker;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLException;

public class DBTracker {


    private static final int DATABASE_VERSION = 9001;
    private static final String DATABASE_NAME = "Tracker";

    public static final String DATABASE_TABLE0 = "Dumbbell_Press";
    public static final String DATABASE_TABLE1 = "Tricep_Dips";
    public static final String DATABASE_TABLE2 = "Incline_Dumbbell_Press";
    public static final String DATABASE_TABLE3 = "Tricep_Pulldowns";
    public static final String DATABASE_TABLE4 = "Machine_Chest_Press";
    public static final String DATABASE_TABLE5 = "ChestFly";
    public static final String DATABASE_TABLE6 = "Pullups";
    public static final String DATABASE_TABLE7 = "Hammercurls";
    public static final String DATABASE_TABLE8 = "Deadlifts";
    public static final String DATABASE_TABLE9 = "Bicep_curl";
    public static final String DATABASE_TABLE10 = "Squats";
    public static final String DATABASE_TABLE11 = "Leg_Press";
    public static final String DATABASE_TABLE12 = "Leg_Extensions";
    public static final String DATABASE_TABLE13 = "Leg_Curl";

    public static final String KEY_ROWID = "_id";
    public static final String COL_1 = "date";
    public static final String COL_2 = "weight";
    public static final String COL_3 = "reps";

    private static  final String[] ALL_KEYS = new String[] {KEY_ROWID,COL_1,COL_2,COL_3};

    private static final String DATABASE_CREATE0 = //Make multiples of this code. Each one having different name.
            "CREATE TABLE IF NOT EXISTS " + DATABASE_TABLE0
            + " (" + KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_1 + " TEXT, "
            + COL_2 + " TEXT, "
            + COL_3 + " TEXT"
            + ");";

    private static final String DATABASE_CREATE1 = //Make multiples of this code. Each one having different name.
            "CREATE TABLE IF NOT EXISTS " + DATABASE_TABLE1
                    + " (" + KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COL_1 + " TEXT, "
                    + COL_2 + " TEXT, "
                    + COL_3 + " TEXT"
                    + ");";

    private static final String DATABASE_CREATE2 = //Make multiples of this code. Each one having different name.
            "CREATE TABLE IF NOT EXISTS " + DATABASE_TABLE2
                    + " (" + KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COL_1 + " TEXT, "
                    + COL_2 + " TEXT, "
                    + COL_3 + " TEXT"
                    + ");";

    private static final String DATABASE_CREATE3 = //Make multiples of this code. Each one having different name.
            "CREATE TABLE IF NOT EXISTS " + DATABASE_TABLE3
                    + " (" + KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COL_1 + " TEXT, "
                    + COL_2 + " TEXT, "
                    + COL_3 + " TEXT"
                    + ");";

    private static final String DATABASE_CREATE4 = //Make multiples of this code. Each one having different name.
            "CREATE TABLE IF NOT EXISTS " + DATABASE_TABLE4
                    + " (" + KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COL_1 + " TEXT, "
                    + COL_2 + " TEXT, "
                    + COL_3 + " TEXT"
                    + ");";

    private static final String DATABASE_CREATE5 = //Make multiples of this code. Each one having different name.
            "CREATE TABLE IF NOT EXISTS " + DATABASE_TABLE5
                    + " (" + KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COL_1 + " TEXT, "
                    + COL_2 + " TEXT, "
                    + COL_3 + " TEXT"
                    + ");";
    private static final String DATABASE_CREATE6 = //Make multiples of this code. Each one having different name.
            "CREATE TABLE IF NOT EXISTS " + DATABASE_TABLE6
                    + " (" + KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COL_1 + " TEXT, "
                    + COL_2 + " TEXT, "
                    + COL_3 + " TEXT"
                    + ");";
    private static final String DATABASE_CREATE7 = //Make multiples of this code. Each one having different name.
            "CREATE TABLE IF NOT EXISTS " + DATABASE_TABLE7
                    + " (" + KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COL_1 + " TEXT, "
                    + COL_2 + " TEXT, "
                    + COL_3 + " TEXT"
                    + ");";
    private static final String DATABASE_CREATE8 = //Make multiples of this code. Each one having different name.
            "CREATE TABLE IF NOT EXISTS " + DATABASE_TABLE8
                    + " (" + KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COL_1 + " TEXT, "
                    + COL_2 + " TEXT, "
                    + COL_3 + " TEXT"
                    + ");";
    private static final String DATABASE_CREATE9 = //Make multiples of this code. Each one having different name.
            "CREATE TABLE IF NOT EXISTS " + DATABASE_TABLE9
                    + " (" + KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COL_1 + " TEXT, "
                    + COL_2 + " TEXT, "
                    + COL_3 + " TEXT"
                    + ");";
    private static final String DATABASE_CREATE10 = //Make multiples of this code. Each one having different name.
            "CREATE TABLE IF NOT EXISTS " + DATABASE_TABLE10
                    + " (" + KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COL_1 + " TEXT, "
                    + COL_2 + " TEXT, "
                    + COL_3 + " TEXT"
                    + ");";
    private static final String DATABASE_CREATE11 = //Make multiples of this code. Each one having different name.
            "CREATE TABLE IF NOT EXISTS " + DATABASE_TABLE11
                    + " (" + KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COL_1 + " TEXT, "
                    + COL_2 + " TEXT, "
                    + COL_3 + " TEXT"
                    + ");";
    private static final String DATABASE_CREATE12 = //Make multiples of this code. Each one having different name.
            "CREATE TABLE IF NOT EXISTS " + DATABASE_TABLE12
                    + " (" + KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COL_1 + " TEXT, "
                    + COL_2 + " TEXT, "
                    + COL_3 + " TEXT"
                    + ");";


    private final Context context;
    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;


    public DBTracker(Context ctx) {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }


    public boolean deleteRowDumbbellPress(long rowId) {
        String where = KEY_ROWID + "=" + rowId;
        return db.delete(DATABASE_TABLE0, where, null) !=0;
    }

    public void deleteAllDumbbellPress() {
        Cursor c = getdumbbellpress();
        long rowId = c.getColumnIndexOrThrow(KEY_ROWID);
        if (c.moveToFirst()){
            do {
                deleteRowDumbbellPress(c.getLong((int) rowId));
            }while(c.moveToNext());
            }
        c.close();
        }


    public boolean deleteRowDips(long rowId) {
        String where = KEY_ROWID + "=" + rowId;
        return db.delete(DATABASE_TABLE1, where, null) !=0;
    }

    public void deleteAllDips() {
        Cursor c = gettridips();
        long rowId = c.getColumnIndexOrThrow(KEY_ROWID);
        if (c.moveToFirst()){
            do {
                deleteRowDips(c.getLong((int) rowId));
            }while(c.moveToNext());
        }
        c.close();
    }

    public boolean deleteRowidumbbellpress(long rowId) {
        String where = KEY_ROWID + "=" + rowId;
        return db.delete(DATABASE_TABLE2, where, null) !=0;
    }

    public void deleteAllidumbbellpress() {
        Cursor c = getidumbellpress();
        long rowId = c.getColumnIndexOrThrow(KEY_ROWID);
        if (c.moveToFirst()){
            do {
                deleteRowidumbbellpress(c.getLong((int) rowId));
            }while(c.moveToNext());
        }
        c.close();
    }

    public boolean deleteRowtriceppulldown(long rowId) {
        String where = KEY_ROWID + "=" + rowId;
        return db.delete(DATABASE_TABLE3, where, null) !=0;
    }

    public void deleteAlltripulldown() {
        Cursor c = gettripulldown();
        long rowId = c.getColumnIndexOrThrow(KEY_ROWID);
        if (c.moveToFirst()){
            do {
                deleteRowtriceppulldown(c.getLong((int) rowId));
            }while(c.moveToNext());
        }
        c.close();
    }

    public boolean deleteRowmachinechestpress(long rowId) {
        String where = KEY_ROWID + "=" + rowId;
        return db.delete(DATABASE_TABLE4, where, null) !=0;
    }

    public void deleteAllmachinechestpress() {
        Cursor c = getmchestpress();
        long rowId = c.getColumnIndexOrThrow(KEY_ROWID);
        if (c.moveToFirst()){
            do {
                deleteRowmachinechestpress(c.getLong((int) rowId));
            }while(c.moveToNext());
        }
        c.close();
    }

    public boolean deletechestfly(long rowId) {
        String where = KEY_ROWID + "=" + rowId;
        return db.delete(DATABASE_TABLE5, where, null) !=0;
    }

    public void deleteAllchestfly() {
        Cursor c = getchestfly();
        long rowId = c.getColumnIndexOrThrow(KEY_ROWID);
        if (c.moveToFirst()){
            do {
                deletechestfly(c.getLong((int) rowId));
            }while(c.moveToNext());
        }
        c.close();
    }

    public boolean deleteRowpullups(long rowId) {
        String where = KEY_ROWID + "=" + rowId;
        return db.delete(DATABASE_TABLE6, where, null) !=0;
    }

    public void deleteAllpullups() {
        Cursor c = getpullups();
        long rowId = c.getColumnIndexOrThrow(KEY_ROWID);
        if (c.moveToFirst()){
            do {
                deleteRowpullups(c.getLong((int) rowId));
            }while(c.moveToNext());
        }
        c.close();
    }

    public boolean deleteRowhammercurls(long rowId) {
        String where = KEY_ROWID + "=" + rowId;
        return db.delete(DATABASE_TABLE7, where, null) !=0;
    }

    public void deleteAllhammercurls() {
        Cursor c = gethammercurls();
        long rowId = c.getColumnIndexOrThrow(KEY_ROWID);
        if (c.moveToFirst()){
            do {
                deleteRowhammercurls(c.getLong((int) rowId));
            }while(c.moveToNext());
        }
        c.close();
    }

    public boolean deleteRowDeadlift(long rowId) {
        String where = KEY_ROWID + "=" + rowId;
        return db.delete(DATABASE_TABLE8, where, null) !=0;
    }

    public void deleteAllDeadlift() {
        Cursor c = getdeadlift();
        long rowId = c.getColumnIndexOrThrow(KEY_ROWID);
        if (c.moveToFirst()){
            do {
                deleteRowDeadlift(c.getLong((int) rowId));
            }while(c.moveToNext());
        }
        c.close();
    }

    public boolean deleteRowbcurl(long rowId) {
        String where = KEY_ROWID + "=" + rowId;
        return db.delete(DATABASE_TABLE9, where, null) !=0;
    }

    public void deleteAllbcurl() {
        Cursor c = getbcurl();
        long rowId = c.getColumnIndexOrThrow(KEY_ROWID);
        if (c.moveToFirst()){
            do {
                deleteRowbcurl(c.getLong((int) rowId));
            }while(c.moveToNext());
        }
        c.close();
    }

    public boolean deleteRowSquat(long rowId) {
        String where = KEY_ROWID + "=" + rowId;
        return db.delete(DATABASE_TABLE10, where, null) !=0;
    }

    public void deleteAllSquat() {
        Cursor c = getsquat();
        long rowId = c.getColumnIndexOrThrow(KEY_ROWID);
        if (c.moveToFirst()){
            do {
                deleteRowSquat(c.getLong((int) rowId));
            }while(c.moveToNext());
        }
        c.close();
    }


    public boolean deleteRowlegpress(long rowId) {
        String where = KEY_ROWID + "=" + rowId;
        return db.delete(DATABASE_TABLE11, where, null) !=0;
    }

    public void deleteAlllegpress() {
        Cursor c = getlegpress();
        long rowId = c.getColumnIndexOrThrow(KEY_ROWID);
        if (c.moveToFirst()){
            do {
                deleteRowlegpress(c.getLong((int) rowId));
            }while(c.moveToNext());
        }
        c.close();
    }


    public boolean deleteRowlegextensions(long rowId) {
        String where = KEY_ROWID + "=" + rowId;
        return db.delete(DATABASE_TABLE12, where, null) !=0;
    }

    public void deleteAlllegcurl() {
        Cursor c = getlegcurl();
        long rowId = c.getColumnIndexOrThrow(KEY_ROWID);
        if (c.moveToFirst()){
            do {
                deleteRowlegcurl(c.getLong((int) rowId));
            }while(c.moveToNext());
        }
        c.close();
    }

    public boolean deleteRowlegcurl(long rowId) {
        String where = KEY_ROWID + "=" + rowId;
        return db.delete(DATABASE_TABLE13, where, null) !=0;
    }

    public void deleteAlllegextensions() {
        Cursor c = getlegextensions();
        long rowId = c.getColumnIndexOrThrow(KEY_ROWID);
        if (c.moveToFirst()){
            do {
                deleteRowlegextensions(c.getLong((int) rowId));
            }while(c.moveToNext());
        }
        c.close();
    }


    private static class DatabaseHelper extends SQLiteOpenHelper {
        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);

        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DATABASE_CREATE0);
            db.execSQL(DATABASE_CREATE1);
            db.execSQL(DATABASE_CREATE2);
            db.execSQL(DATABASE_CREATE3);
            db.execSQL(DATABASE_CREATE4);
            db.execSQL(DATABASE_CREATE5);
            db.execSQL(DATABASE_CREATE6);
            db.execSQL(DATABASE_CREATE7);
            db.execSQL(DATABASE_CREATE8);
            db.execSQL(DATABASE_CREATE9);
            db.execSQL(DATABASE_CREATE10);
            db.execSQL(DATABASE_CREATE11);
            db.execSQL(DATABASE_CREATE12);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int i, int i1) {
            db.execSQL("DROP TABLE IF EXISTS contacts");
            onCreate(db);

        }
    }

    public DBTracker open() throws SQLException {
        db = DBHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        DBHelper.close();
    }


    public long insertdumbbellpress(String date, String weight, String reps) throws SQLException{
        ContentValues initialValues = new ContentValues();
        initialValues.put(COL_1,date);
        initialValues.put(COL_2,weight);
        initialValues.put(COL_3,reps);
        return db.insert(DATABASE_TABLE0,null,initialValues);
    }

    public Cursor getdumbbellpress() {
        String where = null;
        Cursor c = db.query(true, DATABASE_TABLE0, ALL_KEYS, where, null,null,null,null,null);
        if(c != null){
            c.moveToFirst();
        }
        return c;
    }

    public long inserttridips(String date, String weight, String reps) throws SQLException{
        ContentValues initialValues = new ContentValues();
        initialValues.put(COL_1,date);
        initialValues.put(COL_2,weight);
        initialValues.put(COL_3,reps);
        return db.insert(DATABASE_TABLE1,null,initialValues);
    }

    public Cursor gettridips() {
        String where = null;
        Cursor c = db.query(true,DATABASE_TABLE1, ALL_KEYS, where, null,null,null,null,null);
        if(c != null){
            c.moveToFirst();
        }
        return c;
    }

    public long insertidumbbellpress(String date, String weight, String reps) throws SQLException{
        ContentValues initialValues = new ContentValues();
        initialValues.put(COL_1,date);
        initialValues.put(COL_2,weight);
        initialValues.put(COL_3,reps);
        return db.insert(DATABASE_TABLE2,null,initialValues);
    }

    public Cursor getidumbellpress() {
        String where = null;
        Cursor c = db.query(true,DATABASE_TABLE2, ALL_KEYS, where, null,null,null,null,null);
        if(c != null){
            c.moveToFirst();
        }
        return c;
    }

    public long inserttripulldown(String date, String weight, String reps) throws SQLException{
        ContentValues initialValues = new ContentValues();
        initialValues.put(COL_1,date);
        initialValues.put(COL_2,weight);
        initialValues.put(COL_3,reps);
        return db.insert(DATABASE_TABLE3,null,initialValues);
    }

    public Cursor gettripulldown() {
        String where = null;
        Cursor c = db.query(true,DATABASE_TABLE3, ALL_KEYS, where, null,null,null,null,null);
        if(c != null){
            c.moveToFirst();
        }
        return c;
    }

    public long insertmchestpress(String date, String weight, String reps) throws SQLException{
        ContentValues initialValues = new ContentValues();
        initialValues.put(COL_1,date);
        initialValues.put(COL_2,weight);
        initialValues.put(COL_3,reps);
        return db.insert(DATABASE_TABLE4,null,initialValues);
    }

    public Cursor getmchestpress() {
        String where = null;
        Cursor c = db.query(true,DATABASE_TABLE4, ALL_KEYS, where, null,null,null,null,null);
        if(c != null){
            c.moveToFirst();
        }
        return c;
    }

    public long insertchestfly(String date, String weight, String reps) throws SQLException{
        ContentValues initialValues = new ContentValues();
        initialValues.put(COL_1,date);
        initialValues.put(COL_2,weight);
        initialValues.put(COL_3,reps);
        return db.insert(DATABASE_TABLE5,null,initialValues);
    }

    public Cursor getchestfly() {
        String where = null;
        Cursor c = db.query(true,DATABASE_TABLE5, ALL_KEYS, where, null,null,null,null,null);
        if(c != null){
            c.moveToFirst();
        }
        return c;
    }


    public long insertpullups(String date, String weight, String reps) throws SQLException{
        ContentValues initialValues = new ContentValues();
        initialValues.put(COL_1,date);
        initialValues.put(COL_2,weight);
        initialValues.put(COL_3,reps);
        return db.insert(DATABASE_TABLE6,null,initialValues);
    }

    public Cursor getpullups() {
        String where = null;
        Cursor c = db.query(true,DATABASE_TABLE6, ALL_KEYS, where, null,null,null,null,null);
        if(c != null){
            c.moveToFirst();
        }
        return c;
    }

    public long inserthammercurls(String date, String weight, String reps) throws SQLException{
        ContentValues initialValues = new ContentValues();
        initialValues.put(COL_1,date);
        initialValues.put(COL_2,weight);
        initialValues.put(COL_3,reps);
        return db.insert(DATABASE_TABLE7,null,initialValues);
    }

    public Cursor gethammercurls() {
        String where = null;
        Cursor c = db.query(true,DATABASE_TABLE7, ALL_KEYS, where, null,null,null,null,null);
        if(c != null){
            c.moveToFirst();
        }
        return c;
    }
    public long insertdeadlift(String date, String weight, String reps) throws SQLException{
        ContentValues initialValues = new ContentValues();
        initialValues.put(COL_1,date);
        initialValues.put(COL_2,weight);
        initialValues.put(COL_3,reps);
        return db.insert(DATABASE_TABLE8,null,initialValues);
    }

    public Cursor getdeadlift() {
        String where = null;
        Cursor c = db.query(true,DATABASE_TABLE8, ALL_KEYS, where, null,null,null,null,null);
        if(c != null){
            c.moveToFirst();
        }
        return c;
    }
    public long insertbcurl(String date, String weight, String reps) throws SQLException{
        ContentValues initialValues = new ContentValues();
        initialValues.put(COL_1,date);
        initialValues.put(COL_2,weight);
        initialValues.put(COL_3,reps);
        return db.insert(DATABASE_TABLE9,null,initialValues);
    }

    public Cursor getbcurl() {
        String where = null;
        Cursor c = db.query(true,DATABASE_TABLE9, ALL_KEYS, where, null,null,null,null,null);
        if(c != null){
            c.moveToFirst();
        }
        return c;
    }
    public long insertsquat(String date, String weight, String reps) throws SQLException{
        ContentValues initialValues = new ContentValues();
        initialValues.put(COL_1,date);
        initialValues.put(COL_2,weight);
        initialValues.put(COL_3,reps);
        return db.insert(DATABASE_TABLE10,null,initialValues);
    }

    public Cursor getsquat() {
        String where = null;
        Cursor c = db.query(true,DATABASE_TABLE10, ALL_KEYS, where, null,null,null,null,null);
        if(c != null){
            c.moveToFirst();
        }
        return c;
    }
    public long insertlegpress(String date, String weight, String reps) throws SQLException{
        ContentValues initialValues = new ContentValues();
        initialValues.put(COL_1,date);
        initialValues.put(COL_2,weight);
        initialValues.put(COL_3,reps);
        return db.insert(DATABASE_TABLE11,null,initialValues);
    }

    public Cursor getlegpress() {
        String where = null;
        Cursor c = db.query(true,DATABASE_TABLE11, ALL_KEYS, where, null,null,null,null,null);
        if(c != null){
            c.moveToFirst();
        }
        return c;
    }
    public long insertlegextentions(String date, String weight, String reps) throws SQLException{
        ContentValues initialValues = new ContentValues();
        initialValues.put(COL_1,date);
        initialValues.put(COL_2,weight);
        initialValues.put(COL_3,reps);
        return db.insert(DATABASE_TABLE12,null,initialValues);
    }

    public Cursor getlegextensions() {
        String where = null;
        Cursor c = db.query(true,DATABASE_TABLE12, ALL_KEYS, where, null,null,null,null,null);
        if(c != null){
            c.moveToFirst();
        }
        return c;
    }

    public long insertlegcurl(String date, String weight, String reps) throws SQLException{
        ContentValues initialValues = new ContentValues();
        initialValues.put(COL_1,date);
        initialValues.put(COL_2,weight);
        initialValues.put(COL_3,reps);
        return db.insert(DATABASE_TABLE13,null,initialValues);
    }

    public Cursor getlegcurl() {
        String where = null;
        Cursor c = db.query(true,DATABASE_TABLE13, ALL_KEYS, where, null,null,null,null,null);
        if(c != null){
            c.moveToFirst();
        }
        return c;
    }

    }


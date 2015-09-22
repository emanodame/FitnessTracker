package com.example.FitnessTracker;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLException;

public class DBTracker {


    private static final int DATABASE_VERSION = 1;
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

    private static final String DATABASE_CREATE0 = //Make multiples of this code. Each one specific for a different exercise.
            "CREATE TABLE IF NOT EXISTS " + DATABASE_TABLE0
            + " (" + KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_1 + " TEXT, "
            + COL_2 + " TEXT, "
            + COL_3 + " TEXT"
            + ");";

    private static final String DATABASE_CREATE1 =//Make multiples of this code. Each one specific for a different exercise.
            "CREATE TABLE IF NOT EXISTS " + DATABASE_TABLE1
                    + " (" + KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COL_1 + " TEXT, "
                    + COL_2 + " TEXT, "
                    + COL_3 + " TEXT"
                    + ");";

    private static final String DATABASE_CREATE2 = //Make multiples of this code. Each one specific for a different exercise.
            "CREATE TABLE IF NOT EXISTS " + DATABASE_TABLE2
                    + " (" + KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COL_1 + " TEXT, "
                    + COL_2 + " TEXT, "
                    + COL_3 + " TEXT"
                    + ");";

    private static final String DATABASE_CREATE3 = //Make multiples of this code. Each one specific for a different exercise.
            "CREATE TABLE IF NOT EXISTS " + DATABASE_TABLE3
                    + " (" + KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COL_1 + " TEXT, "
                    + COL_2 + " TEXT, "
                    + COL_3 + " TEXT"
                    + ");";

    private static final String DATABASE_CREATE4 = //Make multiples of this code. Each one specific for a different exercise.
            "CREATE TABLE IF NOT EXISTS " + DATABASE_TABLE4
                    + " (" + KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COL_1 + " TEXT, "
                    + COL_2 + " TEXT, "
                    + COL_3 + " TEXT"
                    + ");";

    private static final String DATABASE_CREATE5 =//Make multiples of this code. Each one specific for a different exercise.
            "CREATE TABLE IF NOT EXISTS " + DATABASE_TABLE5
                    + " (" + KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COL_1 + " TEXT, "
                    + COL_2 + " TEXT, "
                    + COL_3 + " TEXT"
                    + ");";
    private static final String DATABASE_CREATE6 = //Make multiples of this code. Each one specific for a different exercise.
            "CREATE TABLE IF NOT EXISTS " + DATABASE_TABLE6
                    + " (" + KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COL_1 + " TEXT, "
                    + COL_2 + " TEXT, "
                    + COL_3 + " TEXT"
                    + ");";
    private static final String DATABASE_CREATE7 = //Make multiples of this code. Each one specific for a different exercise.
            "CREATE TABLE IF NOT EXISTS " + DATABASE_TABLE7
                    + " (" + KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COL_1 + " TEXT, "
                    + COL_2 + " TEXT, "
                    + COL_3 + " TEXT"
                    + ");";
    private static final String DATABASE_CREATE8 =//Make multiples of this code. Each one specific for a different exercise.
            "CREATE TABLE IF NOT EXISTS " + DATABASE_TABLE8
                    + " (" + KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COL_1 + " TEXT, "
                    + COL_2 + " TEXT, "
                    + COL_3 + " TEXT"
                    + ");";
    private static final String DATABASE_CREATE9 = //Make multiples of this code. Each one specific for a different exercise.
            "CREATE TABLE IF NOT EXISTS " + DATABASE_TABLE9
                    + " (" + KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COL_1 + " TEXT, "
                    + COL_2 + " TEXT, "
                    + COL_3 + " TEXT"
                    + ");";
    private static final String DATABASE_CREATE10 = //Make multiples of this code. Each one specific for a different exercise.
            "CREATE TABLE IF NOT EXISTS " + DATABASE_TABLE10
                    + " (" + KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COL_1 + " TEXT, "
                    + COL_2 + " TEXT, "
                    + COL_3 + " TEXT"
                    + ");";
    private static final String DATABASE_CREATE11 = //Make multiples of this code. Each one specific for a different exercise.
            "CREATE TABLE IF NOT EXISTS " + DATABASE_TABLE11
                    + " (" + KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COL_1 + " TEXT, "
                    + COL_2 + " TEXT, "
                    + COL_3 + " TEXT"
                    + ");";
    private static final String DATABASE_CREATE12 = //Make multiples of this code. Each one specific for a different exercise.
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

    /*
    Below is code for specific Database functions. Add/Delete/Retrieve. All different for each database.
     */


    //Code for deleting a specific row.
    public boolean deleteRowDumbbellPress(long rowId) {
        String where = KEY_ROWID + "=" + rowId;
        return db.delete(DATABASE_TABLE0, where, null) !=0;
    }
    //Code for deleting the contents of database.
    public void deleteAllDumbbellPress() {
        Cursor c = getDumbbellPress();
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
        Cursor c = getTriDips();
        long rowId = c.getColumnIndexOrThrow(KEY_ROWID);
        if (c.moveToFirst()){
            do {
                deleteRowDips(c.getLong((int) rowId));
            }while(c.moveToNext());
        }
        c.close();
    }


    public void deleteAllDumbellPress() {
        Cursor c = getiDumbellPress();
        long rowId = c.getColumnIndexOrThrow(KEY_ROWID);
        if (c.moveToFirst()){
            do {
                deleteRowDumbbellPress(c.getLong((int) rowId));
            }while(c.moveToNext());
        }
        c.close();
    }

    public boolean deleteRowTricepPulldown(long rowId) {
        String where = KEY_ROWID + "=" + rowId;
        return db.delete(DATABASE_TABLE3, where, null) !=0;
    }

    public void deleteAllTriPulldown() {
        Cursor c = getTriPulldown();
        long rowId = c.getColumnIndexOrThrow(KEY_ROWID);
        if (c.moveToFirst()){
            do {
                deleteRowTricepPulldown(c.getLong((int) rowId));
            }while(c.moveToNext());
        }
        c.close();
    }

    public boolean deleteRowMachineChestpress(long rowId) {
        String where = KEY_ROWID + "=" + rowId;
        return db.delete(DATABASE_TABLE4, where, null) !=0;
    }

    public void deleteAllMachineChestpress() {
        Cursor c = getMchestPress();
        long rowId = c.getColumnIndexOrThrow(KEY_ROWID);
        if (c.moveToFirst()){
            do {
                deleteRowMachineChestpress(c.getLong((int) rowId));
            }while(c.moveToNext());
        }
        c.close();
    }

    public boolean deleteChestfly(long rowId) {
        String where = KEY_ROWID + "=" + rowId;
        return db.delete(DATABASE_TABLE5, where, null) !=0;
    }

    public void deleteAllChestfly() {
        Cursor c = getChestFly();
        long rowId = c.getColumnIndexOrThrow(KEY_ROWID);
        if (c.moveToFirst()){
            do {
                deleteChestfly(c.getLong((int) rowId));
            }while(c.moveToNext());
        }
        c.close();
    }

    public boolean deleteRowPullups(long rowId) {
        String where = KEY_ROWID + "=" + rowId;
        return db.delete(DATABASE_TABLE6, where, null) !=0;
    }

    public void deleteAllPullups() {
        Cursor c = getPullups();
        long rowId = c.getColumnIndexOrThrow(KEY_ROWID);
        if (c.moveToFirst()){
            do {
                deleteRowPullups(c.getLong((int) rowId));
            }while(c.moveToNext());
        }
        c.close();
    }

    public boolean deleteRowHammercurls(long rowId) {
        String where = KEY_ROWID + "=" + rowId;
        return db.delete(DATABASE_TABLE7, where, null) !=0;
    }

    public void deleteAllHammercurls() {
        Cursor c = getHammercurls();
        long rowId = c.getColumnIndexOrThrow(KEY_ROWID);
        if (c.moveToFirst()){
            do {
                deleteRowHammercurls(c.getLong((int) rowId));
            }while(c.moveToNext());
        }
        c.close();
    }

    public boolean deleteRowDeadlift(long rowId) {
        String where = KEY_ROWID + "=" + rowId;
        return db.delete(DATABASE_TABLE8, where, null) !=0;
    }

    public void deleteAllDeadlift() {
        Cursor c = getDeadlift();
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
        Cursor c = getSquat();
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

    public void deleteAllLegpress() {
        Cursor c = getLegpress();
        long rowId = c.getColumnIndexOrThrow(KEY_ROWID);
        if (c.moveToFirst()){
            do {
                deleteRowlegpress(c.getLong((int) rowId));
            }while(c.moveToNext());
        }
        c.close();
    }


    public boolean deleteRowLegExtensions(long rowId) {
        String where = KEY_ROWID + "=" + rowId;
        return db.delete(DATABASE_TABLE12, where, null) !=0;
    }

    public void deleteAllLegCurl() {
        Cursor c = getLegCurl();
        long rowId = c.getColumnIndexOrThrow(KEY_ROWID);
        if (c.moveToFirst()){
            do {
                deleteRowLegCurl(c.getLong((int) rowId));
            }while(c.moveToNext());
        }
        c.close();
    }

    public boolean deleteRowLegCurl(long rowId) {
        String where = KEY_ROWID + "=" + rowId;
        return db.delete(DATABASE_TABLE13, where, null) !=0;
    }

    public void deleteAllLegExtensions() {
        Cursor c = getLegExtensions();
        long rowId = c.getColumnIndexOrThrow(KEY_ROWID);
        if (c.moveToFirst()){
            do {
                deleteRowLegExtensions(c.getLong((int) rowId));
            }while(c.moveToNext());
        }
        c.close();
    }


    private static class DatabaseHelper extends SQLiteOpenHelper {
        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);

        }

        //Executes all code for database creation.
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


    //Insert stats for database.
    public long insertDumbbellPress(String date, String weight, String reps) throws SQLException{
        ContentValues initialValues = new ContentValues();
        initialValues.put(COL_1,date);
        initialValues.put(COL_2,weight);
        initialValues.put(COL_3,reps);
        return db.insert(DATABASE_TABLE0,null,initialValues);
    }
    //Get stats from a specific database.
    public Cursor getDumbbellPress() {
        String where = null;
        Cursor c = db.query(true, DATABASE_TABLE0, ALL_KEYS, where, null,null,null,null,null);
        if(c != null){
            c.moveToFirst();
        }
        return c;
    }

    public long insertTriDips(String date, String weight, String reps) throws SQLException{
        ContentValues initialValues = new ContentValues();
        initialValues.put(COL_1,date);
        initialValues.put(COL_2,weight);
        initialValues.put(COL_3,reps);
        return db.insert(DATABASE_TABLE1,null,initialValues);
    }

    public Cursor getTriDips() {
        String where = null;
        Cursor c = db.query(true,DATABASE_TABLE1, ALL_KEYS, where, null,null,null,null,null);
        if(c != null){
            c.moveToFirst();
        }
        return c;
    }

    public long insertiDumbbellPress(String date, String weight, String reps) throws SQLException{
        ContentValues initialValues = new ContentValues();
        initialValues.put(COL_1,date);
        initialValues.put(COL_2,weight);
        initialValues.put(COL_3,reps);
        return db.insert(DATABASE_TABLE2,null,initialValues);
    }

    public Cursor getiDumbellPress() {
        String where = null;
        Cursor c = db.query(true,DATABASE_TABLE2, ALL_KEYS, where, null,null,null,null,null);
        if(c != null){
            c.moveToFirst();
        }
        return c;
    }

    public long insertTriPulldown(String date, String weight, String reps) throws SQLException{
        ContentValues initialValues = new ContentValues();
        initialValues.put(COL_1,date);
        initialValues.put(COL_2,weight);
        initialValues.put(COL_3,reps);
        return db.insert(DATABASE_TABLE3,null,initialValues);
    }

    public Cursor getTriPulldown() {
        String where = null;
        Cursor c = db.query(true,DATABASE_TABLE3, ALL_KEYS, where, null,null,null,null,null);
        if(c != null){
            c.moveToFirst();
        }
        return c;
    }

    public long insertMchestPress(String date, String weight, String reps) throws SQLException{
        ContentValues initialValues = new ContentValues();
        initialValues.put(COL_1,date);
        initialValues.put(COL_2,weight);
        initialValues.put(COL_3,reps);
        return db.insert(DATABASE_TABLE4,null,initialValues);
    }

    public Cursor getMchestPress() {
        String where = null;
        Cursor c = db.query(true,DATABASE_TABLE4, ALL_KEYS, where, null,null,null,null,null);
        if(c != null){
            c.moveToFirst();
        }
        return c;
    }

    public long insertChestFly(String date, String weight, String reps) throws SQLException{
        ContentValues initialValues = new ContentValues();
        initialValues.put(COL_1,date);
        initialValues.put(COL_2,weight);
        initialValues.put(COL_3,reps);
        return db.insert(DATABASE_TABLE5,null,initialValues);
    }

    public Cursor getChestFly() {
        String where = null;
        Cursor c = db.query(true,DATABASE_TABLE5, ALL_KEYS, where, null,null,null,null,null);
        if(c != null){
            c.moveToFirst();
        }
        return c;
    }


    public long insertPullups(String date, String weight, String reps) throws SQLException{
        ContentValues initialValues = new ContentValues();
        initialValues.put(COL_1,date);
        initialValues.put(COL_2,weight);
        initialValues.put(COL_3,reps);
        return db.insert(DATABASE_TABLE6,null,initialValues);
    }

    public Cursor getPullups() {
        String where = null;
        Cursor c = db.query(true,DATABASE_TABLE6, ALL_KEYS, where, null,null,null,null,null);
        if(c != null){
            c.moveToFirst();
        }
        return c;
    }

    public long insertHammercurls(String date, String weight, String reps) throws SQLException{
        ContentValues initialValues = new ContentValues();
        initialValues.put(COL_1,date);
        initialValues.put(COL_2,weight);
        initialValues.put(COL_3,reps);
        return db.insert(DATABASE_TABLE7,null,initialValues);
    }

    public Cursor getHammercurls() {
        String where = null;
        Cursor c = db.query(true,DATABASE_TABLE7, ALL_KEYS, where, null,null,null,null,null);
        if(c != null){
            c.moveToFirst();
        }
        return c;
    }
    public long insertDeadlift(String date, String weight, String reps) throws SQLException{
        ContentValues initialValues = new ContentValues();
        initialValues.put(COL_1,date);
        initialValues.put(COL_2,weight);
        initialValues.put(COL_3,reps);
        return db.insert(DATABASE_TABLE8,null,initialValues);
    }

    public Cursor getDeadlift() {
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
    public long insertSquat(String date, String weight, String reps) throws SQLException{
        ContentValues initialValues = new ContentValues();
        initialValues.put(COL_1,date);
        initialValues.put(COL_2,weight);
        initialValues.put(COL_3,reps);
        return db.insert(DATABASE_TABLE10,null,initialValues);
    }

    public Cursor getSquat() {
        String where = null;
        Cursor c = db.query(true,DATABASE_TABLE10, ALL_KEYS, where, null,null,null,null,null);
        if(c != null){
            c.moveToFirst();
        }
        return c;
    }
    public long insertLegpress(String date, String weight, String reps) throws SQLException{
        ContentValues initialValues = new ContentValues();
        initialValues.put(COL_1,date);
        initialValues.put(COL_2,weight);
        initialValues.put(COL_3,reps);
        return db.insert(DATABASE_TABLE11,null,initialValues);
    }

    public Cursor getLegpress() {
        String where = null;
        Cursor c = db.query(true,DATABASE_TABLE11, ALL_KEYS, where, null,null,null,null,null);
        if(c != null){
            c.moveToFirst();
        }
        return c;
    }
    public long insertLegExtentions(String date, String weight, String reps) throws SQLException{
        ContentValues initialValues = new ContentValues();
        initialValues.put(COL_1,date);
        initialValues.put(COL_2,weight);
        initialValues.put(COL_3,reps);
        return db.insert(DATABASE_TABLE12,null,initialValues);
    }

    public Cursor getLegExtensions() {
        String where = null;
        Cursor c = db.query(true,DATABASE_TABLE12, ALL_KEYS, where, null,null,null,null,null);
        if(c != null){
            c.moveToFirst();
        }
        return c;
    }

    public long insertLegCurl(String date, String weight, String reps) throws SQLException{
        ContentValues initialValues = new ContentValues();
        initialValues.put(COL_1,date);
        initialValues.put(COL_2,weight);
        initialValues.put(COL_3,reps);
        return db.insert(DATABASE_TABLE13,null,initialValues);
    }

    public Cursor getLegCurl() {
        String where = null;
        Cursor c = db.query(true,DATABASE_TABLE13, ALL_KEYS, where, null,null,null,null,null);
        if(c != null){
            c.moveToFirst();
        }
        return c;
    }

    }


package edu.missouriwestern.aambrosius.retrobejewled;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ambrosius on 3/1/2016.
 */
public class Database extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Scores";
    private static final String TABLE_EASY_HIGH_SCORES = "Easy_High_Scores";
    private static final String TABLE_MEDIUM_HIGH_SCORES = "Medium_High_Scores";
    private static final String TABLE_HARD_HIGH_SCORES = "Hard_High_Scores";
    private static final String TABLE_CRAZY_HIGH_SCORES = "Crazy_HighScores";

    private static final String KEY_SCORE = "Score";
    private static final String KEY_INITIAL = "Initials";

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    //@Override

    public void dropCrazy(SQLiteDatabase db) {
        db.execSQL("DROP TABLE " + TABLE_CRAZY_HIGH_SCORES);
    }
    public void onCreateEasy(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EASY_HIGH_SCORES);
        String CREATE_EASY_HIGH_SCORE_TABLE = "CREATE TABLE " + TABLE_EASY_HIGH_SCORES + "("
                + KEY_SCORE + " INTEGER," + KEY_INITIAL + " TEXT)";
        db.execSQL(CREATE_EASY_HIGH_SCORE_TABLE);
    }

    //@Override

    public void onCreateMedium(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MEDIUM_HIGH_SCORES);
        String CREATE_MEDIUM_SCORE_TABLE = "CREATE TABLE " + TABLE_MEDIUM_HIGH_SCORES + "("
                + KEY_SCORE + " INTEGER," + KEY_INITIAL + " TEXT)";
        db.execSQL(CREATE_MEDIUM_SCORE_TABLE);
    }

    public void onCreateHard(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HARD_HIGH_SCORES);
        String CREATE_HARD_SCORE_TABLE = "CREATE TABLE " + TABLE_HARD_HIGH_SCORES + "("
                + KEY_SCORE + " INTEGER," + KEY_INITIAL + " TEXT)";
        db.execSQL(CREATE_HARD_SCORE_TABLE);
    }

    //@Override
    public void onCreateCrazy(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_CRAZY_HIGH_SCORES + "("
                + KEY_SCORE + " INTEGER," + KEY_INITIAL + " TEXT)");
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_EASY_HIGH_SCORE_TABLE = "CREATE TABLE " + TABLE_EASY_HIGH_SCORES + "("
                + KEY_SCORE + " INTEGER," + KEY_INITIAL + " TEXT)";
        db.execSQL(CREATE_EASY_HIGH_SCORE_TABLE);

        String CREATE_MEDIUM_HIGH_SCORE_TABLE = "CREATE TABLE " + TABLE_MEDIUM_HIGH_SCORES + "("
                + KEY_SCORE + " INTEGER," + KEY_INITIAL + " TEXT)";
        db.execSQL(CREATE_MEDIUM_HIGH_SCORE_TABLE);

        String CREATE_HARD_HIGH_SCORE_TABLE = "CREATE TABLE " + TABLE_HARD_HIGH_SCORES + "("
                + KEY_SCORE + " INTEGER," + KEY_INITIAL + " TEXT)";
        db.execSQL(CREATE_HARD_HIGH_SCORE_TABLE);

        String CREATE_CRAZY_HIGH_SCORE_TABLE = "CREATE TABLE " + TABLE_CRAZY_HIGH_SCORES + "("
                + KEY_SCORE + " INTEGER," + KEY_INITIAL + " TEXT)";
        db.execSQL(CREATE_CRAZY_HIGH_SCORE_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EASY_HIGH_SCORES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MEDIUM_HIGH_SCORES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HARD_HIGH_SCORES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CRAZY_HIGH_SCORES);

        // Create tables again
        onCreateEasy(db);
        onCreateMedium(db);
        onCreateCrazy(db);
        onCreateCrazy(db);

    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    void addEasyHighScore(HighScores highScores) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_SCORE, highScores.getScore());
        values.put(KEY_INITIAL, highScores.getInitial());

        // Inserting Row
        db.insert(TABLE_EASY_HIGH_SCORES, null, values);
        db.close();
    }

    void addMediumHighScore(HighScores highScores) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_SCORE, highScores.getScore());
        values.put(KEY_INITIAL, highScores.getInitial());

        // Inserting Row
        db.insert(TABLE_MEDIUM_HIGH_SCORES, null, values);
        db.close();
    }

    void addHardHighScore(HighScores highScores) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_SCORE, highScores.getScore());
        values.put(KEY_INITIAL, highScores.getInitial());

        // Inserting Row
        db.insert(TABLE_HARD_HIGH_SCORES, null, values);
        db.close();
    }

    void addCrazyHighScore(HighScores highScores) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_SCORE, highScores.getScore());
        values.put(KEY_INITIAL, highScores.getInitial());

        // Inserting Row
        db.insert(TABLE_CRAZY_HIGH_SCORES, null, values);
        db.close();
    }

    public List<HighScores> getAllMediumHighScores() {
        List<HighScores> highScoreList = new ArrayList<HighScores>();
        // Select All Query

        String selectQuery = "SELECT  * FROM " + TABLE_EASY_HIGH_SCORES;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                HighScores highScores = new HighScores();
                highScores.setScore(Integer.parseInt(cursor.getString(0)));
                highScores.setInitial(cursor.getString(1));
                // Adding contact to list
                highScoreList.add(highScores);
            } while (cursor.moveToNext());
        }
        return highScoreList;
    }

    public List<HighScores> getAllMedHighScores() {
        List<HighScores> highScoreList = new ArrayList<HighScores>();
        // Select All Query

        String selectQuery = "SELECT  * FROM " + TABLE_MEDIUM_HIGH_SCORES;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                HighScores highScores = new HighScores();
                highScores.setScore(Integer.parseInt(cursor.getString(0)));
                highScores.setInitial(cursor.getString(1));
                // Adding contact to list
                highScoreList.add(highScores);
            } while (cursor.moveToNext());
        }
        return highScoreList;
    }

    public List<HighScores> getAllHardHighScores() {
        List<HighScores> highScoreList = new ArrayList<HighScores>();
        // Select All Query

        String selectQuery = "SELECT  * FROM " + TABLE_HARD_HIGH_SCORES;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                HighScores highScores = new HighScores();
                highScores.setScore(Integer.parseInt(cursor.getString(0)));
                highScores.setInitial(cursor.getString(1));
                // Adding contact to list
                highScoreList.add(highScores);
            } while (cursor.moveToNext());
        }
        return highScoreList;
    }

    public Cursor getEasyHighScores() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_EASY_HIGH_SCORES + " ORDER BY " + KEY_SCORE + " DESC LIMIT 10", null);
        return res;
    }

    public Cursor getMediumHighScores() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_MEDIUM_HIGH_SCORES + " ORDER BY " + KEY_SCORE + " DESC LIMIT 10", null);
        return res;
    }

    public Cursor getHardHighScores() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_HARD_HIGH_SCORES + " ORDER BY " + KEY_SCORE + " DESC LIMIT 10", null);
        return res;
    }

    public Cursor getCrazyHighScores() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_CRAZY_HIGH_SCORES + " ORDER BY " + KEY_SCORE + " DESC LIMIT 10", null);
        return res;
    }

}

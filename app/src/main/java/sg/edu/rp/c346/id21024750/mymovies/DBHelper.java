package sg.edu.rp.c346.id21024750.mymovies;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

class DBHelper extends SQLiteOpenHelper {

    //Metadata of the database
    private static final int DATABASE_VER = 1;
    private static final String DATABASE_NAME = "movies.db";

    private static final String TABLE_MOVIES = "movies";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_TITLE = "title";
    private static final String COLUMN_GENRE = "Genre";
    private static final String COLUMN_RATING = "Rating";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableSql = "CREATE TABLE " + TABLE_MOVIES +  "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_TITLE + " TEXT,"
                + COLUMN_RATING + " TEXT,"
                + COLUMN_GENRE + " TEXT )";
        Log.d("DEBUG Create", createTableSql);
        db.execSQL(createTableSql);
        Log.i("info" ,"created tables");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MOVIES);
        // Create table(s) again
        onCreate(db);

    }

    public void insertTask(String description, String date){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, title);
        values.put(COLUMN_RATING, rating);
        values.put(COLUMN_GENRE, genre)
        db.insert(TABLE_MOVIES, null, values);
        db.close();
    }


    public ArrayList<String> getAllMoviesByCategory() {
        ArrayList<String> movies = new ArrayList<String>();

        String selectQuery = "SELECT " + COLUMN_TITLE
                + " FROM " + TABLE_MOVIES;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                movies.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return movies;
    }

    public ArrayList<Movies> getAllMovies(boolean asc) {
        ArrayList<Movies> movies = new ArrayList<Movies>();
        String selectQuery = "SELECT " + COLUMN_ID + ", "
                + COLUMN_TITLE + ", "
                + COLUMN_RATING
                + " FROM " + TABLE_MOVIES
                + " ORDER BY" + COLUMN_TITLE;
        if(asc){
            selectQuery +="ASC";
        }
        else {
            selectQuery += "DESC";
        }


        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String description = cursor.getString(1);
                String date = cursor.getString(2);
                Movies obj = new Movies(id, description, date);
                movies.add(obj);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return movies;
    }
}

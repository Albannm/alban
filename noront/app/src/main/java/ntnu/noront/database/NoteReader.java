package ntnu.noront.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by HACCO on 10/3/2016.
 */
public class NoteReader extends SQLiteOpenHelper {

    private static final String TEXT_TYPE = " TEXT";
    private static final String NUMBER_TYPE = " REAL";
    private static final String COMMA = " , ";

    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + NoteReaderContract.NoteEntry.TABLE_NAME
                                                    + "(" + NoteReaderContract.NoteEntry._ID + " INTEGER PRIMARY KEY "
                                                    + NoteReaderContract.NoteEntry.COLUMN_NOTE_TITLE + TEXT_TYPE + COMMA
                                                    + NoteReaderContract.NoteEntry.COLUMN_NOTE_MESSAGE + TEXT_TYPE + COMMA
                                                    + NoteReaderContract.NoteEntry.COLUMN_IMAGE_SOURCE + TEXT_TYPE + COMMA
                                                    + NoteReaderContract.NoteEntry.COLUMN_SOUND_SOURCE + TEXT_TYPE + COMMA
                                                    + NoteReaderContract.NoteEntry.COLUMN_LATITUDE + NUMBER_TYPE + COMMA
                                                    + NoteReaderContract.NoteEntry.COLUMN_LATITUDE + NUMBER_TYPE + ")";

    private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + NoteReaderContract.NoteEntry.TABLE_NAME;

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "ntnu.Noront.db";

    public NoteReader(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}

package ntnu.noront.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;

import ntnu.noront.utilities.Note;

/**
 * Created by HACCO on 10/3/2016.
 */
public class NoteSelector {


    public static String [] TABLE_PROJECTION = {
            NoteReaderContract.NoteEntry._ID,
            NoteReaderContract.NoteEntry.COLUMN_NOTE_TITLE,
            NoteReaderContract.NoteEntry.COLUMN_NOTE_MESSAGE,
            NoteReaderContract.NoteEntry.COLUMN_NOTE_DATE_TIME,
            NoteReaderContract.NoteEntry.COLUMN_IMAGE_SOURCE,
            NoteReaderContract.NoteEntry.COLUMN_SOUND_SOURCE,
            NoteReaderContract.NoteEntry.COLUMN_LATITUDE,
            NoteReaderContract.NoteEntry.COLUMN_LONGITUDE
    };

    public static ArrayList<Note> getNotes(Context context, boolean archive){
        ArrayList<Note> notes = new ArrayList<>();
        notes.add(new Note().setTitle("Title1").setMessage("Message to be seen!"));
        notes.add(new Note().setTitle("Title1").setMessage("Message to be seen!"));
        notes.add(new Note().setTitle("Title1").setMessage("Message to be seen!"));
        notes.add(new Note().setTitle("Title1").setMessage("Message to be seen!"));
        if(archive == Note.ARCHIVE){
            notes.add(new Note().setTitle("Archive Title1").setMessage("Archive Message to be seen!"));
            notes.add(new Note().setTitle("Archive Title1").setMessage("Archive Message to be seen!"));
            notes.add(new Note().setTitle("Archive Title1").setMessage("Archive Message to be seen!"));
        }
        return notes;
    }


    public static ArrayList<Note> getAllNotes(Context context){
        NoteReader noteReader = null;
        SQLiteDatabase sqLiteDatabase = null;
        ArrayList<Note> notes = new ArrayList<>();
        try{
            noteReader = new NoteReader(context);
            sqLiteDatabase = noteReader.getReadableDatabase();

            String SORT_ORDER = NoteReaderContract.NoteEntry.COLUMN_NOTE_DATE_TIME + " DESC";

            Cursor cursor = sqLiteDatabase.query(
                    NoteReaderContract.NoteEntry.TABLE_NAME,
                    TABLE_PROJECTION,
                    null,
                    null,
                    null,
                    null,
                    SORT_ORDER
            );

            while(cursor.moveToNext()){
                Note note = parseNote(cursor);
                if(note != null)
                    notes.add(note);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        finally{
            if(sqLiteDatabase != null)
                sqLiteDatabase.close();
        }
        return notes;
    }

    private static Note parseNote(Cursor cursor) throws ParseException{
        long id = cursor.getLong(cursor.getColumnIndex(NoteReaderContract.NoteEntry._ID));

        String title = cursor.getString(cursor.getColumnIndex(NoteReaderContract.NoteEntry.COLUMN_NOTE_TITLE));
        String message = cursor.getString(cursor.getColumnIndex(NoteReaderContract.NoteEntry.COLUMN_NOTE_MESSAGE));
        String dateTime = cursor.getString(cursor.getColumnIndex(NoteReaderContract.NoteEntry.COLUMN_NOTE_DATE_TIME));
        String imageSrc = cursor.getString(cursor.getColumnIndex(NoteReaderContract.NoteEntry.COLUMN_IMAGE_SOURCE));

        double longitude = cursor.getDouble(cursor.getColumnIndex(NoteReaderContract.NoteEntry.COLUMN_LONGITUDE));
        double latitude = cursor.getDouble(cursor.getColumnIndex(NoteReaderContract.NoteEntry.COLUMN_LATITUDE));

        return new Note().setID(id).setTitle(title).setMessage(message).setDateTime(DateFormat.getDateTimeInstance().parse(dateTime)).setLocation(new Note.NoteLocation().setLongitude(longitude).setLatitude(latitude));
    }
}

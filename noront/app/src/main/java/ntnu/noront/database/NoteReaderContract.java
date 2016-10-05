package ntnu.noront.database;

import android.provider.BaseColumns;

/**
 * Created by HACCO on 10/3/2016.
 */
public class NoteReaderContract {

    private NoteReaderContract(){}

    public static class NoteEntry implements BaseColumns{

        public static final String TABLE_NAME = "Notes";
        public static final String COLUMN_NOTE_TITLE = "Title";
        public static final String COLUMN_NOTE_MESSAGE = "Message";
        public static final String COLUMN_NOTE_DATE_TIME = "DateTime";
        public static final String COLUMN_IMAGE_SOURCE = "Image";
        public static final String COLUMN_SOUND_SOURCE = "Sound";
        public static final String COLUMN_LONGITUDE = "Longitude";
        public static final String COLUMN_LATITUDE = "Latitude";
    }
}

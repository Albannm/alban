package ntnu.noront.utilities;

import android.location.Location;
import android.media.Image;

import java.util.Date;

/**
 * Created by HACCO on 10/3/2016.
 */
public class Note {

    public static final boolean ACTIVE = true;
    public static final boolean ARCHIVE = false;

    public static final String NOTE_TYPE_KEY = "ntnu.Noront.NOTE_TYPE_KEY";

    private long id;
    private String title;
    private String message;
    private Date dateTime;
    private boolean isArchive;
    private NoteLocation location;
    private Image image;

    public long getID(){
        return this.id;
    }
    public String getTitle(){
        return this.title;
    }
    public String getMessage(){
        return this.message;
    }
    public Date getDateTime(){
        return this.dateTime;
    }
    public NoteLocation getLocation(){
        return this.location;
    }
    public Image getImage(){
        return  this.image;
    }
    public boolean isArchive(){ return this.isArchive; }

    public Note setID(long id){
        this.id = id;
        return this;
    }
    public Note setTitle(String title){
        this.title = title;
        return this;
    }
    public Note setMessage(String message){
        this.message = message;
        return this;
    }
    public Note setDateTime(Date dateTime){
        this.dateTime = dateTime;
        return this;
    }
    public Note setLocation(NoteLocation location){
        this.location = location;
        return this;
    }
    public Note setImage(Image image){
        this.image = image;
        return this;
    }
    public Note setArchive(boolean archive){
        this.isArchive = archive;
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Note) {
            return ((Note) obj).getID() == getID();
        }
        return false;
    }

    public static class NoteLocation{

        private double longitude;
        private double latitude;

        public double getLongitude(){
            return this.longitude;
        }
        public double getLatitude(){
            return this.latitude;
        }

        public NoteLocation setLongitude(double longitude){
            this.longitude = longitude;
            return this;
        }
        public NoteLocation setLatitude(double latitude){
            this.latitude = latitude;
            return this;
        }
    }
}

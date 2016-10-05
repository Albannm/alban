package ntnu.noront.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ntnu.noront.R;

public class NoteViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_view);
        alban();
    }
    public void alban(){
        System.out.println("Hello there");
    }
}

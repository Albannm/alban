package ntnu.noront.activities;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ntnu.noront.R;
import ntnu.noront.fragments.NoteEditFragment;

public class NoteEditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_edit);

        NoteEditFragment noteEditFragment = new NoteEditFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.acitvity_note_edit, noteEditFragment , "VIEW ALL NOTES FRAGMENT");;
        fragmentTransaction.commit();
    }
}

package ntnu.noront.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ntnu.noront.R;
//import ntnu.noront.utilities.AudioRecord;

/**
 * A simple {@link Fragment} subclass.
 */
public class NoteViewFragment extends Fragment {


    public NoteViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //AudioRecord audioRecord = new AudioRecord();

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_note_view, container, false);

    }

}

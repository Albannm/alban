package ntnu.noront.fragments;


import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

import ntnu.noront.database.NoteSelector;
import ntnu.noront.utilities.Note;
import ntnu.noront.utilities.NoteAdapter;

/**
 * A simple {@link android.app.Fragment} subclass.
 */
public class NoteListFragment extends ListFragment {

    private NoteAdapter noteAdapter;

    public NoteListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceStats){
        super.onActivityCreated(savedInstanceStats);
        boolean type = Note.ACTIVE;
        if(getArguments() != null){
            type = getArguments().getBoolean(Note.NOTE_TYPE_KEY);
        }
        ArrayList<Note> list = NoteSelector.getNotes(getActivity(), type);
        getListView().setAdapter(null);
        noteAdapter = new NoteAdapter(getActivity(), list);
        noteAdapter.notifyDataSetChanged();
        setListAdapter(noteAdapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int postion, long id) {
        super.onListItemClick(l,v,postion,id);
        Note note = noteAdapter.getItem(postion);
    }
}

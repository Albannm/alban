package ntnu.noront.utilities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import ntnu.noront.R;

/**
 * Created by HACCO on 10/3/2016.
 */
public class NoteAdapter extends ArrayAdapter<Note> {

    public NoteAdapter(Context context, List<Note> notes){
        super(context,0,notes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Note note = getItem(position);
        ViewHolder viewHolder;
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_row, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.titleView = (TextView) convertView.findViewById(R.id.list_item_note_title);
            viewHolder.infoView = (TextView) convertView.findViewById(R.id.list_item_note_message);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.titleView.setText(note.getTitle());
        viewHolder.infoView.setText(note.getMessage());

        return convertView;
    }

    private static class ViewHolder{
        TextView titleView;
        TextView infoView;
    }
}

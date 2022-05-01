package com.jwhh.notekeeper;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NoteRecyclerAdapter extends RecyclerView.Adapter<NoteRecyclerAdapter.ViewHolder> {

    private final Context mContext;
    private final List<NoteInfo> mNotes;
    private final LayoutInflater mLayoutInflater;

    public NoteRecyclerAdapter(Context context, List<NoteInfo> notes) {
        mContext = context;
        mNotes = notes;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//      First Parm -> Resource item we want to inflate
//      Second Param - > The view group that it's being inflated within
//      Third Param -> False = indicates that we don't want to have this newly inflated view
//            auto attached to it's parent as we will do this through the adapter and RV coop
//        This contains the ref to our top level view i.e card and all of the text view
        View itemView = mLayoutInflater.inflate(R.layout.item_note_list, parent, false);
        return new ViewHolder(itemView) ;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
         NoteInfo note = mNotes.get(position);
         viewHolder.mTextCourse.setText(note.getCourse().getTitle());
         viewHolder.mTextTitle.setText(note.getTitle());
         viewHolder.mCurrentPosition = position;
    }

    @Override
    public int getItemCount() {
        return mNotes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public final TextView mTextCourse;
        public final TextView mTextTitle;
        public int mCurrentPosition;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextCourse = (TextView) itemView.findViewById(R.id.test_course);
            mTextTitle = (TextView) itemView.findViewById(R.id.text_title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, NoteActivity.class);
                    intent.putExtra(NoteActivity.NOTE_POSITION,mCurrentPosition);
                    mContext.startActivity(intent);
                }
            });

        }
    }
}

package com.jwhh.notekeeper;

import android.os.Bundle;

import androidx.lifecycle.ViewModel;

public class NoteActivityViewModel extends ViewModel {
    private static final String ORIGINAL_NOTE_COURSE_ID = "com.jwhh.notekeeper.ORIGINAL_NOTE_COURSE_ID";
    private static final String ORIGINAL_NOTE_COURSE_TITLE = "com.jwhh.notekeeper.ORIGINAL_NOTE_TITLE";
    private static final String ORIGINAL_NOTE_COURSE_TEXT = "com.jwhh.notekeeper.ORIGINAL_NOTE_TEXT";

    private String mOriginalNoteCourseID;
    private String mOriginalNoteCourseTitle;
    private String mOriginalNoteCourseText;

    private boolean isViewNewlyCreated = true;

    public String getOriginalNoteCourseID() {return mOriginalNoteCourseID;}
    public String getOriginalNoteCourseTitle() {return mOriginalNoteCourseTitle;}
    public String getOriginalNoteCourseText() {return mOriginalNoteCourseText;}
    public boolean getIsViewNewlyCreated() {return isViewNewlyCreated; }

    public void setOriginalNoteCourseID(String originalNoteCourseID) {mOriginalNoteCourseID = originalNoteCourseID; }
    public void setOriginalNoteCourseTitle(String originalNoteCourseTitle) {mOriginalNoteCourseTitle = originalNoteCourseTitle;}
    public void setOriginalNoteCourseText(String originalNoteCourseText) { mOriginalNoteCourseText = originalNoteCourseText; }
    public void setViewNewlyCreated(boolean viewNewlyCreated) { isViewNewlyCreated = viewNewlyCreated; }

    public void saveState(Bundle outState) {
        outState.putString(ORIGINAL_NOTE_COURSE_ID, mOriginalNoteCourseID);
        outState.putString(ORIGINAL_NOTE_COURSE_TEXT,mOriginalNoteCourseText);
        outState.putString(ORIGINAL_NOTE_COURSE_TITLE, mOriginalNoteCourseTitle);
    }

    public void restoreState(Bundle inState){
        mOriginalNoteCourseID = inState.getString(ORIGINAL_NOTE_COURSE_ID);
        mOriginalNoteCourseText = inState.getString(ORIGINAL_NOTE_COURSE_TEXT);
        mOriginalNoteCourseTitle = inState.getString(ORIGINAL_NOTE_COURSE_TITLE);
    }
}

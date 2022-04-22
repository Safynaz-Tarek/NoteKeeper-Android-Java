package com.jwhh.notekeeper;

import androidx.lifecycle.ViewModel;

public class NoteActivityViewModel extends ViewModel {
    private String mOriginalNoteCourseID;
    private String mOriginalNoteCourseTitle;
    private String mOriginalNoteCourseText;

    public String getOriginalNoteCourseID() {return mOriginalNoteCourseID;}
    public String getOriginalNoteCourseTitle() {return mOriginalNoteCourseTitle;}
    public String getOriginalNoteCourseText() {return mOriginalNoteCourseText;}

    public void setOriginalNoteCourseID(String originalNoteCourseID) {mOriginalNoteCourseID = originalNoteCourseID; }
    public void setOriginalNoteCourseTitle(String originalNoteCourseTitle) {mOriginalNoteCourseTitle = originalNoteCourseTitle;}
    public void setOriginalNoteCourseText(String originalNoteCourseText) { mOriginalNoteCourseText = originalNoteCourseText; }

}

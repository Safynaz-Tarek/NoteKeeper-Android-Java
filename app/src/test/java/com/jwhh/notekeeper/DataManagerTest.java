package com.jwhh.notekeeper;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DataManagerTest extends TestCase {
    DataManager sDataManager = DataManager.getInstance();

    @Before
    public void setup(){
        sDataManager.getNotes().clear();
        sDataManager.initializeExampleNotes();

    }

    @Test
    public void testCreateNewNote() {
        CourseInfo course = sDataManager.getCourse("android_async");
        String courseText = "This is the text of my test Note";
        String courseTitle = "Test Note Title";

        int testNoteIdx = sDataManager.createNewNote();
        NoteInfo newNote = sDataManager.getNotes().get(testNoteIdx);

        newNote.setTitle(courseTitle);
        newNote.setText(courseText);
        newNote.setCourse(course);

        NoteInfo noteToCompare = sDataManager.getNotes().get(testNoteIdx);

        assertEquals(noteToCompare.getCourse(), course);
        assertEquals(noteToCompare.getText(),  courseText);
        assertEquals(noteToCompare.getTitle(), courseTitle);

    }

    @Test
    public void testSimilarNotes(){

        CourseInfo course = sDataManager.getCourse("android_async");
        String courseText = "This is the text of my test Note";
        String courseTextTwo = "This is the text of my second test Note";
        String courseTitle = "Test Note Title";

        int testNotedOne = sDataManager.createNewNote();
        NoteInfo newNoteOne = sDataManager.getNotes().get(testNotedOne);
        newNoteOne.setTitle(courseTitle);
        newNoteOne.setText(courseText);
        newNoteOne.setCourse(course);

        int testNotedTwo = sDataManager.createNewNote();
        NoteInfo newNoteTwo = sDataManager.getNotes().get(testNotedTwo);
        newNoteTwo.setTitle(courseTitle);
        newNoteTwo.setText(courseTextTwo);
        newNoteTwo.setCourse(course);

        int foundIdxOne = sDataManager.findNote(newNoteOne);
        assertEquals(testNotedOne, foundIdxOne);

        int foundIdxTwo = sDataManager.findNote(newNoteTwo);
        assertEquals(testNotedTwo, foundIdxTwo);

    }
}
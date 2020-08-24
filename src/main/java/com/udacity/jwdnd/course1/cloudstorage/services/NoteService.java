package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.NoteMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    private NoteMapper noteMapper;

    public NoteService(NoteMapper noteMapper) {
        this.noteMapper = noteMapper;
    }

    // make sure that note titles are uniques for better information management
    public boolean isNoteTitleAvailable(String notetitle) {
        return noteMapper.getNoteByTitle(notetitle) == null;
    }

    // get all notes for a given user
    public List<Note> getAllNotes(Integer userid) {
        List<Note> notes = noteMapper.getAllNotesForUser(userid);
        return notes;
    }

    // get note by notetitle
    public Note getNoteByTitle(String notetitle) {
        return noteMapper.getNoteByTitle(notetitle);
    }
}

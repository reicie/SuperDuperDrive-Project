package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NoteMapper {
    @Select("SELECT * FROM NOTES WHERE notetitle = #{notetitle}")
    Note getNoteByTitle(String notetitle);

    @Select("SELECT * FROM NOTES WHERE userid = #{userid}")
    List<Note> getAllNotesForUser(Integer userid);

    @Insert("INSERT INTO NOTES(notetitle, notedescription) VALUES(#{notetitle}, #{notedescription}) WHERE noteid = #{noteid}")
    @Options(useGeneratedKeys = true, keyProperty = "noteid")
    int insertNote(Note note);

    @Delete("DELETE FROM NOTES WHERE noteid = #{noteid}")
    void deleteNote(Integer noteid);


}

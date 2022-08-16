package com.richardsoares.firstproject_androidsrs.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.richardsoares.firstproject_androidsrs.model.Aluno;

@Database(entities = {Aluno.class}, version = 1, exportSchema = false)
public abstract class AgendaDatabase extends RoomDatabase {

}

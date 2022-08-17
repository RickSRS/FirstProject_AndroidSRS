package com.richardsoares.firstproject_androidsrs.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.richardsoares.firstproject_androidsrs.database.dao.AlunoDAO;
import com.richardsoares.firstproject_androidsrs.model.Aluno;

@Database(entities = {Aluno.class}, version = 1, exportSchema = false)
public abstract class AgendaDatabase extends RoomDatabase {

    private static final String BANCO_DE_DADOS = "agenda.db";

    public abstract AlunoDAO getRoomAlunoDAO();

    public static AgendaDatabase getInstance(Context context) {
        return Room.databaseBuilder(context, AgendaDatabase.class, BANCO_DE_DADOS)
                .allowMainThreadQueries()
                .build();
    }
}

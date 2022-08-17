package com.richardsoares.firstproject_androidsrs;

import android.app.Application;

import androidx.room.Room;

import com.richardsoares.firstproject_androidsrs.dao.AlunoDAO;
import com.richardsoares.firstproject_androidsrs.database.AgendaDatabase;
import com.richardsoares.firstproject_androidsrs.database.dao.RoomAlunoDAO;
import com.richardsoares.firstproject_androidsrs.model.Aluno;

public class AgendaAppliaction extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        criaAlunosTeste();
    }

    private void criaAlunosTeste() {
        AgendaDatabase dataBase = Room.databaseBuilder(this, AgendaDatabase.class, "agenda.db")
                .allowMainThreadQueries()
                .build();
        RoomAlunoDAO dao = dataBase.getRoomAlunoDAO();
        dao.salva(new Aluno("Richard", "1112223333", "srs@gmail.com"));
        dao.salva(new Aluno("Fran", "1112223333", "fran@gmail.com"));
    }
}

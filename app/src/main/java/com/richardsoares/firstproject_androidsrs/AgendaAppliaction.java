package com.richardsoares.firstproject_androidsrs;

import android.app.Application;

import com.richardsoares.firstproject_androidsrs.dao.AlunoDAO;
import com.richardsoares.firstproject_androidsrs.model.Aluno;

public class AgendaAppliaction extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        criaAlunosTeste();
    }

    private void criaAlunosTeste() {
        AlunoDAO dao = new AlunoDAO();
        dao.salva(new Aluno("Richard", "1112223333", "srs@gmail.com"));
        dao.salva(new Aluno("Fran", "1112223333", "fran@gmail.com"));
    }
}

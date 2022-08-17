package com.richardsoares.firstproject_androidsrs.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import com.richardsoares.firstproject_androidsrs.database.AgendaDatabase;
import com.richardsoares.firstproject_androidsrs.database.dao.AlunoDAO;
import com.richardsoares.firstproject_androidsrs.model.Aluno;
import com.richardsoares.firstproject_androidsrs.ui.adapter.ListaAlunosAdapter;

public class ListaAlunosView {
    private final ListaAlunosAdapter adapter;
    private final AlunoDAO dao;
    private final Context context;

    public ListaAlunosView(Context context) {
        this.context = context;
        this.adapter = new ListaAlunosAdapter(this.context);
        dao = AgendaDatabase.getInstance(context).getRoomAlunoDAO();
    }

    public void confirmaRemocao(final MenuItem item) {
        new AlertDialog
                .Builder(context)
                .setTitle("Remover aluno")
                .setMessage("Tem certeza que deseja remover o aluno?")
                .setPositiveButton("Sim", (dialogInterface, i) -> {
                    AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                    Aluno alunoEscolhido = adapter.getItem(menuInfo.position);
                    remove(alunoEscolhido);
                })
                .setNegativeButton("Não", null).
                show();
    }

    public void atualizaAlunos() {
        adapter.atualiza(dao.todos());
    }

    private void remove(Aluno aluno) {
        dao.remove(aluno);
        adapter.remove(aluno);
    }

    public void configAdapter(ListView listaAlunos) {
        listaAlunos.setAdapter(adapter);
    }
}
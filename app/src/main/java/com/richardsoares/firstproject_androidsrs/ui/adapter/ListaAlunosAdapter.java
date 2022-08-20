package com.richardsoares.firstproject_androidsrs.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.richardsoares.firstproject_androidsrs.R;
import com.richardsoares.firstproject_androidsrs.database.AgendaDatabase;
import com.richardsoares.firstproject_androidsrs.database.dao.TelefoneDAO;
import com.richardsoares.firstproject_androidsrs.model.Aluno;
import com.richardsoares.firstproject_androidsrs.model.Telefone;

import java.util.ArrayList;
import java.util.List;

public class ListaAlunosAdapter extends BaseAdapter {
    private final List<Aluno> alunos = new ArrayList<>();
    private final Context context;

    public ListaAlunosAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return alunos.size();
    }

    @Override
    public Aluno getItem(int index) {
        return alunos.get(index);
    }

    @Override
    public long getItemId(int index) {
        return alunos.get(index).getId();
    }

    @Override
    public View getView(int index, View view, ViewGroup viewGroup) {
        View viewCriada = criaView(viewGroup);
        Aluno alunoDevolvido = alunos.get(index);
        vinculaAluno(viewCriada, alunoDevolvido);
        return viewCriada;
    }

    private void vinculaAluno(View view, Aluno aluno) {
        TextView nome = view.findViewById(R.id.item_aluno_nome);
        nome.setText(aluno.getNomeCompleto());
        TextView telefone = view.findViewById(R.id.item_aluno_telefone);
        TelefoneDAO dao = AgendaDatabase.getInstance(context).getTelefoneDAO();
        Telefone primeiroTelefone = dao.buscaPrimeiroTelefoneDoAluno(aluno.getId());
        telefone.setText(primeiroTelefone.getNumero());
    }

    private View criaView(ViewGroup viewGroup) {
        return LayoutInflater
                .from(context)
                .inflate(R.layout.item_aluno, viewGroup, false);
    }

    public void remove(Aluno aluno) {
        alunos.remove(aluno);
        notifyDataSetChanged();
    }

    public void atualiza(List<Aluno> alunos){
        this.alunos.clear();
        this.alunos.addAll(alunos);
        notifyDataSetChanged();
    }
}

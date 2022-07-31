package com.richardsoares.firstproject_androidsrs.dao;

import androidx.annotation.Nullable;

import com.richardsoares.firstproject_androidsrs.model.Aluno;

import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {
    private final static List<Aluno> alunos = new ArrayList<>();
    private static int contadorIds = 1;

    public void salva(Aluno aluno) {
        aluno.setId(contadorIds);
        alunos.add(aluno);
        atualizaIds();
    }

    private void atualizaIds() {
        contadorIds++;
    }

    public void edita(Aluno aluno) {
        Aluno alunoEncontrado = buscaAlunoPorId(aluno);
        if (alunoEncontrado != null) {
            int indexAluno = alunos.indexOf(alunoEncontrado);
            alunos.set(indexAluno, aluno);
        }
    }

    @Nullable
    private Aluno buscaAlunoPorId(Aluno aluno) {
        Aluno alunoEncontrado = null;
        for (Aluno a :
                alunos) {
            if (a.getId() == aluno.getId()) {
                return a;
            }
        }
        return null;
    }

    public List<Aluno> todos() {
        return new ArrayList<>(alunos);
    }
}

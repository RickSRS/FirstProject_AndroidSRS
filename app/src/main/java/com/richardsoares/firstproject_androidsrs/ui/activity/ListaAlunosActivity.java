package com.richardsoares.firstproject_androidsrs.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.richardsoares.firstproject_androidsrs.R;
import com.richardsoares.firstproject_androidsrs.dao.AlunoDAO;
import com.richardsoares.firstproject_androidsrs.model.Aluno;

import java.util.List;

import static com.richardsoares.firstproject_androidsrs.ui.activity.ConstantesActivities.CHAVE_ALUNO;

public class ListaAlunosActivity extends AppCompatActivity {

    private static final String TITULO_APPBAR = "Lista de Alunos";
    private final AlunoDAO dao = new AlunoDAO();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);
        setTitle(TITULO_APPBAR);
        fabNovoAluno();
        dao.salva(new Aluno("Richard", "1112223333", "srs@gmail.com"));
        dao.salva(new Aluno("Fran", "1112223333", "fran@gmail.com"));
    }

    private void fabNovoAluno() {
        FloatingActionButton btnNovoAluno = findViewById(R.id.activity_lista_alunos_fab_novo_aluno);
        btnNovoAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abreFormulariomModoInsereAluno();
            }
        });
    }

    private void abreFormulariomModoInsereAluno() {
        startActivity(new Intent(this, FormularioAlunoActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        configuraListViewAlunos();
    }

    private void configuraListViewAlunos() {
        ListView listaAlunos = findViewById(R.id.activity_lista_alunos_listview);
        final List<Aluno> alunos = dao.todos();
        configAdapter(listaAlunos, alunos);
        configListenerClickPorItem(listaAlunos);
    }

    private void configListenerClickPorItem(ListView listaAlunos) {
        listaAlunos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int index, long id) {
                Aluno alunoEscolhido = (Aluno) adapterView.getItemAtPosition(index);
                abreFormularioModoEditarAluno(alunoEscolhido);
            }
        });
    }

    private void abreFormularioModoEditarAluno(Aluno aluno) {
        Intent vaiParaFormularioActivity = new Intent(ListaAlunosActivity.this, FormularioAlunoActivity.class);
        vaiParaFormularioActivity.putExtra(CHAVE_ALUNO, aluno);
        startActivity(vaiParaFormularioActivity);
    }

    private void configAdapter(ListView listaAlunos, List<Aluno> alunos) {
        listaAlunos.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                alunos));
    }
}
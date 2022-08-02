package com.richardsoares.firstproject_androidsrs.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.richardsoares.firstproject_androidsrs.R;
import com.richardsoares.firstproject_androidsrs.dao.AlunoDAO;
import com.richardsoares.firstproject_androidsrs.model.Aluno;

import static com.richardsoares.firstproject_androidsrs.ui.activity.ConstantesActivities.CHAVE_ALUNO;

public class FormularioAlunoActivity extends AppCompatActivity {

    private static final String TITULO_APPBAR_NOVO_ALUNO = "Novo aluno";
    private static final String TITULO_APPBAR_EDITA_ALUNO = "Edita aluno";
    private EditText nomeAluno;
    private EditText telefoneAluno;
    private EditText emailAluno;
    private final AlunoDAO dao = new AlunoDAO();
    private Aluno aluno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_aluno);
        inicializacaoVariavel();
        carregaAluno();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_formulario_aluno_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.activity_formulario_aluno_menu_salvar) {
            finalizaFormulario();
        }
        return super.onOptionsItemSelected(item);
    }

    private void carregaAluno() {
        Intent dados = getIntent();
        if (dados.hasExtra(CHAVE_ALUNO)) {
            setTitle(TITULO_APPBAR_EDITA_ALUNO);
            aluno = (Aluno) dados.getSerializableExtra(CHAVE_ALUNO);
            preencheCampos();
        } else {
            setTitle(TITULO_APPBAR_NOVO_ALUNO);
            aluno = new Aluno();
        }
    }

    private void preencheCampos() {
        nomeAluno.setText(aluno.getNome());
        telefoneAluno.setText(aluno.getTelefone());
        emailAluno.setText(aluno.getEmail());
    }

    private void finalizaFormulario() {
        preencheAluno();
        if (aluno.temIdValido()) {
            dao.edita(aluno);
        } else {
            dao.salva(aluno);
        }
        finish();
    }

    private void inicializacaoVariavel() {
        nomeAluno = findViewById(R.id.activity_formulario_aluno_nome);
        telefoneAluno = findViewById(R.id.activity_formulario_aluno_telefone);
        emailAluno = findViewById(R.id.activity_formulario_aluno_email);
    }

    private void preencheAluno() {
        String nome = nomeAluno.getText().toString();
        String telefone = telefoneAluno.getText().toString();
        String email = emailAluno.getText().toString();

        aluno.setNome(nome);
        aluno.setTelefone(telefone);
        aluno.setEmail(email);
    }
}
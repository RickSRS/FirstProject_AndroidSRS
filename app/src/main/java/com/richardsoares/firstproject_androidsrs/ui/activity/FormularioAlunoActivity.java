package com.richardsoares.firstproject_androidsrs.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.richardsoares.firstproject_androidsrs.R;
import com.richardsoares.firstproject_androidsrs.dao.AlunoDAO;
import com.richardsoares.firstproject_androidsrs.model.Aluno;

public class FormularioAlunoActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Novo aluno";
    private EditText nomeAluno;
    private EditText telefoneAluno;
    private EditText emailAluno;
    private final AlunoDAO dao = new AlunoDAO();
    private Aluno aluno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_aluno);
        setTitle(TITULO_APPBAR);
        inicializacaoVariavel();
        configBtnSalvarAluno();

        Intent dados = getIntent();
        aluno = (Aluno) dados.getSerializableExtra("aluno");
        nomeAluno.setText(aluno.getNome());
        telefoneAluno.setText(aluno.getTelefone());
        emailAluno.setText(aluno.getEmail());
    }

    private void configBtnSalvarAluno() {
        Button btnSalvar = findViewById(R.id.activity_formulario_aluno_btn_salvar);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Aluno alunoCriado = preencheAluno();
                //salvaAluno(alunoCriado);
                preencheAluno();
                dao.edita(aluno);
                finish();
            }
        });
    }

    private void inicializacaoVariavel() {
        nomeAluno = findViewById(R.id.activity_formulario_aluno_nome);
        telefoneAluno = findViewById(R.id.activity_formulario_aluno_telefone);
        emailAluno = findViewById(R.id.activity_formulario_aluno_email);
    }

    private void salvaAluno(Aluno alunoCriado) {
        dao.salva(alunoCriado);
        finish();
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
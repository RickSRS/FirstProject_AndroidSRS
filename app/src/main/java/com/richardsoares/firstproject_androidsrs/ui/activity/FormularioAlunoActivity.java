package com.richardsoares.firstproject_androidsrs.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.richardsoares.firstproject_androidsrs.R;
import com.richardsoares.firstproject_androidsrs.dao.AlunoDAO;
import com.richardsoares.firstproject_androidsrs.model.Aluno;

public class FormularioAlunoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_aluno);

        final AlunoDAO dao = new AlunoDAO();

        final EditText nomeAluno = findViewById(R.id.activity_formulario_aluno_nome);
        final EditText telefoneAluno = findViewById(R.id.activity_formulario_aluno_telefone);
        final EditText emailAluno = findViewById(R.id.activity_formulario_aluno_email);

        Button btnSalvar = findViewById(R.id.activity_formulario_aluno_btn_salvar);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = nomeAluno.getText().toString();
                String telefone = telefoneAluno.getText().toString();
                String email = emailAluno.getText().toString();

                Aluno alunoCriado = new Aluno(nome, telefone, email);
                dao.salva(alunoCriado);

                finish();
            }
        });
    }
}
package com.richardsoares.firstproject_androidsrs.database.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.richardsoares.firstproject_androidsrs.model.Telefone;

@Dao
public interface TelefoneDAO {
    @Query("SELECT t.* FROM Telefone t " +
            "JOIN Aluno a ON t.alunoId = a.id " +
            "WHERE t.alunoId = :alunoId LIMIT 1")
    Telefone buscaPrimeiroTelefoneDoAluno(int alunoId);
}

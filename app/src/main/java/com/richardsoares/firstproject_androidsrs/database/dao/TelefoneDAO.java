package com.richardsoares.firstproject_androidsrs.database.dao;

import androidx.room.Dao;

import com.richardsoares.firstproject_androidsrs.model.Telefone;

@Dao
public interface TelefoneDAO {
    Telefone buscaPrimeiroTelefoneDoAluno();
}

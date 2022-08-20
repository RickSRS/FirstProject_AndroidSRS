package com.richardsoares.firstproject_androidsrs.database;

import androidx.annotation.NonNull;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

public class AgendaMigrations {
    private static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE aluno ADD COLUMN sobrenome TEXT");
        }
    };

    private static final Migration MIGRATION_2_3 = new Migration(2, 3) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE aluno ADD COLUMN dataCadastro INTEGER");
        }
    };

    private static final Migration MIGRATION_3_4 = new Migration(3, 4) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("CREATE TABLE IF NOT EXISTS `Aluno_novo` (" +
                    "`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                    "`nome` TEXT, " +
                    "`sobrenome` TEXT, " +
                    "`telefoneFixo` TEXT, " +
                    "`email` TEXT, " +
                    "`telefoneCelular` TEXT)");

            database.execSQL("INSERT INTO Aluno_novo (id, nome, sobrenome, telefoneFixo, email)" +
                            "SELECT id, nome, sobrenome, telefone, email FROM Aluno");

            database.execSQL("DROP TABLE Aluno");

            database.execSQL("ALTER TABLE Aluno_novo RENAME TO Aluno");
        }
    };

    static final Migration[] TODAS_MIGRATIONS = {MIGRATION_1_2, MIGRATION_2_3, MIGRATION_3_4};
}

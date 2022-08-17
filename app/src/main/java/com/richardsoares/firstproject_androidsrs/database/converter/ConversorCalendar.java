package com.richardsoares.firstproject_androidsrs.database.converter;

import androidx.room.TypeConverter;

import java.util.Calendar;

public class ConversorCalendar {
    @TypeConverter
    public Long paraLong(Calendar valor) {
        return valor.getTimeInMillis();
    }

    @TypeConverter
    public Calendar paraCalendar(Long valor) {
        Calendar dataAtual = Calendar.getInstance();
        if (valor != null) {
            dataAtual.setTimeInMillis(valor);
        }
        return dataAtual;
    }
}

package com.leet.temp.Leet.jva.model;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public enum BirthdayFormat {
    DDsMMsYY,
    YYYYMMDD;
    static DateTimeFormatter SLASH_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    static DateTimeFormatter NO_SEPAR_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd");
    private LocalDate date;

    private DateTimeFormatter formatter;
}

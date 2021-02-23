package com.leet.temp.Leet.jva.model;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Birthday {
    static DateTimeFormatter SLASH_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    static DateTimeFormatter NO_SEPAR_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd");
    private LocalDate date;

    private Birthday(String date, DateTimeFormatter formatter) {
        this.formatter = formatter;
        this.date = LocalDate.parse(date, formatter);
    }

    private DateTimeFormatter formatter;
    public static Birthday createBirthdayFromString(String date, BirthdayFormat format) {
        switch (format) {
            case DDsMMsYY:
                return new Birthday(date, SLASH_FORMATTER);
            case YYYYMMDD:
                return new Birthday(date, NO_SEPAR_FORMATTER);
            default:
                throw new IllegalStateException("Format " + format + " not supported");
        }
    }
    @Override
    public String toString() {
        return "Birthday{" + date +  '}';
    }

}

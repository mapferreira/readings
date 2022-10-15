package com.domike.reading;

import java.time.LocalDate;

public class Reading {

    public Long reading;
    public LocalDate date;

    public ReadingType type;

    public Reading() {

    }

    public Reading(Long reading, LocalDate date, ReadingType type) {
        this.reading = reading;
        this.date = date;
        this.type = type;
    }
}

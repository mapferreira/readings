package com.domike.reading;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Priority;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Alternative;
import java.time.LocalDate;

@Priority(1)
@Alternative
@ApplicationScoped
public class TestReading extends Readings {

    @PostConstruct
    public void init() {
        readings.add(new Reading(1000L, LocalDate.now(), ReadingType.ELECTRICITY));
        readings.add(new Reading(1000L, LocalDate.now(), ReadingType.GAS));
        readings.add(new Reading(1000L, LocalDate.now(), ReadingType.WATER));
        readings.add(new Reading(1000L, LocalDate.now(), null));
    }

}

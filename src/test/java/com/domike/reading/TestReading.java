package com.domike.reading;

import javax.annotation.PostConstruct;
import javax.annotation.Priority;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import java.time.LocalDate;

@Priority(1)
@Alternative
@ApplicationScoped
public class TestReading extends Readings{

    @PostConstruct
    public void init() {
        Reading reading = new Reading();
        reading.type = ReadingType.ELECTRICITY;
        reading.date = LocalDate.now();
        reading.reading = 1000L;
        readings.add(reading);
    }

}

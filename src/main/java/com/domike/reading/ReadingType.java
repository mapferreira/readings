package com.domike.reading;

public enum ReadingType {
    ELECTRICITY("Electricity", "Kw"), GAS("Gas", "Kw"), WATER("Water", "m3");
    public final String label;
    public final String unit;

    ReadingType(String label, String unit) {
        this.label = label;
        this.unit = unit;
    }
}

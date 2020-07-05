package com.deepika.GenricsInterface;

import java.util.Comparator;

public class CarColourComparator implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        return o1.colour.compareTo(o2.colour);
    }
}

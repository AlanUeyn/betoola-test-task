package ru.tsyrikov.betoola.rounding;

import java.math.RoundingMode;

public class ServiceFavorRoundingStrategy implements RoundingStrategy{

    @Override
    public RoundingMode buyRounding() {
        return RoundingMode.FLOOR;
    }

    @Override
    public RoundingMode sellRounding() {
        return RoundingMode.CEILING;
    }
}

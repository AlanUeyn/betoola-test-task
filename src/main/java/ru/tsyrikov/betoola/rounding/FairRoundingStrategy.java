package ru.tsyrikov.betoola.rounding;

import java.math.RoundingMode;

public class FairRoundingStrategy implements RoundingStrategy {

    @Override
    public RoundingMode buyRounding() {
        return RoundingMode.HALF_UP;
    }

    @Override
    public RoundingMode sellRounding() {
        return RoundingMode.HALF_UP;
    }
}

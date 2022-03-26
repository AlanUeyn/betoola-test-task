package ru.tsyrikov.betoola.rounding;

import java.math.RoundingMode;

public class CustomerFavorRoundingStrategy implements RoundingStrategy{
    @Override
    public RoundingMode buyRounding() {
        return RoundingMode.CEILING;
    }

    @Override
    public RoundingMode sellRounding() {
        return RoundingMode.FLOOR;
    }
}

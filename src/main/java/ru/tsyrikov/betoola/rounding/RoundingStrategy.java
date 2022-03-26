package ru.tsyrikov.betoola.rounding;

import java.math.RoundingMode;

public interface RoundingStrategy {

    RoundingMode buyRounding();

    RoundingMode sellRounding();

}

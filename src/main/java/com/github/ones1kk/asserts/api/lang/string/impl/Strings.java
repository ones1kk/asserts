package com.github.ones1kk.asserts.api.lang.string.impl;

import com.github.ones1kk.asserts.api.AsAssert;
import com.github.ones1kk.asserts.api.feature.comparable.calculator.ComparableCalculatorInterface;
import com.github.ones1kk.asserts.api.feature.comparable.calculator.impl.StringCalculator;
import com.github.ones1kk.asserts.api.lang.charsequence.impl.CharSequences;
import com.github.ones1kk.asserts.api.lang.string.StringsInterface;

public class Strings extends CharSequences implements StringsInterface<String> {

    private final ComparableCalculatorInterface<String> calculator = new StringCalculator();

    public Strings(CharSequence actual, AsAssert<?> asAssert) {
        super(actual, asAssert);
    }

    @Override
    public void assertIsLessThan(String actual, String expected) {
        if (calculator.isGraterThan(actual, expected)) {
            asAssert.setDescription(actual, "{} is not less than {}");
            throw asAssert.getException();
        }
    }

    @Override
    public void assertIsLessThanOrEqualTo(String actual, String expected) {
        if (calculator.isGraterThanOrEqualTo(actual, expected)) {
            asAssert.setDescription(actual, expected, "{} is not less than or equal to {}");
            throw asAssert.getException();
        }
    }

    @Override
    public void assertIsGreaterThan(String actual, String expected) {
        if (calculator.isLessThan(actual, expected)) {
            asAssert.setDescription(actual, expected, "{} is not greater than {}");
            throw asAssert.getException();
        }
    }

    @Override
    public void assertIsGreaterThanOrEqualTo(String actual, String expected) {
        if (calculator.isLessThanOrEqualTo(actual, expected)) {
            asAssert.setDescription(actual, expected, "{} is not greater than or equal to {}");
            throw asAssert.getException();
        }
    }

    @Override
    public void assertIsBetween(String actual, String start, String end) {
        // TODO
        //   asAssert.setDescription() -> update args
        //  {} is not between {} and {}
        if (calculator.isLessThan(actual, start) || calculator.isGraterThan(actual, end)) {
            asAssert.setDescription(actual, "{} is not between ");
            throw asAssert.getException();
        }
    }

}
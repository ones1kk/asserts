package com.github.ones1kk.asserts.core.lang.duble.impl;

import com.github.ones1kk.asserts.core.AsAssert;
import com.github.ones1kk.asserts.core.feature.Offset;
import com.github.ones1kk.asserts.core.feature.comparable.calculator.ComparableCalculatorInterface;
import com.github.ones1kk.asserts.core.feature.comparable.calculator.impl.DoubleCalculator;
import com.github.ones1kk.asserts.core.lang.duble.DoublesInterface;
import com.github.ones1kk.asserts.core.lang.object.impl.Objects;

import static com.github.ones1kk.asserts.core.feature.number.unit.DoubleUnit.of;

public class Doubles extends Objects<Double> implements DoublesInterface<Double> {

    private final ComparableCalculatorInterface<Double> calculator = new DoubleCalculator();


    public Doubles(AsAssert<?> asAssert) {
        super(asAssert);
    }

    @Override
    public void assertIsInfinity(Double actual) {
        if (!Double.isInfinite(actual)) {
            handler.setDescription(handler.from(actual, "{} is not infinity"));
            throw handler.getException();
        }
    }

    @Override
    public void assertIsFinite(Double actual) {
        if (!Double.isFinite(actual)) {
            handler.setDescription(handler.from(actual, "{} is not finite"));
            throw handler.getException();
        }
    }

    @Override
    public void assertIsNaN(Double actual) {
        if (!Double.isNaN(actual)) {
            handler.setDescription(handler.from(actual, "{} is not NaN"));
            throw handler.getException();
        }
    }

    @Override
    public void assertIsLessThan(Double actual, Double expected) {
        if (calculator.isGraterThanOrEqualTo(actual, expected)) {
            handler.setDescription(handler.from(actual, expected, "{} is not less than {}"));
            throw handler.getException();
        }
    }

    @Override
    public void assertIsLessThanOrEqualTo(Double actual, Double expected) {
        if (calculator.isGraterThan(actual, expected)) {
            handler.setDescription(handler.from(actual, expected, "{} is not less than or equal to {}"));
            throw handler.getException();
        }
    }

    @Override
    public void assertIsGreaterThan(Double actual, Double expected) {
        if (calculator.isLessThanOrEqualTo(actual, expected)) {
            handler.setDescription(handler.from(actual, expected, "{} is not greater than {}"));
            throw handler.getException();
        }
    }

    @Override
    public void assertIsGreaterThanOrEqualTo(Double actual, Double expected) {
        if (calculator.isLessThan(actual, expected)) {
            handler.setDescription(handler.from(actual, expected, "{} is not greater than or equal to {}"));
            throw handler.getException();
        }
    }

    @Override
    public void assertIsBetween(Double actual, Double start, Double end) {
        if (calculator.isLessThan(actual, start)
                || calculator.isGraterThan(actual, end)) {
            String description = handler.from("{} is not between {} and {}", actual, start, end);
            handler.setDescription(handler.from(actual, description));
            throw handler.getException();
        }
    }

    @Override
    public void assertIsPositive(Double actual) {
        if (calculator.isLessThanOrEqualTo(actual, (double) 0)) {
            handler.setDescription(handler.from(actual, "{} is not positive"));
            throw handler.getException();
        }
    }

    @Override
    public void assertIsNotPositive(Double actual) {
        if (calculator.isGraterThan(actual, (double) 0)) {
            handler.setDescription(handler.from(actual, "{} is positive"));
            throw handler.getException();
        }
    }

    @Override
    public void assertIsNegative(Double actual) {
        if (calculator.isGraterThanOrEqualTo(actual, (double) 0)) {
            handler.setDescription(handler.from(actual, "{} is not negative"));
            throw handler.getException();
        }
    }

    @Override
    public void assertIsNotNegative(Double actual) {
        if (calculator.isLessThan(actual, (double) 0)) {
            handler.setDescription(handler.from(actual, "{} is negative"));
            throw handler.getException();
        }
    }

    @Override
    public void assertIsZero(Double actual) {
        if (of(actual).isNotZero()) {
            handler.setDescription(handler.from(actual, "{} is not zero"));
            throw handler.getException();
        }
    }

    @Override
    public void assertIsNotZero(Double actual) {
        if (of(actual).isZero()) {
            handler.setDescription(handler.from(actual, "{} is zero"));
            throw handler.getException();
        }
    }

    @Override
    public void assertIsCloseTo(Double actual, Double expected, Offset<Double> offset) {
        double startResult = Double.compare(actual, (expected - offset.getValue()));
        double endResult = Double.compare(actual, (expected + offset.getValue()));

        if (calculator.is(startResult, (double) -1)
                || calculator.is(endResult, (double) 1)) {
            setAssertClose(actual, expected, offset);
        }
    }

    @Override
    public void assertIsNotCloseTo(Double actual, Double expected, Offset<Double> offset) {
        double startResult = Double.compare(actual, (expected - offset.getValue()));
        double endResult = Double.compare(actual, (expected + offset.getValue()));

        if (calculator.is(startResult, (double) 1)
                || calculator.is(endResult, (double) 1)) {
            setAssertClose(actual, expected, offset);
        }
    }

    private void setAssertClose(Double actual, Double expected, Offset<Double> offset) {
        // TODO : getter
        String scope = handler.getDescribable().as("{} is close to {}", actual,
                (expected - offset.getValue()) + " ~ " + (expected + offset.getValue()));
        handler.setDescription(handler.from(actual, scope));
        throw handler.getException();
    }
}

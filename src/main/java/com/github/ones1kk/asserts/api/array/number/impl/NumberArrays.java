package com.github.ones1kk.asserts.api.array.number.impl;

import com.github.ones1kk.asserts.api.AsAssert;
import com.github.ones1kk.asserts.api.array.number.NumberArraysInterface;
import com.github.ones1kk.asserts.api.feature.iterable.containable.Containable;
import com.github.ones1kk.asserts.api.feature.iterable.containable.impl.NumberArrayContainable;
import com.github.ones1kk.asserts.api.lang.object.impl.Objects;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.function.Predicate;

public class NumberArrays extends Objects<Number[]> implements NumberArraysInterface<Number[], Number> {

    private final Containable<Number[], Number> containable = new NumberArrayContainable();

    public NumberArrays(AsAssert<?> asAssert) {
        super(asAssert);
    }

    @Override
    public void assertIsMax(Number[] actual, Number expected) {
        // TODO
    }

    @Override
    public void assertIsMin(Number[] actual, Number expected) {
        // TODO
    }

    @Override
    public void assertIsEmpty(Number[] actual) {
        if (ArrayUtils.isNotEmpty(actual)) {
            handler.setDescription(handler.from(toString(actual), "{} is not empty"));
            throw handler.getException();
        }
    }

    @Override
    public void assertIsNotEmpty(Number[] actual) {
        if (ArrayUtils.isEmpty(actual)) {
            handler.setDescription(handler.from(toString(actual), "{} is empty"));
            throw handler.getException();
        }
    }

    @Override
    public void assertIsNullOrEmpty(Number[] actual) {
        if (ArrayUtils.isNotEmpty(actual) || actual == null) {
            handler.setDescription(handler.from(toString(actual), "{} is not null or not empty"));
            throw handler.getException();
        }
    }

    @Override
    public void assertContains(Number[] actual, Number expected) {
        if (containable.doesNotContains(actual, expected)) {
            handler.setDescription(handler.from(toString(actual), expected, "{} doesn't contains of {}"));
            throw handler.getException();
        }

    }

    @Override
    public void assertDoesNotContain(Number[] actual, Number expected) {
        if (containable.contains(actual, expected)) {
            handler.setDescription(handler.from(toString(actual), expected, "{} contains of {}"));
            throw handler.getException();
        }
    }

    @Override
    public void assertContainsAll(Number[] actual, Number... expected) {

    }

    @Override
    public void assertContainsAny(Number[] actual, Number... expected) {

    }

    @Override
    public void assertContainsNull(Number[] actual) {

    }

    @Override
    public void assertDoesNotContainNull(Number[] actual) {

    }

    @Override
    public void assertAllMatch(Number[] actual, Predicate<Number> expected) {

    }

    @Override
    public void assertNoneMatch(Number[] actual, Predicate<Number> expected) {

    }

    private String toString(Number[] actual) {
        return Arrays.deepToString(actual);
    }
}
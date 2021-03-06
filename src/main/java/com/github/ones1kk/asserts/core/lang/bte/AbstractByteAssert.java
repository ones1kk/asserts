package com.github.ones1kk.asserts.core.lang.bte;

import com.github.ones1kk.asserts.core.feature.Offset;
import com.github.ones1kk.asserts.core.lang.object.AbstractObjectAssert;

public class AbstractByteAssert<SELF extends AbstractByteAssert<SELF, ACTUAL>, ACTUAL> extends AbstractObjectAssert<SELF, Byte> implements ByteAssertInterface<SELF> {

    private final BytesInterface<Byte> bytes;

    public AbstractByteAssert(Class<?> self, Byte actual) {
        super(self, actual);
        this.bytes = assertFactory.createAssert(actual, this);
    }

    @Override
    public SELF isOdd() {
        bytes.assertIsOdd(actual);
        return self;
    }

    @Override
    public SELF isNotOdd() {
        bytes.assertIsNotOdd(actual);
        return self;
    }

    @Override
    public SELF isEven() {
        bytes.assertIsEven(actual);
        return self;
    }

    @Override
    public SELF isNotEven() {
        bytes.assertIsNotEven(actual);
        return self;
    }

    @Override
    public SELF isLessThan(Byte expected) {
        bytes.assertIsLessThan(actual, expected);
        return self;
    }

    @Override
    public SELF isLessThanOrEqualTo(Byte expected) {
        bytes.assertIsLessThanOrEqualTo(actual, expected);
        return self;
    }

    @Override
    public SELF isGreaterThan(Byte expected) {
        bytes.assertIsGreaterThan(actual, expected);
        return self;
    }

    @Override
    public SELF isGreaterThanOrEqualTo(Byte expected) {
        bytes.assertIsGreaterThanOrEqualTo(actual, expected);
        return self;
    }

    @Override
    public SELF isBetween(Byte start, Byte end) {
        bytes.assertIsBetween(actual, start, end);
        return self;
    }

    @Override
    public SELF isPositive() {
        bytes.assertIsPositive(actual);
        return self;
    }

    @Override
    public SELF isNotPositive() {
        bytes.assertIsNotPositive(actual);
        return self;
    }

    @Override
    public SELF isNegative() {
        bytes.assertIsNegative(actual);
        return self;
    }

    @Override
    public SELF isNotNegative() {
        bytes.assertIsNotNegative(actual);
        return self;
    }

    @Override
    public SELF isZero() {
        bytes.assertIsZero(actual);
        return self;
    }

    @Override
    public SELF isNotZero() {
        bytes.assertIsNotZero(actual);
        return self;
    }

    @Override
    public SELF isCloseTo(Byte expected, Offset<Byte> offset) {
        bytes.assertIsCloseTo(actual, expected, offset);
        return self;
    }

    @Override
    public SELF isNotCloseTo(Byte expected, Offset<Byte> offset) {
        bytes.assertIsNotCloseTo(actual, expected, offset);
        return self;
    }
}

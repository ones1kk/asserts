package com.github.ones1kk.asserts.api.lang.integer;

import com.github.ones1kk.asserts.api.feature.comparable.Comparable;
import com.github.ones1kk.asserts.api.feature.number.Numerable;

public interface IntegersInterface<ACTUAL> extends Comparable<ACTUAL>, Numerable<Integer> {

    void assertIsOdd(ACTUAL actual);

    void assertIsNotOdd(ACTUAL actual);

    void assertIsEven(ACTUAL actual);

    void assertIsNotEven(ACTUAL actual);
}

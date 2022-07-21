package com.github.ones1kk.asserts.api.lang.shrt;

import com.github.ones1kk.asserts.api.feature.comparable.ComparableAssert;
import com.github.ones1kk.asserts.api.feature.number.NumerableAssert;

public interface ShortAssertInterface<SELF> extends NumerableAssert<SELF, Short>, ComparableAssert<SELF, Short> {

    SELF isOdd();

    SELF isNotOdd();

    SELF isEven();

    SELF isNotEven();
}

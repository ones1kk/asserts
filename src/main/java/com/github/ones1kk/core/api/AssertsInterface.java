package com.github.ones1kk.core.api;

public interface AssertsInterface<SELF, ACTUAL> {

    SELF isNull();

    SELF isNotNull();

    SELF isSameAs(ACTUAL expected);

    SELF isEqualTo(ACTUAL expected);

    SELF isNotEqualTo(ACTUAL expected);

    SELF isAssignableFrom(Class<?> expected);
}
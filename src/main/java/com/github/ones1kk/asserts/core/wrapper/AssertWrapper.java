package com.github.ones1kk.asserts.core.wrapper;

import javax.annotation.Nullable;
import java.util.function.Supplier;

@Deprecated
public interface AssertWrapper<SELF> {

    SELF as(Supplier<String> description, @Nullable Object... args);

    SELF as(String description, @Nullable Object... args);
}

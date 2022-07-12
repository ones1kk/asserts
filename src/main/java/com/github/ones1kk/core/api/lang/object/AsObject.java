package com.github.ones1kk.core.api.lang.object;

import com.github.ones1kk.core.api.lang.model.ObjectAssert;
import com.github.ones1kk.core.api.lang.object.impl.ObjectsImpl;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public class AsObject extends AbstractObjectAssert<ObjectAssert, Object> {

    private final Object actual;

    public AsObject(Class<?> self, Object actual, ObjectsImpl objects) {
        super(self, actual, objects);
        this.actual = actual;
    }

    public ObjectAssert as(Supplier<String> description, @Nullable Object... args) {
        described(description.get(), args);
        return new ObjectAssert(ObjectAssert.class, actual, objects);
    }

    public ObjectAssert as(String description, @Nullable Object... args) {
        described(description, args);
        return new ObjectAssert(ObjectAssert.class, actual, objects);
    }

    private void described(String description, Object[] args) {
        objects.asDescription = objects.describable.describedFormat(actual, null,
                objects.described(description, args));
    }

}

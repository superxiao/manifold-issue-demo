package com.extensions.java.lang.Object;

import java.util.Optional;
import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.Self;
import manifold.ext.rt.api.This;

@Extension
public class ObjectExt {
    public static Optional<@Self Object> asOpt(@This Object it) {
        return Optional.ofNullable(it);
    }
}
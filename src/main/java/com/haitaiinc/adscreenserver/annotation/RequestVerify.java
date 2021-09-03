package com.haitaiinc.adscreenserver.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
@Inherited
public @interface RequestVerify {
    public abstract boolean isVerifyIP();
}

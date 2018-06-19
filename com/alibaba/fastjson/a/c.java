package com.alibaba.fastjson.a;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
/* compiled from: JSONPOJOBuilder */
public @interface c {
    String a() default "build";

    String b() default "with";
}

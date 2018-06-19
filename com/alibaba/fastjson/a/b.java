package com.alibaba.fastjson.a;

import com.alibaba.fastjson.serializer.SerializerFeature;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
/* compiled from: JSONField */
public @interface b {
    int a() default 0;

    String b() default "";

    String c() default "";

    boolean d() default true;

    boolean e() default true;

    SerializerFeature[] f() default {};

    String g() default "";
}

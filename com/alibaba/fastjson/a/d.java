package com.alibaba.fastjson.a;

import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
/* compiled from: JSONType */
public @interface d {
    boolean a() default true;

    String[] b() default {};

    String[] c() default {};

    String[] d() default {};

    SerializerFeature[] e() default {};

    Feature[] f() default {};

    boolean g() default true;

    Class<?> h() default Void.class;

    Class<?> i() default Void.class;
}

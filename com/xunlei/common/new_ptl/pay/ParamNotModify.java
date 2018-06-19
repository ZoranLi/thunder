package com.xunlei.common.new_ptl.pay;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Inherited
@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.CLASS)
public @interface ParamNotModify {
}

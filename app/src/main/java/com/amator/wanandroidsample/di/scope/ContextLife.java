package com.amator.wanandroidsample.di.scope;

/**
 * Created by AmatorLee on 2018/4/26.
 */

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface ContextLife{
    String value() default "";
}

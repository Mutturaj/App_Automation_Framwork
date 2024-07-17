package com.stockBroking.qa.testRail;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author kuldeep.yadav
 * @date 15/02/24
 * @package testRail
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface TestRail {

    String testRailId() default "";
    String[] tags()default"";
}
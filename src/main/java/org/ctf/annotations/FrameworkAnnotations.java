package org.ctf.annotations;

import org.ctf.enums.CategoryType;
import org.ctf.enums.DeviceType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface FrameworkAnnotations {

    public String[] author() default "FW" ;

    public CategoryType[] category() default CategoryType.COMMON;

    public DeviceType device() default DeviceType.WINDOWS;


}

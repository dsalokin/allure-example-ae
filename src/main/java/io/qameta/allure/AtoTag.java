package io.qameta.allure;

import java.lang.annotation.*;

/**
 * @author eroshenkoam (Artem Eroshenko).
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@Repeatable(AtoTags.class)
@LabelAnnotation(name = "tag")
public @interface AtoTag {

    String value();

}

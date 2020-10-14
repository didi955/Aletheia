package fr.didi955.aletheia.commands;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value=ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Command {

    public String name();
    public String description();
    public ExecutorType sender() default ExecutorType.ALL;

    public enum ExecutorType {

        ALL, USER, CONSOLE;
    }


}

package com.pract3.service.Predicates;

import java.util.function.Predicate;


/**
 * Класс для создания условий и проверки объектов
 */
public abstract class CustomPredicates<T> implements Predicate<T> {

    private final String falseMessage;

    protected CustomPredicates(String falseMessage) {
        this.falseMessage = falseMessage;
    }

    @Override
    abstract public boolean test(T t);

    public String getFalseMessage(){
        return falseMessage;
    };
}

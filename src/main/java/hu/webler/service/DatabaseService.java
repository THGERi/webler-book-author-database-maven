package hu.webler.service;

import java.sql.Connection;

// https://www.digitalocean.com/community/tutorials/java-generics-example-method-class-interface
// https://docs.oracle.com/javase/tutorial/java/generics/types.html
public interface DatabaseService<T> {

    // Object save(Object object);
    T save(T entity, Connection connection);
}
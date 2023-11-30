package hu.webler.entity;

import hu.webler.base.Identifier;

import java.util.ArrayList;
import java.util.List;

public class Author extends Identifier {

    private String name;

    public Author() {
        super();
    }

    public Author(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                '}';
    }
}
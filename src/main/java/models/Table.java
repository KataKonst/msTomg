package models;

/**
 * Created by katakonst on 10/15/16.
 */
public class Table {

    private String name;

    public Table(String name) {
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
        return name;
    }
}

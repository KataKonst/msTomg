package models;

/**
 * Created by katakonst on 10/15/16.
 */
public class Field {
    private String name;
    private String dataType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public Field(String name, String dataType) {
        this.name = name;
        this.dataType = dataType;
    }
}

package model.entity;

/**
 * @创建人 shizhendong
 * @创建时间 2018/10/8
 * @描述 列实体的信息包括列名 字段类型 长度
 */
public class Columns {

    String name="";
    String type="";
    int length=0;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }





}

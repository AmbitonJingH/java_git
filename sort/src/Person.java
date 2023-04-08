public class Person {
    private String type;
    private String sex;

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Person{" +
                "type='" + type + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}

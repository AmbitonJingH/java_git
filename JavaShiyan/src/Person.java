public class Person {

    private String name;
    private String address;
    private int phoneNum;
    private String emailAddress;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
       String a =this.getClass()+" "+this.getName();
        return a;
    }
}

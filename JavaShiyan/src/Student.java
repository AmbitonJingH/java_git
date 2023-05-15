public class Student extends Person{
    final public String FRESHMAN= "freshman";
    final public String SOPHOMORE= "sophomore";
    final public String JUNIOR= "junior";
    final public String SENIOR= "senior";
    private String classStatu;
    public String toString(){
        //Student student = new Student();

        String a =this.getClass()+ " "+this.getName();;
        return a;
    }
}

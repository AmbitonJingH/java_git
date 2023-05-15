public class Faculty extends Employee{
    private String officeHour;
    private String rank;
    public String toString(){
        String a =this.getClass()+" "+this.getName();
        return a;
    }
}

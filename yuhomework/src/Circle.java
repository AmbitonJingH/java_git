public class Circle {
    private double r=0;
    final private double PI = Math.PI;
    Circle(){

    }
    Circle(double r){
        this.r = r;
    }
    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }
    public double getArea(){
        double area = r*r*PI;
        return area;
    }

}

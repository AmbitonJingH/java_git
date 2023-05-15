public class Square extends GeometricObject implements Colorable{
    @Override
    public String howToColor() {

        return color;
    }
    private double length;
    private double width;
    private String color="";
    public Square(double length,double width,String color){
        this.length = length;
        this.width = width;
        this.color = color;
    }
    public double getArea(){
        double area = length*width;
        return area;
    }
    public String toString() {
        if (!color.equals("")) {
            return "Square: "+" area= "+this.getArea()+" Colors on all four sides ："+howToColor();
        }
        return "Square: "+" area= "+this.getArea();
    }

}

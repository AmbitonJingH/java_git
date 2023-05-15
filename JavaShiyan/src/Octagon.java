public class Octagon extends GeometricObject implements Cloneable,Comparable<Octagon>{

    private double side;
    private double area;
    private double perimeter;
    Octagon(double side){
        this.side=side;
    }
    @Override
    public double getArea() {
        area = ((2+4/Math.sqrt(2))*side*side);
        return area;
    }

    @Override
    public double getPerimeter() {
        perimeter = side*8;
        return perimeter;
    }

    @Override
    public int compareTo(Octagon o) {
        if(getArea()>o.getArea())
            return 1;
        else if(getArea()<o.getArea())
            return -1;
        else
            return 0;
    }
    public Object clone(){
        try{
            return super.clone();
        }catch (CloneNotSupportedException ex){
            return null;
        }
    }
}

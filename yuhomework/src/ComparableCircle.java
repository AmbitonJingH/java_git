public class ComparableCircle extends Circle implements Comparable<ComparableCircle>{
    public ComparableCircle(){

    }
    public ComparableCircle(double r){
        super(r);
    }
    @Override
    public int compareTo(ComparableCircle o) {
        if(getArea()>o.getArea())
            return 1;
        else if(getArea()<o.getArea())
            return -1;
        else
            return 0;
    }
}

public class Shiyan8Test {
    public static void main(String[] args) {
                Octagon octagon = new Octagon(5);
        System.out.println("The area is "+octagon.getArea());
        System.out.println("The perimeter is "+octagon.getPerimeter());
        Octagon octagon1 = (Octagon) octagon.clone();
        if(octagon.compareTo(octagon1)==0)
            System.out.println("octagon和octagon1面积相等,面积为："+octagon.getArea());
        else
            System.out.println(octagon.compareTo(octagon1)>0?"octagon面积较大 面积为"+octagon.getArea():"octagon1面积较大 面积为"+octagon1.getArea());
    }
}

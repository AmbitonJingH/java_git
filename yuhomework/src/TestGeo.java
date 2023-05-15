public class TestGeo {
    public static void main(String[] args) {
        GeometricObject[] array = new GeometricObject[5];
        array[0] = new Triangle(6,8,10);
        array[1] = new Square(10,5,"白色");
        array[2] = new Triangle(3,4,5);
        array[3] = new Square(8,8,"蓝色");
        array[4] = new Triangle(3,6,9);
        for(int i =0;i<5;i++){
            System.out.println(array[i].toString());
        }
    }
}

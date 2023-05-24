public class OutClass {

    public static void main(String[] args) {
        //创建Person的静态的成员内部类的实例
        Person.Dog dog = new Person.Dog();
        dog.eat();
        //Person.Bird bird = new Person.Bird() 报错！！！！
        Person p1 = new Person();
        Person.Bird bird = p1.new Bird();
        bird.eat();
        bird.show("级尼太美");
    }
}
class Person{
    String name = "Tom";
    int age=20;
    //静态的成员内部类
    static class Dog{
        public void eat(){
            System.out.println("狗吃骨头");
        }
    }
    //非静态的成员内部类
    class Bird{
        String name = "啄木鸟";
        public void eat(){
            System.out.println("鸟吃虫子");
        }
        public void show(String name){
            System.out.println("age= "+age);
            System.out.println("name= "+name);
            System.out.println("name= "+this.name);
            System.out.println("name= "+Person.this.name);
        }
        public void show1(){
            eat();
            Person.this.eat();

        }
    }
    public void method(){
        //局部内部类
        class InnerClass{

        }
    }
    public void eat(){
        System.out.println("人吃饭");
    }
}
public class OuterClassTest {

    //局部内部类的使用
    public void method1() {
        class A {
            //可以声明属性，方法
        }

    }

    //开发中的场景
    public Comparable getInstance() {
        //实现了Comparable接口的类
        //方式1  提供了接口的实现类的匿名对象
//        class MyComparable implements Comparable{
//
//            @Override
//            public int compareTo(Object o) {
//                return 0;
//            }
//        }
//        return new MyComparable();
//    }
        //方式2   提供了接口的匿名实现类的匿名对象
        return new Comparable() {
            @Override
            public int compareTo(Object o) {
                return 0;
            }
        };

    }
}

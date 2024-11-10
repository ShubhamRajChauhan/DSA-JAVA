public class ConstructorChaining {
    public static void main(String[] args) {
        B o1 = new B();
    }
}

class A{
    public A() {
        System.out.println("A 1");
    }
}

class B extends A {
    public B() {
        this(4);
        System.out.println("B 1");
    }
    public B(int k) {
        System.out.println("B 2");
    }
}

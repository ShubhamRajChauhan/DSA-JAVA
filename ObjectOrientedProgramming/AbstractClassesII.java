public class AbstractClassesII {
    public static void main(String[] args) {
        Horse h = new Horse();
        h.eat();
        h.walk();
        System.out.println(h.color);
        
    }
}

abstract class Animal {
    String color;
    Animal() {
        color = "brown";
    }
    void eat() {
        System.out.println("animal eats");
    }

    abstract void walk();
}

class Horse extends Animal {
    void changeColor() {
        color = "dark brown";
    }
    void walk() {
        System.out.println("walks on 4 leg");
    }
}

class Chicken extends Animal {
     void changeColor() {
        color = "yellow";
    }
    void walk() {
        System.out.println("walks on 2 leg");
    }
}

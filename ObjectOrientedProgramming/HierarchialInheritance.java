public class HierarchialInheritance {
    public static void main(String[] args) {
        Fish moyemoye = new Fish();
        moyemoye.swim();
        Mammal bhupendraJogi = new Mammal();
        bhupendraJogi.eat();
        bhupendraJogi.breathe();
        
    }
}
//Base class
class Animal {
    String color;

    void eat() {
        System.out.println("eats");
    }
    void breathe() {
        System.out.println("breathe");
    }
}

//Derived class
class Mammal extends Animal {
    void walk() {
        System.out.println("walks");
    }
}

//Derived class
class Fish extends Animal {
    void swim() {
        System.out.println("swim");
    }
}

//Derived class
class Bird extends Animal {
    void fly() {
        System.out.println("fly");
    }
}



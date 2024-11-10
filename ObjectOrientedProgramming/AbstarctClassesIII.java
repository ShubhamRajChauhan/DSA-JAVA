public class AbstarctClassesIII {
    public static void main(String[] args) {
        Mustang myHorse = new Mustang();
        //Animal -> Horse -> Mustang
        
    }
}

abstract class Animal {
    
    Animal() {
        System.out.println("animal constructor called");
    }
    
}

class Horse extends Animal {
    Horse() {
        System.out.println("Horse constructor called");
    }
    
}

class Mustang extends Horse {
    Mustang() {
        System.out.println("Mustang constructor called");
    }
}




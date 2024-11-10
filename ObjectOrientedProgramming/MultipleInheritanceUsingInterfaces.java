public class MultipleInheritanceUsingInterfaces {
    public static void main(String[] args) {
        Bear b = new Bear();
        b.veg();
        Bear b2 = new Bear();
        b2.nonveg();
    }
}

interface Herbivore {
    void veg();
}

interface Carnivore {
    void nonveg();
}


class Bear implements Herbivore, Carnivore {
    public void veg() {
        System.out.println("Veg");
    }
    public void nonveg() {
        System.out.println("Non-Veg");
    }

}

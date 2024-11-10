public class Constructors {
    public static void main(String[] args) {
        //Student s1 = new Student("Bikky");
        Student s1 = new Student();
        //System.out.println(s1.name);
    }
}

class Student {
    String name; 
    int roll;

    //Student(String name) {  //constructor
    //    this.name = name;
    //}

    Student() {
        System.out.println("constructor is called...");
    }
}

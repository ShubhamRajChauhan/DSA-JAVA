//3 Types of Constructors :  (i).Non-parameterized , (ii).Parameterized , (iii). Copy Constructor

//Here is about 1st and 2nd type

public class TypesOfConstructors {
    public static void main(String args[]) {
        Student s1 = new Student();
        Student s2 = new Student("Shubham");
        Student s3 = new Student(123);
        //Student s4 = new Student("Bikky", 567);
        System.out.println(s2.name);
        System.out.println(s3.roll);
    }
}

class Student {
    String name;
    int roll;

    Student() {  //Non-parameterized
        System.out.println("Constructor is called...");
    }

    Student(String name) {  //Parameterized
        this.name = name;
    }

    Student(int roll) {  //Parameterized
        this.roll = roll;
    }
}

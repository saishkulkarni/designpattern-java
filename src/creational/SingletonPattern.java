package creational;

public class SingletonPattern {
    public static void main(String[] args) {
        Student obj1=Student.getInstance();
        Student obj2=Student.getInstance();

        System.out.println(obj1);
        System.out.println(obj2);
    }
}

class Student {
    private Student() {} // Private constructor

    private static class StudentHelper {
        private static final Student INSTANCE = new Student();
    }

    public static Student getInstance() {
        return StudentHelper.INSTANCE;
    }
}
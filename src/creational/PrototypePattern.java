package creational;

public class PrototypePattern {
    public static void main(String[] args) {
        try {
            Employee emp1 = new Employee("Saish", 987456321L, 85);
            System.out.println("Original Object:");
            emp1.display();

            // Cloned object
            Employee emp2 = (Employee) emp1.clone();
            System.out.println("\nCloned Object:");
            emp2.display();

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}


class Employee implements Cloneable {
    private String name;
    private long mobile;
    private double salary;

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employee(String name, long mobile, double salary) {
        this.name = name;
        this.mobile = mobile;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public long getMobile() {
        return mobile;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();  // shallow copy
    //   return new Employee(this.name,this.mobile,this.salary);  //deep copy works when object reference
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Mobile: " + mobile);
        System.out.println("Salary: " + salary);
    }

}


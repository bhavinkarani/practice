package com.leet.temp.Leet.jva.collections;


import java.util.Arrays;
import java.util.Comparator;

public class Employee implements Comparable<Employee>{
    private int id;
    private String name;
    private int age;
    private long salary;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public Employee(int id, String name, int age, int salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    @Override
    //this is required to print the user-friendly information about the Employee
    public String toString() {
        return "[id=" + this.id + ", name=" + this.name + ", age=" + this.age + ", salary=" +
                this.salary + "]";
    }

    public static void main(String args[]){
        Employee[] empArr = new Employee[5];
        empArr[0] = new Employee(10, "Mikey", 25, 10000);
        empArr[1] = new Employee(20, "Arun", 29, 20000);
        empArr[2] = new Employee(5, "Lisa", 35, 5000);
        empArr[3] = new Employee(1, "Pankaj", 32, 42300);
        empArr[4] = new Employee(1, "Chotu", 32, 11000);


        Arrays.sort(empArr);
        System.out.println("Default Sorting of Employees list:\n"+Arrays.toString(empArr));
        Arrays.sort(empArr,new EmployeeComparatorByIdAndName());
        System.out.println("Default Sorting of Employees list:\n"+Arrays.toString(empArr));

        Comparator<Employee> nameComparator = (Employee e1, Employee e2) -> e1.getName().compareTo(e2.getName());
        Arrays.sort(empArr,nameComparator);
        System.out.println("Default Sorting of Employees list:\n"+Arrays.toString(empArr));


    }

    @Override
    public int compareTo( Employee e) {
        return (this.id - e.id);
    }
}

class EmployeeComparatorByIdAndName implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        int res = o1.getId()-o2.getId();
        if(res==0) res=o2.getName().compareTo(o1.getName());
        return res;
    }
}

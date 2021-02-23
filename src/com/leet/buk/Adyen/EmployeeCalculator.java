package com.leet.buk.Adyen;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class EmployeeCalculator {
    public static void main(String[] args) {
        Employee e1 = new Employee("a","a1", new BigDecimal(200));
        Employee e2 = new Employee("a","a1",  new BigDecimal(500));
        Employee e3 = new Employee("a","a1",  new BigDecimal(700));
        Employee e4 = new Employee("a","a1",  new BigDecimal(600));
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);
        employeeList.add(e4);
        System.out.print(getDetails(employeeList.stream()).getTotal().intValue());
    }

    private static CompanyOverview getDetails(Stream<Employee> stream) {
        Temp temp = new Temp(BigDecimal.ZERO, new ArrayList<EmployeeDetail>());
        stream.map(e-> getEmployeeDetail(e, temp));
        return new CompanyOverview(temp.getEmployeeDetailList(), temp.getSum());
    }

    private static Temp getEmployeeDetail(Employee e, Temp total) {
        total.setSum(total.getSum().add(e.getSalary()));
        total.getEmployeeDetailList().add(new EmployeeDetail(e.getName(), e.getEid()));
        return total;
    }
}

@Getter
@Setter
@AllArgsConstructor
class Temp {
    BigDecimal sum;
    List<EmployeeDetail> employeeDetailList;
}

@Value
class Employee{
    String name;
    String eid;
    BigDecimal salary;
}
@Value
class EmployeeDetail{
    String name;
    String eid;
}

@Value
class CompanyOverview {
    List<EmployeeDetail> employeeDetailList;
    BigDecimal total;
}
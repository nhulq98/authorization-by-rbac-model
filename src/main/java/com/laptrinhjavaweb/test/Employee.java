package com.laptrinhjavaweb.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Employee implements IEmployee {
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    private String phoneNumber;
    private String role;

    private Scanner scanner = new Scanner(System.in);


    @Override
    public List<Employee> input() {

        List<Employee> list = new ArrayList<>();
        int i = 1;
        while (i != 0) {
            Employee employee = new Employee();
            System.out.println("input name: ");
            employee.name = scanner.next();


            System.out.println("input phone number: ");
            employee.phoneNumber = scanner.nextLine();

            System.out.println("input role: ");
            employee.role = scanner.next();

            System.out.println("countinue = 1 || stop = 0: ");
            i = scanner.nextInt();

            list.add(employee);
        }
        scanner.close();
        return list;
    }

    @Override
    public void output() {

    }

    @Override
    public void sortByName() {

    }

    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.input();

        Object[] a = new Object[23];
        a[0] = 20;
        a[1] = 20L;
        a[0] = "le quang nhu";
    }
}

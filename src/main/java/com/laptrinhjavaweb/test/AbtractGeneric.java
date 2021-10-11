package com.laptrinhjavaweb.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AbtractGeneric<T> implements GenericDAO<T>{

    private T[] arr;

    private Scanner scanner = new Scanner(System.in);


    @Override
    public List<T> input(T object) {
        List<T> list = new ArrayList<>();
        int i = 1;
        while (i != 0) {

//            Employee employee = new Employee();
//            System.out.println("input name: ");
//            employee.name = scanner.next();
//
//            System.out.println("input phone number: ");
//            employee.phoneNumber = scanner.nextLine();
//
//            System.out.println("input role: ");
//            employee.role = scanner.next();
//
//            System.out.println("countinue = 1 || stop = 0: ");
//            i = scanner.nextInt();
//
//            list.add(employee);
        }
        scanner.close();
        return list;
    }

    @Override
    public T inputdata() {
        return null;
    }

    public static void main(String[] args) {

    }
}

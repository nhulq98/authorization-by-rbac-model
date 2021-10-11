package com.laptrinhjavaweb.test;

import java.util.List;
import java.util.Scanner;

public class Customer implements GenericDAO<Customer> {
    private long id;
    private String name;
    private String phoneNumber;

    private Scanner scanner = new Scanner(System.in);

    @Override
    public List<Customer> input(Customer object) {
        return null;
    }

    @Override
    public Customer inputdata() {
        return null;
    }

//    @Override
//    public List<Customer> input() {
//        List<Customer> list = new ArrayList<>();
//        int i = 1;
//        while(i != 0){
//            Customer customer = new Customer();
//            System.out.println("input name: ");
//            customer.name = scanner.nextLine();
//
//            System.out.println("input phone number: ");
//            customer.phoneNumber = scanner.next();
//            System.out.println("countinue = 1 || stop = 0: ");
//            i = scanner.nextInt();
//            list.add(customer);
//        }
//        scanner.close();
//
//        return list;
//    }


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
}

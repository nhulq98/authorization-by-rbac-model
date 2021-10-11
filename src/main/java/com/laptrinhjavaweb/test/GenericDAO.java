package com.laptrinhjavaweb.test;

import java.util.List;

public interface GenericDAO<T> {
    List<T> input(T object);


    T inputdata();

}

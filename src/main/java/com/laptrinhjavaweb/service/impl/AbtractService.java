package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.service.interf.GenericService;

import javax.servlet.http.HttpServletRequest;

public class AbtractService<T> implements GenericService<T> {
    @Override
    public void getObjectByParameter(HttpServletRequest request, T object, Object... parameters) {
        for(int i = 0; i < parameters.length; i++){
            //String
        }
    }
}

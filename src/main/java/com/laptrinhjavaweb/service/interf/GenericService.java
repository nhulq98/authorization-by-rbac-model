package com.laptrinhjavaweb.service.interf;

import javax.servlet.http.HttpServletRequest;

public interface GenericService<T> {
    void getObjectByParameter(HttpServletRequest request, T object, Object... parameters);
}

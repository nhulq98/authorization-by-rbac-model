package com.laptrinhjavaweb.utils;

import javax.servlet.http.HttpServletRequest;

public class SessionUtil {

    private static SessionUtil sessionUtil = null;

    // create object one time
    public static SessionUtil getInstance() {
        if (sessionUtil == null) {
            sessionUtil = new SessionUtil();
        }
        return sessionUtil;
    }

    public void putSession(HttpServletRequest request, Object value, String key) {
        request.getSession().setAttribute(key, value);
    }

    public Object getValue(HttpServletRequest request, String key) {
        return request.getSession().getAttribute(key);
    }

    public void removeSession(HttpServletRequest request, String key) {
        request.getSession().removeAttribute(key);
    }

//    public Object getValue(HttpServletRequest request, Object... parameters) {
//        Enumeration<String> attributes = request.getSession().getAttributeNames();
//        int i = 0;
//        while (attributes.hasMoreElements()) {
//            String attribute = (String) attributes.nextElement();
//            if (attribute.equals(parameters[i].getClass().toString())) {
//                return request.getSession().getAttribute(attribute);
//            }
//        }
//        return null;
//    }


}

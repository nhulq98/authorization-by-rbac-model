package com.laptrinhjavaweb.dao.impl;

import java.util.*;

public class main {

    public void sapXepTangDanTheoMa(Vector<String> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {

                Collections.swap(list, i, j);

                    //SWAP
//                    SVAnToanThongTin sVAnToanThongTin = new SVAnToanThongTin(list.get(i));
//                    list.set(i, new SVAnToanThongTin(list.get(j)));
//                    list.set(j, sVAnToanThongTin);
            }
        }
    }

    public static void main(String[] args) {
//        CategoryDAO categoryDAO = new CategoryDAO();
//        List<CategoryModel> categoryModels = categoryDAO.findAll();
//
//        for(CategoryModel categoryModel: categoryModels){
//            System.out.println(categoryModel.getName());
//        }

        int a = 9;
        int b = 2;
        int c = 3;
        int d = 1;

        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(a, "chin");
        map.put(b, "hai");
        map.put(c, "ba");
        map.put(d, "mot");

        Set<Integer> integers = map.keySet();
        for(int i : integers){
            // change value into
            System.out.println(map.get(i));
        }

    }
}

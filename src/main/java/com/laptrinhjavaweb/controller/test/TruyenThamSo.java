package com.laptrinhjavaweb.controller.test;

public class TruyenThamSo {

    public void hoanVi(int a, int b){
        int temp = a;
        a = b;
        b = temp;
    }





    public void updateString(String str){
        str = str + "le quang nhu";
        System.out.println(str);
    }

    public void sortArr(int[] mang){
        for(int i = 0; i < mang.length - 1; i++){
            for(int j = i + 1; j < mang.length; j++){
                if(mang[i] > mang[j]){
                    int temp = mang[i];
                    mang[i] = mang[j];
                    mang[j] = temp;
                }
            }

        }
        mang[1] = 69;
    }

    public void changeStr(String str1, String str2){
        String temp = str1;
        str1 = str2;
        str2 = temp;
    }

    public static void main(String[] args) {
        TruyenThamSo truyenThamSo = new TruyenThamSo();
        String a = "20";
        String b = "40";
        truyenThamSo.changeStr(a, b);
        System.out.println("a = " + a);
        System.out.println("b = " + b);
//        int[] arr= {2, 3, 1, 8, 4, 9};
//        truyenThamSo.sortArr(arr);
//        System.out.println("sau khi sắp xếp");
//        for(int i: arr){
//            System.out.print(i + " ");
//        }
//        int a = 1, b = 2;
//        System.out.println("a = " + a);
//        System.out.println("b = " + b);
//        truyenThamSo.hoanVi(a, b);



//
//        System.out.println("sau khi hoan vi");
//        System.out.println("a = " + a);
//        System.out.println("b = " + b);

    }
}

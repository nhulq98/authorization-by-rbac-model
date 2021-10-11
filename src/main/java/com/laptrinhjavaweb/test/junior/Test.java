package com.laptrinhjavaweb.test.junior;

public class Test {

    public void swapObject(Balloon a, Balloon b) {
        Balloon temp = new Balloon();
        temp.setColor(a.getColor());
        a.setColor(b.getColor());
        b.setColor(temp.getColor());
    }

    public void swapBallon(Balloon a, Balloon b){
        Balloon temp = a;
        a = b;
        b = temp;
    }



    public static void main(String[] args) {

    }
}

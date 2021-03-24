package com.deepika.Inheritance;

public class JJJ implements ff1 {
    public static void main(String[] args) {
        JJJ jj = new JJJ();
        System.out.println(((ff)jj).c);
        jj.show();
        ff.show();
    }
}
interface  ff{
        final int c=4;
       static void show(){
            System.out.println("Show in ff Interface...");
        }
}
interface ff1 extends ff{
    final int c=2;
    default void show(){
        System.out.println("Show in ff1 interface");
    }
}
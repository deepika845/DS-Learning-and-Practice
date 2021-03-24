package com.deepika.Inheritance;

public class DataHiding {
    int x = 5;
//    static {
//        x=44;
//        System.out.println("DataHiding");
//    }
}
class DataHiding2 extends DataHiding{
    int x =10;
}
class DataHiding1 extends DataHiding2{
    static int x =60;
     void shw(){
        System.out.println("DataHiding1");
    }
}

class  Child extends DataHiding1{
     static int x = 55;
//    static {
//        x=100;
//        System.out.println("Child");
//    }
    Child(){
        super();
        System.out.println("Cild");
    }
      void shw(){
        System.out.println("Child");
    }
    public void show(){
        System.out.println(x);
        System.out.println(super.x);
        System.out.println(((DataHiding2)this).x);
        System.out.println(((DataHiding)this).x);
    }
    public static void main(String[] args) {
        DataHiding1 cc = new Child();
       // System.out.println(cc.x);
        //DataHiding1.shw();
        cc.shw();

    }
}
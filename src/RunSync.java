class RunSync
{

    public static void main(String s[])
    {
        Shared st=new Shared();
        CustomThread t1=new CustomThread(st,"one");
        //t1.start();
        CustomThread1 t2=new CustomThread1(st,"two");
        //t2.start();
        //CustomThread2 t3=new CustomThread2(st,"three");
    }
}

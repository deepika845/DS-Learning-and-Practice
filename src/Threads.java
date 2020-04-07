class Threads extends Thread {
    SubmitWithdraw ss;
    Threads(SubmitWithdraw dd,String ll){
        super(ll);
        this.ss=dd;
        start();
    }
    public void run(){
        System.out.println(ss.withdraw());
    }
}
class Threadss extends Thread{
    SubmitWithdraw zz;
    Threadss(SubmitWithdraw d,String yy){
        super(yy);
        this.zz=d;
        start();
    }
    public void run(){
        zz.submit();
    }
}

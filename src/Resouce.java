class   Resouce
{
    public static void main(String[] s)
    {
        try(Demo  d=new  Demo())
        {
            d.show();
        }catch(ArithmeticException |  ArrayIndexOutOfBoundsException   e)
        {
            System.out.println(e);
        }
    }
}
class  Demo  implements  AutoCloseable
{
    void  show()
    {
        System.out.println("show");
    }
    public void  close()
    {
        System.out.println("close");
    }

}

package fibonaciwithoutrecursion;
public class Fibonacci {
    public static void main(String[]args)
    {
        int n1=0,n2=1,n3,count=10;
        System.out.println(n1+""+n2);//print 0 and 1
        for(int i=2;i<count;++i){  //This loop will start from 2 
            n3=n1+n2;
            System.out.println(""+n3);
            n1=n2;
            n2=n3;
        }

    }
}

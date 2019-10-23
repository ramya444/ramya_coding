/*created by Ramya
factorial of a number using loop
 */
package factorialprogram;

public class Factorialprogram {
    public static void main(String[]args)
    {
        int i,fact=1;
        int number=5; //number to calculate the factorial
        for(i=1;i<=number;i++)
        {
            fact=fact*i;
        }
        System.out.println("The factorial of this +number is :"+fact );
    }
}

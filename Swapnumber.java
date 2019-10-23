/*created by Ramya
swap number without using third variable
 */
package swapnumber;
import java.util.*;
public class Swapnumber {
    public static void main(String[]args){
        int x,y;
        System.out.println("enter x and y:");
        Scanner in=new Scanner(System.in);
        x=in.nextInt();                                 //getting the x and y value from the user
        y=in.nextInt();
        System.out.println("Before swapping\n:" +x  +y);
        x=x+y;                                           
        y=x-y;
        x=x-y;                                          //getting the x and y value from the above expression and perform the sub operation
        System.out.println("After swapping:" +x +y);
    }
}

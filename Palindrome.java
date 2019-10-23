/*created by Ramya
Palindrome
 */
package palindrome;
import java.util.*;
public class Palindrome {
    public static void main(String[]args){
        String string,strrev="";                 //declaring the original string and reversed string to empty
        Scanner in=new Scanner(System.in);
        int length;
        System.out.println("Enter the string:");
        string=in.nextLine();                    //getting the input string
        length=string.length();                      //getting the length of the string
        for(int i=length-1;i>=0;i--){                 //loop which decrements the index of an array and prints the charecters in a reverse order
            strrev=strrev+string.charAt(i);
        }
        System.out.println("the reversed string is:" +strrev);
        if(string.equals(strrev))                       //compares the original string with reversed one using string.equals function
            System.out.println("palindrome");
        else
            System.out.println("not palindrome");
    }
}

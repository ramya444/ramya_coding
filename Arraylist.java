/*created by Ramya
Arraylist
 */
package arraylist;
import java.util.*;

public class Arraylist {
public static void main(String[]args)
{
    ArrayList list=new ArrayList(); //creating array list
    list.add("10");
    list.add("20");
    list.add("30");
    list.add("40");
    list.add("50");


    System.out.println(list.size());  //to get the size of an array
    System.out.println("Advanced for loop");
    for(Object obj:list){                     //created an object for ForEach loop to get the array of values
        System.out.println(obj);
    }
    System.out.println("After delete operation:");
    list.remove("40");                             //to remove number from arraylist
    for(Object obj:list){
        System.out.println(obj);                   //to print array after deletion
    }
    System.out.println("After Update operation");
    list.set(1,15);                                 //to set the number in 1st index
    for(Object obj:list){
        System.out.println(obj);                     //get the values of an array after update function
    }
}}

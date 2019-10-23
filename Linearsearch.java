/*created by Ramya
simple program for Linear search
 */
package linearsearch;
import java.util.*;
public class Linearsearch{
public static int Linearsearch(int[] arr,int key) {
    for(int i=0;i<arr.length-1;i++){ //for loop is used to compare the array with key element 
        if(arr[i]==key){         //if the index value arr[i] is equal to key then it will return index 
            return i;
        }
        }
    return -1; //else return -1
}
public static void main(String[]args)
        {
            int[] a1={10,20,30,40,50};
            int key=40;
            System.out.println(key+ "is found at index:"+Linearsearch(a1,key)); //calling the above linear search function 
        }
        }

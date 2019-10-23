/*Created by Ramya
simple program to store sum of two matrices
 */
package addtwomatrices;
import java.util.*;
public class Addtwomatrices {
    public static void main(String[] args) {

        //creating two matrices
        int a[][] = {{1, 2, 3}, {2, 4, 5}, {1, 6, 9}};
        int b[][] = {{2, 5, 7}, {1, 5, 6}, {3, 6, 8}};
        //creating another matrix to store sum of two matrices
        int c[][] = new int[3][3];
        //loop for to add numbers in matrix a
        for (int i = 0; i < 3; i++) {
            //loop for to add numbers in matrix b
            for (int j = 0; j < 3; j++) {
                c[i][j] = a[i][j] + b[i][j];
                System.out.print(c[i][j] + "");
            }
            System.out.println(); //next line
        }
    }
}


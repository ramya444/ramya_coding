/*created by Ramya
string reverse
 */
package stringreverse;
import java.util.*;
public class Stringreverse {
    public static void main(String[] args) {
        String str = "blanket";
        char chars[] = str.toCharArray();//convert the string to charecter
        for (int i = chars.length- 1; i >= 0; i--) { //sets a variable charecter length -1 before the loop starts and if it is greater than 0 i is decremented//
System.out.println(chars[i]);
        }

    }
}
package arrays;
public class Arrayprograms {
    //SUM OF NUMBERS WHICH IS PRESENT IN AN ARRAY
    public static void main(String[]args){
    int array[]={1,4,5,6,78,9}; //initialising array of values
    int sum=0;
    for(int i:array){           //this for each loop is used to get all the numbers in an array
        sum+=i;                 //sum=sum+i;
    }
    //AVERAGE OF SERIES OF NUMBERS
    System.out.println("The sum is:"+sum);
    int average=sum/array.length;   //this is used to get the average of the numbers
    System.out.println("The average is:"+average);
    System.out.println("Odd Numbers:");
    //ODD NUMBER
    for(int i=0;i<array.length;i++) {                  //this for loop is used to get the array of numbers starting from index 0
        if (array [i]% 2 != 0) {                       //if we got the reminder which is not equal to 0 print those odd numbers
            System.out.println(+array[i]);
        }
    }
    //EVEN NUMBER
    System.out.println("Even numbers:");
    for(int i=0;i<array.length;i++){                     //this for loop is used to get the array of numbers starting from index 0
        if(array[i]%2==0){                                //if we got the reminder which is equal to 0 print those even numbers
            System.out.println(+array[i]);
        }
    }
    //REVERSED ARRAY
    System.out.println("Reversed array of numbers are:");
    for(int i=array.length-1;i>=0;i--){                    //here i is initialised to arraylength-1 and if the i value is equal to 0 then it goes out of the loop and prints the array in reverse order
        System.out.println(+array[i]);
    }
    //TO FIND THE LARGEST NUMBER IN AN ARRAY
    int max=array[0]; //initialize max with first element of array
    for(int i=0;i<array.length;i++){        //comparing those numbers with array[0] value and if it is greater than max then initialise max value to array[i]
        if(array[i]>max){
            max=array[i];
        }
    }
    //DESCENDNG ORDER
    System.out.println("The largest element in an array is:"+max);
    System.out.println("Descending order of array elements are: ");
    int temp;
    for(int i=0;i<array.length;i++){     //to start the array index value from 0
        for(int j=i+1;j<array.length;j++){ //to start the loop from 1
            if(array[i]<array[j]){           //if array[i] is lesser than array[j]
                temp=array[i];               //store array[i] value in temp
                array[i]=array[j];
                array[j]=temp;
            }
        }
    }
    for(int i=0;i<array.length;i++) {          //this for loop is to print the array in descendig order
        System.out.println(+array[i]);
    }
}
}


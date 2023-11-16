package DAA_Lab;

public class Fib {
     static int n1=0 , n2=1,n3;
     static void printFib(int count){
         if(count>0){
             n3=n1+n2;
             n1= n2;
             n2=n3;
             System.out.print(" "+n3);
             printFib(count-1);

         }
     }

    public static void main(String[] args) {
        int count = 1;
        if (count==1){
            System.out.print(n1);
        }
        else {
            System.out.print(n1+" "+n2);
        }
        printFib(count-2);
    }
    }

    //Time Complexity: O(n)
//Space Complexity:O(1)

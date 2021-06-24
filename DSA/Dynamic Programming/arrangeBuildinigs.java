// 1. You are given a number n, which represents the length of a road. The road has n plots on it's each side.
// 2. The road is to be so planned that there should not be consecutive buildings on either side of the road.
// 3. You are required to find and print the number of ways in which the buildings can be built on both side of roads.
// Input Format
// A number n
// Output Format
// A number representing the number of ways in which the buildings can be built on both side of roads.



import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner x=new Scanner(System.in);
    int n= x.nextInt();
    
    long dp[][] = new long[2][n+1];
    
    long countEnd0=1; //represents "Ends with building"
    long countEnd1=1; //represents "Ends with space"
    for(int len=2;len<=n;len++){
        long t0 = countEnd1; //if building gets selected then it can be done in same way as prev space ways
        long t1 = countEnd1 + countEnd0; //if space gets selected, it can be done in (no of prev space ways+ number of prev building ways) as there is no limitation of not having conseq spaces
        
        countEnd0=t0;
        countEnd1=t1;
    }
    
    System.out.println((countEnd0+countEnd1)*(countEnd0+countEnd1));
 }

}
A group of friends(divyanshu,abhishek,mayank,raman) are playing a game nd they call it "quarantine game".
game is decribed as followed :
1. a person is given a string of characters.
2. in order to escape from quarantine ,that person has to find total-count of very special kind substring.
3. only substring having same first nd last character are selected in the total-count.

Now, divyanshu is selected at random & locked in a dark room.he is given a string, your task is to help him 
find correct number of special substrings so that he can get out from the room.
Input Format

a string ,str

Constraints

len(str) >= 0

Output Format

a number representing count of special substrings

Sample Input 0

aba
Sample Output 0

4
Explanation 0

The substrings are a, b, a and aba
____________________________________________________

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner x=new Scanner(System.in);
        String str=x.nextLine();
        int count=0;
        int n=str.length();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<=n;j++){
                String temp=str.substring(i,j);
                
                if(temp.charAt(0)==temp.charAt(temp.length()-1)){
                    count++;
                }
            }
        }
        
        System.out.println(count);
    }
    
    
}
1.Take as input N, a number. N is the size of a snakes and ladder board (without
any snakes and ladders).
2.Take as input M, a number. M is the number of faces of the dice.

a. Write a recursive function which returns the count of different ways the
board can be travelled using the dice. Print the value returned.

b. Write a recursive function which returns an ArrayList of dice values for all
valid paths across the board. Print the value returned.

c. Write a recursive function which prints dice-values for all valid paths across
the board (void is the return type for function).
Input Format

Integer Input
Constraints

1<= n <=1000000000
Output Format

print the output.
Sample Input 0

5
6
Sample Output 0

16
[11111, 1112, 1121, 113, 1211, 122, 131, 14, 2111, 212, 221, 23, 311, 32, 41, 5]
11111
1112
1121
113
1211
122
131
14
2111
212
221
23
311
32
41
5

____________________________________________________

import java.util.ArrayList;
import java.util.Scanner;

public class Solution{
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
    
        int N = scn.nextInt(); // board length
        int M = scn.nextInt(); // Number of faces of dice

        System.out.println(count(N,M));
        
        System.out.println(paths(N, M,""));
        print(N,M,"");
    }

    public static int count(int N,int M){
        if(N<0){
            return 0;
        }
        if(N==0){
            return 1;
        }
        int s=0;
        for(int i=M;i>=1;i--){
            s+=count(N-i, M);
        }
        return s;
    }

    public static void print(int N,int M, String psf){
        if(N<0){
            return;
        }
        if(N==0){
            System.out.println(psf);
            return;
        }
        
        for(int i=1;i<=M;i++){
            print(N-i, M, psf+i);
        }
        
    }

    public static ArrayList<String> paths(int N,int M, String psf){
        
        if(N<0){
            ArrayList<String> bz= new ArrayList<>();
            return bz;
        }
        
        if(N==0){
            ArrayList<String> bz= new ArrayList<>();
            bz.add(psf);
            return bz;
        }
        ArrayList<String> ans=new ArrayList<String>();
        for(int i=1;i<=M;i++){
            for(String path: paths(N-i, M, psf+i)){
                ans.add(path);
            }
        }
        
        return ans;
        
    }
}
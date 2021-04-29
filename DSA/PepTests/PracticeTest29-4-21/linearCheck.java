// Check whether all points lie ona horizontal or vertical line ?
// print "YES" if all points lie on the line & "NO" otherwise.

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        
        // code here
        int x[]=new int[n];
        int y[]=new int[n];
        for(int i=0;i<n;i++){
            x[i]=scn.nextInt();
            y[i]=scn.nextInt();
        }
        boolean vert = chV(y,n);
        boolean hor = chH(x,n);
        
        if(vert || hor){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
    
    public static boolean chV(int y[], int n){
        int a=y[0];
        
        for(int i=1;i<n-1;i++){
            if(y[i]!=a){
                return false;
            }
        }
        return true;
    }
    
    public static boolean chH(int x[], int n){
        int a=x[0];
        
        for(int i=1;i<n-1;i++){
            if(x[i]!=a){
                return false;
            }
        }
        return true;
    }
}
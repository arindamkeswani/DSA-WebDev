// 1. You are given a number n1, representing the number of rows of 1st matrix.
// 2. You are given a number m1, representing the number of columns of 1st matrix.
// 3. You are given n1*m1 numbers, representing elements of 2d array a1.
// 4. You are given a number n2, representing the number of rows of 2nd matrix.
// 5. You are given a number m2, representing the number of columns of 2nd matrix.
// 6. You are given n2*m2 numbers, representing elements of 2d array a2.
// 7. If the two arrays representing two matrices of dimensions n1 * m1 and n2 * m2 can be multiplied, display the contents of prd array as specified in output Format.
// 8. If the two arrays can't be multiplied, print "Invalid input".

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        
        Scanner x=new Scanner(System.in);
        int n1=x.nextInt();
        int m1=x.nextInt();
        
        int[][] a1=new int[n1][m1];
        for(int i=0;i<n1;i++){
            for(int j=0;j<m1;j++){
                a1[i][j]=x.nextInt();
            }
        }
        
        
        
        
        
        int n2=x.nextInt();
        int m2=x.nextInt();
        
        int[][] a2=new int[n2][m2];
        for(int i=0;i<n2;i++){
            for(int j=0;j<m2;j++){
                a2[i][j]=x.nextInt();
            }
        }
        
        int[][] arr=new int[n1][m2];
        
        
        
        
        if(m1!=n2){
            System.out.println("Invalid input");
        }
        else{
            // for(int i=0;i<n1;i++){    
            //     for(int j=0;j<m2;j++){    
            //         arr[i][j]=0;      
            //         for(int k=0;k<m1;k++){      
            //             arr[i][j]+=a1[i][k]*a2[k][j];      
            //             }//end of k loop  
            //         System.out.print(arr[i][j]+" ");  //printing matrix element  
            //         }//end of j loop  
            // System.out.println();//new line    
            // }    
            
            for(int i=0;i<n1;i++){
                for(int j=0;j<m2;j++){
                    arr[i][j]=0;
                    for(int k=0;k<m1;k++){
                        arr[i][j]+= a1[i][k]*a2[k][j];
                    }
                    
                }
            }
            
            //print
            for(int i=0;i<n1;i++){
                for(int j=0;j<m2;j++){
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println();
            }
        }
            
        
        
    }

}
// 1. You are given a number n and a number k separated by a space, representing the number of houses and number of colors.
// 2. In the next n rows, you are given k space separated numbers representing the cost of painting nth house with one of the k colors.
// 3. You are required to calculate and print the minimum cost of painting all houses without painting any consecutive house with same color.
// Input Format
// A number n
// n1-0th n1-1st n1-2nd .. n1-kth
// n2-0th n2-1st n2-2nd .. n2-kth
// .. n number of elements
// Output Format
// A number representing the minimum cost of painting all houses without painting any consecutive house with same color.





///////////////////OPTIMISED??????????????????
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner x= new Scanner(System.in);
        int n = x.nextInt();
        int k = x.nextInt();
        
        int cost[][] = new int[n][k];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<k;j++){
                cost[i][j] = x.nextInt();
            }
        }
        
       
        //Make array (nxk), n represents number of houses till rowNo., col represents colour(RGB)
        //Cell value represents min cost of painting of all houses till current one
        //Ingore value of previous row, same column (as it is adjacent house, same colour)
        //Take cell value = min(other 2 colours of prev row) + cost(curr cell)
        
        
        
        int dp[][] = new int[n][k];
        
        int least = Integer.MAX_VALUE;
        int second_least = Integer.MAX_VALUE;
        
        for(int j=0;j<k;j++){
            dp[0][j] = cost[0][j];
            // System.out.print(dp[0][j]+" ");
            if(cost[0][j] <= least){
                least=cost[0][j];
            }else if(cost[0][j] <= second_least){
                second_least=cost[0][j];
            }
            
        }
        
        // System.out.println();
        for(int i=1;i<n;i++){
            int newLeast = Integer.MAX_VALUE;
            int newSLeast = Integer.MAX_VALUE;
            for(int j=0;j<k;j++){
                if(least == dp[i-1][j]){
                    dp[i][j] = cost[i][j] + second_least;
                }else{
                    dp[i][j] = cost[i][j] + least;
                }
                
                
                if(dp[i][j] <= newLeast){
                    newSLeast=newLeast;
                    newLeast = dp[i][j];
                }else if(dp[i][j] <= newSLeast){
                    newSLeast=dp[i][j];
                }
                // System.out.print(dp[i][j]+" ");
            }
              
            least = newLeast;
            second_least = newSLeast;
            // System.out.println();
        }
        
        
        System.out.println(least);
        ////////////////////////////////////////////////////////
        
        // int dp[][] = new int[n][k];
        // for(int j=0;j<k;j++){
        //     dp[0][j] = cost[0][j];
        //     // System.out.print(dp[0][j]+" ");
        // }
        // // System.out.println();
        
        // for(int i=1;i<n;i++){
        //     for(int j=0;j<k;j++){
        //         int min = Integer.MAX_VALUE;
                
        //         for(int l=0;l<k;l++){
        //             if(l!=j){
        //                 if(dp[i-1][l]<min){
        //                     min = dp[i-1][l];
        //                 }
                        
        //             }
        //         }
                
        //         dp[i][j] = min + cost[i][j];
        //         // System.out.print(dp[i][j]+" ");
        //     }
        //     // System.out.println();
        // }
        
        // int finCost = Integer.MAX_VALUE;
        // for(int i=0;i<k;i++){
        //     if(dp[n-1][i]<finCost){
        //         finCost = dp[n-1][i];
        //     }
        // }
        
        // System.out.println(finCost);
        
        
        ////////////////////////////////////////////////////////////////////////
        
        
    }
}


import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner x= new Scanner(System.in);
        int n = x.nextInt();
        int k = x.nextInt();
        
        int cost[][] = new int[n][k];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<k;j++){
                cost[i][j] = x.nextInt();
            }
        }
        
       
        //Make array (nxk), n represents number of houses till rowNo., col represents colour(RGB)
        //Cell value represents min cost of painting of all houses till current one
        //Ingore value of previous row, same column (as it is adjacent house, same colour)
        //Take cell value = min(other 2 colours of prev row) + cost(curr cell)
        
        
        
        int dp[][] = new int[n][k];
        for(int j=0;j<k;j++){
            dp[0][j] = cost[0][j];
            // System.out.print(dp[0][j]+" ");
        }
        // System.out.println();
        
        for(int i=1;i<n;i++){
            for(int j=0;j<k;j++){
                int min = Integer.MAX_VALUE;
                
                for(int l=0;l<k;l++){
                    if(l!=j){
                        if(dp[i-1][l]<min){
                            min = dp[i-1][l];
                        }
                        
                    }
                }
                
                dp[i][j] = min + cost[i][j];
                // System.out.print(dp[i][j]+" ");
            }
            // System.out.println();
        }
        
        int finCost = Integer.MAX_VALUE;
        for(int i=0;i<k;i++){
            if(dp[n-1][i]<finCost){
                finCost = dp[n-1][i];
            }
        }
        
        System.out.println(finCost);
        
        
        ////////////////////////////////////////////////////////////////////////
        // int cellCost[] = new int[k];
        
        // for(int i=0;i<k;i++){ //Base case
        //     cellCost[i] = cost[0][i];
        // }
        
        // for(int i=1;i<n;i++){
        //     int newCellCost[] = new int[k];
        //     for(int j=0;j<k;j++){ //initialise temp values with max
        //         newCellCost[j] = 1001;
        //     }
            
        //     for(int j=0;j<k;j++){
        //         for(int l=0;l<k;l++){
        //             if(j!=l){
        //                 newCellCost[j] = Math.min(newCellCost[j], cellCost[l]) + cost[i][j]; 
        //             }
                    
        //         }
                
        //     }
            
        //     //update values
        //     for(int j=0;j<k;k++){
        //         cellCost[j] = newCellCost[j];
        //     }
        // }
        
        // int finCost=Integer.MAX_VALUE;
        // for(int i=0;i<k;i++){
        //     finCost = Math.min(finCost, cellCost[i]);
        // }
        
        // System.out.println(finCost);
        ////////////////////////////////////////////////////////////////////////
    }
}
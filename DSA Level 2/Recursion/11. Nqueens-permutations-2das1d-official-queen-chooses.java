// 1. You are given a number n, representing the size of a n * n chess board.
// 2. You are required to calculate and print the permutations in which n queens (distinct) can be 
//      placed on the n * n chess-board. 
// 3. No queen shall be able to kill another.

// Note -> Use the code snippet and follow the algorithm discussed in question video. The judge can't 
//                force you but the intention is to teach a concept. Play in spirit of the question.
// Input Format
// A number n
// Output Format
// Check the sample output and question video


import java.io.*;
import java.util.*;

public class Main {

    public static boolean IsQueenSafe(int[][] chess, int row, int col) {
        // write your code here
        
        //check col(up and down direction)
        for(int i=0,j=col;i<chess.length;i++){
            if(chess[i][j]!=0){
                return false;
            }
        }
        
        //check row(left and right direction)
        for(int i=row,j=0;j<chess[0].length;j++){
            if(chess[i][j]!=0){
                return false;
            }
        }
        
        //check top right diagnonal
        for(int i=row-1,j=col+1 ;i>=0 && j<chess[0].length; i--,j++){
            if(chess[i][j]!=0){
                return false;
            }
        }
        
        //check bottom right diagnonal
        for(int i=row+1,j=col+1;i<chess.length && j<chess[0].length;i++,j++){
            if(chess[i][j]!=0){
                return false;
            }
        }
        
        // bottom left diag
        for(int i=row+1,j=col-1;i<chess.length && j>=0;i++,j--){
            if(chess[i][j]!=0){
                return false;
            }
        }
        
        //top left diag
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(chess[i][j]!=0){
                return false;
            }
        }
        
        return true;
    }

    public static void nqueens(int qpsf, int tq, int[][] chess) {
        // write your code here
        if(qpsf==tq){
            for(int arr[]:chess){
                for(int vl: arr){
                    System.out.print(vl==0? "-\t" : "q"+vl+"\t");
                }
                System.out.println();
            }
            System.out.println();
        }
        for(int i=0;i<tq*tq;i++){
            int r=i/tq;
            int c=i%tq;
            if(chess[r][c]==0 && IsQueenSafe(chess, r,c)){
                chess[r][c]= qpsf+1; //mark (qpsf th+1) queen as visited
                nqueens(qpsf+1, tq, chess);
                chess[r][c]= 0;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] chess = new int[n][n];

        nqueens(0, n, chess);
    }
}
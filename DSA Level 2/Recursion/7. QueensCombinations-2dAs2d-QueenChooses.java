// 1. You are given a number n, representing the size of a n * n chess board.
// 2. You are required to calculate and print the combinations in which n queens can be placed on the 
//      n * n chess-board. 

// Note -> Use the code snippet and follow the algorithm discussed in question video. The judge can't 
//                force you but the intention is to teach a concept. Play in spirit of the question.
// Input Format
// A number n
// Output Format
// Check the sample output and question video



import java.io.*;
import java.util.*;

public class Main {

    public static void queensCombinations(int qpsf, int tq, boolean[][] chess, int i, int j){
        // write your code here
        
        if(qpsf == tq){
            for(int r=0;r<chess.length;r++){
                for(int c=0;c<chess.length;c++){
                    if(chess[r][c]==true){
                        System.out.print("q"+"\t");
                    }else{
                        System.out.print("-"+"\t");
                    }
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        
        //for places after current space in the same row
        for(int col=j+1;col<chess.length;col++){
            chess[i][col] = true;
            queensCombinations(qpsf+1, tq, chess, i, col);
            chess[i][col] = false;
        }
        
        for(int row=i+1;row<chess.length;row++){ //for places after current block in the lower rows
            for(int col=0;col<chess.length;col++){ //and all their columns
                chess[row][col] = true;
                queensCombinations(qpsf+1, tq, chess, row, col);
                chess[row][col] = false;
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];
        
        queensCombinations(0, n, chess, 0, -1);
    }
}
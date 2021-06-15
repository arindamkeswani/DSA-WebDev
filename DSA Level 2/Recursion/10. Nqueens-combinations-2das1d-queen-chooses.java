// 1. You are given a number n, representing the size of a n * n chess board.
// 2. You are required to calculate and print the combinations in which n queens can be placed on the 
//      n * n chess-board. 
// 3. No queen shall be able to kill another.

// Note -> Use the code snippet and follow the algorithm discussed in question video. The judge can't 
//                force you but the intention is to teach a concept. Play in spirit of the question.
// Input Format
// A number n
// Output Format
// Check the sample output and question video


//First check if block is safe, then place the queen



import java.io.*;
import java.util.*;

public class Main {

    public static boolean IsQueenSafe(boolean[][] chess, int row, int col) {
        // write your code here
        for(int i=row-1,j=col; i>=0;i--){ //check same col(towards up)
            if(chess[i][j]==true){ //unsafe
                return false;
            }
        }
        
        for(int i=row-1,j=col+1; i>=0 && j<chess[0].length;i--,j++){ //check top right diag
            if(chess[i][j]==true){ //unsafe
                return false;
            }
        }
        
        for(int i=row-1,j=col-1; i>=0 && j>=0;i--,j--){ //check top left diag
            if(chess[i][j]==true){ //unsafe
                return false;
            }
        }
        
        // for(int i=row,j=col-1; j>=0;j--){ //check same row(towards left)
        //     if(chess[i][j]==true){ //unsafe
        //         return false;
        //     }
        // }
        
        //Last condition has been omitted because we put (last cell no used) as last pos in the row, so next queen will be evaluated from next row
        //No need to check for right and bottom directions as all those spots are vacant
        return true;
    }

    public static void nqueens(int qpsf, int tq, boolean[][] chess, int lcno) {
        if (qpsf == tq) {
            for (int row = 0; row < chess.length; row++) {
                for (int col = 0; col < chess.length; col++) {
                    System.out.print(chess[row][col] ? "q\t" : "-\t");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        for (int i = lcno + 1; i < chess.length * chess.length; i++) {
            int row = i / chess.length;
            int col = i % chess.length;

            if (chess[row][col] == false && IsQueenSafe(chess, row, col)) { //First condn not needed
                chess[row][col] = true;
                nqueens(qpsf + 1, tq, chess, tq*(row+1)-1);  //Used formula (total queens*(row+1)-1->gives number of complete rows - 1 position (to push it back to last pos of last row so that new queen starts from new row))
                chess[row][col] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];

        nqueens(0, n, chess, -1);
    }
}
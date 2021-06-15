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

    public static void queensCombinations(int qpsf, int tq, boolean[][] chess, int lcno) {
        // write your code here
        if(qpsf==tq){ //when all queens are placed, print chess board in reqd format
            for(int r=0;r<tq;r++){
                for(int c=0;c<tq;c++){
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
        for(int i=lcno+1;i<tq*tq;i++){ //traverse from (last placed col no. + 1) positionto end to place rest of queens
            int r=i/tq; //get number of row completed
            int c=i%tq; //get position in row (for 1d conversion)
            chess[r][c]=true; //mark as visited
            queensCombinations(qpsf+1, tq, chess, i); //make last col placed as parameter for next queen's evaluation
            chess[r][c]=false; //unvisit to test all combinations
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];

        queensCombinations(0, n, chess, -1);
    }
}
// // Queens Combinations - 2d As 2d - Box Chooses
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

    public static void queensCombinations(int qpsf, int tq, int row, int col, String asf){
        // write your code here
        if(row==tq){
            if(qpsf==tq){ //quees placed so far == capacity
                System.out.println(asf);
            }
            return;
        }
        int nr, nc;
        String sep = "";
        if(col == tq-1){ //if we are at last column, move to next line
            nr=row+1; //go down one row 
            nc=0; //go to first col of next row
            sep="\n"; //for answer so far to go to newline
        }else{
            nr=row; //stay in current row
            nc=col+1; //move to next col
            sep = ""; //for answer so far to stay in current line
        }
        queensCombinations(qpsf+1, tq, nr,nc,asf+"q"+sep); //if queen is placed on curr block
        queensCombinations(qpsf, tq, nr,nc,asf+"-"+sep); //if queen is not placed on curr block
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        queensCombinations(0, n, 0, 0, "");
    }
}
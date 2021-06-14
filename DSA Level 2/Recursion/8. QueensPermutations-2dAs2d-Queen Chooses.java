import java.io.*;
import java.util.*;

public class Main {

    public static void queensPermutations(int qpsf, int tq, int[][] chess){
        // write your code here
        if(qpsf == tq){ //if all queens are placed
            for(int r=0;r<chess.length;r++){ //print full board with queen values
                for(int c=0;c<chess[0].length;c++){
                    if(chess[r][c]!=0){
                        System.out.print("q"+chess[r][c]+"\t");
                    }else{
                        System.out.print("-"+"\t");
                    }
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        
        for(int i=0;i<chess.length;i++){ //go through all rows
            for(int j=0;j<chess[0].length;j++){ //go through every column in the row
                if(chess[i][j]==0){ //if block empty
                    chess[i][j]=qpsf+1; //place queen (with value)
                    queensPermutations(qpsf+1, tq, chess); //evaluate next queen
                    chess[i][j]=0; //unvisit the block
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] chess = new int[n][n];
        
        queensPermutations(0, n, chess);
    }
}
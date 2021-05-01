import java.io.*;
import java.util.*;
 
public class Solution {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt(), c = sc.nextInt();
        int k = sc.nextInt();
        int[][] mat = new int[r][c];
        if (k == 0) {
            // Displaying the empty matrix
            display(mat);
        } else {
            knightConclave(0, 0, mat, k);
        }
    }
    
    private static void knightConclave(int r, int c, int[][] mat, int k) {
        if (k == 0) {
            // all the indexes are traversed
            display(mat);
            return;
        }
        for (int i = r; i < mat.length; i++) {
            for (int j = c; j < mat[0].length; j++) {
                // starting from the index got
                if(isSafeMove(i, j, mat)) {
                    // if knight can be placed safely, copy the current board to new board and put knight on it
                    int[][] mat1 = new int[mat.length][mat[0].length];
                    placeKnight(i, j, mat, mat1);
                    // putting rest of the knights after one is put
                    knightConclave(i, j, mat1, k - 1);
                }
            }
            // so that it starts from 0 index from next row onwards
            c = 0;
        }
    }
    
    private static void placeKnight(int i, int j, int[][] mat, int[][] mat1) {
        for (int a = 0; a < mat.length; a++) {
            for (int b = 0; b < mat[0].length; b++) {
                // copying previous board
                mat1[a][b] = mat[a][b];
            }
        }
        // putting the knight
        mat1[i][j] = 1;
        // now mark all the places where knight cannot be placed
        markNonSafePlaces(i, j, mat1);
    }
    
    // r - 2, c + 1
    // r - 1, c + 2
    // r + 1, c + 2
    // r + 2, c + 1
    // r + 2, c - 1
    // r + 1, c - 2
    // r - 1, c - 2
    // r - 2, c - 1
    private static void markNonSafePlaces(int i, int j, int[][] mat) {
        int m = mat.length, n = mat[0].length;
        // checking all the possible novements of knight and if it is valid position, mark it as unsafe i.e. by -1
        if ((i - 2) >= 0 && (j + 1) < n)
            mat[i - 2][j + 1] = -1;
        if ((i - 1) >= 0 && (j + 2) < n)
            mat[i - 1][j + 2] = -1;
        if ((i + 1) < m && (j + 2) < n)
            mat[i + 1][j + 2] = -1;
        if ((i + 2) < m && (j + 1) < n)
            mat[i + 2][j + 1] = -1;
        if ((i + 2) < m && (j - 1) >= 0)
            mat[i + 2][j - 1] = -1;
        if ((i + 1) < m && (j - 2) >= 0)
            mat[i + 1][j - 2] = -1;
        if ((i - 1) >= 0 && (j - 2) >= 0)
            mat[i - 1][j - 2] = -1;
        if ((i - 2) >= 0 && (j - 1) >= 0)
            mat[i - 2][j - 1] = -1;
    }
    
    private static void display(int[][] mat) {
        for (int[] r : mat) {
            for (int c : r)
                if (c == -1)
                    System.out.print("0 "); // all unsafe places were marked -1 for recognition hence printing 0 acc. to question
                else
                    System.out.print(c + " ");
            System.out.println();
        }
        System.out.println();
    }
    
    private static boolean isSafeMove(int i, int j, int[][] mat) {
        // check if it is valid index and -1 is not present i.e. position is safe for knight to get placed
        return (i >= 0 && i < mat.length && j >= 0 && j < mat[0].length && mat[i][j] == 0);
    }
}

RAW Paste Data
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt(), c = sc.nextInt();
        int k = sc.nextInt();
        int[][] mat = new int[r][c];
        if (k == 0) {
            // Displaying the empty matrix
            display(mat);
        } else {
            knightConclave(0, 0, mat, k);
        }
    }
    
    private static void knightConclave(int r, int c, int[][] mat, int k) {
        if (k == 0) {
            // all the indexes are traversed
            display(mat);
            return;
        }
        for (int i = r; i < mat.length; i++) {
            for (int j = c; j < mat[0].length; j++) {
                // starting from the index got
                if(isSafeMove(i, j, mat)) {
                    // if knight can be placed safely, copy the current board to new board and put knight on it
                    int[][] mat1 = new int[mat.length][mat[0].length];
                    placeKnight(i, j, mat, mat1);
                    // putting rest of the knights after one is put
                    knightConclave(i, j, mat1, k - 1);
                }
            }
            // so that it starts from 0 index from next row onwards
            c = 0;
        }
    }
    
    private static void placeKnight(int i, int j, int[][] mat, int[][] mat1) {
        for (int a = 0; a < mat.length; a++) {
            for (int b = 0; b < mat[0].length; b++) {
                // copying previous board
                mat1[a][b] = mat[a][b];
            }
        }
        // putting the knight
        mat1[i][j] = 1;
        // now mark all the places where knight cannot be placed
        markNonSafePlaces(i, j, mat1);
    }
    
    // r - 2, c + 1
    // r - 1, c + 2
    // r + 1, c + 2
    // r + 2, c + 1
    // r + 2, c - 1
    // r + 1, c - 2
    // r - 1, c - 2
    // r - 2, c - 1
    private static void markNonSafePlaces(int i, int j, int[][] mat) {
        int m = mat.length, n = mat[0].length;
        // checking all the possible novements of knight and if it is valid position, mark it as unsafe i.e. by -1
        if ((i - 2) >= 0 && (j + 1) < n)
            mat[i - 2][j + 1] = -1;
        if ((i - 1) >= 0 && (j + 2) < n)
            mat[i - 1][j + 2] = -1;
        if ((i + 1) < m && (j + 2) < n)
            mat[i + 1][j + 2] = -1;
        if ((i + 2) < m && (j + 1) < n)
            mat[i + 2][j + 1] = -1;
        if ((i + 2) < m && (j - 1) >= 0)
            mat[i + 2][j - 1] = -1;
        if ((i + 1) < m && (j - 2) >= 0)
            mat[i + 1][j - 2] = -1;
        if ((i - 1) >= 0 && (j - 2) >= 0)
            mat[i - 1][j - 2] = -1;
        if ((i - 2) >= 0 && (j - 1) >= 0)
            mat[i - 2][j - 1] = -1;
    }
    
    private static void display(int[][] mat) {
        for (int[] r : mat) {
            for (int c : r)
                if (c == -1)
                    System.out.print("0 "); // all unsafe places were marked -1 for recognition hence printing 0 acc. to question
                else
                    System.out.print(c + " ");
            System.out.println();
        }
        System.out.println();
    }
    
    private static boolean isSafeMove(int i, int j, int[][] mat) {
        // check if it is valid index and -1 is not present i.e. position is safe for knight to get placed
        return (i >= 0 && i < mat.length && j >= 0 && j < mat[0].length && mat[i][j] == 0);
    }
}


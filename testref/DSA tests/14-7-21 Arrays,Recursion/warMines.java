A soldier in a war needs to cross a mine field.
mines are spread in field (represented by 0).
We have to avoid landmines and their four adjacent cells (left, right, above and below) as they are also unsafe.
soldier is able move left, right, above and below.
Help him identify length of the shortest safest route(left column to right column) if it exists or print "soldier:KIA" if there is no path.
0 -> represents mine
1 -> safe place
Input Format

(battle field represented by rows and columns)
m (rows)
n (columns)
mxn more inputs of 0/1 
Constraints

number

Output Format

a number representing length of safest route or "soldier:KIA".
depending upon the input.
Sample Input 0

12
10
1  1  1  1  1  1  1  1  1  1
1  0  1  1  1  1  1  1  1  1
1  1  1  0  1  1  1  1  1  1
1  1  1  1  0  1  1  1  1  1
1  1  1  1  1  1  1  1  1  1
1  1  1  1  1  0  1  1  1  1
1  0  1  1  1  1  1  1  0  1
1  1  1  1  1  1  1  1  1  1
1  1  1  1  1  1  1  1  1  1
0  1  1  1  1  0  1  1  1  1
1  1  1  1  1  1  1  1  1  1
1  1  1  0  1  1  1  1  1  1
Sample Output 0

13
Explanation 0

Length of shortest safe route is 13

____________________________________________________

import java.io.*;
import java.util.*;

public class Solution {
    static int ans=Integer.MAX_VALUE;
    static int rowNum[] = { -1, 0, 0, 1 };
    static int colNum[] = { 0, -1, 1, 0 };
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner x=new Scanner(System.in);
        int m=x.nextInt();
        int n=x.nextInt();
        int arr[][]=new int[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = x.nextInt();
            }
        }
            //mark adjacent cells
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {

                // If a landmine is found
                if (arr[i][j] == 0)
                {

                    // Mark all adjacent cells
                    for(int k = 0; k < 4; k++)
                        if (isValid(i + rowNum[k], j + colNum[k], m,n))
                            arr[i + rowNum[k]][j + colNum[k]] = -1;
                }
            }
        }
        
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==-1){
                    arr[i][j]=0;
                }
            }
        }
        
        boolean visited[][]=new boolean[m][n];
        for(int i=0;i<m;i++){
            mines(arr,m,n,i,0, visited, 0);
            if (ans == n - 1)
                break;
        }
        if(ans==Integer.MAX_VALUE){
            System.out.println("soldier:KIA");
        }else{
            System.out.println(ans);
        }
        
    }
    
    
    static boolean isValid(int x, int y, int m, int n)
    {
        if (x < m && y < n && x >= 0 && y >= 0)
            return true;

        return false;
    }
    public static void mines(int arr[][], int m, int n, int r, int c, boolean visited[][], int csf){
        if(r<0 || c<0 || r>=m || c>=n || visited[r][c]==true || arr[r][c]==0 ||csf>ans){
            return;
        }
        
        if(c==n-1){
            ans=Math.min(ans,csf);
            return;
        }
        
        
        visited[r][c]=true;
        
        mines(arr, m,n,r+1,c,visited, csf+1); //down
        mines(arr, m,n,r-1,c,visited, csf+1); //up
        mines(arr, m,n,r,c+1,visited, csf+1); //right
        mines(arr, m,n,r,c-1,visited, csf+1); //left
        
        visited[r][c]=false;
        
    }
}
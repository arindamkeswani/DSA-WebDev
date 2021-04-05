// You are given a n*m matrix where n are the number of rows and m are the number of columns. You are also given n*m numbers representing the elements of the matrix.
// You will be given a ring number 's' representing the ring of the matrix. For details, refer to image.

// shell-rotate

// You will be given a number 'r' representing number of rotations in an anti-clockwise manner of the specified ring.
// You are required to rotate the 's'th ring by 'r' rotations and display the rotated matrix.

import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        
        Scanner x=new Scanner(System.in);
        int n=x.nextInt();
        int m=x.nextInt();
        
        int[][] arr=new int[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]= x.nextInt();
            }
        }
        
        int s=x.nextInt();
        int r=x.nextInt();
        
        
        
        
        int minr=s-1, maxr=n-s; 
        int minc=s-1, maxc=m-s;
        
        
        SRotate(arr,s,r);
        display(arr);
        
        // // System.out.println(arr[minr][minc]);
        
        // int[] temp=new int[(maxr-minr)*2+(maxc-minc)*2];
        
        // //store all elements in temp array
        // int p=0;
        // //left wall
        // for(int i=minr;i<maxr;i++){
        //     temp[p]=arr[i][minc];
        //     p++;
        // }
        
        // //bottom wall
        // for(int i=minc;i<maxc;i++){
        //     temp[p]=arr[maxr][i];
        //     p++;
        // }
        
        // //right wall
        //  for(int i=maxr;i>minr;i--){
        //     temp[p]=arr[i][maxc];
        //     p++;
        // }
        
        // //top wall
        // for(int i=maxc;i>minc;i--){
        //     temp[p]=arr[minr][i];
        //     p++;
        // }
        
        // // test display temp
        // // for(int i=0;i<temp.length;i++){
        // //     System.out.println(temp[i]);
        // // }
        
        // //storing last r rotated elements
        // int[] temp2=new int[r];
        // int y=0;
        // for(int i=temp.length-r;i<temp.length;i++){
        //     temp2[y++]=temp[i];
        //     // System.out.println(temp2[i]);
        // }
        
        // //anti clock conversion in temp
        // for(int i=r;i<temp.length;i++){
        //     temp[i]=temp[i-r];
        // }
        // // int y=0;
        // for(int i=0;i<r;i++){
        //     temp[i]=temp2[i];
        // }
        
        // // test display temp
        // for(int i=0;i<temp.length;i++){
        //     System.out.println(temp[i]);
        // }
        
        
    }
    
    public static void SRotate(int arr[][],int s,int r){
        int oned[]=fill1d(arr,s);
        // int[] rot=
        rotate(oned,r);
        fill2d(arr,s,oned);
    }
    
    public static int[] fill1d(int arr[][],int s){
        int nr = arr.length;
        int nc = arr[0].length;
        int rmin = s - 1, cmin = s - 1, rmax = nr - s, cmax = nc - s;
        int total = 2 * (rmax - rmin + cmax - cmin);

        int oned[] = new int[total];
        int idx = 0;
        // left wall : top -> bottom
        for (int i = rmin, j = cmin; i <= rmax; i++) {
            oned[idx] = arr[i][j];
            idx++;
        }
        cmin++;

        // bottom wall : left -> right
        for (int i = rmax, j = cmin; j <= cmax; j++) {
            oned[idx] = arr[i][j];
            idx++;
        }
        rmax--;

        // right wall : bottom -> top
        for (int i = rmax, j = cmax; i >= rmin; i--) {
            oned[idx] = arr[i][j];
            idx++;
        }
        cmax--;

        // top wall : right -> left
        for (int i = rmin, j = cmax; j >= cmin; j--) {
            oned[idx] = arr[i][j];
            idx++;
        }
        rmin++;
        
        return oned;
        
    }
    
    public static void fill2d(int arr[][],int s,int oned[]){
        int nr = arr.length;
        int nc = arr[0].length;
        int rmin = s - 1, cmin = s - 1, rmax = nr - s, cmax = nc - s;
        
        int idx = 0;
        // left wall : top -> bottom
        for (int i = rmin, j = cmin; i <= rmax; i++) {
            arr[i][j]  = oned[idx];
            idx++;
        }
        cmin++;

        // bottom wall : left -> right
        for (int i = rmax, j = cmin; j <= cmax; j++) {
            arr[i][j]  = oned[idx];
            idx++;
        }
        rmax--;

        // right wall : bottom -> top
        for (int i = rmax, j = cmax; i >= rmin; i--) {
            arr[i][j]  = oned[idx];
            idx++;
        }
        cmax--;

        // top wall : right -> left
        for (int i = rmin, j = cmax; j >= cmin; j--) {
            arr[i][j]  = oned[idx];
            idx++;
        }
        rmin++;
        
        
    }
    
    public static void reverse(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }


    }


    public static void rotate(int[] a, int k) {
        // write your code here
        k = k % a.length;
        if (k < 0) {
            k += a.length;
        }

        int n = a.length;

        reverse(a, 0, n - k - 1);
        reverse(a, n - k, n - 1);
        reverse(a, 0, n - 1);
        //reverse 0 to n-k-1


        //reverse n-k-1 to n

    }


    public static void display(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}
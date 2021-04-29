// you are given radius & center of two circles. Find out whether the given circles :
// touches each other at one point
// touches each other at two points
// are far-apart from each other
// one circle overlap's other 
// print "overlaps" or "far-apart" or "touches at 1 point" or "touches at 2 point" or "concentric" , accordingly.

// Input
// x(x1) & y(y1) center coordinates of circle 1
// x(x2) & y(y2) center coordinates of circle 2
// radius(r1) of circle 1
// radius(r2) of circle 2



import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
       Scanner scn = new Scanner(System.in);
        int x1 = scn.nextInt();
        int y1 = scn.nextInt();
        
        int x2 = scn.nextInt();
        int y2 = scn.nextInt();
        
        int r1 = scn.nextInt();
        int r2 = scn.nextInt();
        
        //distance between centers        
        int a = (x1 - x2);        
        int b = (y1 - y2);
      
        double centerDis = Math.sqrt((a*a) + (b*b)) ;
        
        //conditions
        
        if(centerDis == 0){
            System.out.println("concentric");
        }else if(centerDis == r1+r2){
            System.out.println("touches at 1 point");
        }else if(centerDis > r1+r2){
            System.out.println("far-apart");
        }else if(centerDis < r1 || centerDis < r2){
            System.out.println("overlaps");
        }else if(centerDis < r1 +r2){
            System.out.println("touches at 2 point");
        }
    }
}
// import java.io.*;
// import java.util.*;

// public class Solution {

//     public static void main(String[] args) {
//         /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
//         Scanner x=new Scanner(System.in);
//         int x1=x.nextInt(); int y1=x.nextInt();
//         int x2=x.nextInt(); int y2=x.nextInt();
//         int r1 = x.nextInt();
//         int r2 = x.nextInt();
        
//         if(Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1)) +Math.min(r1,r2) < Math.max(r1,r2) && (x1!=x2 || y1!=y2)){//overlaps
//             System.out.println("overlaps");
//         } 
//         else if(x1==x2 && y1==y2 && r1!=r2){//concentric
//             System.out.println("concentric");
//         }
//         else if(Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1)) > r1+r2){//far-apart
//             System.out.println("far-apart");
//         }
//         else if((Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1)) == r1+r2) || (Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1)) == Math.abs(r1-r2))){//touches at 1 point
//             System.out.println("touches at 1 point");
//         }
//         else if(Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1)) < r1+r2){//touches at 2 point
//             System.out.println("touches at 2 point");
//         }
        
        
        
        
        
        
//     }
// }
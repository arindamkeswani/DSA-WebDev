// 1. You are given a number n, representing the number of houses.
// 2. In the next n rows, you are given 3 space separated numbers representing the cost of painting nth house with red or blue or green color.
// 3. You are required to calculate and print the minimum cost of painting all houses without painting any consecutive house with same color.
// Input Format
// A number n
// n1red n1blue n1green
// n2red n2blue n2green
// .. n number of elements
// Output Format
// A number representing the minimum cost of painting all houses without painting any consecutive house with same color.


import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner x= new Scanner(System.in);
        int n = x.nextInt();
        int red[] = new int[n];
        int blue[] = new int[n];
        int green[] = new int[n];
        
        for(int i=0;i<n;i++){
            // for(int j=0;j<3;j++){
                red[i] = x.nextInt();
                blue[i] = x.nextInt();
                green[i] = x.nextInt();
            // }
        }
        
        //Make array (nx3), n represents number of houses till rowNo., col represents colour(RGB)
        //Cell value represents min cost of painting of all houses till current one
        //Ingore value of previous row, same column (as it is adjacent house, same colour)
        //Take cell value = min(other 2 colours of prev row) + cost(curr cell)
        
        int redCost=red[0];
        int blueCost=blue[0];
        int greenCost=green[0];
        
        for(int i=1;i<n;i++){
            int newRed = Math.min(blueCost, greenCost) + red[i];
            int newBlue = Math.min(redCost, greenCost) + blue[i];
            int newGreen = Math.min(blueCost, redCost) + green[i];
            
            redCost = newRed;
            blueCost = newBlue;
            greenCost = newGreen;
        }
        
        System.out.println(Math.min(redCost, Math.min(blueCost,greenCost)));
    }
}
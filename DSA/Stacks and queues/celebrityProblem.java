// 1. You are given a number n, representing the number of people in a party.
// 2. You are given n strings of n length containing 0's and 1's
// 3. If there is a '1' in ith row, jth spot, then person i knows about person j.
// 4. A celebrity is defined as somebody who knows no other person than himself but everybody else knows him.
// 5. If there is a celebrity print it's index otherwise print "none".

// Note -> There can be only one celebrity. Think why?


import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }

        findCelebrity(arr);

    }

    public static void findCelebrity(int[][] arr) {
        // if a celebrity is there print it's index (not position), if there is not then
        // print "none"
        
        Stack<Integer> st=new Stack<>();
        int n = arr.length;
        
        for(int i=0;i<n;i++){
            st.push(i);
            
        }
        
        while(st.size()>1){
            int p1=st.pop() , p2=st.pop();
            
            if(arr[p1][p2]==1){
                //p2 can be celeb  p1 knows p2
                st.push(p2);
            }
            else{
                //p1 can be celeb  p1 does not know p2
                st.push(p1);
            }
        }
        
        int possible=st.pop();
        
        for(int i=0;i<n;i++){
            if(arr[possible][i]==1){
                System.out.println("none");
                return;
            }
        }
        
        for(int i=0;i<n;i++){
            if(arr[i][possible]==0 && i!=possible){
                System.out.println("none");
                return;
            }
        }
        
        System.out.println(possible);
        
    }

}
// 1. You are given a word.
// 2. You have to generate all abbrevations of that word.

// Use recursion as suggested in question video
// Input Format
// A string representing a word
// Output Format
// Check the sample ouput and question video.

/*
pep
Sample Output
pep
pe1
p1p
p2
1ep
1e1
2p
3
*/

import java.io.*;
import java.util.*;

public class Main {

    public static void solution(String str, String asf,int count, int pos){
        //write your code here
        if(pos==str.length()){
            System.out.println(asf + (count==0?"": count)); //adding count to ans if non-zero
            return;
        }
        
        char ch=str.charAt(pos); //current character
        
        String tmp= count==0?""+ch:""+count+ch; // if count=0, just add curr char, if not, add prev count then curr char
        solution(str, asf+tmp, 0, pos+1); //included curr char
        
        solution(str, asf, count+1, pos+1); //excluded curr char
        
    }
	public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        solution(str,"",0,0);
    }
    
    
};
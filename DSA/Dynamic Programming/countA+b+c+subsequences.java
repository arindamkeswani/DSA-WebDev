// 1. You are given a string str.
// 2. You are required to calculate and print the count of subsequences of the nature a+b+c+.
// For abbc -> there are 3 subsequences. abc, abc, abbc
// For abcabc -> there are 7 subsequences. abc, abc, abbc, aabc, abcc, abc, abc.
// Input Format
// A string str
// Output Format
// count of subsequences of the nature a+b+c+ (RegEx)


import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner x= new Scanner(System.in);
        String s= x.nextLine();
        
        //make (n+1)x3. Rows represent each character is strong (starting with blank string)
        //columns represent, a+, a+b+, a+b+c+ resepectively
        //On encountering a, we use (a+)= 2(a+ (old sequences)) + 1
        //On encountering b, we use (a+b+)= 2(a+b+ (old sequences)) + (a+(current no. of sequences))
        //On encountering c, we use (a+b+c+)= 2(a+b+c+ (old sequences)) + (a+b+c+ (currentno. of sequences))
        
        //Multiplying by factor of 2 is due to two possibilities (whether to include or exclude)
        //Addition component is for the case where curr char starts its own subsequence (for a+), or curr carries forward into a new subsequence (for a+b+ and a+b+c+)
        
        
        int countOfa=0; //Base cases
        int countOfab=0;
        int countOfabc=0;
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            
            if(ch=='a'){
                countOfa = 2*countOfa + 1;
            }else if(ch=='b'){
                countOfab = 2*countOfab + countOfa;
            }else{
                countOfabc = 2*countOfabc + countOfab;
            }
        }
        
        System.out.println(countOfabc);
    }
}
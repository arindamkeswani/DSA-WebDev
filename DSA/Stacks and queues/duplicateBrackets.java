// 1. You are given a string exp representing an expression.
// 2. Assume that the expression is balanced  i.e. the opening and closing brackets match with each other.
// 3. But, some of the pair of brackets maybe extra/needless. 
// 4. You are required to print true if you detect extra brackets and false otherwise.

// e.g.'
// ((a + b) + (c + d)) -> false
// (a + b) + ((c + d)) -> true


import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);
        String exp=scn.nextLine();
        System.out.println(isDuplicate(exp));
    }
    
    public static boolean isDuplicate(String exp) {
        Stack<Character> st=new Stack<>();
        
        for(int idx=0;idx<exp.length();idx++){
            char ch=exp.charAt(idx);
            if(ch==')'){
                if(st.peek()=='('){
                    return true;   //duplicacy detected
                }else{
                    //valid bracket
                    while(st.peek()!='('){
                        st.pop(); //remove intermediate characters
                    }
                    st.pop(); //remove opening bracket
                }
                
            }else{
                st.push(ch);
            }
        }
        
        return false;   //duplicacy was never detected. Expression has no duplicate brackets
    }
}
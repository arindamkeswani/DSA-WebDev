// 1. You are given a string exp representing an expression.
// 2. You are required to check if the expression is balanced i.e. closing brackets and opening brackets match up well.

// e.g.
// [(a + b) + {(c + d) * (e / f)}] -> true
// [(a + b) + {(c + d) * (e / f)]} -> false
// [(a + b) + {(c + d) * (e / f)} -> false
// ([(a + b) + {(c + d) * (e / f)}] -> false

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner x=new Scanner(System.in);
        String exp=x.nextLine();
        
        System.out.println(bb(exp));
    }
    
    public static boolean bb(String exp){
        Stack<Character> st= new Stack<>();
        
        for(int i=0;i<exp.length();i++){
            char ch=exp.charAt(i);
            
            
            if(ch==')'){
                
                if(st.size()==0){
                    return false;
                }
                else{
                    if(st.peek()=='('){
                    st.pop();
                    
                    }
                    else{
                        return false;
                    }
                }
                
            }
            
            if(ch=='}'){
                if(st.size()==0){
                    return false;
                }
                else{
                    if(st.peek()=='{'){
                        st.pop();
                        
                    }
                    else{
                        return false;
                    }
                }
            }
            
            if(ch==']'){
                if(st.size()==0){
                    return false;
                }
                else{
                    if(st.peek()=='['){
                        st.pop();
                        
                    }
                    else{
                        return false;
                    }
                }
            }
            
            
            if(ch=='('){
                st.push(ch);
                
            }
            if(ch=='{'){
                st.push(ch);
                
            }
            if(ch=='['){
                st.push(ch);
                
            }
            
            // System.out.println(st);
            
        }
        
        if(st.size()!=0){
            return false;
        }else{
            return true;
        }
    }

}
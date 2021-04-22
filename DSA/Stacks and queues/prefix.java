// 1. You are given a prefix expression.
// 2. You are required to evaluate it and print it's value.
// 3. You are required to convert it to infix and print it.
// 4. You are required to convert it to postfix and print it.

// Note -> Use brackets in infix expression for indicating precedence. Check sample input output for more details.


import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    Scanner x=new Scanner(System.in);
    String exp = x.nextLine();

    // code
    solve(exp);
    
 }
 
 public static void solve(String exp){
    Stack<Integer> eval=new Stack<Integer>();
    Stack<String> infix=new Stack<>();
    Stack<String> prefix=new Stack<>();
    
    for(int i=exp.length()-1;i>=0;i--){
        char ch=exp.charAt(i);
        
        
        
        if(ch!='*' && ch!='+' && ch!='-' && ch!='/'){
            eval.push(Integer.parseInt(ch+""));
            infix.push(ch+"");
            prefix.push(ch+"");
        }
        else{
            evaluation(eval,ch);
            prefixExpBuild(prefix,ch);
            infixExpBuild(infix,ch);
        }
    }
    
    System.out.println(eval.pop());
    System.out.println(infix.pop());
    System.out.println(prefix.pop());
 }
 
 public static void evaluation(Stack<Integer> eval, char op){
     int v1=eval.pop();
     int v2=eval.pop();
     
     if(op=='+'){
         eval.push(v1+v2);
     }
     else if(op=='-'){
         eval.push(v1-v2);
     }
     else if(op=='*'){
         eval.push(v1*v2);
     }
     else if(op=='/'){
         eval.push(v1/v2);
     }
 }
 
 public static void prefixExpBuild(Stack<String> prefix, char op){
     String v1=prefix.pop();
     String v2=prefix.pop();
     prefix.push(v1+v2+op);
     
 }
 
 public static void infixExpBuild(Stack<String> infix, char op){
     String v1=infix.pop();
     String v2=infix.pop();
     infix.push("("+v1+op+v2+")");
 }
 
}
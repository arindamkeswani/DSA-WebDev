// 1. You are given a string str.
// 2. You are required to find the character with maximum frequency.

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        HashMap<Character, Integer> hm= new HashMap<>();
        Scanner x=new Scanner(System.in);
        
        String str = x.nextLine();
        for(int i=0;i<str.length(); i++){
            char ch = str.charAt(i);
            if(hm.containsKey(ch)){
                hm.put(ch, hm.get(ch)+1); //update value if it already exists
            }else{
                hm.put(ch, 1); //init value
            }
            
        }
        
        // System.out.println(hm);
        char c=' ';int max=Integer.MIN_VALUE;
        for(Character keys : hm.keySet()){
            if(hm.get(keys) > max){
                max=hm.get(keys);
                c=keys;
            }
        }
        
        System.out.println(c);
        
    }

}
// 1. You are given three strings s1, s2 and s3.
// 2. First two are supposed to add and form third. s1 + s2 = s3
// 3. You have to map each individual character to a digit, so that the above equation holds true.

// Note -> Check out the question video and write the recursive code as it is intended without 
//                changing the signature. The judge can't force you but intends you to teach a concept.
// Input Format
// Three strings
// s1
// s2
// s3

// Sample Input
// team
// pep
// toppr
// Sample Output
// a-3 e-9 m-4 o-1 p-2 r-6 t-0 
// a-3 e-9 m-5 o-1 p-2 r-7 t-0 
// a-3 e-9 m-6 o-1 p-2 r-8 t-0 
// a-4 e-9 m-2 o-1 p-3 r-5 t-0 
// a-4 e-9 m-5 o-1 p-3 r-8 t-0 
// a-5 e-9 m-2 o-1 p-4 r-6 t-0 
// a-5 e-9 m-3 o-1 p-4 r-7 t-0 
// a-6 e-9 m-2 o-1 p-5 r-7 t-0 
// a-6 e-9 m-3 o-1 p-5 r-8 t-0 
// a-7 e-9 m-2 o-1 p-6 r-8 t-0 





//Find distinct mapping for each character to a digit (char->digit) which satisfies number(s1) + number(s2) = number(s3)
//Here s1 and s2 are strings which will be added and s3 is resust
/*
 s1
+s2
-----
 s3
*/

//Put each distinct char in hashmap with -1 value
//Map a value to char from unique string in order
//Go forward in the tree and map next char in unique string with a digit as well (with a different digit from the remaining ones)
//Then back track and un-map the char for next combination

//In each combo, calculate s1+s2 and check =s3 or not



////


pimport java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String s1 = scn.nextLine();
    String s2 = scn.nextLine();
    String s3 = scn.nextLine();

    HashMap<Character, Integer> charIntMap = new HashMap<>();
    String unique = "";
    for (int i = 0; i < s1.length(); i++) {
      if (!charIntMap.containsKey(s1.charAt(i))) {
        charIntMap.put(s1.charAt(i), -1);
        unique += s1.charAt(i);
      }
    }

    for (int i = 0; i < s2.length(); i++) {
      if (!charIntMap.containsKey(s2.charAt(i))) {
        charIntMap.put(s2.charAt(i), -1);
        unique += s2.charAt(i);
      }
    }

    for (int i = 0; i < s3.length(); i++) {
      if (!charIntMap.containsKey(s3.charAt(i))) {
        charIntMap.put(s3.charAt(i), -1);
        unique += s3.charAt(i);
      }
    }

    boolean[] usedNumbers = new boolean[10];
    solution(unique, 0, charIntMap, usedNumbers, s1, s2, s3);
  }

    public static int makeNum(String s, HashMap<Character,Integer> map){
        StringBuilder sb= new StringBuilder();
        for(int idx=0;idx<s.length();idx++){
            char ch= s.charAt(idx); //get character
            sb.append(map.get(ch)); //get char's value
        }
    
        return Integer.parseInt(sb.toString()); //convert sb into String first the convert to integer
    }
  
  public static void solution(String unique, int idx, 
							  HashMap<Character, Integer> charIntMap, boolean[] usedNumbers, 
							  String s1, String s2, String s3) {
	    // write your code here
	    if(idx==unique.length()){
            int n1=makeNum(s1,charIntMap);
            int n2=makeNum(s2,charIntMap);
            int n3=makeNum(s3,charIntMap);
        
            if(n1+n2==n3){
                // System.out.println(charIntMap); //Not printing in alphabetical order
                for(int i=0;i<26;i++){
                    char ch= (char)('a'+i); //perform any operations with character, it becomes char's unicode/ascii value, so typecasting to character is needed
                    Integer res= charIntMap.get(ch); //get char in  alphabetical order
                    if(res!=null){ //check is it exists in HashMap
                        System.out.print(ch+"-"+res+" ");
                    }
                }
                System.out.println();
            }
            return;
        }
        
        char ch=unique.charAt(idx);
        for(int digit=0;digit<=9;digit++){
            if(usedNumbers[digit]==false){
                usedNumbers[digit]=true;
                charIntMap.put(ch,digit);
                solution(unique, idx+1, charIntMap, usedNumbers, s1,s2,s3);
                usedNumbers[digit]=false; //mark as unused to map characters to different digits in every recursion
                charIntMap.put(ch,-1);
            }
        }
          }

}

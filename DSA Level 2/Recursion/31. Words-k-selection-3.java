import java.io.*;
import java.util.*;

public class Main {

  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int k = Integer.parseInt(br.readLine());

    HashMap<Character, Integer> unique = new HashMap<>();
    String ustr = "";
    for (char ch : str.toCharArray()) {
      if (unique.containsKey(ch) == false) {
        unique.put(ch, 1);
        ustr += ch;
      } else {
        unique.put(ch, unique.get(ch) + 1);
      }
    }

   comb(ustr, unique, 0,"",k);
  }

    public static void comb(String ustr, HashMap<Character, Integer> fmap, int idx, String asf, int k){
       //Either char will be selected in ans or it will not. If it gets selected, based on freq, take all possible comb such as "aaa", "aa", "a", or if "a" is not selected at all
       //Each level represents a character
       if(asf.length()>k){ //invalid length
           return;
       }
       if(idx==ustr.length()){ //when all characters are exhausted
           if(asf.length()==k){ //if length is the one that is reqd , print
            System.out.println(asf);
           }
           return;
       }
       char ch= ustr.charAt(idx); //select char for curr level
        for(int i=fmap.get(ch); i>=0;i--){ //test for each possible freq of character from 0 to given freq
            String s="";
            for(int j=0;j<i;j++){ //add curr level of freq to string and add to answer
                s+=ch;
            }
            
            comb(ustr, fmap, idx+1, asf+s,k);
        }
   }
}
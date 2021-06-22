// 1. You are given a 10*10 2-D array(arr) containing only '+' and '-' characters, which represents a 
//     crossword puzzle. 
// 2. You are also given n number of words which need to be filled into the crossword.
// 3. Cells containing '-' are to be filled with the given words.

// Note -> Check out the question video and write the recursive code as it is intended without 
//                changing signature. The judge can't force you but intends you to teach a concept.
// Input Format
// 10 * 10 grid of characters containing only '+' and '-' 
// A number n
// str1
// str2
// ...n strings

// +-++++++++
// +-++++++++
// +-++++++++
// +-----++++
// +-+++-++++
// +-+++-++++
// +++++-++++
// ++------++
// +++++-++++
// +++++-++++
// 4
// LONDON
// DELHI 
// ICELAND 
// ANKARA
// Sample Output
// +L++++++++
// +O++++++++
// +N++++++++
// +DELHI++++
// +O+++C++++
// +N+++E++++
// +++++L++++
// ++ANKARA++
// +++++N++++
// +++++D++++

import java.io.*;
import java.util.*;

public class Main {

	public static void solution(char[][] arr, String[] words, int vidx){
		//write your code here
		if(vidx==words.length){
		    print(arr);
		    return;
		}
        String word = words[vidx];
        
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                if(arr[i][j]=='-' || arr[i][j]==word.charAt(0)){ //if cell is blank or cell contains starting letter of word
                
                    if(canPlaceHorizontal(arr, i,j,word)){ //check if we can place curr word horizontally
                        boolean visited[]=new boolean[word.length()];
                        placeWordHorizontally(arr,word, i, j,visited); 
                        solution(arr, words, vidx+1); //check next word
                        unplaceWordHorizontally(arr,word, i, j,visited); //backtrack to remove word to place it vertically
                    }
                    
                    //Do same for vertical placement
                    if(canPlaceVertical(arr, i,j,word)){
                        boolean visited[]=new boolean[word.length()];
                        placeWordVertically(arr,word, i, j,visited);
                        solution(arr, words, vidx+1);
                        unplaceWordVertically(arr,word, i, j,visited);  //backtrack to remove word and check next combination
                    }
                    
                    
                }
            }
        }
	}

	public static boolean canPlaceHorizontal(char [][]arr, int r, int c, String word){
	    for(int i=0;i<word.length();i++){
	        if(c+i>=10){ //if word does not fit in row
	            return false;
	        }
	        if(arr[r][c+i]=='-' || arr[r][c+i]==word.charAt(i)){ 
	            //if either cell is blank or its in same pos as char of word
	            continue;
	        }else{
	            return false;
	        }
	    }
	    
	    //if the word fits and it is wrong
	    if(c!=0){ //if we are not at start of row
	        if(arr[r][c-1]!='+'){ //if we do not have extra blanks behind us in the row
	            return false;
	        }
	    }
	    
	    if(c+word.length()==10 || arr[r][c+word.length()]=='+'){
	        //check whether we will go out of the board or not. COnd 1:Just fit, cond 2:less
	        return true;
	    }else{
	        return false;
	    }
	}
	public static boolean canPlaceVertical(char [][]arr, int r, int c, String word){
	    for(int i=0;i<word.length();i++){
	        if(r+i>=10){ //if word does not fir in row
	            return false;
	        }
	        if(arr[r+i][c]=='-' || arr[r+i][c]==word.charAt(i)){ 
	            continue;
	        }else{
	            return false;
	        }
	    }
	    
	    //if the word fits and it is wrong
	    if(r!=0){
	        if(arr[r-1][c]!='+'){
	            return false;
	        }
	    }
	    
	    if(r+word.length()==10 || arr[r+word.length()][c]=='+'){
	        return true;
	    }else{
	        return false;
	    }
	}
	public static void placeWordHorizontally(char [][]arr,String word,int r, int c, boolean []visited){
	    for(int i=0;i<word.length();i++){
	        if(arr[r][c+i]=='-'){
	            arr[r][c+i]= word.charAt(i);
	            visited[i]=true;
	        }
	        
	    }
	}
	public static void placeWordVertically(char [][]arr,String word,int r, int c,boolean []visited){
	    for(int i=0;i<word.length();i++){
	        if(arr[r+i][c]=='-'){
	            arr[r+i][c]= word.charAt(i);
	            visited[i]=true;
	        }
	        
	    }
	}
	public static void unplaceWordHorizontally(char [][]arr,String word,int r, int c,boolean []visited){
	    //check for overlapping values
	    for(int i=0;i<word.length();i++){
	        if(visited[i]=true){
	            arr[r][c+i]= '-';
	        }
	    }
	}
	public static void unplaceWordVertically(char [][]arr,String word,int r, int c,boolean []visited){
	    for(int i=0;i<word.length();i++){
	        if(visited[i]=true){
	            arr[r+i][c]= '-';
	        }
	    }
	}
	public static void print(char[][] arr){
		for(int i = 0 ; i < arr.length; i++){
			for(int j = 0 ; j < arr.length; j++){
				System.out.print(arr[i][j]);
			}
                  System.out.println();
		}
		
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		char[][] arr = new char[10][10];
		for(int i = 0 ; i < arr.length; i++){
			String str = scn.next();
			arr[i] = str.toCharArray();
		}
		int n = scn.nextInt();
		String[] words = new String[n];
		for(int i = 0 ; i  < words.length; i++){
			words[i] = scn.next();
		}
        
        solution(arr, words, 0);
	}
}
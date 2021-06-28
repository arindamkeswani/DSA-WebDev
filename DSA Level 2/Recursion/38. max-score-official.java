
// 1. You are given a list of words, a list of alphabets(might be repeating) and score of every alphabet 
// from a to z.
// 2. You have to find the maximum score of any valid set of words formed by using the given 
// alphabets.
// 3. A word can not be used more than one time.
// 4. Each alphabet can be used only once. 
// 5. It is not necessary to use all the given alphabets.

// Note -> Check out the question video and write the recursive code as it is intended without 
//           changing signature. The judge can't force you but intends you to teach a concept.
// Input Format
// A number N representing number of words
// N space separated strings
// A number M representing number of alphabets(might be repeating)
// M space separated characters
// 26 numbers representing score of unique alphabets from a to z.
// Output Format
// Check the sample ouput and question video.

/*
Sample Input
4
dog cat dad good
9
a b c d d d g o o
1 0 9 5 0 0 3 0 0 0 0 0 0 0 2 0 0 0 0 0 0 0 0 0 0 0
Sample Output
23
*/


import java.io.*;
import java.util.*;

public class Main {

	public static int solution(String[] words, int[] farr, int[] score, int idx) {
		//write your code here
		
		if(idx==words.length){ //if all words are parsed
		    return 0;
		}
		
		int scoreNotInclude = 0 + solution(words, farr, score, idx+1); //not including idxTh word
		
		//including idx th word
		int scoreIdxWord=0; //var to store score of current word
		String word=words[idx]; //curr word
		boolean flag=true; //if word can be inluded
		
		for(int i=0;i<word.length();i++){ //checking if curr word's characters have frequency left or not
		    char ch= word.charAt(i);
		    if(farr[ch -'a']==0){ //curr character cant be used as freq is 0
		        flag=false;
		    }
		    farr[ch-'a']-=1; //decrease freq 
		    scoreIdxWord+=score[ch-'a'];// add char's score, if valid score will be added, otherwise it will add 0 on its own
		}
		
		int scoreInclude = 0; //var to store score of current word
		if(flag){ //if character is valid
		    scoreInclude = scoreIdxWord + solution(words, farr, score, idx+1); //add its score and test word combinations
		}
		
		for(int i=0;i<word.length();i++){ //backtrcak and restore frequencies
		    char ch= word.charAt(i);
		    farr[ch-'a']+=1;
		}
		
		return Math.max(scoreNotInclude,scoreInclude); //return whichever score is highest
	}

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int nofWords = scn.nextInt();
		String[] words = new String[nofWords];
		for(int i = 0 ; i < words.length; i++) {
			words[i] = scn.next();
		}
		int nofLetters = scn.nextInt();
		char[] letters = new char[nofLetters];
		for (int i = 0; i < letters.length; i++) {
			letters[i] = scn.next().charAt(0);
		}
		int[] score = new int[26];
		for (int i = 0; i < score.length; i++) {
			score[i] = scn.nextInt();
		}
		if (words == null || words.length == 0 || letters == null || letters.length == 0 || score == null
				|| score.length == 0) {
			System.out.println(0);
			return;
		}
		int[] farr = new int[score.length];
		for (char ch : letters) {
			farr[ch - 'a']++;
		}
		System.out.println(solution(words, farr, score, 0));

	}
}
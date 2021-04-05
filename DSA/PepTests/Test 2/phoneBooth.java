// There are n phone booths that are available and are placed next to each other. The phone booths have very thins walls hence the sound from one phone booth can be heard in the adjacent
// phone booth. The owner knowing this problem places the callers in non-adjacent phone booths so that they are not disturbed. Initally some of the phone booths are occupied and 
// suddenly k number of people come to make a phone call. The owner wants to know if he can allot the phone booth to the k people such that no one is disturbed by the noise in adjacent
// booth.

// We are given an array that shows which of the n booth is occupied. 1 denotes that the booth is occupied and 0 denotes that the booth is unoccupied.

// The next input is the integer k denoting the number of new people that want to place the call.


import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = scn.nextInt();
        }

        int k = scn.nextInt();

       // code here
        int c=0;
        // for(int i=0;i<arr.length;i++){
        //     if(arr[i]==0){
        //         c++; //count number of empty booths
        //     }
        // }
        boolean flag=false;
        for(int i=1;i<arr.length-1;i++){
            if(arr[i]==0 && arr[i-1]==0 && arr[i+1]==0){
                c++; //count number of usable booths
            }
        }
        
        if(c>=k){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
    }
}
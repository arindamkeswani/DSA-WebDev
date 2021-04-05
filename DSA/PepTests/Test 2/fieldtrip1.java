// School students of different class(classes 1-9) are going on a field trip. Event coordinator ,Miss. Pepper wants to make (multiple groups) groups of students among each other ,such that all students within a particular group must belong to the same class and all groups should have same number of students.
// Miss. Pepper doesn't want any to be left alone in the group.
// Will Miss. Pepper be able to make groups with such given constraints ?(true/false)

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner x=new Scanner(System.in);
        int n=x.nextInt();
        
        int arr[]=new int[n];
        
        int cl[]={0,0,0,0,0,0,0,0,0};
        for(int i=0;i<n;i++){
            arr[i]=x.nextInt();
        }
        
        //count number of students in each class
        for(int i=0;i<n;i++){
            cl[arr[i]-1]+=arr[i];
        }
        
        //greater than=2 and even
        boolean flag=true;
        for(int i=0;i<9;i++){
            if(cl[i]==0){
                continue;
            }
            if(cl[i]<2 || cl[i]%2!=0){
                flag=false;
                break;
            }
        }
        
    
        System.out.println(flag);
        
        
    }
}
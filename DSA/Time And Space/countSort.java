
//O(n) =>[4n + (nRange)]
//Not commonly preferred when range of values is very high
//Space complexity = O(Math.max(n,nRange))
int numUnique=max-min+1;
int freq[] = new int[numUnique];

for(int val:arr){ //map elements with their frequencies
    freq[val-min]++;
}

for(int idx=1;idx<numUnique;i++){ //cumulative frequencies
    freq[idx] += freq[idx-1];
}

int res[]=new int[arr.length]; //result array

for(int idx=arr.length-1;idx>=0;idx--){
    int val = arr[idx]; //value of element from unsorted array
    int pos = val-min; //position mapped in freq array
    int place = freq[pos]; //place of current element in the resultant array acc to freq array
    res[place-1] = val; //place - 1 is index of current element in resultant array
    freq[pos]--; //update value of current elements in freq table
}

for(int i=0;i<arr.length;i++){
    arr[i] = res[i];
}
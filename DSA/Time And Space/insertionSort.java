int n=arr.length;
//best n, worst n^2
for(int itr=1;itr<n;itr++){ //itr values are sorted at the end of every iterations
    for(int idx=itr;idx>0;idx--){  //itr values are sorted, and one value tries to insert itself into it
        if(isGreater(arr,idx-1,idx)){ //if current value is less than previous value, swap it (inside currently sorted array)
            swap(idx, idx-1,idx);
        }else{
            break;
        }
    }
}
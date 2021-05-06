
// Given an array nums of n integers. Delete a subsequence of length k (where k = n/3)  from the array. Let's call the array B after deleting the subsequence. Now Geek will be happy if the array B can be divided into 2 subarray of equal length such that difference between sum of elements of first subarray and sum of elements of second subarray is minimum possible. Geek asked you to make him happy.
// Note: It is guaranted that n is divisible by 3.
 

// Example 1:

// Input: nums = {7,9,5,7,2,1}
// Output: 3
// Explanation: Delete the nums[2] and 
// nums[6]. Then array B will be-
// {7, 5, 7, 2}. Now the array can be divided
// into {7,5} and {7,2}. So the answer will be
// (7+5)-(7+2) = 3.
// Example 2:

// Input: nums = {5,6,3}
// Output: -1
// Explanation: Delete nums[3]. Then array B
// will be-
// {5,6}. Now the array can be divided into {5}
// and {6}. So the answer will be 5-6 = -1.
 

// Your Task:
// You don't need to read or print anything. Your task is to complete the function maximizeHappiness() which takes nums as input parameter and returns the answer.
 

// Constraints:
// 1 <= n <= 3*105
// 1 <= numsi <= 109

//Back-end complete function Template for C++

class Solution {
public:
	long long maximizeHappiness(vector<int>nums){
		using ll = long long int;
		int n = (int)nums.size() / 3;
		priority_queue<ll>pq;
		ll sum = 0;
		vector<ll>l(n+1,0);
		for(int i = 0; i < n; i++){
		    sum += nums[i];
		    pq.push(nums[i]);
		}
		l[0] = sum;
		for(int i = n; i < 2*n; i++){
		    ll x = pq.top();
		    pq.pop();
		    sum = sum - x + nums[i];
		    l[i-n+1] = sum;
		    pq.push(nums[i]);
		}
		sum = 0;
		priority_queue<ll, vector<ll>, greater<ll>>pq1;
		for(int i = 2*n; i < 3*n; i++){
		    sum += nums[i];
		    pq1.push(nums[i]);
		}
		vector<ll>r(n+1, 0);
		r[0] = sum;
		for(int i = 2*n-1; i >= n; i--){
		    ll x = pq1.top();
		    pq1.pop();
		    sum = sum - x + nums[i];
		    r[2*n - i] = sum;
		    pq1.push(nums[i]);
		}
		for(int i = 1; i <= n; i++)r[i] = max(r[i], r[i-1]);
		for(int i = 1; i <= n; i++)l[i] = min(l[i], l[i-1]);
		ll ans = 1e18;
		for(int i = 0; i <= n; i++){
		    ans = min(ans, l[i] - r[n-i]);
		}
		return ans;
	}
};
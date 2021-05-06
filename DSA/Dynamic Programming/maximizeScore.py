# Maximize the Score
# Accuracy: 0.0% Submissions: 0 Points: 100
# N boxes are arranged in a straight line on a table. Each box has an integer label on it and also contains an integer value inside it. You are also given two integers cost1 and cost2. The score of a sequence of boxes is calculated as follows: 
# 1.    If there are no boxes on the table, then the score is 0. Otherwise, the initial score is the product of cost1 and the integer contained inside the first box from left. 
# 2.    For every box left on the table(traverse from left to right) except the first box from the left, we add 

# # a.    The product of cost1 and the integer inside the current box to the score, if the labels on the current box and the box present to its left are different.
# # b.    The product of cost2 and the integer inside the current box to the score, if the labels on the current box and the box present to its left are the same.

# # Geek wants to remove some boxes (possibly Zero or all) so that the score is maximum possible.

# # Example 1:

# # Input:
# # N = 4, cost1 = 2, cost2 = 3 
# # values[] = { 3, 3, 2, -1 } 
# # labels[] = { 1, 2, 2, 3 }
# # Output:
# # 18
# # Explanation:
# # Geek can remove the last box. The score 
# # after removal will be (cost1*values[0]) + 
# # (cost1*values[1]) + (cost2*values[2]) = 18, 
# # which the maximum possible score.
# # Example 2:

# # Input: 
# # N = 4, cost1 = 2, cost2 = 3 
# # values[] = { -1, -2, -6, -1 } 
# # labels[] = { 1, 2, 2, 3 }
# # Output:
# # 0
# # Explanation: 
# # To get the maximum score, Geek should 
# # remove all the boxes.
# # Your Task:
# # Complete the function maximumScore() which takes the integers N, cost1, cost2 and the two arrays values and labels as input parameters, and returns the maximum possible score Geek can attain after removing some boxes

# # Constraints:
# # 1 ≤ N ≤ 105
# # -105 ≤ cost1, cost2, values[i] ≤ 105
# # 1 ≤ labels[i] ≤ 109


Maximize the Score
Accuracy: 0.0% Submissions: 0 Points: 100
N boxes are arranged in a straight line on a table. Each box has an integer label on it and also contains an integer value inside it. You are also given two integers cost1 and cost2. The score of a sequence of boxes is calculated as follows: 
1.    If there are no boxes on the table, then the score is 0. Otherwise, the initial score is the product of cost1 and the integer contained inside the first box from left. 
2.    For every box left on the table(traverse from left to right) except the first box from the left, we add 

a.    The product of cost1 and the integer inside the current box to the score, if the labels on the current box and the box present to its left are different.
b.    The product of cost2 and the integer inside the current box to the score, if the labels on the current box and the box present to its left are the same.

Geek wants to remove some boxes (possibly Zero or all) so that the score is maximum possible.

Example 1:

Input:
N = 4, cost1 = 2, cost2 = 3 
values[] = { 3, 3, 2, -1 } 
labels[] = { 1, 2, 2, 3 }
Output:
18
Explanation:
Geek can remove the last box. The score 
after removal will be (cost1*values[0]) + 
(cost1*values[1]) + (cost2*values[2]) = 18, 
which the maximum possible score.
Example 2:

Input: 
N = 4, cost1 = 2, cost2 = 3 
values[] = { -1, -2, -6, -1 } 
labels[] = { 1, 2, 2, 3 }
Output:
0
Explanation: 
To get the maximum score, Geek should 
remove all the boxes.
Your Task:
Complete the function maximumScore() which takes the integers N, cost1, cost2 and the two arrays values and labels as input parameters, and returns the maximum possible score Geek can attain after removing some boxes

Constraints:
1 ≤ N ≤ 105
-105 ≤ cost1, cost2, values[i] ≤ 105
1 ≤ labels[i] ≤ 109


////////////////////////////JAVA?????????????????????
class Solution{
    public long maximumScore(int N, int cost1, int cost2, int values[], int labels[]){
        HashMap<Integer, Long> dp= new HashMap<Integer,Long>();
        
        for (int i = 0; i < N; i++) {
            dp.put(labels[i], (long)-1e16);
        }
        dp.put(0,(long)0);
        int firstMax = 0, secondMax = 0;

        for (int i = 0; i < N; i++) {
            dp.put(labels[i], Math.max(dp.get(labels[i]) + (long)cost2 * (long)values[i], dp.get(labels[i])));

            if (labels[i] != firstMax) {
                dp.put(labels[i], Math.max(dp.get(labels[i]), dp.get(firstMax) + (long)values[i] * (long)cost1));
            } else {
                dp.put(labels[i],Math.max(dp.get(labels[i]), dp.get(secondMax) + (long)values[i] * (long)cost1));
            }

            if (labels[i] != firstMax) {
                if (dp.get(labels[i]) > dp.get(firstMax)) {
                    secondMax = firstMax;
                    firstMax = labels[i];
                } else if (dp.get(labels[i]) > dp.get(secondMax)) {
                    secondMax = labels[i];
                }
            }
        }
        return dp.get(firstMax);
    }
}

###############PYTHON
class Solution:
    def maximumScore(self, N, cost1, cost2, values, labels):
        # Code here
        dp={}
        for i in range(N):
            dp[labels[i]] = -10**16
        dp[0] = 0
        firstMax = 0
        secondMax = 0
        
        for i in range(N):
            dp[labels[i]] = max(dp[labels[i]] + cost2 * values[i], dp[labels[i]])
            if labels[i] != firstMax:
                dp[labels[i]] = max(dp[labels[i]], dp[firstMax] + values[i] * cost1);
            else:
                dp[labels[i]] = max(dp[labels[i]], dp[secondMax] + values[i] * cost1);

            if  labels[i] != firstMax:
                if dp[labels[i]] > dp[firstMax]:
                    secondMax = firstMax
                    firstMax = labels[i]
                elif dp[labels[i]] > dp[secondMax]:
                    secondMax = labels[i]
        return dp[firstMax]
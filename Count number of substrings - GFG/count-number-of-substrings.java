//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String s = sc.next ();
            int k = sc.nextInt();
    		System.out.println (new Solution().substrCount (s, k));
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    long substrCount (String s, int k) {
      return solve(s,k)-solve(s,k-1);
    }
    
    long solve(String s, int k) {
        int i=0, j=0, size=0;
        long ans=0;
        
        int[] mapArray = new int[26];
        while(j < s.length()) {
            char ch = s.charAt(j);
            if(mapArray[ch -'a'] == 0) size++;
            mapArray[ch -'a']++;
            
            while(size > k) {
                char c = s.charAt(i);
                mapArray[c -'a']--;
                i++;
                if(mapArray[c -'a']==0) size--;
            }
            ans += j-i+1;
            j++;
        }
        return ans;
    }
}
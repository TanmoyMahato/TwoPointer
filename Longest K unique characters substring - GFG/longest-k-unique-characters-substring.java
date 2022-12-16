//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String str, int k) {
        int start=0, end=0;
        HashMap<Character,Integer> map = new HashMap<>();
        
        int maxSubstrLen = -1;
        while(end < str.length()){
            char addChar = str.charAt(end);
            map.put(addChar, map.getOrDefault(addChar,0)+1);
            
            if(map.size() == k){
                maxSubstrLen = Math.max(maxSubstrLen,end-start+1);
            } 
            else{
                while(map.size() > k){
                    char removeChar = str.charAt(start);
                    map.put(removeChar, map.getOrDefault(removeChar,0)-1);
                    if(map.get(removeChar) == 0) map.remove(removeChar);
                    start++;
                }
            }
            end++;
        }
        
        return maxSubstrLen;
    }
}
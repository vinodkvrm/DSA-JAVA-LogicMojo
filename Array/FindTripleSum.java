package Array;

import java.util.HashSet;
import java.util.Set;

class FindTripleSum
{
    //Function to find if there exists a triplet in the 
    //array A[] which sums up to X.
    public static boolean find3Numbers(int A[], int n, int X) { 
    
       // Your code Here
       
       for(int k =0;k < n;k++){
           int x=A[k],y=0,z=0;
           Set<Integer> set = new HashSet<>();
           for(int i=0;i<n;i++){
               if(k == i)
                continue;
               if(set.contains(X -A[k] - A[i])){
                   return true;
               }else{
                   set.add(A[i]);
               }
           }
           
       }
       return false;
    
    }

    public static void main(String[] args) {
        int arr[] = {1, 4, 45, 6, 10, 8};
        int n = arr.length;
        int X = 22;
        System.out.println(find3Numbers(arr, n, X));
    }
}

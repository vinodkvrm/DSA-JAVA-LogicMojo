package Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class ArrayTwoSumCandidates {
    boolean hasArrayTwoCandidates(int arr[], int n, int x) {
        // code here
        Set<Integer> map = new HashSet<>();
        for(int i : arr){
            if(map.contains(x-i))
                return true;
            map.add(i);
        }
        return false;
    }

    boolean hasArrayTwoCandidates1(int arr[], int n, int x) {
        arr = Arrays.stream(arr).sorted().toArray();
        int l=0;
        int r = arr.length-1;
        while(l < r){
            if(arr[l] + arr[r] == x)
                return true;
            if((arr[l] + arr[r]) < x)
                l++;
            else
                r--;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {3,6,1,2};
        ArrayTwoSumCandidates obj = new ArrayTwoSumCandidates();
        System.out.println(obj.hasArrayTwoCandidates(arr, arr.length, 10));
        System.out.println(obj.hasArrayTwoCandidates1(arr, arr.length, 10));
    }
}
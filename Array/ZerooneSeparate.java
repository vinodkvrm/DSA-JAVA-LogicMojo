package Array;

import java.util.Arrays;

class ZerooneSeparate {
    void segregate0and1(int[] arr, int n) {
        // code here
        int result[] = new int[n];
        int count = 0;
        int i=0;
        for(int num : arr){
            if(num != 0)
                count++;
            else
                result[i++]=num;
        }
        for(int j = n - count;j < n;j++){
            result[j] = 1;
        }
        Arrays.stream(result).forEach(System.out::print);
    }

    void segregate0and1_1(int[] arr, int n) {
        // code here
        int l = 0,r = arr.length-1;

        while( l < r){
            while(l<r && arr[l] == 0){
                l++;
            }

            while(l < r && arr[r] == 1){
                r--;
            }
            if(l < r){
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
                l++;
                r--;
            }

        }

    }

    public static void main(String[] args) {
        int[] arr = {0,0,1,1,0,0};
        new ZerooneSeparate().segregate0and1(arr, arr.length);
        new ZerooneSeparate().segregate0and1_1(arr, arr.length);
    }

}

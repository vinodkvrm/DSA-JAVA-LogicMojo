package Array;

class MaxIndexDiff {

    int maxIndexDiff(int arr[], int n) {
        // code here
        int[] a=new int[n];
        a[n-1] = arr[n-1];
        
        for(int i=n-2; i>=0;i--){
            a[i] = Math.max(arr[i], a[i+1]);
        }
        
        int count = 0;
        int i=0,j=0;
        while(i<n && j<n){
            if(arr[i] <= a[j]){
                count = Math.max(count, j-i);
                j++;
            }
            else{
                i++;
            }
        }
        return count;

    }

    public static void main(String[] args) {
        int[] arr = {34, 8 ,10 ,3, 2, 80, 30, 33 ,1};
        System.out.println(new MaxIndexDiff().maxIndexDiff(arr, arr.length));
    }
}
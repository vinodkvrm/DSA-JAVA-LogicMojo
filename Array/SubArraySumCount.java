package Array;

import java.util.HashMap;
import java.util.Map;

class SubArraySumCount {
    public int subarraySum(int[] nums, int k) {
        int sum =0;
        int count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i=0; i < nums.length;i++){
            sum = sum + nums[i];
            if(map.containsKey(sum - k)){
                count += map.get(sum - k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int k = 2;
        System.out.println(new SubArraySumCount().subarraySum(nums, k));
    }
}
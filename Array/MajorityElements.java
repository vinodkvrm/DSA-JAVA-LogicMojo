package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class MajorityElements {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int majorityTimes = nums.length / 2;
        for (int num : nums){
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);               
            }else{
                map.put(num,1);
            }
            if(map.get(num) > majorityTimes)
                    return num; 
        }
        return -1;
    }

    public int majorityElement1(int[] nums) {
        return majorityElement(nums,nums[0],0) ;
    }

    public int majorityElement2(int[] nums) {
        nums = Arrays.stream(nums).sorted().toArray();
        return nums[nums.length/2];
    }

    public int majorityElement(int[] nums, int val, int index){
        int count = 0;
        for (int i = index; i < nums.length; i++) {
            if (val == nums[i])
                count++;
            else
                count--;
            if (count < 0)
                return majorityElement(nums, nums[i], i);
        }
        return val;
    }

    public static void main(String[] args) {
        int[] arr = {6,5,5};
        System.out.println(new MajorityElements().majorityElement(arr));
        System.out.println(new MajorityElements().majorityElement1(arr));
        System.out.println(new MajorityElements().majorityElement2(arr));
    }
}
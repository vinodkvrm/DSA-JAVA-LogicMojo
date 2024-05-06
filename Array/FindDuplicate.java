package Array;

import java.util.HashSet;
import java.util.Set;

class FindDuplicate {
    public int findDuplicate(int[] nums) {
        int result = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums){
            if(!set.add(num))
                return num;
        }
        return result;
    }

    public int findDuplicate2(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow != fast);

        fast = nums[0];
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public int findDuplicate3(int[] nums) {
        for (int i = 0;i < nums.length;i++){
            if(nums[Math.abs(nums[i])] < 0)
                return Math.abs(nums[i]);
            nums[Math.abs(nums[i])] = - nums[Math.abs(nums[i])];
        }
        return -1;
    }
    public int findDuplicate4(int[] nums) {
            boolean visited[] = new boolean[nums.length + 1];
            for(int x : nums) {
                if(visited[x]) {
                    return x;
                }
                visited[x] = true;
            }
            return -1;
    }

    public static void main(String[] args) {
        // each integer in array is 1 - N , where N is length of array
        FindDuplicate findDuplicate = new FindDuplicate();
        System.out.println(findDuplicate.findDuplicate(new int[]{1,2,3,4,3,5}));
        System.out.println(findDuplicate.findDuplicate(new int[]{2,2,2,2}));
        System.out.println(findDuplicate.findDuplicate2(new int[]{2,2,2,2}));
        System.out.println(findDuplicate.findDuplicate3(new int[]{2,2,2,2}));

    }
}
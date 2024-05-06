package Array;

import java.util.*;
import java.util.stream.Collectors;

class MajorityElementby3 {
    public List<Integer> majorityElement(int[] nums) {
        /*List<Integer> result = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : nums){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }else{
                map.put(i,1);
            }

        }
        for(int i : map.keySet()){
            if(map.get(i) > nums.length/3){
                result.add(i);
            }
        }
        return result;*/
        Map<Integer,Integer> map = new HashMap<>();
        Arrays.stream(nums).forEach(i -> map.compute(i, (k,v) -> Optional.ofNullable(v).map(j -> j+1).orElse(1)));
        return map.keySet().stream().filter(i -> map.get(i) > (nums.length/3) ).collect(Collectors.toList());
    }

    public List<Integer> majorityElement2(int[] nums) {
        int first=Integer.MIN_VALUE,second=Integer.MIN_VALUE,count1=0,count2=0;
        List<Integer> list = new ArrayList<>();
        for(int i : nums){
            if(first == i)
                count1++;
            else if(second == i)
                count2++;
            else if(count1 == 0){
                first = i;
                count1++;
            }else if(count2 == 0){
                second = i;
                count2++;
            }
            else{
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int i : nums ){
            if(first == i)
                count1++;
            else if(second == i){
                count2++;
            }
        }
        if(count1 > (nums.length / 3))
            list.add(first);
        if(count2 > (nums.length /3)){
            list.add(second);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,3};
        MajorityElementby3 obj = new MajorityElementby3();
        List<Integer> result = obj.majorityElement(arr);
        System.out.println(result);
        System.out.println(obj.majorityElement2(arr));
    }
}
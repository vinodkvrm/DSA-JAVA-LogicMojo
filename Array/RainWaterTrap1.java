package Array;

class RainWaterTrap1 {
    public int trap(int[] height) {
       int n = height.length;
       int l = 1,r = n-2;
       int leftMax = height[0],rightMax = height[n-1];
       int saved = 0;
       while(l <= r){
            if( leftMax <= rightMax){
                if( height[l] <= leftMax)
                    saved += leftMax - height[l];
                else
                    leftMax = height[l];
                l++;
            }else{
                if( height[r] <= rightMax)
                    saved += rightMax - height[r];
                else
                    rightMax = height[r];
                r--;
            }
        }
    return saved;
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(new RainWaterTrap1().trap(height));
    }
}
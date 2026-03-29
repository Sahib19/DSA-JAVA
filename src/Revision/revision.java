package Revision;

public class revision {
    public static void main(String[] args) {
        int[] height = {1, 2, 3, 4, 5, 6};
        // calculating right and left max array

        int[] leftMax = new int[height.length];
        leftMax[0] = height[0];
        for (int i = 1; i < leftMax.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }


        int[] rightMax = new int[height.length];
        rightMax[height.length - 1] = height[height.length - 1];
        for (int i = rightMax.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }

        // calculating trapped water
        int trappedWater = 0;
        for (int i = 0; i < height.length; i++) {
            trappedWater += (Math.min(leftMax[i], rightMax[i]) - height[i]);
        }

        System.out.println(trappedWater);

    }
}

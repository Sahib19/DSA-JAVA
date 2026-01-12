package DataStructures;

public class dsa6 {

    public static int RotatedSortedArray(int [] nums , int target){
        int start =  0 , end = nums.length-1 ;
        while(start<=end){
            int mid = start+(end -start)/2 ;
            if(target == nums[mid]){
                return mid ;
            }
            if(nums[start]<=nums[mid]){
                // it mean left is sorted array
                if(nums[start]<= target && target <=nums[mid]){
                   end = mid-1 ;
                }else{
                    start = mid +1 ;
                }
            }else{
                //it mean right is sorted array
                if(nums[mid]< target && target <= nums[end]){
                    start = mid+1 ;
                }else{
                    end = mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int [] nums = {4,5,6,7,0,1,2};
        System.out.println(RotatedSortedArray(nums,0));;
    }
}

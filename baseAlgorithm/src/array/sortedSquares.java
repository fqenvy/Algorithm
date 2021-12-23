package array;

/**
 * 有序数组，平方之后排序
 */
public class sortedSquares {
    public int[] sortedSquares(int[] nums) {
        //r指针
        int r = nums.length - 1;
        //l指针
        int l = 0;
        //辅助数组
        int[] res = new int[nums.length];
        //用i来记录最后的数据
        int i = res.length - 1;
        //相等则结束循环
        while (l <= r) {
            if (nums[l] * nums[l] > nums[r] * nums[r]) {
                res[i] = nums[l] * nums[l];
                i--;
                l++;
            } else {
                res[i] = nums[r] * nums[r];
                i--;
                r--;
            }
        }
        return res;

    }
}

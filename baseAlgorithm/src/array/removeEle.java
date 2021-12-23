package array;

/**
 * 移除数组中的给定的值
 * removeE：暴力枚举
 * remove：双指针
 */

public class removeEle {

    public int removeE(int[] nums, int val) {
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            if (nums[i] == val) {
                //指针指向的值与val相等，
                for (int j = i + 1; j < size; j++) {
                    //i后面的数字逐步覆盖掉
                    nums[j - 1] = nums[j];
                }
                i--;
                size--;
            }
        }
        return size;
    }

    public int remove(int[] nums, int val) {
        int size = nums.length;

        int s = 0;
        for (int f = 0; f < size; f++) {
            //若快指针的值不是删除的值
            if (nums[f] != val) {
                //将其挪到s的位置
                nums[s] = nums[f];
                s++;
            }
        }
        return s;
    }


}

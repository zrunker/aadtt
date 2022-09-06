package cc.banzhi.android.algorithmdemo;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 303. 区域和检索 - 数组不可变
 * @author: zoufengli01
 * @create: 2022/8/14 10:52
 **/
public class NumArray {
    private int[] sums;

    public NumArray(int[] nums) {
        if (nums == null) return;
        int length = nums.length;
        sums = new int[length + 1];
        sums[0] = 0;
        for (int i = 0; i < length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return sums[right + 1] - sums[left];
    }

}

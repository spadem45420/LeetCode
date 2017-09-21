package prac;

import java.util.Arrays;

/**
 * 	Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.

	Example 1:
	Input: [1,4,3,2]
	
	Output: 4
	Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
	Note:
	n is a positive integer, which is in the range of [1, 10000].
	All the integers in the array will be in the range of [-10000, 10000].
 *
 */
public class ArrayPartitionI {

	public static void main(String[] args) {
		int[] nums = {1,4,3,2};
		System.out.println(new ArrayPartitionI().arrayPairSum(nums));
	}
	
	/**
	 * 這邊用的是貪婪算法(不是很懂該演算法)
	 * 由於我們要最大化每個對中的最小值之和，所以每對數字必須越接近越好
	 * 如果差距太大，大數字就會被浪費了 ex:[1,100]
	 * 所以先以小到大順序排序後取奇數位加起來便是解答
	 */
	public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i+=2) {
        	sum = sum + nums[i];
        }
        return sum;
    }
	

}

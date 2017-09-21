package prac;

/**
 * 	Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.

	Note:
	The given integer is guaranteed to fit within the range of a 32-bit signed integer.
	You could assume no leading zero bit in the integer’s binary representation.
	Example 1:
	Input: 5
	Output: 2
	Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
	Example 2:
	Input: 1
	Output: 0
	Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.

 */
public class NumberComplement {

	public static void main(String[] args) {
		// 010
		int num = 5;
		//
		System.out.println(~4);
		
		System.out.println(7<<1 | 0x1);
		
		System.out.println((1<<1)|0x1);
		
		System.out.println(new NumberComplement().findComplement(5));
		
	}
	
	public int findComplement(int num) {
        /*
		        思路是这样的，从左向右找第一个不是0的位，没找到之前不做处理，找到之后开始凑答案，
		        如果是1，就把答案向左移一位，如果是0，就把答案向左移一位，并且跟0x1或一下。
        */
		/**
		 * 這個是參考某位博客的寫法
		 * 因為int是32位元，所以for循環32次
		 * 每次都會 & 0x80000000
		 * 意思就是跟 1000 0000 0000 0000 0000 0000 0000 0000 做 & 運算
		 * 並且向左移1位
		 * 直到第一位為1的時候會進if判斷
		 * 這時候開始湊答案
		 * 答案的需求為該整數取反但前面的都不要，啥意思？
		 * 舉例：5的二進位 0000 0000 0000 0000 0000 0000 0000 0101
		 * 取反的話為          1111 1111 1111 1111 1111 1111 1111 1010
		 * 照題目例子 101 取反變成 010，所以就是保留左邊數來第一個1之後的位數
		 * --
		 * 可以知道1會變成0，0會變成1
		 * 只要是0的就必須變成1，1的話就把它變成0就對了
		 * 所以如果是1的話就直接把答案向左移一格，是0的話就 | 0x1 ( | 0x1 會把最後一位變成1，其餘不變)
		 * 以5為例子
		 * 循環到第29次時 (answer這邊以4位元表示)
		 * 1010 0000 0000 0000 0000 0000 0000 0000 -> answer = 0000
		 * i = 30 -> 開頭為0，向左移1並 | 0x1
		 * 0100 0000 0000 0000 0000 0000 0000 0000 -> answer = 0001
		 * i = 31 -> 開頭位1，向左移1
		 * 1000 0000 0000 0000 0000 0000 0000 0000 -> answer = 0010
		 */
        boolean startFlag = false;
        int numCopy = num;
        int answer = 0;
        for(int i = 0; i < 32; i++){
        	// 找到1
            if((numCopy & 0x80000000) == 0x80000000){
                if(startFlag == false){
                    startFlag = true;
                }
                if(startFlag == true){
                    answer = answer << 1;
                }
            }
            // 都是0
            else{
            	System.out.println("i = " + i);
                if(startFlag == true){
                    answer = answer << 1;
                    answer = answer | 0x1;
                }
            }
            numCopy = numCopy << 1;
            System.out.println("answer = " + answer);

        }
        return answer;
    }
	
	/**
	 * 似乎是網路上的最佳解
	 * 先以Integer.highestOneBit(int)取的最高位的1保留的數字
	 * 舉例：5的二進位 0000 0000 0000 0000 0000 0000 0000 0101
	 * 保留之後             0000 0000 0000 0000 0000 0000 0000 0100
	 * 最左邊的1被保留，其餘皆為0
	 * 向左移1在減1
	 * 左移1會變為     	 0000 0000 0000 0000 0000 0000 0000 1000
	 * 減1會變為            0000 0000 0000 0000 0000 0000 0000 0111
	 * (這邊會減1是因為減1有個特性，會將最右邊的1變為0，其餘皆相反)
	 * 再跟取反的num做&
	 *   1111 1111 1111 1111 1111 1111 1111 1010
	 * & 0000 0000 0000 0000 0000 0000 0000 0111
	 * ----------------------------------------------
	 *   0000 0000 0000 0000 0000 0000 0000 0010
	 * 
	 */
	public int findComplement2(int num) {
        return ~num & ((Integer.highestOneBit(num) << 1) - 1);
    }

}

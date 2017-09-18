package prac;

/**
 * 
 * 兩個等長字符串之間的漢明距離（英語：Hamming distance）是兩個字符串對應位置的不同字符的個數
 *
 * ex:
 * 1011101與1001001之間的漢明距離是2。
 * 2143896與2233796之間的漢明距離是3。
 * "toned"與"roses"之間的漢明距離是3。
 */
public class HammingDistance {

	public static void main(String[] args) {
		
		// &的自由練習
		//000010
		//000111
//		System.out.println(2&7);
		//000011
		//000111
//		System.out.println(3&7);
		//000100
		//000111
//		System.out.println(4&7);
		//000101
		//000111
//		System.out.println(5&7);
		//001000
		//000111
//		System.out.println(8&7);
//		int solution1 = new HammingDistance().solution1(7);
//		int solution2 = new HammingDistance().solution2(7);
//		int solution3 = new HammingDistance().solution3(7);
//		System.out.println("solution1 = " + solution1);
//		System.out.println("solution2 = " + solution2);
//		System.out.println("solution3 = " + solution3);
		
		// 實作HammingDistance
		// x= 5=0101
		// y=10=1010
		System.out.println(new HammingDistance().calculate(5, 10));
		System.out.println(new HammingDistance().calculate2(5, 10));
	}
	
	// 判斷最右邊的值是不是1，每次都向右移1位，直到變成0為止
	public int solution1(int i) {
		int count = 0;
		
		while (i >= 1) {
			// ex:
			// i = 000100
			// 1 = 000001
			// 因為1最右邊是1，所以只要i&1之後不是1表示i最右邊為0
			if ((i & 1) >= 1) {
				count++;
			}
			i = i >> 1;
		}
		return count;
	}
	
	// 每次都將flag向左移1位，做&運算看是不是1，直到變成0為止
	public int solution2(int i) {
		int count = 0;
		int flag = 1;
		while (flag >= 1) {
			
			// ex:
			// i    = 000010
			// flag = 000001
			// flag不斷地向左移做&運算，若有&為1表示移到的位置有1
			if ((i & flag) >= 1) {
				count++;
				System.out.println("count = " + count);
			}
			flag = flag << 1;
			System.out.println("flag = " + flag);
		}
		return count;
	}
	
	// 如果一個整數若不為0，那二進制時必有一位是1
	// 將這個整數減去1，那該數二進制最右邊的1則會變成0
	// ex: 8-1=7
	// 8 -> 001000
	// 7 -> 000111
	// 也會發現減1之後，最右邊的1開始所有的位數都變相反了(0變成1)
	// 也就是說，一個整數減去1，在跟原整數做&運算，會將最右邊的1變成0
	// 一個整數的二進制有多少1，則可以這樣操作多少次
	public int solution3(int i) {
		int count = 0;
		while (i >= 1) {
			++count;
			i = (i-1) & i;
		}
		return count;
	}
	
	public int calculate(int x, int y) {
		int i = x^y;
		int count = 0;
		while (i != 0) {
			++count;
			i = (i-1) & i;
		}
		return count;
	}
	
	public int calculate2(int x, int y) {
		return Integer.bitCount(x ^ y);
	}

}

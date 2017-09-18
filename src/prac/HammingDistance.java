package prac;

/**
 * 
 * ��ӵ����r�Ŧꤧ�����~���Z���]�^�y�GHamming distance�^�O��Ӧr�Ŧ������m�����P�r�Ū��Ӽ�
 *
 * ex:
 * 1011101�P1001001�������~���Z���O2�C
 * 2143896�P2233796�������~���Z���O3�C
 * "toned"�P"roses"�������~���Z���O3�C
 */
public class HammingDistance {

	public static void main(String[] args) {
		
		// &���ۥѽm��
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
		
		// ��@HammingDistance
		// x= 5=0101
		// y=10=1010
		System.out.println(new HammingDistance().calculate(5, 10));
		System.out.println(new HammingDistance().calculate2(5, 10));
	}
	
	// �P�_�̥k�䪺�ȬO���O1�A�C�����V�k��1��A�����ܦ�0����
	public int solution1(int i) {
		int count = 0;
		
		while (i >= 1) {
			// ex:
			// i = 000100
			// 1 = 000001
			// �]��1�̥k��O1�A�ҥH�u�ni&1���ᤣ�O1���i�̥k�䬰0
			if ((i & 1) >= 1) {
				count++;
			}
			i = i >> 1;
		}
		return count;
	}
	
	// �C�����Nflag�V����1��A��&�B��ݬO���O1�A�����ܦ�0����
	public int solution2(int i) {
		int count = 0;
		int flag = 1;
		while (flag >= 1) {
			
			// ex:
			// i    = 000010
			// flag = 000001
			// flag���_�a�V������&�B��A�Y��&��1��ܲ��쪺��m��1
			if ((i & flag) >= 1) {
				count++;
				System.out.println("count = " + count);
			}
			flag = flag << 1;
			System.out.println("flag = " + flag);
		}
		return count;
	}
	
	// �p�G�@�Ӿ�ƭY����0�A���G�i��ɥ����@��O1
	// �N�o�Ӿ�ƴ�h1�A���ӼƤG�i��̥k�䪺1�h�|�ܦ�0
	// ex: 8-1=7
	// 8 -> 001000
	// 7 -> 000111
	// �]�|�o�{��1����A�̥k�䪺1�}�l�Ҧ�����Ƴ��ܬۤϤF(0�ܦ�1)
	// �]�N�O���A�@�Ӿ�ƴ�h1�A�b����ư�&�B��A�|�N�̥k�䪺1�ܦ�0
	// �@�Ӿ�ƪ��G�i��h��1�A�h�i�H�o�˾ާ@�h�֦�
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

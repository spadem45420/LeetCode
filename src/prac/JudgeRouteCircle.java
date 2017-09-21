package prac;

/**
 * 	Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle, 
 * which means it moves back to the original place.

	The move sequence is represented by a string. And each move is represent by a character. 
	The valid robot moves are R (Right), L (Left), U (Up) and D (down). The output should be true or false representing 
	whether the robot makes a circle.
	
	Example 1:
	Input: "UD"
	Output: true
	Example 2:
	Input: "LL"
	Output: false
 */
public class JudgeRouteCircle {
	
	public static void main(String[] args) {
//		new JudgeRouteCircle().judgeCircle("UDLR");
//		System.out.println(new JudgeRouteCircle().judgeCircle1("UUDDLLRR"));
		System.out.println(new JudgeRouteCircle().judgeCircle2("UUDDLLRR"));
	}
	
	// U ↑
	// D ↓
	// L ←
	// R →
	// origin place (0,0)
	// 這個做法沒問題，但是會比judgeCircle2多一個循環
	// 也就是時間複雜度會較高
	public boolean judgeCircle1(String moves) {
		int[] coordinate = {0,0}; 
		char[] movesArrsy = moves.toCharArray();
		for (char move : movesArrsy) {
			System.out.println("move = " + move);
			if ('U' == move) {
				System.out.println("U");
				coordinate[1] = coordinate[1] + 1;
			} else if ('D' == move) {
				System.out.println("D");
				coordinate[1] = coordinate[1] - 1;
			} else if ('L' == move) {
				System.out.println("L");
				coordinate[0] = coordinate[0] - 1;
			} else if ('R' == move) {
				System.out.println("R");
				coordinate[0] = coordinate[0] + 1;
			} else {
				System.err.println(move);
			}
		}
		System.out.println("(x,y) = " + "(" +coordinate[0] + "," + coordinate[1] + ")");
		if (coordinate[0] == 0 && coordinate[1] == 0) {
			return true;
		}
		return false;
    }
	
	public boolean judgeCircle2(String moves) {
		int x = 0;
		int y = 0;
		for (int i = 0; i < moves.length(); i++) {
			char move = moves.charAt(i);
			if ('U' == move) {
				System.out.println("U");
				y++;
			} else if ('D' == move) {
				System.out.println("D");
				y--;
			} else if ('L' == move) {
				System.out.println("L");
				x--;
			} else if ('R' == move) {
				System.out.println("R");
				x++;
			} else {
				System.err.println(move);
			}
		}
		return x==0 && y==0;
	}
}

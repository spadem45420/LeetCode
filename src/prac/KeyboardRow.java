package prac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 *  Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.


	American keyboard
	https://leetcode.com/static/images/problemset/keyboard.png
	
	Example 1:
	Input: ["Hello", "Alaska", "Dad", "Peace"]
	Output: ["Alaska", "Dad"]
	Note:
	You may use one character in the keyboard more than once.
	You may assume the input string will only contain letters of alphabet.

 */
public class KeyboardRow {

	public static void main(String[] args) {
		String[] words = {"Hello", "Alaska", "Dad", "Peace"};
//		String[] findWords = new KeyboardRow().findWords(words);
		String[] findWords = new KeyboardRow().findWords2(words);
		for (String word : findWords) {
			System.out.println(word);
		}
	}

	public static final String LINE1 = "QWERTYUIOPqwertyuiop";
	public static final String LINE2 = "ASDFGHJKLasdfghjkl";
	public static final String LINE3 = "ZXCVBNMzxcvbnm";
	public String[] findWords(String[] words) {
		List<String> validateWords = new ArrayList<String>();
		for (String word : words) {
			int lineV = this.findLineV(word);
			boolean isSameLine = findLine(word, lineV);
			if (isSameLine) {
				validateWords.add(word);
			}
		}
		return validateWords.toArray(new String[validateWords.size()]);
    }
	
	// 找出這個單字第一個字是屬於哪一個line的
	// line1 回傳1
	// line2 回傳2
	// line3 回傳3
	private int findLineV(String word) {
		for (int i=0;i<word.length();i++) {
			char alphabet = word.charAt(i);
			if (LINE1.contains(String.valueOf(alphabet))) {
				return 1;
			}
			if (LINE2.contains(String.valueOf(alphabet))) {
				return 2;
			}
			if (LINE3.contains(String.valueOf(alphabet))) {
				return 3;
			}
		}
		return 0;
	}
	
	// 檢查該單字是否每個字都是在同一個line上
	// 若有發現一個字不同line則回傳false
	private boolean findLine(String word, int lineV) {
		for (int i=1;i<word.length();i++) {
			char alphabet = word.charAt(i);
			if (LINE1.contains(String.valueOf(alphabet))) {
				if (1 != lineV) {
					return false;
				}
			}
			if (LINE2.contains(String.valueOf(alphabet))) {
				if (2 != lineV) {
					return false;
				}
			}
			if (LINE3.contains(String.valueOf(alphabet))) {
				if (3 != lineV) {
					return false;
				}
			}
		}
		return true;
	}
	
	
	// 寫三小XDD
	public String[] findWords2(String[] words) {
	    return Stream.of(words).filter(s -> s.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*")).toArray(String[]::new);
	}
}

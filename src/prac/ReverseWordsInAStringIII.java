package prac;

/**
 * 	Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

	Example 1:
	Input: "Let's take LeetCode contest"
	Output: "s'teL ekat edoCteeL tsetnoc"
	Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 */
public class ReverseWordsInAStringIII {
	
	public static final String SENTENCE = "Let's take LeetCode contest";

	public static void main(String[] args) {
		System.out.println(new ReverseWordsInAStringIII().reverseWords(SENTENCE));
//		System.out.println(new ReverseWordsInAStringIII().reverseWords2(SENTENCE));
		
//		String test = "test 123";
//		String[] split = test.split(" ");
//		for (String s : split) {
//			System.out.println(s);
//		}
	}
	
	/**
	 * 先用空白把每個單字切開
	 * 然後逐一把單字變成相反的再塞回去
	 */
	public String reverseWords(String s) {
		StringBuffer reverseWords = new StringBuffer();
		String[] splitWords = s.split(" ");
		for (String word : splitWords) {
			StringBuffer newWord = new StringBuffer();
			for (int i = word.length()-1; i >= 0; i--) {
				char charAt = word.charAt(i);
				newWord.append(charAt);
			}
			reverseWords.append(String.valueOf(newWord)).append(" ");
		}
		return reverseWords.toString().substring(0,reverseWords.length() - 1);
    }
	
	/**
	 * 這個做法雖然只有一個for但是效能反而不好
	 * 寫法是這樣的，將句子由最後一個字往前取
	 * 取到空白就開始處理
	 * 最後i=0的時候表示循環要結束了，這時侯把最後一塞進去(因為是以' '判斷要不要塞值最後一個單字不會擷取到空白，所以用i=0判斷)
	 */
	public String reverseWords2(String s) {
		StringBuffer reverseWords = new StringBuffer();
		StringBuffer tempWord = new StringBuffer();
		for (int i=s.length()-1; i >= 0;i--) {
			char charAt = s.charAt(i);
			tempWord.append(charAt);
			if (charAt == ' ') {
				// 先塞進tempWord
				tempWord.append(reverseWords);
				// 再產生新的StringBuffer，append進去
				// 這樣可以讓順序顛倒過來
				reverseWords = new StringBuffer().append(tempWord);
				tempWord = new StringBuffer();
			} 
			if (i==0) {
				tempWord.append(" ").append(reverseWords);
				reverseWords = new StringBuffer().append(tempWord);
				tempWord = new StringBuffer();
			}
		}
		return s.length() > 0 ? reverseWords.toString().substring(0, reverseWords.length()-1) : s;
    }


}

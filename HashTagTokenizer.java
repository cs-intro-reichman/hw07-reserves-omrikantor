

public class HashTagTokenizer {

	public static void main(String[] args) {

		String hashTag = args[0];
		String []dictionary = readDictionary("dictionary.txt");
		breakHashTag(hashTag, dictionary);
	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];
		In in = new In(fileName);
		for(int i = 0; i < 3000; i++)
		{
			dictionary[i] = in.readLine();
		}
		return dictionary;
	}

	public static boolean existInDictionary(String word, String []dictionary) {
		for(int i = 0; i < 3000; i++)
		{
			if(stringEquals(word, dictionary[i]))
			{
				return true;
			}
		}
		return false;
	}

	public static void breakHashTag(String hashtag, String[] dictionary) {

		// Base case: do nothing (return) if hashtag is an empty string.
        if (hashtag.isEmpty()) {
            return;
		}
		String h = hashtag.toLowerCase();
        int N = hashtag.length();
        for (int i = 1; i <= N; i++) 
		{
			String s = h.substring(0, i);
			if(existInDictionary(s, dictionary))
			{
				System.out.println(s);
				breakHashTag(h.substring(i, N), dictionary);
				i = N;
			}
		}
    }
	public static boolean stringEquals(String str1,String str2) {
		if (str1.length() != str2.length()) {
		 return false;
		}
		// we may assume the strings length are equal (from here)
		if (str1.length() == 0) { // we finished going over the strings
		 return true;
		}
		 if (str1.charAt(0) != str2.charAt(0)) { 
		 return false;
		}
		 return stringEquals(str1.substring(1),str2.substring(1));
	}		
}

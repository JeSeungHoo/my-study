package c.string.split_tokenizer;

public class StringSplitExam {

	public static void main(String[] args) {
		String text = "최기근&박주신,이주명,페이커-빛강선";
		String[] names = text.split("&|,|-");
		for(String s : names) {
			System.out.print(s+" ");
		}
	}

}



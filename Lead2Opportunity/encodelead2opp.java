package Lead2Opportunity;

import java.util.Base64;

public class encodelead2opp {

	public static void main(String[] args) {
		String uname = "kpriya@testleaf.com";
		String pwd = "March2016.";
		String encodedString = Base64.getEncoder().encodeToString(uname.getBytes());
		String encodeToString = Base64.getEncoder().encodeToString(pwd.getBytes());
		System.out.println(encodedString);
		System.out.println(encodeToString);
		//encoded username - a3ByaXlhQHRlc3RsZWFmLmNvbQ==
		//encoded password - TWFyY2gyMDE2Lg==
	}

}

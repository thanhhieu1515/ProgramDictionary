
package dataAccess;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import common.Library;
import common.Validation;
import model.English;
import model.Vietnamese;

public class Dictonary {
	private static Dictonary instance = null;
	Library library = new Library();

	Validation validation = new Validation();

	public static Dictonary Instance() {
		if (instance == null) {
			synchronized (Dictonary.class) {
				if (instance == null) {
					instance = new Dictonary();
				}
			}
		}
		return instance;
	}

	public void addNewWord(HashMap<English, Vietnamese> hm) {
		System.out.print("Enter Enlish: ");
		String english = validation.checkInputString();
		English eng = new English(english);
		if (!library.checkKeywordExist(hm, english)) {
			if (!validation.checkInputYN()) {
				return;
			}else {
				deleteWordToReplace(hm, english);
			}
		}
		System.out.print("Enter Vietnamese: ");
		String vietnam = validation.checkInputString();
		Vietnamese vn = new Vietnamese(vietnam);
		// check key word english exist or not
		hm.put(eng, vn);
		System.err.println("Add successful.");
	}

	public void deleteWordToReplace(HashMap<English, Vietnamese> hm, String english) {
		for (Map.Entry<English, Vietnamese> set : hm.entrySet()) {
			if (set.getKey().getEng().equalsIgnoreCase(english)) {
				hm.remove(set.getKey());
				return;
			}
		}
	}
	
	public void deleteWord(HashMap<English, Vietnamese> hm) {
		System.out.print("Enter english: ");
		String english = validation.checkInputString();
		English eng = new English(english);

		for (Map.Entry<English, Vietnamese> set : hm.entrySet()) {
			if (set.getKey().getEng().equalsIgnoreCase(english)) {
				hm.remove(set.getKey());
				System.err.println("Delete successful.");
				return;
			}

		}
		System.out.println("Don't have this word in dictionary");

	}

	public void translate(HashMap<English, Vietnamese> hm) {

		System.out.print("Enter english to translate: ");
		String english = validation.checkInputString();

		for (Map.Entry<English, Vietnamese> set : hm.entrySet()) {
			if (set.getKey().getEng().equalsIgnoreCase(english)) {
				System.out.println("Vietnamese : " + set.getValue());
				return;
			}

		}
		System.out.println("Don't have this word in dictionary");
	}
}


package repository;

import java.util.HashMap;

import dataAccess.Dictonary;
import model.English;
import model.Vietnamese;

public class DictionaryRepository implements IDictionary{
	HashMap<English, Vietnamese> hm = new HashMap<>();
	@Override
	public void addWord() {
		Dictonary.Instance().addNewWord(hm);
		
	}

	@Override
	public void removeWord() {
		Dictonary.Instance().deleteWord(hm);
		
	}

	@Override
	public void translate() {
		Dictonary.Instance().translate(hm);
		
	}

}

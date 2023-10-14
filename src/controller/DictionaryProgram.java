
package controller;

import repository.DictionaryRepository;
import view.Menu;

public class DictionaryProgram extends Menu<String> {
	static String[] mc = {"Add Word","Delete Word", "Translate", "Exit"};
	private DictionaryRepository dictionaryInstance = new DictionaryRepository();
	public DictionaryProgram() {
		super("Dictionary program", mc);
	}
	@Override
	public void executed(int n) {
		switch (n) {
		case 1: 
			dictionaryInstance.addWord();
			break;
		case 2:
			dictionaryInstance.removeWord();
			break;
		case 3:
			dictionaryInstance.translate();
			break;
		case 4:
			System.out.println("Program end");
			System.exit(0);
		default:
			throw new IllegalArgumentException("Unexpected value: " + n);
		}
		
	}
	
}

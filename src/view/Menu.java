
package view;

import java.util.ArrayList;
import java.util.Scanner;

import common.Library;

public abstract class Menu<T> {
	protected String title;
	protected ArrayList<T> mChon;
	
	private Library library = new Library();
	public Menu() {
	}

	public Menu(String td, String[] mc) {
		title = td;
		mChon = new ArrayList<>();
		for (String s : mc) {
			mChon.add((T) s);
		}
	}

	public void Display() {
		System.out.println(title);
		System.out.println("--------------------------------------------------");
		for (int i = 0; i < mChon.size(); i++)
			System.out.println("|  " + (i + 1) + ". " + mChon.get(i));
		System.out.println("--------------------------------------------------");
	}

	public int getSelected() {
		Display();
		return library.getIntForMenu("Enter your choice: ", 1, mChon.size());
	}
	
	public abstract void executed(int n);

	
	public  void  run() {
		while(true) {
			int n = getSelected();
			executed(n);
		}
	}
}

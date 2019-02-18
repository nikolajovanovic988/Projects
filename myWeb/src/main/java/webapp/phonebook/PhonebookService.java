package webapp.phonebook;

import java.util.ArrayList;
import java.util.List;

public class PhonebookService {
	
	private static List<Phonebook> phonebook = new ArrayList<Phonebook>();
	static {
	}
	
	
	
	public void addPhonebook(String name, String number) {
		phonebook.add(new Phonebook(name,number));
	}
	public List<Phonebook> getPhonebook() {
		return phonebook;
	}
	
	public void deletePhonebook(String name, String number) {
		phonebook.remove(new Phonebook(name,number));
	}
	
	public int getPhonebookNum() {
		return phonebook.size();
	}
}

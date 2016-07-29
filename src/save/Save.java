package save;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

import book.ContactInfo;

public class Save {
	public void Save(File file2, List<ContactInfo> contactList) throws FileNotFoundException {
		// TODO Auto-generated constructor stub
		FileOutputStream fout = new FileOutputStream(file2);
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(fout);
			oos.writeObject(contactList);
			fout.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void save(File file, List<ContactInfo> contactList) throws FileNotFoundException {
		FileOutputStream fout = new FileOutputStream(file);
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(fout);
			oos.writeObject(contactList);
			fout.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

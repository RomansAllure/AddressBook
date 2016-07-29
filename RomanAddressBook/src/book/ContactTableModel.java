package book;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import javax.swing.table.AbstractTableModel;

import book.ContactInfo;
import save.Save;

public class ContactTableModel extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final List<ContactInfo> contactList;
	private final Save save = new Save();
	private final String un;

	private final String[] columnNames = new String[] { "Id", "Last Name", "First Name", "Phone Number", "City",
			"Group" };

	private final Class[] columnClass = new Class[] { Integer.class, String.class, String.class, String.class,
			String.class, String.class };

	public ContactTableModel(List<ContactInfo> contactList, String un2) {
		this.un = un2;
		this.contactList = contactList;
	}

	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return columnClass[columnIndex];
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return contactList.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		ContactInfo row = contactList.get(rowIndex);
		if (0 == columnIndex) {
			File file = new File("C:\\addressbook\\" + un + "File.dat");
			try {
				save.save(file, contactList);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return row.getId();
		} else if (1 == columnIndex) {
			File file = new File("C:\\addressbook\\" + un + "File.dat");
			try {
				save.save(file, contactList);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return row.getLastName();
		} else if (2 == columnIndex) {
			File file = new File("C:\\addressbook\\" + un + "File.dat");
			try {
				save.save(file, contactList);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return row.getFirstName();
		} else if (3 == columnIndex) {
			File file = new File("C:\\addressbook\\" + un + "File.dat");
			try {
				save.save(file, contactList);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return row.getCellNumber();
		} else if (4 == columnIndex) {
			File file = new File("C:\\addressbook\\" + un + "File.dat");
			try {
				save.save(file, contactList);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return row.getCity();
		} else if (5 == columnIndex) {
			File file = new File("C:\\addressbook\\" + un + "File.dat");
			try {
				save.save(file, contactList);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return row.getGroupName();
		}
		return null;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}
	
	public void removeRow(int rowIndex) {
	    fireTableRowsDeleted(rowIndex, rowIndex);
	}
	
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		ContactInfo row = contactList.get(rowIndex);
		if (0 == columnIndex) {
			row.setId((Integer) aValue);

		} else if (1 == columnIndex) {
			row.setLastName((String) aValue);

		} else if (2 == columnIndex) {
			row.setFirstName((String) aValue);
		} else if (3 == columnIndex) {
			row.setCellNumber((String) aValue);
		} else if (4 == columnIndex) {
			row.setCity((String) aValue);
		} else if (5 == columnIndex) {
			row.setGroupName((String) aValue);
		}
	}

}

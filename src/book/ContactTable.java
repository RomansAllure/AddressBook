package book;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import book.ContactTableModel;
import book.ContactInfo;
import save.Save;

public class ContactTable extends JFrame {

	private JTextField searchField;
	private JPanel panel;
	private JScrollPane scroll;
	private int size;

	public ContactTable(String un) throws FileNotFoundException, ClassNotFoundException {

		super("JTable sorting Demo");
		panel = new JPanel();

		searchField = new JTextField();

		panel.setLayout(null);

		List<ContactInfo> contactList = new ArrayList<ContactInfo>();
		File file = new File("C:\\addressbook\\" + un + "File.dat");
		FileInputStream fin = new FileInputStream(file);
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(fin);
			contactList = (ArrayList<ContactInfo>) ois.readObject();
			size = contactList.size();
			fin.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ContactTableModel model = new ContactTableModel(contactList, un);

		JTable table = new JTable(model);

		table.setAutoCreateRowSorter(true);
		table.setBounds(10, 10, 150, 20);
		JButton btn = new JButton("Add");
		btn.setBounds(730, 10, 150, 20);
		btn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				List<ContactInfo> contactList = new ArrayList<ContactInfo>();
				File file = new File("C:\\addressbook\\" + un + "File.dat");
				FileInputStream fins;
				ObjectInputStream ois;
				try {
					fins = new FileInputStream(file);
					ois = new ObjectInputStream(fins);
					contactList = (ArrayList<ContactInfo>) ois.readObject();
					contactList.add(
							new ContactInfo(contactList.size() + 1, " ", " ", " ", " ", " ", "1 ", " ", " ", " ", " "));
					Save save = new Save();

					try {
						save.save(file, contactList);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					fin.close();
				} catch (IOException | ClassNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

				JFrame ContactTable;
				dispose();
				try {
					ContactTable = new ContactTable(un);
					ContactTable.setVisible(true);
				} catch (FileNotFoundException r) {
					// TODO Auto-generated catch block
					r.printStackTrace();
				} catch (ClassNotFoundException r) {
					// TODO Auto-generated catch block
					r.printStackTrace();
				}

			}

		});

		JLabel st = new JLabel("Search: ");
		st.setBounds(10, 10, 80, 20);
		panel.add(st);

		searchField.setBounds(100, 10, 150, 20);
		TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(table.getModel());
		table.setRowSorter(rowSorter);
		searchField.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void changedUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				String text = searchField.getText();

				if (text.trim().length() == 0) {
					rowSorter.setRowFilter(null);
				} else {
					rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				}
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				String text = searchField.getText();

				if (text.trim().length() == 0) {
					rowSorter.setRowFilter(null);
				} else {
					rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				}
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				String text = searchField.getText();

				if (text.trim().length() == 0) {
					rowSorter.setRowFilter(null);
				} else {
					rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				}
			}
		});

		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				int i = (int) table.getValueAt(table.getSelectedRow(), 0);
				i--;
				JFrame Contact;
				String r = Integer.toString(i);
				dispose();
				try {
					Contact = new Contact(r, un);
					Contact.setVisible(true);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		setResizable(false);
		scroll = new JScrollPane(table);
		scroll.setBounds(0, 40, 900, 300);
		panel.add(searchField);
		panel.add(scroll);
		panel.add(btn);

		getContentPane().add(panel);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Inventory Window");
		setSize(900, 400);
		setLocationRelativeTo(null);
		setVisible(true);

	}

}

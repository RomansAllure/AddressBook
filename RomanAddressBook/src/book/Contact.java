package book;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.Main;
import save.Save;
import user.UserInfo;

public class Contact extends JFrame {

	private JPanel contentPane;
	private final Save save = new Save();

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Contact(String id, String u) throws FileNotFoundException, ClassNotFoundException {
		setSize(300, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		int size = Integer.parseInt(id);
		List<ContactInfo> contactList = new ArrayList<ContactInfo>();
		File file = new File("C:\\addressbook\\" + u + "File.dat");
		FileInputStream fin = new FileInputStream(file);
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(fin);
			contactList = (ArrayList<ContactInfo>) ois.readObject();
			fin.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String idf = Integer.toString(size + 1);
		ContactInfo row = contactList.get(size);

		JLabel idLabel = new JLabel("ID");
		idLabel.setBounds(10, 10, 80, 25);
		contentPane.add(idLabel);

		JLabel fNameLabel = new JLabel("First Name");
		fNameLabel.setBounds(10, 40, 80, 25);
		contentPane.add(fNameLabel);

		JLabel lNameLabel = new JLabel("Last Name");
		lNameLabel.setBounds(10, 70, 80, 25);
		contentPane.add(lNameLabel);

		JLabel nNameLabel = new JLabel("Nick Name");
		nNameLabel.setBounds(10, 100, 80, 25);
		contentPane.add(nNameLabel);

		JLabel cNumLabel = new JLabel("Cell Number");
		cNumLabel.setBounds(10, 130, 80, 25);
		contentPane.add(cNumLabel);

		JLabel wNumLabel = new JLabel("Work Number");
		wNumLabel.setBounds(10, 160, 80, 25);
		contentPane.add(wNumLabel);

		JLabel sAddrLabel = new JLabel("Street");
		sAddrLabel.setBounds(10, 190, 80, 25);
		contentPane.add(sAddrLabel);

		JLabel cityLabel = new JLabel("City");
		cityLabel.setBounds(10, 220, 80, 25);
		contentPane.add(cityLabel);

		JLabel zCodeLabel = new JLabel("Zip Code");
		zCodeLabel.setBounds(10, 250, 80, 25);
		contentPane.add(zCodeLabel);

		JLabel eMailLabel = new JLabel("E Mail");
		eMailLabel.setBounds(10, 280, 80, 25);
		contentPane.add(eMailLabel);

		JLabel groupLabel = new JLabel("Group");
		groupLabel.setBounds(10, 310, 80, 25);
		contentPane.add(groupLabel);

		JLabel idText = new JLabel(idf);
		idText.setBounds(100, 10, 160, 25);
		contentPane.add(idText);

		String fn = row.getFirstName();
		JTextField fNameText = new JTextField(fn);
		fNameText.setBounds(100, 40, 160, 25);
		contentPane.add(fNameText);

		String ln = row.getLastName();
		JTextField lNameText = new JTextField(ln);
		lNameText.setBounds(100, 70, 160, 25);
		contentPane.add(lNameText);

		String nn = row.getNickName();
		JTextField nNameText = new JTextField(nn);
		nNameText.setBounds(100, 100, 160, 25);
		contentPane.add(nNameText);

		String cn = row.getCellNumber();
		JTextField cNumText = new JTextField(cn);
		cNumText.setBounds(100, 130, 160, 25);
		contentPane.add(cNumText);

		String wn = row.getWorkNumber();
		JTextField wNumText = new JTextField(wn);
		wNumText.setBounds(100, 160, 160, 25);
		contentPane.add(wNumText);

		String sa = row.getStreetAddress();
		JTextField sAddrText = new JTextField(sa);
		sAddrText.setBounds(100, 190, 160, 25);
		contentPane.add(sAddrText);

		String ct = row.getCity();
		JTextField cityText = new JTextField(ct);
		cityText.setBounds(100, 220, 160, 25);
		contentPane.add(cityText);

		String zc = row.getZipCode();
		JTextField zCodeText = new JTextField(zc);
		zCodeText.setBounds(100, 250, 160, 25);
		contentPane.add(zCodeText);

		String em = row.getEmailAddress();
		JTextField eMailText = new JTextField(em);
		eMailText.setBounds(100, 280, 160, 25);
		contentPane.add(eMailText);

		String gr = row.getGroupName();
		JTextField groupText = new JTextField(gr);
		groupText.setBounds(100, 310, 160, 25);
		contentPane.add(groupText);

		JButton goBack = new JButton("Back");
		goBack.setBounds(10, 340, 80, 25);
		contentPane.add(goBack);

		goBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame ContactTable;
				dispose();
				try {
					ContactTable = new ContactTable(u);
					ContactTable.setVisible(true);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		JButton save = new JButton("Save");
		save.setBounds(100, 340, 80, 25);
		contentPane.add(save);

		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Save save = new Save();
				List<ContactInfo> contactList = new ArrayList<ContactInfo>();
				File file = new File("C:\\addressbook\\" + u + "File.dat");
				int size = Integer.parseInt(id);
				FileInputStream fin;
				try {
					fin = new FileInputStream(file);
					ObjectInputStream ois;
					ois = new ObjectInputStream(fin);
					contactList = (ArrayList<ContactInfo>) ois.readObject();

					ContactInfo row1 = new ContactInfo(size + 1, fNameText.getText(), lNameText.getText(),
							nNameText.getText(), cNumText.getText(), wNumText.getText(), sAddrText.getText(),
							cityText.getText(), zCodeText.getText(), eMailText.getText(), groupText.getText());
					// contactList.remove(size);
					contactList.add(size, row1);
				} catch (IOException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				// ContactInfo row1 = new ContactInfo(size,fn, ln, nn, cn, wn,
				// sa, ct, zc, em, gr);
				// contactList.add(size - 1, row1);
				try {
					save.save(file, contactList);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				JFrame ContactTable;
				dispose();
				try {
					ContactTable = new ContactTable(u);
					ContactTable.setVisible(true);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		JButton remove = new JButton("Remove");
		remove.setBounds(190, 340, 80, 25);
		contentPane.add(remove);

		remove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Save save = new Save();
				List<ContactInfo> contactList = new ArrayList<ContactInfo>();
				File file = new File("C:\\addressbook\\" + u + "File.dat");
				int size = Integer.parseInt(id);
				FileInputStream fin;
				try {
					fin = new FileInputStream(file);
					ObjectInputStream ois;
					ois = new ObjectInputStream(fin);
					contactList = (ArrayList<ContactInfo>) ois.readObject();

					int size1 = contactList.size();
					ContactInfo row = contactList.get(size1 - 1);
					ContactInfo row1 = new ContactInfo(size + 1, row.getFirstName(), row.getLastName(),
							row.getNickName(), row.getCellNumber(), row.getWorkNumber(), row.getStreetAddress(),
							row.getCity(), row.getZipCode(), row.getEmailAddress(), row.getGroupName());
					contactList.remove(size);

					contactList.add(size, row1);
					contactList.remove(size1 - 1);
				} catch (IOException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					save.save(file, contactList);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				JFrame ContactTable;
				dispose();
				try {
					ContactTable = new ContactTable(u);
					ContactTable.setVisible(true);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

	}

}

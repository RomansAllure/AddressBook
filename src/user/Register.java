package user;

import java.awt.EventQueue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import book.ContactInfo;
import main.Main;
import save.Save;

public class Register extends JFrame {

	private JPanel contentPane;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
	}

	public Register() {
		setSize(300, 180);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);

		JLabel userLabel = new JLabel("User Name");
		userLabel.setBounds(10, 10, 80, 25);
		contentPane.add(userLabel);

		JTextField userText = new JTextField(20);
		userText.setBounds(100, 10, 160, 25);
		contentPane.add(userText);

		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10, 40, 80, 25);
		contentPane.add(passwordLabel);

		JPasswordField passwordText = new JPasswordField(20);
		passwordText.setBounds(100, 40, 160, 25);
		contentPane.add(passwordText);

		JLabel passwordConfirmLabel = new JLabel("Password");
		passwordConfirmLabel.setBounds(10, 70, 80, 25);
		contentPane.add(passwordConfirmLabel);

		JPasswordField passwordConfirmText = new JPasswordField(20);
		passwordConfirmText.setBounds(100, 70, 160, 25);
		contentPane.add(passwordConfirmText);

		JButton registerButton = new JButton("register");
		registerButton.setBounds(100, 110, 80, 25);
		contentPane.add(registerButton);

		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String un = userText.getText();
				char[] cpw = passwordText.getPassword();
				String pw = String.valueOf(cpw);
				char[] cpwc = passwordConfirmText.getPassword();
				String pwc = String.valueOf(cpwc);
				if (pw.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Password is blank!", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					if (pwc.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Password Confirmation is blank!", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else {
						if (un.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Username is blank!", "Error",
									JOptionPane.ERROR_MESSAGE);
						} else {
							if (new String(pw).equals(pwc)) {
								File files = new File("C:\\addressbook");
								files.mkdir();
								Path path = Paths.get("C:\\addressbook\\" + un + "File.txt");
								final String u = un;
								final String p = pw;
								if (Files.exists(path)) {
									JOptionPane.showMessageDialog(null, "Username Taken!", "Error",
											JOptionPane.ERROR_MESSAGE);
								} else {
									try {
										UserInfo user = new UserInfo();
										user.setUsername(u);
										user.setPassword(p);
										File file = new File("C:\\addressbook\\" + u + "File.txt");
										File file2 = new File("C:\\addressbook\\" + u + "File.dat");
										file2.createNewFile();
										OutputStream fileOutputStream = new FileOutputStream(file);
										ObjectOutput outputStream = new ObjectOutputStream(fileOutputStream);
										outputStream.writeObject(user);
										ContactInfo row1 = new ContactInfo(1, "Angel", "Roman", "Monster",
												"407-832-2930", "407-938-3029", "13238 James Town", "Orlando", "32837",
												"Monster@gmail.com", "Family");
										ContactInfo row2 = new ContactInfo(2, "Tom", "Brown", "Fat Boy", "407-832-2954",
												"407-938-9999", "13238 James Town", "Orlando", "32837",
												"brown@gmail.com", "Family");
										ContactInfo row3 = new ContactInfo(3, "Bob", "Ruth", "Bunz", "407-822-8493",
												"407-938-3099", "13238 James Town", "Orlando", "32837", " ", "Family");
										ContactInfo row4 = new ContactInfo(4, "Kim", "Possible", " ", "407-832-8473",
												"407-938-9929", "74832 Water Ford", "Orlando", "32888",
												"sunShiny99@gmail.com", "Friend");
										ContactInfo row5 = new ContactInfo(5, "Tim", "Timmy", "T", "407-832-8493",
												"407-938-8888", "84938 Water Ford", "Orlando", "32888", " ", "Friend");
										ContactInfo row6 = new ContactInfo(6, "Jim", "Kimmy", "J - Dawg",
												"407-832-1232", "407-938-4073", "99993 kim Cape", "Orlando", "32555",
												"LLCOOLJ@gmail.com", "Boss");
										ContactInfo row7 = new ContactInfo(7, "Sonny", "Dave", " ", "407-832-3214",
												"407-938-3222", "99993 kim Cape", "Orlando", "3444",
												"TheJuan@gmail.com", "Co-Worker");
										ContactInfo row8 = new ContactInfo(8, "Ali", "Luke", " ", "407-832-9999",
												"407-938-3111", "99993 kim Cape", "Orlando", "3444",
												"Gmail.Support@gmail.com", "Family");
										ContactInfo row9 = new ContactInfo(9, "Jason", "Todd", " ", "407-832-2933",
												"407-938-3349", "74837 Dark Side", "Orlando", "31234",
												"Batman@gmail.com", "Friend");
										ContactInfo row10 = new ContactInfo(10, "Eric", "Rider", "Jason",
												"407-832-3330", "407-938-8477", "94837 Sonny Side", "Orlando", "32234",
												"UglyDuck@gmail.com", "Friend");

										List<ContactInfo> contactList = new ArrayList<ContactInfo>();
										contactList.add(row1);
										contactList.add(row2);
										contactList.add(row3);
										contactList.add(row4);
										contactList.add(row5);
										contactList.add(row6);
										contactList.add(row7);
										contactList.add(row8);
										contactList.add(row9);
										contactList.add(row10);

										Save save = new Save();

										try {
											save.save(file2, contactList);
										} catch (FileNotFoundException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										JOptionPane.showMessageDialog(null,
												"Account Name:  " + u + " Has Been Created.", "Welcome!!",
												JOptionPane.PLAIN_MESSAGE);
										dispose();
										JFrame main = new Main();
										main.setVisible(true);
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}

							} else {
								JOptionPane.showMessageDialog(null, "Passwords do not match!", "Error",
										JOptionPane.ERROR_MESSAGE);
							}
						}
					}
				}
			}
		});
	}

}

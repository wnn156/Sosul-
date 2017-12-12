package client.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import ProblemDomain.User;
import client.ChatClient;
import common.Message;
import java.awt.event.ActionListener;
import javax.swing.JScrollBar;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JLabel;

public class RegisterFrame extends JFrame {
	User user = new User();

	private JPanel contentPane;
	private JTextField txtJoin;
	private JTextField txtId;
	private JTextField tID;
	private JTextField txtPw;
	private JTextField tPW;
	private JTextField txtRpw;
	private JTextField tPhone;
	private JTextField txtNick;
	private JTextField tAddress;
	private JTextField txtName;
	private JTextField tBirth_year;
	private JTextField txtHp;
	private JTextField tName;
	private JTextField txtEmail;
	private JTextField tEmail;
	private JTextField txtSex;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField tBirth_month;
	private JTextField tBirth_day;
	private JTextField txtIntroduction;
	private JTextPane tIntroduction;
	private int gender = -1;//0:man, 1:woman
	
	public RegisterFrame(final ChatClient client) {

		// frame ¼³Á¤
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 306, 622);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(0, 0, 289, 590);
		contentPane.add(panel);
		panel.setLayout(null);

		// È¸¿ø°¡ÀÔ textfield
		txtJoin = new JTextField();
		txtJoin.setForeground(new Color(0, 0, 0));
		txtJoin.setEnabled(false);
		txtJoin.setEditable(false);
		txtJoin.setFont(new Font("±¼¸²Ã¼", Font.BOLD, 18));
		txtJoin.setText("  Join");
		txtJoin.setBounds(111, 21, 82, 31);
		panel.add(txtJoin);
		txtJoin.setColumns(10);

		// ID
		txtId = new JTextField();
		txtId.setFont(new Font("±¼¸²", Font.PLAIN, 11));
		txtId.setEnabled(false);
		txtId.setEditable(false);
		txtId.setText("ID :");
		txtId.setBounds(51, 70, 33, 21);
		panel.add(txtId);
		txtId.setColumns(10);

		tID = new JTextField();
		tID.setFont(new Font("±¼¸²", Font.PLAIN, 11));
		tID.setBounds(123, 70, 116, 21);
		panel.add(tID);
		tID.setColumns(10);

		// PW
		txtPw = new JTextField();
		txtPw.setFont(new Font("±¼¸²", Font.PLAIN, 11));
		txtPw.setText("PW :");
		txtPw.setEnabled(false);
		txtPw.setEditable(false);
		txtPw.setColumns(10);
		txtPw.setBounds(51, 110, 33, 21);
		panel.add(txtPw);

		tPW = new JTextField();
		tPW.setFont(new Font("±¼¸²", Font.PLAIN, 11));
		tPW.setColumns(10);
		tPW.setBounds(123, 110, 116, 21);
		panel.add(tPW);

		// Phone
		txtRpw = new JTextField();
		txtRpw.setFont(new Font("±¼¸²", Font.PLAIN, 11));
		txtRpw.setText("Phone :");
		txtRpw.setEnabled(false);
		txtRpw.setEditable(false);
		txtRpw.setColumns(10);
		txtRpw.setBounds(51, 150, 51, 21);
		panel.add(txtRpw);

		tPhone = new JTextField();
		tPhone.setFont(new Font("±¼¸²", Font.PLAIN, 11));
		tPhone.setColumns(10);
		tPhone.setBounds(123, 150, 116, 21);
		panel.add(tPhone);

		// Address
		txtNick = new JTextField();
		txtNick.setFont(new Font("±¼¸²", Font.PLAIN, 11));
		txtNick.setText("Address :");
		txtNick.setEnabled(false);
		txtNick.setEditable(false);
		txtNick.setColumns(10);
		txtNick.setBounds(51, 190, 64, 21);
		panel.add(txtNick);

		tAddress = new JTextField();
		tAddress.setFont(new Font("±¼¸²", Font.PLAIN, 11));
		tAddress.setColumns(10);
		tAddress.setBounds(123, 190, 116, 21);
		panel.add(tAddress);

		// Birth
		txtName = new JTextField();
		txtName.setFont(new Font("±¼¸²", Font.PLAIN, 11));
		txtName.setText("Birth :");
		txtName.setEnabled(false);
		txtName.setEditable(false);
		txtName.setColumns(10);
		txtName.setBounds(51, 230, 39, 21);
		panel.add(txtName);

		tBirth_year = new JTextField();
		tBirth_year.setFont(new Font("±¼¸²", Font.PLAIN, 11));
		tBirth_year.setColumns(10);
		tBirth_year.setBounds(123, 230, 46, 21);
		panel.add(tBirth_year);

		tBirth_month = new JTextField();
		tBirth_month.setFont(new Font("±¼¸²", Font.PLAIN, 11));
		tBirth_month.setColumns(10);
		tBirth_month.setBounds(173, 230, 31, 21);
		panel.add(tBirth_month);

		tBirth_day = new JTextField();
		tBirth_day.setFont(new Font("±¼¸²", Font.PLAIN, 11));
		tBirth_day.setColumns(10);
		tBirth_day.setBounds(211, 230, 30, 21);
		panel.add(tBirth_day);

		// Name
		txtHp = new JTextField();
		txtHp.setFont(new Font("±¼¸²", Font.PLAIN, 11));
		txtHp.setText("Name :");
		txtHp.setEnabled(false);
		txtHp.setEditable(false);
		txtHp.setColumns(10);
		txtHp.setBounds(51, 270, 51, 21);
		panel.add(txtHp);

		tName = new JTextField();
		tName.setFont(new Font("±¼¸²", Font.PLAIN, 11));
		tName.setColumns(10);
		tName.setBounds(123, 270, 116, 21);
		panel.add(tName);

		// Email
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("±¼¸²", Font.PLAIN, 11));
		txtEmail.setText("Email :");
		txtEmail.setEnabled(false);
		txtEmail.setEditable(false);
		txtEmail.setColumns(10);
		txtEmail.setBounds(51, 310, 51, 21);
		panel.add(txtEmail);

		tEmail = new JTextField();
		tEmail.setFont(new Font("±¼¸²", Font.PLAIN, 11));
		tEmail.setColumns(10);
		tEmail.setBounds(123, 310, 116, 21);
		panel.add(tEmail);

		// gender
		txtSex = new JTextField();
		txtSex.setFont(new Font("±¼¸²", Font.PLAIN, 11));
		txtSex.setText("Gender :");
		txtSex.setEnabled(false);
		txtSex.setEditable(false);
		txtSex.setColumns(10);
		txtSex.setBounds(51, 350, 57, 21);
		panel.add(txtSex);

		JRadioButton rMan = new JRadioButton("man");
		rMan.setFont(new Font("±¼¸²", Font.PLAIN, 11));
		buttonGroup.add(rMan);
		rMan.setBounds(118, 350, 51, 23);
		panel.add(rMan);

		JRadioButton rWoman = new JRadioButton("woman");
		rWoman.setFont(new Font("±¼¸²", Font.PLAIN, 11));
		buttonGroup.add(rWoman);
		rWoman.setBounds(173, 349, 73, 23);
		panel.add(rWoman);
		
		if(rMan.isSelected())
			gender = 0;
		else if(rWoman.isSelected())
			gender = 1;
		
		// intorduction
		txtIntroduction = new JTextField();
		txtIntroduction.setFont(new Font("±¼¸²", Font.PLAIN, 11));
		txtIntroduction.setText("Introduction :");
		txtIntroduction.setEnabled(false);
		txtIntroduction.setEditable(false);
		txtIntroduction.setColumns(10);
		txtIntroduction.setBounds(51, 390, 82, 21);
		panel.add(txtIntroduction);

		tIntroduction = new JTextPane();
		tIntroduction.setFont(new Font("±¼¸²", Font.PLAIN, 11));
		tIntroduction.setBounds(51, 421, 190, 102);
		panel.add(tIntroduction);

		//Register button
		JButton btnJoin = new JButton("Register");
		btnJoin.setFont(new Font("±¼¸²", Font.PLAIN, 11));
		btnJoin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String actionCommand = e.getActionCommand();
				if (actionCommand.equals("Register")) {
					User user = new User(tID.getText(),tPW.getText(),tPhone.getText(),tAddress.getText(), Integer.parseInt(tBirth_year.getText()),Integer.parseInt(tBirth_month.getText()),Integer.parseInt(tBirth_day.getText()),tName.getText(),tEmail.getText(),gender,tIntroduction.getText());
					JOptionPane.showMessageDialog(null, "È¸¿ø°¡ÀÔ ¿Ï·á.");
					
					System.out.println(user);
					try {
						client.sendToServer(new Message(user, 'a'));
						client.receiveFromServer();
						
						//userfile¿¡ user ÀúÀå
						
					} catch (IOException | ClassNotFoundException err) {
						// TODO Auto-generated catch block
						err.printStackTrace();
					}
					setVisible(false);
				}
			}
		});
		btnJoin.setBounds(51, 544, 82, 23);
		panel.add(btnJoin);

		//cancel button
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("±¼¸²", Font.PLAIN, 11));
		btnCancel.setBounds(166, 544, 73, 23);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {	
				setVisible(false);
			}			
		});
		panel.add(btnCancel);
		
		setVisible(true);
	}
}
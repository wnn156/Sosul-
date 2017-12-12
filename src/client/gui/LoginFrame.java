package client.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.plaf.FontUIResource;

import ProblemDomain.User;
import client.ChatClient;

import common.Message;
import common.gui.AbstractFrame;

/**
 * 
 * @author Wooyong Choi
 * �α����� �ϱ� ���� ������ 
 * 
 */
public class LoginFrame extends AbstractFrame {

	
	private ChatClient client;
	
	private JTextField tfID;
	private JPasswordField tfPW;
	
	public LoginFrame(ChatClient chatClient) {
		// Size �Ѱ� �� (Width, Height)
		super(450, 270);

		this.client = chatClient;	
		
		// ��ü Client UI�� ��Ʈ�� Times �Ϲ�, ũ��� 20���� ����
        setUIFont(new FontUIResource(new Font("Times", Font.PLAIN, 20)));
		
		// �ܼ� Text ǥ���ϴ� ��ü(JLabel) ��
		JLabel lblID = new JLabel("ID");
		lblID.setBounds(116, 55, 62, 18);
		contentPane.add(lblID);
		
		JLabel lblPW = new JLabel("PW");
		lblPW.setBounds(116, 95, 62, 18);
		contentPane.add(lblPW);

		
		// Text �Է¹��� �� �ִ� ��ü(JTextField) ��
		tfID = new JTextField();
		tfID.setBounds(165, 49, 136, 30);
		contentPane.add(tfID);
		tfID.setColumns(10);
		
		tfPW = new JPasswordField();
		tfPW.setBounds(165, 89, 136, 30);
		contentPane.add(tfPW);
		tfPW.setColumns(10);
		
		
		// �α��� �� ȸ���� ��ư(JButton) ǥ��
		JButton btnSignin = new JButton("Sign in");
		btnSignin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// �α��� ��ư�� ������ �� ����
				// TextField���� �Էµ� ID�� PW�� �����ͼ� ���� ��ü ��
				String inputID = tfID.getText();
				String inputPW = tfPW.getText();
				User user = new User(inputID, inputPW);
				
				// ������ ������ Check
				Message msg = null;
				try {
					client.sendToServer(new Message(user, 'c'));
					msg = client.receiveFromServer();
				} catch (IOException | ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				switch(msg.getMode()) {
				case 's': // Success
			        // ���� ��Ƽ� MainFrame �ѱ�
					new MainFrame(user);
					
					// LoginFrame ����
					dispose();
					break;
					
				case 'f': // Fail
					JOptionPane.showMessageDialog(LoginFrame.this, "Invalid ID or PW", "Error", JOptionPane.ERROR_MESSAGE);
					break;
				}
				
			}
		});
		btnSignin.setBounds(82, 157, 105, 35);
		contentPane.add(btnSignin);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// ȸ���� ��ư�� ������ �� ����
				// ID�� PW�� �Է¹��� Dialog�� ���
				String newID = JOptionPane.showInputDialog("Please input your ID.");
				String newPW = JOptionPane.showInputDialog("Please input your Password");
				User user = new User(newID, newPW);

				// ������ ȸ������ ���� Append
				try {
					client.sendToServer(new Message(user, 'a'));
					client.receiveFromServer();
				} catch (IOException | ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnRegister.setBounds(212, 157, 130, 35);
		contentPane.add(btnRegister);

		
		// ���̰� ����
		setVisible(true);
	}
	
}

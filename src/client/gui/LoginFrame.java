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
import javax.swing.JPanel;

/**
 * 
 * @author Wooyong Choi
 * 占싸깍옙占쏙옙占쏙옙 占싹깍옙 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 
 * 
 */
public class LoginFrame extends AbstractFrame {

	
	private ChatClient client;
	
	private JTextField tfID;
	private JPasswordField tfPW;
	
	public LoginFrame(ChatClient chatClient) {
		// Size 占싼곤옙 占쏙옙 (Width, Height)
		super(450, 270);

		this.client = chatClient;	
		
		// 占쏙옙체 Client UI占쏙옙 占쏙옙트占쏙옙 Times 占싹뱄옙, 크占쏙옙占� 20占쏙옙占쏙옙 占쏙옙占쏙옙
        setUIFont(new FontUIResource(new Font("Times", Font.PLAIN, 20)));
		
		// 占쌤쇽옙 Text 표占쏙옙占싹댐옙 占쏙옙체(JLabel) 占쏙옙
		JLabel lblID = new JLabel("ID");
		lblID.setBounds(116, 55, 62, 18);
		contentPane.add(lblID);
		
		JLabel lblPW = new JLabel("PW");
		lblPW.setBounds(116, 95, 62, 18);
		contentPane.add(lblPW);

		
		// Text 占쌉력뱄옙占쏙옙 占쏙옙 占쌍댐옙 占쏙옙체(JTextField) 占쏙옙
		tfID = new JTextField();
		tfID.setBounds(165, 49, 136, 30);
		contentPane.add(tfID);
		tfID.setColumns(10);
		
		tfPW = new JPasswordField();
		tfPW.setBounds(165, 89, 136, 30);
		contentPane.add(tfPW);
		tfPW.setColumns(10);
		
		
		// 占싸깍옙占쏙옙 占쏙옙 회占쏙옙占쏙옙 占쏙옙튼(JButton) 표占쏙옙
		JButton btnSignin = new JButton("Sign in");
		btnSignin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// 占싸깍옙占쏙옙 占쏙옙튼占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙 占쏙옙占쏙옙
				// TextField占쏙옙占쏙옙 占쌉력듸옙 ID占쏙옙 PW占쏙옙 占쏙옙占쏙옙占싶쇽옙 占쏙옙占쏙옙 占쏙옙체 占쏙옙
				String inputID = tfID.getText();
				String inputPW = tfPW.getText();
				User user = new User(inputID, inputPW);
				
				// 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 Check
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
			        // 占쏙옙占쏙옙 占쏙옙티占� MainFrame 占싼깍옙
					new MainFrame(user);
					
					// LoginFrame 占쏙옙占쏙옙
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
				
				new RegisterFrame(client);
				
			}			
		});
		btnRegister.setBounds(212, 157, 130, 35);
		contentPane.add(btnRegister);

		
		// 占쏙옙占싱곤옙 占쏙옙占쏙옙
		setVisible(true);
	}
}

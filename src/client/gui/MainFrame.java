package client.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

import ProblemDomain.User;
import client.gui.tab.InfoTabPanel;
import client.gui.tab.SearchTabPanel;

import common.gui.AbstractFrame;

/**
 * 
 * @author Wooyong Choi
 * ���� ����� ������ ������ 
 * 
 */
public class MainFrame extends AbstractFrame {

	private User user;
	
	private InfoTabPanel infoTab;
	private SearchTabPanel searchTab;
	
	public MainFrame(User user) {
		// Size �Ѱ� �� (Width, Height)
		super(900, 800);
		
		// �Ѿ�� ���� ���� �޾Ƶ�
		this.user = user;
		
		
		JLabel lblTitle = new JLabel("My Program");
		lblTitle.setBounds(20, 20, 340, 70);
		contentPane.add(lblTitle);
		lblTitle.setFont(new Font("���� ���", Font.BOLD, 50));
		
		
		// ���� ���� ǥ��
		JLabel lblUserInfo = new JLabel("User : " + user.getId());
		lblUserInfo.setBounds(738, 50, 176, 18);
		contentPane.add(lblUserInfo);
		
		
		// TabPanel ���ؼ� Tab �߰�
		infoTab = new InfoTabPanel(user);
		searchTab = new SearchTabPanel(user);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(7, 125, 880, 640);
		tabbedPane.add("My Infomation", infoTab);  // �� ���� �� �߰�
		tabbedPane.add("Search", searchTab);  // �˻� �� �߰�
		contentPane.add(tabbedPane);
		
		
		// SearchTab�� Contract ��ư Ŭ�� �� InfoTab�� List�� �߰� 
		searchTab.getBtnContract().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = searchTab.getList().getSelectedIndex();
				
				String selected = (String) searchTab.getListModel().getElementAt(index);
				infoTab.getListModel().addElement(selected);
		    	
	            JOptionPane.showMessageDialog(searchTab, "Success to contract", "Infomation", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		
		// ���̰� ����
		setVisible(true);
	}
}


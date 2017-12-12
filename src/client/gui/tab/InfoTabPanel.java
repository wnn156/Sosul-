package client.gui.tab;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import ProblemDomain.User;

public class InfoTabPanel extends AbstractTabPanel {

	private DefaultListModel listModel;
	private JList list;
	
	
	public InfoTabPanel(User user) {
		super(user);
		
		// ������ ����
		setSize(new Dimension(panelWidth, panelHeight));
		

		JLabel lblTitle = new JLabel("User Info");
		lblTitle.setFont(new Font("���� ���", Font.BOLD, 30));
		lblTitle.setBounds(40, 33, 240, 30);
		add(lblTitle);
		
		
		JLabel lblId = new JLabel("ID : " + user.getId());
		lblId.setBounds(40, 102, 180, 23);
		add(lblId);
		
		
		// Scroll ������ List �����ִ� ��ü �� (ScrollPane �ȿ� JList ����
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 150, 276, 194);
		add(scrollPane);

		
		// �׽�Ʈ�� ��
		listModel = new DefaultListModel();
		listModel.addElement("������");
		
		JList list = new JList(listModel);
		scrollPane.setViewportView(list);

		
		// ���� Ŭ�� �� ���� �����ֵ��� ��
		list.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		        JList list = (JList) evt.getSource();
		        
		        // Double-click�� ���
		        if (evt.getClickCount() == 2) {
		        	// Ŭ���� Index ������
		            int index = list.locationToIndex(evt.getPoint());
		            
		            String selected = (String) listModel.getElementAt(index);
		            String msg = String.format("%s : %d����", selected, index * 100);
		            
		            JOptionPane.showMessageDialog(InfoTabPanel.this, msg, "Infomation", JOptionPane.INFORMATION_MESSAGE);
		        }
		    }
		});
	}
	
	
	public JList getList() {
		return list;
	}

	public void setList(JList list) {
		this.list = list;
	}

	public DefaultListModel getListModel() {
		return listModel;
	}

	public void setListModel(DefaultListModel listModel) {
		this.listModel = listModel;
	}
}

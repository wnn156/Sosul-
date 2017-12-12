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
import javax.swing.ListModel;

public class InfoTabPanel extends AbstractTabPanel {

	private DefaultListModel listModel;
	private JList list;
	private DefaultListModel listModel2;
	private JList list2;

	public InfoTabPanel(User user) {
		super(user);

		// myInfo
		setSize(new Dimension(panelWidth, panelHeight));

		JLabel lblTitle = new JLabel("User Info");
		lblTitle.setFont(new Font("占쏙옙占쏙옙 占쏙옙占�", Font.BOLD, 30));
		lblTitle.setBounds(76, 32, 240, 30);
		add(lblTitle);

		JLabel lblId = new JLabel("ID : " + user.getId());
		lblId.setBounds(250, 41, 180, 23);
		add(lblId);

		// HOST
		JLabel lblHost = new JLabel("HOST");
		lblHost.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblHost.setBounds(76, 89, 240, 30);
		add(lblHost);

		// postlist

		JLabel lblPostlist = new JLabel("postlist");
		lblPostlist.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblPostlist.setBounds(86, 148, 240, 30);
		add(lblPostlist);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(76, 188, 276, 194);
		add(scrollPane);

		listModel = new DefaultListModel();
		listModel.addElement("gagaga");

		JList list = new JList(listModel);
		scrollPane.setViewportView(list);

		// CLIENT
		JLabel lblClient = new JLabel("CLIENT");
		lblClient.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblClient.setBounds(518, 89, 240, 30);
		add(lblClient);

		JLabel lblWishlist = new JLabel("wishlist");
		lblWishlist.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblWishlist.setBounds(527, 149, 240, 30);
		add(lblWishlist);

		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(518, 190, 274, 192);
		add(scrollPane2);

		listModel2 = new DefaultListModel();
		listModel2.addElement("gagaga");

		JList list2 = new JList(listModel2);
		scrollPane2.setViewportView(list2);

		// 占쏙옙占쏙옙 클占쏙옙 占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙占쌍듸옙占쏙옙 占쏙옙
		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				JList list = (JList) evt.getSource();

				// Double-click handler
				if (evt.getClickCount() == 2) {
					// receive index from list
					int index = list.locationToIndex(evt.getPoint());

					String selected = (String) listModel.getElementAt(index);
					String msg = String.format("%s : %d man won", selected, index * 100);

					JOptionPane.showMessageDialog(InfoTabPanel.this, msg, "Infomation",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		list2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				JList list = (JList) evt.getSource();

				// Double-click handler
				if (evt.getClickCount() == 2) {
					// receive index from list
					int index = list.locationToIndex(evt.getPoint());

					String selected = (String) listModel.getElementAt(index);
					String msg = String.format("%s : %d man won", selected, index * 200);

					JOptionPane.showMessageDialog(InfoTabPanel.this, msg, "Infomation",
							JOptionPane.INFORMATION_MESSAGE);
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

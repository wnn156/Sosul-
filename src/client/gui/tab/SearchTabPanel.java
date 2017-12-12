package client.gui.tab;

import info.Product;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import ProblemDomain.User;

public class SearchTabPanel extends AbstractTabPanel {

	private DefaultListModel listModel;
	private JList list;

	private JButton btnContract;
	final JRadioButton rd1;
	final JRadioButton rd2;

	final List<Product> testProduct1 = new ArrayList<>();
	final List<Product> testProduct2 = new ArrayList<>();
	
	public SearchTabPanel(User user) {
		super(user);
		
		// �׽�Ʈ�� ��ǰ ��
		testProduct1.add(new Product("item1", "./figures/picture1.png", 1100000));
		testProduct1.add(new Product("item2", "./figures/picture2.png", 1400000));
		testProduct1.add(new Product("item3", "./figures/picture3.png",  900000));
		testProduct2.add(new Product("item4", "./figures/picture4.png", 2200000));
		testProduct2.add(new Product("item5", "./figures/picture5.png", 3400000));
		testProduct2.add(new Product("item6", "./figures/picture6.png", 5600000));
		
		// GUI part
		JLabel lblTitle = new JLabel("Search");
		lblTitle.setFont(new Font("���� ���", Font.BOLD, 30));
		lblTitle.setBounds(40, 33, 240, 30);
		add(lblTitle);
		
		
		JLabel lblForSale = new JLabel("Item List");
		lblForSale.setBounds(40, 116, 122, 24);
		add(lblForSale);
		
		
		// �̸��� ���� ���
		final JTextArea lblProductName = new JTextArea();
		lblProductName.setBounds(600, 222, 80, 30);
		lblProductName.setText("Name :");
		add(lblProductName);
		
		final JTextArea lblProductPrice = new JTextArea();
		lblProductPrice.setBounds(600, 262, 80, 30);
		lblProductPrice.setText("Price : ");
		add(lblProductPrice);
		
		final JTextField txtProductName = new JTextField();
		txtProductName.setBounds(700, 222, 150, 30);
		add(txtProductName);
		
		final JTextField txtProductPrice = new JTextField();
		txtProductPrice.setBounds(700, 262, 150, 30);
		add(txtProductPrice);
		
		
		// ��ǰ �̹����� Label�� Icon���� ����
		final JLabel lblProductImage = new JLabel();
		lblProductImage.setBounds(607, 275, 180, 280);
		add(lblProductImage);
		

		// Scroll ������ List �����ִ� ��ü �� (ScrollPane �ȿ� JList ����
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 150, 530, 425);
		add(scrollPane);

		
		// Listmodel �� (List�� element�� ���� ������ ����)
		listModel = new DefaultListModel();
		for (Product element : testProduct1) {
			listModel.addElement(element.getName());
		}
		
		// Listmodel�� ������ JList ���ϰ� Scroll ������ Panel�� �߰� 
		list = new JList(listModel);
		scrollPane.setViewportView(list);
		
		
		// ����Ʈ���� Ŭ�� �� ��ǰ ������ ���� ���
		list.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
		        // Ŭ���� ��� ���� ǥ��
	            int index = list.getSelectedIndex();
	            if ( index < 0 ) return ;
	            if ( rd1.isSelected() ) {
	            	if ( index >= testProduct1.size() ) return ;
	            	Product selected = testProduct1.get(index);
	            	txtProductName.setText(selected.getName());
	            	txtProductPrice.setText(selected.getPrice()+"");
		    		lblProductImage.setIcon(new ImageIcon(selected.getFigurePath()));
				} else if ( rd2.isSelected() ) {
					if ( index >= testProduct2.size() ) return ;
					Product selected = testProduct2.get(index);
	            	txtProductName.setText(selected.getName());
	            	txtProductPrice.setText(selected.getPrice()+"");
		    		lblProductImage.setIcon(new ImageIcon(selected.getFigurePath()));
				}
			}
		});
		
		
		// ����Ʈ���� ���� Ŭ�� �� ���� �����ֵ��� ��
		list.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		        JList list = (JList) evt.getSource();
		        
		        if (evt.getClickCount() != 0) {
		        }
		        // Double-click�� ���
		        if (evt.getClickCount() == 2) {
		        	// Ŭ���� Index ������
		            int index = list.locationToIndex(evt.getPoint());
		            if ( index < 0 ) return ;
		            
		            if ( rd1.isSelected() ) {
		            	if ( index >= testProduct1.size() ) return ;
		            	Product selected = testProduct1.get(index);
			            String msg = String.format("%s : %,d��", selected.getName(), selected.getPrice());
			            JOptionPane.showMessageDialog(SearchTabPanel.this, msg, "Infomation", JOptionPane.INFORMATION_MESSAGE);
					} else if ( rd2.isSelected() ) {
						if ( index >= testProduct2.size() ) return ;
						Product selected = testProduct2.get(index);
			            String msg = String.format("%s : %,d��", selected.getName(), selected.getPrice());
			            JOptionPane.showMessageDialog(SearchTabPanel.this, msg, "Infomation", JOptionPane.INFORMATION_MESSAGE);
					}
		        }
		    }
		});
		
		// �ɼ� ���ÿ� ��� ����Ʈ ���� ����
		ButtonGroup optionGroup = new ButtonGroup();
		rd1 = new JRadioButton("option1");
		rd2 = new JRadioButton("option2");
		rd1.setBounds(40, 70, 100, 30);
		rd2.setBounds(140, 70, 100, 30);
		optionGroup.add(rd1);
		optionGroup.add(rd2);
		add(rd1);
		add(rd2);
		rd1.addItemListener(new RadioButtonSelectedEvent());
		rd2.addItemListener(new RadioButtonSelectedEvent());
		// �⺻���� ���õ� �ɼ�1
		rd1.setSelected(true);
		

		// ��� ��ư �߰�
		// ��� ��ư�� ���� Listener�� MainFrame�� ����
		// �ֳ��ϸ� SearchTab�� ��ü�� InfoTab�� ��ü�� ������ �ʿ䰡 �ֱ� ����
		btnContract = new JButton("Contract");
		btnContract.setBounds(607, 150, 181, 51);
		add(btnContract);
		
		// ���� �����͸� �߰��ϴ� ��ư
		JButton btnNewData = new JButton("Add new Data");
		btnNewData.setBounds(607, 500, 181, 45);
		add(btnNewData);
		btnNewData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// �ɼ� 1 �� �� ������ ����Ʈ
				if ( rd1.isSelected() ) {
					testProduct1.add(new Product(txtProductName.getText(), "", Integer.parseInt(txtProductPrice.getText())));
				} else if ( rd2.isSelected() ) {
					// �ɼ� 2 �� �� ������ ����Ʈ
					testProduct2.add(new Product(txtProductName.getText(), "", Integer.parseInt(txtProductPrice.getText())));
				}
				updateList();
			}
		});
		
		// ���� �����͸� �����ϴ� ��ư
		JButton btnDelData = new JButton("Del existing Data");
		btnDelData.setBounds(607, 550, 181, 45);
		add(btnDelData);
		btnDelData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = list.getSelectedIndex();
				// �ɼ� 1 �� �� 
				if ( rd1.isSelected() ) {
					testProduct1.remove(index);
				} else if ( rd2.isSelected() ) {
					// �ɼ� 2 �� �� 
					testProduct2.remove(index);
				}
				updateList();
			}
		});
	}
	
	// class ������� �̺�Ʈ�� ǥ���ϴ� ���
	class RadioButtonSelectedEvent implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent e) {
			updateList();
		}
	}
	
	private void updateList() {
		// �ɼ� 1 �� �� ������ ����Ʈ
		listModel.clear();
		if ( rd1.isSelected() ) {
			for (Product element : testProduct1) {
				listModel.addElement(element.getName());
			}
		} else if ( rd2.isSelected() ) {
			// �ɼ� 2 �� �� ������ ����Ʈ
			for (Product element : testProduct2) {
				listModel.addElement(element.getName());
			}
		}
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

	public JButton getBtnContract() {
		return btnContract;
	}


	public void setBtnContract(JButton btnContract) {
		this.btnContract = btnContract;
	}
}
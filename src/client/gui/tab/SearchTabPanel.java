package client.gui.tab;

import java.awt.Choice;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import ProblemDomain.Post;
import ProblemDomain.User;
import info.Product;

public class SearchTabPanel extends AbstractTabPanel{

	private DefaultListModel listModel;
	private JList list;

	private JButton btnContract;
	//final JRadioButton rd1;
	//final JRadioButton rd2;
	Choice choice;
	JScrollPane scrollPane;
	final ArrayList<Post> postList = new ArrayList<Post>();
	
	final List<Product> testProduct1 = new ArrayList<>();
	final List<Product> testProduct2 = new ArrayList<>();
	
	public SearchTabPanel(User user) {
		
		super(user);
		
		// from postfile
		postList.add(new Post(1,"Post1", 2));
		postList.add(new Post(2,"Post2", 6));
		postList.add(new Post(3,"Post3", 11));
		
		/*
		testProduct1.add(new Product("item1", "./figures/picture1.png", 1100000));
		testProduct1.add(new Product("item2", "./figures/picture2.png", 1400000));
		testProduct1.add(new Product("item3", "./figures/picture3.png",  900000));
		testProduct2.add(new Product("item4", "./figures/picture4.png", 2200000));
		testProduct2.add(new Product("item5", "./figures/picture5.png", 3400000));
		testProduct2.add(new Product("item6", "./figures/picture6.png", 5600000));
		*/
		
		
		// GUI part
		JLabel lblTitle = new JLabel("Search");
		lblTitle.setFont(new Font("占쏙옙占쏙옙 占쏙옙占�", Font.BOLD, 30));
		lblTitle.setBounds(40, 33, 240, 30);
		add(lblTitle);
		
		
		JLabel lblForSale = new JLabel("Item List");
		lblForSale.setBounds(40, 116, 122, 24);
		add(lblForSale);
		
		
		// 占싱몌옙占쏙옙 占쏙옙占쏙옙 占쏙옙占�
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
		
		
		// 占쏙옙품 占싱뱄옙占쏙옙占쏙옙 Label占쏙옙 Icon占쏙옙占쏙옙 占쏙옙占쏙옙
		final JLabel lblProductImage = new JLabel();
		lblProductImage.setBounds(607, 275, 180, 280);
		add(lblProductImage);
		

		// Scroll 占쏙옙占쏙옙占쏙옙 List 占쏙옙占쏙옙占쌍댐옙 占쏙옙체 占쏙옙 (ScrollPane 占싫울옙 JList 占쏙옙占쏙옙
		scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 150, 530, 425);
		add(scrollPane);

		listModel = new DefaultListModel();
		for (int i=0;i<postList.size();i++) {
			listModel.addElement(postList.get(i).getTitle());
		}
		
		// Listmodel占쏙옙 占쏙옙占쏙옙占쏙옙 JList 占쏙옙占싹곤옙 Scroll 占쏙옙占쏙옙占쏙옙 Panel占쏙옙 占쌩곤옙 
		list = new JList(listModel);
		scrollPane.setViewportView(list);
		
		
		choice = new Choice();
 		choice.setBounds(256, 69, 200, 30);
 		choice.addItem("Size of Room");
 		choice.addItem("Big");
 		choice.addItem("Middle");
 		choice.addItem("Small");
 		choice.select(0);
 		add(choice);
 		choice.setVisible(true);
 		
 		choice.addItemListener(new CheckBoxSelectedEvent());
 		
		// Listmodel 占쏙옙 (List占쏙옙 element占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙)
	
		
		// 占쏙옙占쏙옙트占쏙옙占쏙옙 클占쏙옙 占쏙옙 占쏙옙품 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙占�
		list.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
		        // 클占쏙옙占쏙옙 占쏙옙占� 占쏙옙占쏙옙 표占쏙옙
	            int index = list.getSelectedIndex();
	            if ( index < 0 ) return ;
	           
/*
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
			*/}
			
		});
		
		/*
		// 占쏙옙占쏙옙트占쏙옙占쏙옙 占쏙옙占쏙옙 클占쏙옙 占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙占쌍듸옙占쏙옙 占쏙옙
		list.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		        JList list = (JList) evt.getSource();
		        
		        if (evt.getClickCount() != 0) {
		        }
		        // Double-click占쏙옙 占쏙옙占�
		        if (evt.getClickCount() == 2) {
		        	// 클占쏙옙占쏙옙 Index 占쏙옙占쏙옙占쏙옙
		            int index = list.locationToIndex(evt.getPoint());
		            if ( index < 0 ) return ;
		            
		            if ( rd1.isSelected() ) {
		            	if ( index >= testProduct1.size() ) return ;
		            	Product selected = testProduct1.get(index);
			            String msg = String.format("%s : %,d占쏙옙", selected.getName(), selected.getPrice());
			            JOptionPane.showMessageDialog(SearchTabPanel.this, msg, "Infomation", JOptionPane.INFORMATION_MESSAGE);
					} else if ( rd2.isSelected() ) {
						if ( index >= testProduct2.size() ) return ;
						Product selected = testProduct2.get(index);
			            String msg = String.format("%s : %,d占쏙옙", selected.getName(), selected.getPrice());
			            JOptionPane.showMessageDialog(SearchTabPanel.this, msg, "Infomation", JOptionPane.INFORMATION_MESSAGE);
					}
		        }
		    }
		});
		*/
		// 占심쇽옙 占쏙옙占시울옙 占쏙옙占� 占쏙옙占쏙옙트 占쏙옙占쏙옙 占쏙옙占쏙옙
		ButtonGroup optionGroup = new ButtonGroup();
		/*
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
		// 占썩본占쏙옙占쏙옙 占쏙옙占시듸옙 占심쇽옙1
		rd1.setSelected(true);
		
*/
		
		
		
		
		// 占쏙옙占� 占쏙옙튼 占쌩곤옙
		// 占쏙옙占� 占쏙옙튼占쏙옙 占쏙옙占쏙옙 Listener占쏙옙 MainFrame占쏙옙 占쏙옙占쏙옙
		// 占쌍놂옙占싹몌옙 SearchTab占쏙옙 占쏙옙체占쏙옙 InfoTab占쏙옙 占쏙옙체占쏙옙 占쏙옙占쏙옙占쏙옙 占십요가 占쌍깍옙 占쏙옙占쏙옙
		btnContract = new JButton("Contract");
		btnContract.setBounds(607, 150, 181, 51);
		add(btnContract);
		
		// 占쏙옙占쏙옙 占쏙옙占쏙옙占싶몌옙 占쌩곤옙占싹댐옙 占쏙옙튼
		JButton btnNewData = new JButton("Add new Data");
		btnNewData.setBounds(607, 500, 181, 45);
		add(btnNewData);
		
		/*
		btnNewData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// 占심쇽옙 1 占쏙옙 占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙트
				if ( rd1.isSelected() ) {
					testProduct1.add(new Product(txtProductName.getText(), "", Integer.parseInt(txtProductPrice.getText())));
				} else if ( rd2.isSelected() ) {
					// 占심쇽옙 2 占쏙옙 占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙트
					testProduct2.add(new Product(txtProductName.getText(), "", Integer.parseInt(txtProductPrice.getText())));
				}
				updateList();
			}
		});
		*/
		
		// 占쏙옙占쏙옙 占쏙옙占쏙옙占싶몌옙 占쏙옙占쏙옙占싹댐옙 占쏙옙튼
		JButton btnDelData = new JButton("Del existing Data");
		btnDelData.setBounds(607, 550, 181, 45);
		add(btnDelData);
		
		
		/*
		btnDelData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = list.getSelectedIndex();
				// 占심쇽옙 1 占쏙옙 占쏙옙 
				if ( rd1.isSelected() ) {
					testProduct1.remove(index);
				} else if ( rd2.isSelected() ) {
					// 占심쇽옙 2 占쏙옙 占쏙옙 
					testProduct2.remove(index);
				}
				updateList();
			}
		});
		*/
		
		
	}
	
	
	/*
	// class 占쏙옙占쏙옙占쏙옙占� 占싱븝옙트占쏙옙 표占쏙옙占싹댐옙 占쏙옙占�
	class RadioButtonSelectedEvent implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent e) {
			updateList();
		}
	}
	
	private void updateList() {
		// 占심쇽옙 1 占쏙옙 占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙트
		listModel.clear();
		if ( rd1.isSelected() ) {
			for (Product element : testProduct1) {
				listModel.addElement(element.getName());
			}
		} else if ( rd2.isSelected() ) {
			// 占심쇽옙 2 占쏙옙 占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙트
			for (Product element : testProduct2) {
				listModel.addElement(element.getName());
			}
		}
	}
	*/
	class CheckBoxSelectedEvent implements ItemListener{
		public void itemStateChanged(ItemEvent e){
			updateList();
		}
	}
	private void updateList(){
		listModel.clear();
		System.out.println(choice.getSelectedItem());
		if(choice.getSelectedItem().equals("Big")){
 			listModel = new DefaultListModel();
 			for(int i=0;i<postList.size();i++){
 				System.out.println(i);
 				System.out.println(postList.get(i));
 				System.out.println(postList.get(i).getRoom());
 				if(postList.get(i).getRoom().getSize()>10.0){
 					listModel.addElement(postList.get(i).getTitle());
 				}
 			}
 		}
 		else if(choice.getSelectedItem().equals("Middle")){
 			listModel = new DefaultListModel();
 			for(int i=0;i<postList.size();i++){
 				System.out.println(i);
 				System.out.println(postList.get(i));
 				if(postList.get(i).getRoom().getSize()<=10.0 && postList.get(i).getRoom().getSize()>=5.0){
 					listModel.addElement(postList.get(i).getTitle());
 				}
 			}
 		}
 		else if(choice.getSelectedItem().equals("Small")){
 			listModel = new DefaultListModel();
 			for(int i=0;i<postList.size();i++){
 				System.out.println(i);
 				System.out.println(postList.get(i));
 				if(postList.get(i).getRoom().getSize()<5.0){
 					listModel.addElement(postList.get(i).getTitle());
 				}
 			}
 		}
 		else{
 			listModel = new DefaultListModel();
 			for(int i=0;i<postList.size();i++){
 				listModel.addElement(postList.get(i).getTitle());
 			}
 		}
		list = new JList(listModel);
		scrollPane.setViewportView(list);
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
package client.gui.tab;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import ProblemDomain.User;

/**
 * 
 * @author Wooyong Choi
 * �� �гε��� ���� ���� ����
 * 
 */
public abstract class AbstractTabPanel extends JPanel {
	
	protected static int panelWidth = 887;
	protected static int panelHeight = 608;

	protected User user;
	
	
	public AbstractTabPanel(User user) {

		this.user = user;
		
		// ������ ����
		setSize(new Dimension(panelWidth, panelHeight));
		
		// Panel�� ���� ������� ����
		setBackground(new Color(0xEBF7FF));
		
		// Panel�� Absolute layout���� ���� (��ǥ�� ��ü ��ġ ����)
		setLayout(null);		
	}
	
}

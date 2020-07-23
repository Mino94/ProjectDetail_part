package com.kitri.projectDetail.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import com.kitir.payment.model.PaymentDAO;
import com.kitir.payment.model.ProjectDTO;
import com.kitri.projectDetail.controller.ButtonActionListner;

public class ProjectMainTest extends JFrame{
	private static JPanel contentPane;
	private static JPanel Main_contentPanel;
	private JTable table;
	private JScrollPane scrollPane; // ���̺� ��ũ�ѹ� �ڵ����� �����ǰ� �ϱ�
	public String test;
	private String driver = "oracle.jdbc.driver.OracleDriver";        
	private String url = "jdbc:oracle:thin:@localhost:1521/orcl";        // @ȣ��Ʈ IP : ��Ʈ : SID
	String DB_USER = "javauser";
	String DB_PASSWORD = "12345";

	private Object[][] data = null;
	private String colNames[] = { "project image", "project name" }; // ���̺� �÷� ����

	Connection conn = null;
	// ResultSet : ������ �������� ���� �޴� ��ü
	ResultSet rst = null;
	Statement stmt = null; // �׳� �������°�
	// PreparedStatement�� �������� ?�� ����ؼ� �߰��� ?�� ������ �Ҵ��� �ټ� �ֵ��� �ϴ� ��ü
	PreparedStatement ps = null; // ?�־ ����ִ°�


	public JTable table1;

	private DefaultTableModel model = new DefaultTableModel(data, colNames) {
		public Class getComlumnClass(int column) {
			return getValueAt(0,column).getClass();
		}
	};
	public class JTableMouseListener implements MouseListener{    // ���콺�� ��������Ȯ���ϱ�
		public void mouseClicked(java.awt.event.MouseEvent e) {    // ���õ� ��ġ�� ���� ���

			JTable jtable = (JTable)e.getSource();
			int row = jtable.getSelectedRow();                // ���õ� ���̺��� �ప
			int col = jtable.getSelectedColumn();         // ���õ� ���̺��� ����

			System.out.println(model.getValueAt(row, col));   // ���õ� ��ġ�� ���� ���� ���

		}
		public void mouseEntered(java.awt.event.MouseEvent e) {
		}
		public void mouseExited(java.awt.event.MouseEvent e) {    
		}
		public void mousePressed(java.awt.event.MouseEvent e) {
		}
		public void mouseReleased(java.awt.event.MouseEvent e) {
		}
	}

	ProjectMainTest() {
		try {
			String user = "javauser";
			String pw = "12345";
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, pw);

		} catch (ClassNotFoundException cnfe) {
			System.out.println("DB ����̹� �ε� ���� :" + cnfe.toString());
		} catch (SQLException sqle) {
			System.out.println("DB ���ӽ��� : " + sqle.toString());
		} catch (Exception e) {
			System.out.println("Unkonwn error");
			e.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel navPanel = new JPanel();
		navPanel.setBackground(new Color(54, 33, 89));
		navPanel.setBounds(12, 23, 181, 660);
		contentPane.add(navPanel);
		navPanel.setLayout(null);

		JButton BrandColumn = new JButton("BRAND");
		BrandColumn.setForeground(Color.WHITE);
		BrandColumn.setFont(new Font("Segoe UI", Font.BOLD, 25));
		BrandColumn.setBackground(new Color(54, 33, 89));
		BrandColumn.setIcon(null);
		BrandColumn.setBounds(0, 32, 185, 76);
		BrandColumn.setFocusPainted(false);
		BrandColumn.setBorderPainted(false);
		navPanel.add(BrandColumn);

		JButton column1 = new JButton("Project Register");
		column1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		column1.setForeground(Color.WHITE);
		column1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		column1.setBackground(new Color(85, 65, 118));
		column1.setBounds(0, 158, 185, 44);
		column1.setBorderPainted(false);
		column1.setFocusPainted(false);

		navPanel.add(column1);

		JButton column2 = new JButton("Review");
		column2.setForeground(Color.WHITE);
		column2.setFont(new Font("Segoe UI", Font.BOLD, 12));
		column2.setFocusPainted(false);
		column2.setBorderPainted(false);
		column2.setBackground(new Color(85, 65, 118));
		column2.setBounds(0, 224, 185, 44);
		navPanel.add(column2);

		JButton column3 = new JButton("My page");
		column3.setForeground(Color.WHITE);
		column3.setFont(new Font("Segoe UI", Font.BOLD, 12));
		column3.setFocusPainted(false);
		column3.setBorderPainted(false);
		column3.setBackground(new Color(85, 65, 118));
		column3.setBounds(0, 292, 185, 44);
		navPanel.add(column3);

		Main_contentPanel = new JPanel();
		Main_contentPanel.setBounds(193, 23, 1073, 660);
		contentPane.add(Main_contentPanel);
		Main_contentPanel.setLayout(null);
		//         FileOutputStream fos ;
		tableView();
	}

	public void tableView() {

		JPanel headerPanel = new JPanel();
		headerPanel.setBackground(new Color(110, 89, 222));
		headerPanel.setBounds(0, 31, 1073, 79);
		Main_contentPanel.add(headerPanel);
		headerPanel.setLayout(null);

		JLabel hederText = new JLabel("Project");
		hederText.setBounds(40, 10, 193, 57);
		hederText.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		hederText.setForeground(Color.WHITE);
		headerPanel.add(hederText);

		JPanel tableicon1 = new JPanel();
		tableicon1.setBounds(36, 120, 926, 480);
		Main_contentPanel.add(tableicon1);
		tableicon1.setLayout(null);

		String GetProjectQuery1 = "SELECT S_PROJECT_IMAGE, S_PROJECT_NAME, N_PROJECT_NO FROM TB_PROJECT_INFO";  

		try(Connection conn = DriverManager.getConnection(url, DB_USER, DB_PASSWORD);
				Statement stat = conn.createStatement();
				ResultSet rs = stat.executeQuery(GetProjectQuery1);) {
			Class.forName(driver);


			Object[][] data = null;
			String[] columnNames = {"pic","des","pjno"};
			DefaultTableModel model = new DefaultTableModel(data, columnNames) {
				public Class getColumnClass(int column) {
					return getValueAt(0,column).getClass();
				}
			};

			table1 = new JTable(model);

			while (rs.next()) { // ���� ���� �����ͼ� ���̺����� �߰�
				String imgpath = rs.getString(1);
				Icon p1 = new ImageIcon("D:\\eclipse-workspace\\swingFunding\\src\\img"+imgpath);          

				model.addRow(new Object[] {p1, rs.getString(2), rs.getString(3)});
				table1.setPreferredScrollableViewportSize(table1.getPreferredSize());

			}
			JScrollPane scrollPane = new JScrollPane(table1);
			scrollPane.setBounds(51, 25, 850, 445);
			tableicon1.add(scrollPane);

			table1.addMouseListener(new JTableMouseListener() {
				public void mouseClicked(MouseEvent e) {
					int row = table1.getSelectedRow();
					String pjno = (String)table1.getModel().getValueAt(row, 2);
					ProjectDetailComponents pjd = new ProjectDetailComponents();
					System.out.println(pjno);
					try {
						stmt = conn.createStatement();
						String sql = "select S_PROJECT_NAME, L_DESCRIPTION, S_PROJECT_IMAGE,N_PROJECT_NO from TB_PROJECT_INFO where N_PROJECT_NO ="+pjno;	
						System.out.println(sql);
						rst=stmt.executeQuery(sql);
						while(rs.next()){
							String str = rst.getString("S_PROJECT_NAME");
							String str2 = rst.getString("L_DESCRIPTION");
							String str3 = rst.getString("S_PROJECT_IMAGE");

							ImagePaint panel = new ImagePaint(new ImageIcon("D:\\eclipse-workspace\\swingFunding\\src\\img\\"+str3).getImage());
							pjd.getImgPanel().add(panel);
							pjd.getTitleTextArea().append(str);
							pjd.getTextArea().append(str2);
						}

					}catch(Exception e2) {
						e2.printStackTrace();
						System.out.println("�ڷ��б� ���� : "+ e2);
					}finally {
						try {
							if (rs != null) rs.close();
							if(stmt != null) stmt.close();
							if(ps != null) ps.close();
						} catch (Exception e3) {
						}
					}
//					PaymentDAO dao = new PaymentDAO();
//					dao.readData(pjno);

					new ProjectMainUI();
					//pjno������ �ش� ������Ʈ�� ����
				}
			}); // ���̺� ���콺������ ����

		} catch (Exception e) { }


	}



	//table ���� ��� ���� �޼ҵ�
	public void tableCellCenter(JTable t){
		// ���̺� ���� ��� �����ϱ�
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer(); // ����Ʈ���̺��������� ����
		dtcr.setHorizontalAlignment(SwingConstants.CENTER); // �������� ���������� CENTER��

		TableColumnModel tcm = t.getColumnModel() ; // ������ ���̺��� �÷����� ������
		tcm.getColumn(1).setCellRenderer(dtcr);
	}



	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProjectMainTest frame = new ProjectMainTest();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);    // �߾� ��ġ
					frame.setResizable(false);          // ������ ����
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
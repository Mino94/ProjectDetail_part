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
	private JScrollPane scrollPane; // 테이블 스크롤바 자동으로 생성되게 하기
	public String test;
	private String driver = "oracle.jdbc.driver.OracleDriver";        
	private String url = "jdbc:oracle:thin:@localhost:1521/orcl";        // @호스트 IP : 포트 : SID
	String DB_USER = "javauser";
	String DB_PASSWORD = "12345";

	private Object[][] data = null;
	private String colNames[] = { "project image", "project name" }; // 테이블 컬럼 값들

	Connection conn = null;
	// ResultSet : 실행한 쿼리문의 값을 받는 객체
	ResultSet rst = null;
	Statement stmt = null; // 그냥 가져오는거
	// PreparedStatement는 쿼리문에 ?를 사용해서 추가로 ?에 변수를 할당해 줄수 있도록 하는 객체
	PreparedStatement ps = null; // ?넣어서 집어넣는거


	public JTable table1;

	private DefaultTableModel model = new DefaultTableModel(data, colNames) {
		public Class getComlumnClass(int column) {
			return getValueAt(0,column).getClass();
		}
	};
	public class JTableMouseListener implements MouseListener{    // 마우스로 눌려진값확인하기
		public void mouseClicked(java.awt.event.MouseEvent e) {    // 선택된 위치의 값을 출력

			JTable jtable = (JTable)e.getSource();
			int row = jtable.getSelectedRow();                // 선택된 테이블의 행값
			int col = jtable.getSelectedColumn();         // 선택된 테이블의 열값

			System.out.println(model.getValueAt(row, col));   // 선택된 위치의 값을 얻어내서 출력

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
			System.out.println("DB 드라이버 로딩 실패 :" + cnfe.toString());
		} catch (SQLException sqle) {
			System.out.println("DB 접속실패 : " + sqle.toString());
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

			while (rs.next()) { // 각각 값을 가져와서 테이블값들을 추가
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
						System.out.println("자료읽기 실패 : "+ e2);
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
					//pjno같으면 해당 프로젝트로 연결
				}
			}); // 테이블에 마우스리스너 연결

		} catch (Exception e) { }


	}



	//table 내용 가운데 정렬 메소드
	public void tableCellCenter(JTable t){
		// 테이블 내용 가운데 정렬하기
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer(); // 디폴트테이블셀렌더러를 생성
		dtcr.setHorizontalAlignment(SwingConstants.CENTER); // 렌더러의 가로정렬을 CENTER로

		TableColumnModel tcm = t.getColumnModel() ; // 정렬할 테이블의 컬럼모델을 가져옴
		tcm.getColumn(1).setCellRenderer(dtcr);
	}



	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProjectMainTest frame = new ProjectMainTest();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);    // 중앙 배치
					frame.setResizable(false);          // 사이즈 고정
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
package com.kitir.payment.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import com.kitir.payment.model.PaymentDAO;
import com.kitir.payment.model.PaymentDTO;
import com.kitir.payment.model.ProjectDTO;
import com.kitri.projectDetail.controller.ButtonActionListner;

import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class PaymentService extends JFrame {

	private JPanel mainPanel;
	private JTextField accountNameInput;
	private JTextField accountNumberInput;
	private JTextField donatePriceInput;
	private JTextArea fundNameOutput;
	private JTextArea fundProjectName;
	private JTextArea bankOutput;
	private JTextArea accountNumberOutput;
	private JTextArea donatePriceOutput;
	String payTool;
	PaymentDAO dao = new PaymentDAO();
	
	public PaymentService() {
		mainPanel = new JPanel();
        setContentPane(mainPanel);
        setSize(680,454);
        setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JPanel resultPanel = new JPanel();
		resultPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		resultPanel.setBounds(501, 52, 151, 353);
		resultPanel.setBackground(Color.white);
		getContentPane().add(resultPanel);
		resultPanel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(1, 1, 0, 1, (Color) new Color(0, 0, 0)));
		panel_2.setBounds(0, 0, 151, 25);
		panel_2.setBackground(new Color(85, 65, 118));
		panel_2.setForeground(Color.WHITE);
		resultPanel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel infoHeaderLabel = new JLabel("\uACB0\uC81C\uC815\uBCF4\uD655\uC778");
		infoHeaderLabel.setBounds(44, 0, 72, 25);
		panel_2.add(infoHeaderLabel);
		infoHeaderLabel.setForeground(Color.WHITE);
		infoHeaderLabel.setFont(new Font("굴림", Font.BOLD, 11));
		infoHeaderLabel.setBackground(Color.LIGHT_GRAY);
		
		JLabel resultName = new JLabel("\uD6C4\uC6D0\uC790");
		resultName.setEnabled(false);
		resultName.setBounds(12, 44, 57, 15);
		resultPanel.add(resultName);
		
		JLabel lblNewLabel_1 = new JLabel("\uD6C4\uC6D0 \uD504\uB85C\uC81D\uD2B8 \uC774\uB984");
		lblNewLabel_1.setBounds(12, 103, 115, 15);
		resultPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uC9C0\uBD88\uC608\uC815\uAE08\uC561");
		lblNewLabel_2.setBounds(12, 292, 83, 15);
		resultPanel.add(lblNewLabel_2);
		
		JLabel accountNumber_1 = new JLabel("\uACC4\uC88C\uBC88\uD638");
		accountNumber_1.setBounds(8, 227, 87, 21);
		resultPanel.add(accountNumber_1);
		
		JLabel bank_1 = new JLabel("\uC740\uD589");
		bank_1.setBounds(8, 162, 87, 21);
		resultPanel.add(bank_1);
		
		fundNameOutput = new JTextArea();
		fundNameOutput.setBounds(12, 72, 116, 21);
		fundNameOutput.setColumns(10);
		fundNameOutput.setEnabled(false);
		resultPanel.add(fundNameOutput);
		
		fundProjectName = new JTextArea();
		fundProjectName.setColumns(10);
		fundProjectName.setBounds(12, 128, 116, 21);
		fundProjectName.setEnabled(false);
		fundProjectName.setText("");
		ArrayList<ProjectDTO> arr = new ArrayList<ProjectDTO>();
		arr = dao.pjdReadData();
		fundProjectName.append(arr.get(2).getS_project_name());
		resultPanel.add(fundProjectName);
		
		bankOutput = new JTextArea();
		bankOutput.setColumns(10);
		bankOutput.setBounds(11, 196, 116, 21);
		bankOutput.setEnabled(false);
		resultPanel.add(bankOutput);
		
		accountNumberOutput = new JTextArea();
		accountNumberOutput.setColumns(10);
		accountNumberOutput.setBounds(11, 261, 116, 21);
		accountNumberOutput.setEnabled(false);
		resultPanel.add(accountNumberOutput);
		
		donatePriceOutput = new JTextArea();
		donatePriceOutput.setColumns(10);
		donatePriceOutput.setEnabled(false);
		donatePriceOutput.setBounds(12, 317, 116, 21);
		resultPanel.add(donatePriceOutput);
		
		JPanel titlePanel = new JPanel();
		titlePanel.setBorder(null);
		titlePanel.setBounds(12, 10, 640, 32);
		titlePanel.setBackground(new Color(110, 89, 222));
		getContentPane().add(titlePanel);
		titlePanel.setLayout(null);
		
		JLabel headerLabel = new JLabel("결제 정보를 입력 하세요.");
		headerLabel.setBounds(206, 0, 232, 30);
		headerLabel.setVerticalAlignment(SwingConstants.CENTER);
		headerLabel.setForeground(Color.WHITE);
		headerLabel.setFont(new Font("굴림", Font.BOLD, 15));
		headerLabel.setBackground(Color.WHITE);
		titlePanel.add(headerLabel);
		
		JPanel selectPanel = new JPanel();
		selectPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		selectPanel.setBounds(12, 52, 481, 102);
		selectPanel.setBackground(Color.white);
		getContentPane().add(selectPanel);
		selectPanel.setLayout(null);
		
		JLabel selectHeaderLabel = new JLabel("\uACB0\uC81C \uC218\uB2E8 \uC120\uD0DD");
		selectHeaderLabel.setFont(new Font("굴림", Font.BOLD, 12));
		selectHeaderLabel.setForeground(Color.WHITE);
		selectHeaderLabel.setBounds(178, 0, 130, 26);
		selectPanel.add(selectHeaderLabel);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBorder(new MatteBorder(1, 1, 0, 1, (Color) new Color(0, 0, 0)));
		panel.setBackground(new Color(85, 65, 118));
		panel.setBounds(0, 0, 481, 26);
		selectPanel.add(panel);
		
		
		JRadioButton btn1 = new JRadioButton("계좌번호");
		btn1.setBounds(79, 49, 121, 23);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(btn1.isSelected()) {
					payTool = "계좌번호";
				}
			}
		});
		JRadioButton btn2 = new JRadioButton("신용카드");
		btn2.setBounds(279, 49, 121, 23);
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(btn2.isSelected()) {
					payTool = "신용카드";
				}
			}
		});
		ButtonGroup group = new ButtonGroup();
		group.add(btn1);
		group.add(btn2);
		selectPanel.add(btn1);
		selectPanel.add(btn2);
		
		
		JPanel inputPanel = new JPanel();
		inputPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		inputPanel.setBounds(12, 160, 481, 245);
		inputPanel.setBackground(new Color(85, 65, 118));
		inputPanel.setBackground(Color.white);

		getContentPane().add(inputPanel);
		inputPanel.setLayout(null);
		
		JLabel inputHeaderLabel = new JLabel("결제정보입력(입력후 Enter누르세요)");
		inputHeaderLabel.setFont(new Font("굴림", Font.BOLD, 12));
		inputHeaderLabel.setForeground(Color.WHITE);
		inputHeaderLabel.setBounds(143, 0, 241, 26);
		inputHeaderLabel.setBackground(Color.GREEN);
		inputPanel.add(inputHeaderLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(1, 1, 0, 1, (Color) new Color(0, 0, 0)));
		panel_1.setBounds(0, 0, 481, 26);
		panel_1.setBackground(new Color(85, 65, 118));
		panel_1.setForeground(Color.WHITE);
		inputPanel.add(panel_1);
		
		JLabel accountName = new JLabel("\uC608\uAE08\uC8FC ");
		accountName.setBounds(44, 60, 87, 21);
		inputPanel.add(accountName);
		
		accountNameInput = new JTextField();
		accountNameInput.setBounds(143, 60, 296, 21);
		accountNameInput.setColumns(10);
		accountNameInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String fdName = accountNameInput.getText();
				if(fundNameOutput.getText() == fdName) {
				}else {
					fundNameOutput.append(fdName);
				}
			}
		});
		inputPanel.add(accountNameInput);
		
		accountNumberInput = new JTextField();
		accountNumberInput.setColumns(10);
		accountNumberInput.setBounds(143, 122, 296, 21);
		accountNumberInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String fdNumber = accountNumberInput.getText();
				if(accountNumberOutput.getText() == fdNumber) {
				}else {
					accountNumberOutput.append(fdNumber);
				}
			}
		});
		inputPanel.add(accountNumberInput);
		
		JLabel accountNumber = new JLabel("\uACC4\uC88C\uBC88\uD638");
		accountNumber.setBounds(44, 122, 87, 21);
		inputPanel.add(accountNumber);
		
		JLabel donatePrice = new JLabel("\uD6C4\uC6D0\uAE08\uC561 ");
		donatePrice.setBounds(44, 153, 87, 21);
		inputPanel.add(donatePrice);
		
		donatePriceInput = new JTextField();
		donatePriceInput.setColumns(10);
		donatePriceInput.setBounds(143, 153, 296, 21);
		donatePriceInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String donatePrice = donatePriceInput.getText();
				if(donatePriceOutput.getText() == donatePrice) {
				}else {
					donatePriceOutput.append(donatePrice);
				}
			}
		});
		inputPanel.add(donatePriceInput);
		
		JLabel bank = new JLabel("\uC740\uD589");
		bank.setBounds(44, 91, 87, 21);
		
		inputPanel.add(bank);
		String[] bankName = {"농협", "신한","기업","카카오뱅크"};
		JComboBox comboBox = new JComboBox(bankName);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String bkName = comboBox.getSelectedItem().toString();
				if(fundProjectName.getText() == bkName) {
				}else {
					bankOutput.append(bkName);
				}
			}
		});
		comboBox.setBounds(143, 91, 159, 21);
		
		inputPanel.add(comboBox);
		
		
		JButton completeBtn = new JButton("\uACB0\uC81C\uB97C \uC644\uB8CC \uD569\uB2C8\uB2E4.");
		completeBtn.addActionListener(new ActionListener() {
			JFrame f=new JFrame(); 
			public void actionPerformed(ActionEvent arg0) {
				int a=JOptionPane.showConfirmDialog(f,"Are you sure?");  
				if(a==JOptionPane.YES_OPTION){  
					//DB에 들어가는 커맨드
					int fundPrice =Integer.parseInt(donatePriceInput.getText());
					Date nowDate = java.sql.Date.valueOf(java.time.LocalDate.now());
					int accountNo = Integer.parseInt(accountNumberInput.getText());;
					String accountHolder = accountNameInput.getText();
					String bank = comboBox.getSelectedItem().toString();
					String payToolName = payTool;
					dao.insertData(new PaymentDTO(fundPrice,nowDate,accountNo,accountHolder,bank,payToolName));
					System.out.println("데이터 입력 성공");
					f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				} 
			}
		});
		completeBtn.setBounds(0, 212, 481, 33);
		completeBtn.setFocusPainted(false);
		completeBtn.setBorderPainted(false);
		completeBtn.setBackground(new Color(162, 155, 254));
		inputPanel.add(completeBtn);
	}
}

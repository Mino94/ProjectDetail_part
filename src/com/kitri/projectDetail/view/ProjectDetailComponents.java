package com.kitri.projectDetail.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.kitir.payment.model.PaymentDAO;
import com.kitir.payment.model.ProjectDTO;
import com.kitri.projectDetail.controller.ButtonActionListner;
import com.kitri.projectDetail.model.ProjectInfoDAO;
import com.kitri.projectDetail.view.ProjectMainTest.JTableMouseListener;

public class ProjectDetailComponents extends JFrame{

	final String dialogTitle = "∞·¡¶ √¢";
	final String dbOpenTitle = "«¡∑Œ¡ß∆Æ ¡§∫∏ √¢";
	private JPanel contentPane;

	private int arr2 = 0;
	ArrayList<ProjectDTO> arr = new ArrayList<ProjectDTO>();

	public static JTextArea titleTextArea;
	public static JTextArea textArea;
	public static JPanel imgPanel;

	PaymentDAO dao = new PaymentDAO();
	ArrayList<ProjectDTO> pjnoArr = new ArrayList<ProjectDTO>();

	public ProjectDetailComponents() {
//		new ProjectInfoDAO();
	}

	public JPanel MainComponent() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel navPanel = new JPanel();
		navPanel.setBackground(new Color(54, 33, 89));
		navPanel.setBounds(12, 10, 187, 701);
		contentPane.add(navPanel);
		navPanel.setLayout(null);

		JButton BrandColumn = new JButton("BRAND");
		BrandColumn.setForeground(Color.WHITE);
		BrandColumn.setFont(new Font("±º∏≤", Font.BOLD, 25));
		BrandColumn.setBackground(new Color(54, 33, 89));
		BrandColumn.setIcon(null);
		BrandColumn.setBounds(0, 32, 187, 76);
		BrandColumn.setFocusPainted(false);
		BrandColumn.setBorderPainted(false);
		navPanel.add(BrandColumn);

		JButton column1 = new JButton("Project Register");

		column1.setForeground(Color.WHITE);
		column1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		column1.setBackground(new Color(85, 65, 118));
		column1.setBounds(0, 158, 187, 44);
		column1.setBorderPainted(false);
		column1.setFocusPainted(false);

		navPanel.add(column1);

		JButton column2 = new JButton("Review");
		column2.setForeground(Color.WHITE);
		column2.setFont(new Font("Segoe UI", Font.BOLD, 12));
		column2.setFocusPainted(false);
		column2.setBorderPainted(false);
		column2.setBackground(new Color(85, 65, 118));
		column2.setBounds(0, 224, 187, 44);
		navPanel.add(column2);

		JButton column3 = new JButton("My page");
		column3.setForeground(Color.WHITE);
		column3.setFont(new Font("Segoe UI", Font.BOLD, 12));
		column3.setFocusPainted(false);
		column3.setBorderPainted(false);
		column3.setBackground(new Color(85, 65, 118));
		column3.setBounds(0, 292, 187, 44);
		navPanel.add(column3);

		JPanel contentPanel = new JPanel();
		contentPanel.setBounds(199, 10, 1041, 701);
		contentPane.add(contentPanel);
		contentPanel.setLayout(null);

		JPanel headerPanel = new JPanel();
		headerPanel.setBackground(new Color(110, 89, 222));
		headerPanel.setBounds(0, 31, 1041, 79);
		contentPanel.add(headerPanel);
		headerPanel.setLayout(null);

		JLabel hederText = new JLabel("PROGRAM DETAIL");
		hederText.setBounds(40, 10, 261, 57);
		hederText.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		hederText.setForeground(Color.WHITE);
		headerPanel.add(hederText);

		JPanel inContentPanel = new JPanel();
		inContentPanel.setBounds(10, 120, 1031, 548);
		inContentPanel.setBackground(Color.WHITE);
		contentPanel.add(inContentPanel);
		inContentPanel.setLayout(null);

		JPanel paymentPanel = new JPanel();
		paymentPanel.setBounds(792, 14, 176, 361);
		paymentPanel.setBackground(Color.WHITE);
		paymentPanel.setLayout(null);
		inContentPanel.add(paymentPanel);

		JLabel totalPriceLabel = new JLabel("Total Price: " );
		totalPriceLabel.setBounds(12, 110, 152, 28);
		totalPriceLabel.setFont(new Font("SanSerif", Font.PLAIN, 10));
		paymentPanel.add(totalPriceLabel);

		JLabel targetPriceLabel = new JLabel("Target Price : ");
		targetPriceLabel.setBounds(12, 208, 152, 28);
		targetPriceLabel.setFont(new Font("SanSerif", Font.PLAIN, 10));
		paymentPanel.add(targetPriceLabel);

		JLabel percentLabel = new JLabel();
		percentLabel.setBounds(12, 25, 73, 15);
		percentLabel.setFont(new Font("SanSerif", Font.PLAIN, 10));
		paymentPanel.add(percentLabel);

		JTextArea targetOutput = new JTextArea();
		targetOutput.setBounds(12, 238, 152, 56);
		targetOutput.setEditable(false);
		targetOutput.setFont(new Font("SanSerif", Font.BOLD, 20));
		ArrayList<ProjectDTO> arr = new ArrayList<ProjectDTO>();
		arr = dao.pjdReadData();
		targetOutput.append(arr.get(3).getTarget_price()+"  " + Currency.getInstance(Locale.KOREA).getSymbol());
		paymentPanel.add(targetOutput);


		JTextArea totalOutput = new JTextArea();
		totalOutput.setBounds(12, 142, 152, 56);
		totalOutput.setEditable(false);
		totalOutput.setFont(new Font("SanSerif", Font.BOLD, 20));
		arr2 = dao.sumReadData();
		totalOutput.append(arr2 + "  " +Currency.getInstance(Locale.KOREA).getSymbol());
		paymentPanel.add(totalOutput);

		int reNum =  arr.get(3).getTarget_price();
		JTextArea progressPercentOutput = new JTextArea();
		progressPercentOutput.setBounds(12, 50, 152, 56);
		progressPercentOutput.setFont(new Font("SanSerif", Font.BOLD, 30));
		progressPercentOutput.append(String.format("%.2f",(double)arr2/reNum*100) +" %");
		progressPercentOutput.setEditable(false);
		paymentPanel.add(progressPercentOutput);

		JButton funBtn = new JButton("DONATE");
		funBtn.addActionListener(new ButtonActionListner(this, dialogTitle, false));
		funBtn.setForeground(Color.WHITE);
		funBtn.setFont(new Font("Segoe UI", Font.BOLD, 12));
		funBtn.setBackground(new Color(85, 65, 118));
		funBtn.setBounds(0, 317, 176, 44);
		funBtn.setFocusPainted(false);
		funBtn.setBorderPainted(false);
		paymentPanel.add(funBtn);

		JPanel titlePanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) titlePanel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		titlePanel.setBounds(51, 14, 707, 97);
		titlePanel.setBackground(Color.white);
		inContentPanel.add(titlePanel);


		titleTextArea = new JTextArea();
//		titleTextArea.setBounds(0, 10, 707, 87);
//		titleTextArea.setFont(new Font("±º∏≤", Font.PLAIN, 40));
//		titleTextArea.setEditable(false);
		titlePanel.add(titleTextArea);


		imgPanel = new JPanel();
		imgPanel.setBounds(51, 121, 707, 254);
		imgPanel.setBackground(Color.white);
		inContentPanel.add(imgPanel);

		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setFont(new Font("±º∏≤", Font.PLAIN, 20));
		
		JScrollPane scrollbar = new JScrollPane();
		scrollbar.setViewportView(textArea);
		scrollbar.setBounds(51, 381, 707, 157);
		scrollbar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollbar.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		inContentPanel.add(scrollbar);


		return contentPane;
	}

	public JTextArea getTitleTextArea() {
		return titleTextArea;
	}

	public static void setTitleTextArea(JTextArea titleTextArea) {
		ProjectDetailComponents.titleTextArea = titleTextArea;
	}

	public  JTextArea getTextArea() {
		return textArea;
	}

	public static void setTextArea(JTextArea textArea) {
		ProjectDetailComponents.textArea = textArea;
	}

	public JPanel getImgPanel() {
		return imgPanel;
	}

	public static void setImgPanel(JPanel imgPanel) {
		ProjectDetailComponents.imgPanel = imgPanel;
	}

}

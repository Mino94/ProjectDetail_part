package BaseForm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JList;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import javax.swing.JLabel;

public class BaseForm extends JFrame {

   private JPanel contentPane;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               BaseForm frame = new BaseForm();
                  frame.setVisible(true);
                  frame.setResizable(false);
                  frame.setLocationRelativeTo(null);
                frame.setLocationRelativeTo(null);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   /**
    * Create the frame.
    */
   public BaseForm() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 1280, 720);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      JPanel navPanel = new JPanel();
      navPanel.setBackground(new Color(54, 33, 89));
      navPanel.setBounds(12, 23, 181, 492);
      contentPane.add(navPanel);
      navPanel.setLayout(null);
      
      JButton BrandColumn = new JButton("BRAND");
      BrandColumn.setForeground(Color.WHITE);
      BrandColumn.setFont(new Font("±¼¸²", Font.BOLD, 25));
      BrandColumn.setBackground(new Color(54, 33, 89));
      BrandColumn.setIcon(null);
      BrandColumn.setBounds(0, 32, 185, 76);
      BrandColumn.setFocusPainted(false);
      BrandColumn.setBorderPainted(false);
      navPanel.add(BrandColumn);
      
      JButton column1 = new JButton("Project Register");
      
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
      
      JPanel contentPanel = new JPanel();
      contentPanel.setBounds(193, 23, 789, 492);
      contentPane.add(contentPanel);
      contentPanel.setLayout(null);
      
      JPanel headerPanel = new JPanel();
      headerPanel.setBackground(new Color(110, 89, 222));
      headerPanel.setBounds(0, 31, 1073, 79);
      contentPanel.add(headerPanel);
      headerPanel.setLayout(null);
      
      JLabel hederText = new JLabel("TITLE NAME");
      hederText.setBounds(40, 10, 193, 57);
      hederText.setFont(new Font("Segoe UI", Font.PLAIN, 30));
      hederText.setForeground(Color.WHITE);
      headerPanel.add(hederText);
      
      JPanel mainPanel = new JPanel();
      mainPanel.setBounds(0, 0, 1280, 800);
      contentPane.add(mainPanel);
   }
}
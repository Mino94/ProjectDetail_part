package com.kitri.projectDetail.view;

import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.DropMode;

public class ProjectMainUI  extends JFrame{
	ProjectDetailComponents projectDetailComponents = new ProjectDetailComponents();
	/**
	 * @wbp.nonvisual location=1041,319
	 */
	
	public ProjectMainUI() {
		MainFrameConfigs("프로그램 상세 창");
		setContentPane(projectDetailComponents.MainComponent());
	}
	
	protected void MainFrameConfigs(String title) {
		setTitle(title);
		setBounds(100, 100, 1280, 720);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
	}
	
//	public static void main(String[] args) {
//		SwingUtilities.invokeLater(()->{new ProjectMainUI();});
//	}
	
}
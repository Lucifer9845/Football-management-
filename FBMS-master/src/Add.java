import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.sql.*;

public class Add extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add frame = new Add();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection conn = null;

	/**
	 * Create the frame.
	 */
	public Add() {
		conn = JDBCconn.dbconn();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 852, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(29, 29, 789, 600);
		contentPane.add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Teams", null, panel, null);
		panel.setLayout(null);

		JLabel lblTeamid = new JLabel("Team_Id :");
		lblTeamid.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblTeamid.setBounds(76, 39, 115, 37);
		panel.add(lblTeamid);

		JLabel lblTeamname = new JLabel("Team_Name :");
		lblTeamname.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblTeamname.setBounds(76, 103, 115, 37);
		panel.add(lblTeamname);

		JLabel lblNewLabel = new JLabel("City :");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel.setBounds(76, 152, 86, 43);
		panel.add(lblNewLabel);

		JLabel lblOwner = new JLabel("Owner :");
		lblOwner.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblOwner.setBounds(76, 207, 69, 34);
		panel.add(lblOwner);

		textField = new JTextField();
		textField.setBounds(283, 44, 130, 26);
		panel.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(283, 108, 130, 26);
		panel.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(283, 160, 130, 26);
		panel.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(283, 211, 130, 26);
		panel.add(textField_3);
		textField_3.setColumns(10);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "insert into teams values(?,?,?);";
					PreparedStatement pst = conn.prepareStatement(query);
					pst.setString(1, textField.getText());
					pst.setString(2, textField_1.getText());
					pst.setString(3, textField_2.getText());
					//pst.setString(4, textField_3.getText());
					pst.execute();

					pst.close();

					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					//textField_3.setText("");

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}

			}
		});
		btnSubmit.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnSubmit.setBounds(545, 81, 117, 29);
		panel.add(btnSubmit);

		JButton btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Modify m = new Modify();
				m.setVisible(true);
				dispose();
			}
		});
		btnReturn.setBounds(545, 161, 117, 29);
		panel.add(btnReturn);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Players", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblTeam = new JLabel("Team:");
		lblTeam.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblTeam.setBounds(76, 39, 115, 37);
		panel_1.add(lblTeam);

		JLabel lblKit_no = new JLabel("Kit_no :");
		lblKit_no.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblKit_no.setBounds(76, 103, 115, 50);
		panel_1.add(lblKit_no);

		JLabel lblPlayer_name = new JLabel("Player_name :");
		lblPlayer_name.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblPlayer_name.setBounds(76, 152, 86, 80);
		panel_1.add(lblPlayer_name);

		JLabel lblPosition = new JLabel("Position :");
		lblPosition.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblPosition.setBounds(76, 207, 69, 80);
		panel_1.add(lblPosition);

		JLabel lblNationality = new JLabel("Nationality :");
		lblNationality.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNationality.setBounds(76, 257, 69, 80);
		panel_1.add(lblNationality);

		JLabel lblDOB = new JLabel("birth date :");
		lblDOB.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblDOB.setBounds(76, 305, 69, 80);
		panel_1.add(lblDOB);

		JLabel lblteam_id = new JLabel("Team_id :");
		lblteam_id.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblteam_id.setBounds(76, 360, 69, 80);
		panel_1.add(lblteam_id);

		JLabel lblyear_start = new JLabel("year_start :");
		lblyear_start.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblyear_start.setBounds(76, 412, 69, 80);
		panel_1.add(lblyear_start);

		textField = new JTextField();
		textField.setBounds(283, 44, 110, 26);
		panel_1.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(283, 108, 110, 26);
		panel_1.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(283, 160, 110, 26);
		panel_1.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(283, 211, 110, 26);
		panel_1.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(283, 263, 110, 26);
		panel_1.add(textField_4);
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setBounds(283, 310, 110, 26);
		panel_1.add(textField_5);
		textField_5.setColumns(10);

		textField_6 = new JTextField();
		textField_6.setBounds(283, 360, 110, 26);
		panel_1.add(textField_6);
		textField_6.setColumns(10);

		textField_7 = new JTextField();
		textField_7.setBounds(283, 410, 110, 26);
		panel_1.add(textField_7);
		textField_7.setColumns(10);

		JButton btnSubmit_p = new JButton("Submit");
		btnSubmit_p.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "insert into players values(?,?,?,?,?,?,?,?);";
					PreparedStatement pst = conn.prepareStatement(query);
					pst.setString(1, textField.getText());
					pst.setString(2, textField_1.getText());
					pst.setString(3, textField_2.getText());
					pst.setString(4, textField_3.getText());
					pst.setString(5, textField_4.getText());
					pst.setString(6, textField_5.getText());
					pst.setString(7, textField_6.getText());
					pst.setString(8, textField_7.getText());
					pst.execute();

					pst.close();

					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField_4.setText("");
					textField_5.setText("");
					textField_6.setText("");
					textField_7.setText("");
					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}

			}
		});
		btnSubmit.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnSubmit.setBounds(545, 81, 117, 29);
		panel_1.add(btnSubmit);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Stadiums", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblStadium_id = new JLabel("Stadium_id :");
		lblStadium_id.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblStadium_id.setBounds(76, 39, 115, 37);
		panel_2.add(lblStadium_id);

		JLabel lblStadium_Name = new JLabel("Stadium_Name :");
		lblStadium_Name.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblStadium_Name.setBounds(76, 103, 115, 37);
		panel_2.add(lblStadium_Name);

		JLabel lblCapacity = new JLabel("Capacity :");
		lblCapacity.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblCapacity.setBounds(76, 152, 86, 43);
		panel_2.add(lblCapacity);

		JLabel lblTeam_id = new JLabel("Team_id :");
		lblTeam_id.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblTeam_id.setBounds(76, 207, 69, 34);
		panel_2.add(lblTeam_id);

		textField = new JTextField();
		textField.setBounds(283, 44, 130, 26);
		panel_2.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(283, 108, 130, 26);
		panel_2.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(283, 160, 130, 26);
		panel_2.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(283, 211, 130, 26);
		panel_2.add(textField_3);
		textField_3.setColumns(10);


		JButton btnSubmit_st = new JButton("Submit");
		btnSubmit_st.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "insert into stadium values(?,?,?,?);";
					PreparedStatement pst = conn.prepareStatement(query);
					pst.setString(1, textField.getText());
					pst.setString(2, textField_1.getText());
					pst.setString(3, textField_2.getText());
					pst.setString(4, textField_3.getText());
					pst.execute();

					pst.close();

					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}

			}
		});
		btnSubmit.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnSubmit.setBounds(545, 81, 117, 29);
		panel_2.add(btnSubmit);

		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Coaches", null, panel_3, null);
		panel_3.setLayout(null);

		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Matches", null, panel_4, null);
		panel_4.setLayout(null);
		
		/*
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("League", null, panel_5, null);
		panel_5.setLayout(null);
		*/
	}
}

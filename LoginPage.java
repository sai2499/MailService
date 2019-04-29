package Demo1;
import Demo1.GUIDemo;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginPage extends JFrame 
{

	private JPanel contentPane;
	private JTextField login;
	private JTextField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeToMail = new JLabel("Welcome to Mail Service");
		lblWelcomeToMail.setFont(new Font("Consolas", Font.BOLD, 18));
		lblWelcomeToMail.setBounds(85, 24, 235, 26);
		contentPane.add(lblWelcomeToMail);
		
		JLabel lblLoginId = new JLabel("Login Id");
		lblLoginId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLoginId.setBounds(85, 78, 71, 26);
		contentPane.add(lblLoginId);
		
		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(85, 134, 74, 26);
		contentPane.add(lblNewLabel);
		
		login = new JTextField();
		login.setBounds(208, 78, 112, 26);
		contentPane.add(login);
		login.setColumns(10);
		
		pass = new JTextField();
		pass.setBounds(208, 136, 112, 23);
		contentPane.add(pass);
		pass.setColumns(10);
		
		JButton button1 = new JButton("Go On ->>");
		button1.setFont(new Font("Tahoma", Font.BOLD, 12));
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String log=login.getText();
				String p=pass.getText();
				if(log.equals("root")&&p.equals("root"))
				{
					setVisible(false);
					new Select().setVisible(true);
				}
			}
		});
		button1.setBounds(154, 209, 112, 26);
		contentPane.add(button1);
	}
}

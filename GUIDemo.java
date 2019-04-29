package Demo1;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Properties;
import javax.mail.*;    
import javax.mail.internet.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JPasswordField;

public class GUIDemo extends JFrame {

	private JPanel contentPane;
	private JTextField to_;
	private JTextField from_;
	private JTextField subject_;
	private JTextField msg_;
	private JTextField password_;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIDemo frame = new GUIDemo();
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
	public GUIDemo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 545, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGmail = new JLabel("GMAIL");
		lblGmail.setFont(new Font("Consolas", Font.BOLD, 18));
		lblGmail.setBounds(242, 11, 55, 26);
		contentPane.add(lblGmail);
		
		JLabel lblTo = new JLabel("TO");
		lblTo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTo.setBounds(39, 132, 69, 18);
		contentPane.add(lblTo);
		
		JLabel lblFrom = new JLabel("FROM");
		lblFrom.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFrom.setBounds(39, 64, 69, 18);
		contentPane.add(lblFrom);
		
		JLabel lblNewLabel = new JLabel("SUBJECT");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(39, 173, 86, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblMessage = new JLabel("MESSAGE");
		lblMessage.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMessage.setBounds(39, 209, 98, 20);
		contentPane.add(lblMessage);
		
		to_ = new JTextField();
		to_.setBounds(163, 133, 279, 26);
		contentPane.add(to_);
		to_.setColumns(10);
		
		from_ = new JTextField();
		from_.setBounds(163, 64, 279, 23);
		contentPane.add(from_);
		from_.setColumns(10);
		
		subject_ = new JTextField();
		subject_.setBounds(163, 170, 279, 26);
		contentPane.add(subject_);
		subject_.setColumns(10);
		
		msg_ = new JTextField();
		msg_.setBounds(163, 209, 279, 97);
		contentPane.add(msg_);
		msg_.setColumns(10);
		
		JButton SEND = new JButton("SEND");
		SEND.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				String to,from,sub,pass,msg;
				to=to_.getText();
				from=from_.getText();
				sub=subject_.getText();
				pass=password_.getText();
				msg=msg_.getText();
				Properties props = new Properties();    
		        props.put("mail.smtp.host", "smtp.gmail.com");    
		        props.put("mail.smtp.socketFactory.port", "465");    
		        props.put("mail.smtp.socketFactory.class",    
		                  "javax.net.ssl.SSLSocketFactory");    
		        props.put("mail.smtp.auth", "true");    
		        props.put("mail.smtp.port", "465");    
		        //get Session   
		        Session session = Session.getDefaultInstance(props,    
		         new javax.mail.Authenticator() {    
		         protected PasswordAuthentication getPasswordAuthentication() {    
		         return new PasswordAuthentication(from,pass);  
		         }    
		        });    
		        //compose message    
		        try {    
		         MimeMessage message = new MimeMessage(session);    
		         message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
		         message.setSubject(sub);    
		         message.setText(msg);    
		         //send message  
		         Transport.send(message);    
		         System.out.println("message sent successfully");    
		        } catch (MessagingException e) {throw new RuntimeException(e);}
			}
		});
		SEND.setBounds(186, 317, 133, 38);
		contentPane.add(SEND);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPassword.setBounds(39, 93, 111, 28);
		contentPane.add(lblPassword);
		
		password_ = new JTextField();
		password_.setBounds(163, 99, 279, 23);
		contentPane.add(password_);
		password_.setColumns(10);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				new Select().setVisible(true);
			}
		});
		btnNewButton.setBounds(17, 317, 133, 38);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Attach");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				new GmailAttachment().setVisible(true);
			}
			
		});
		btnNewButton_1.setBounds(375, 317, 89, 38);
		contentPane.add(btnNewButton_1);
	}
}

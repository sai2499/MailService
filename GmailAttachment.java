package Demo1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Properties;
import java.awt.event.ActionEvent;

public class GmailAttachment extends JFrame {

	private JPanel contentPane;
	private JTextField _from;
	private JTextField _pass;
	private JTextField _to;
	private JTextField _attach;
	private JTextField _subj;
	private JTextField _msg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GmailAttachment frame = new GmailAttachment();
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
	public GmailAttachment() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 649, 505);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		_from = new JTextField();
		_from.setBounds(292, 70, 284, 28);
		contentPane.add(_from);
		_from.setColumns(10);
		
		_pass = new JTextField();
		_pass.setBounds(292, 114, 284, 28);
		contentPane.add(_pass);
		_pass.setColumns(10);
		
		_to = new JTextField();
		_to.setBounds(292, 159, 284, 28);
		contentPane.add(_to);
		_to.setColumns(10);
		
		_attach = new JTextField();
		_attach.setBounds(292, 206, 284, 28);
		contentPane.add(_attach);
		_attach.setColumns(10);
		
		_subj = new JTextField();
		_subj.setBounds(292, 253, 284, 28);
		contentPane.add(_subj);
		_subj.setColumns(10);
		
		_msg = new JTextField();
		_msg.setBounds(292, 300, 284, 107);
		contentPane.add(_msg);
		_msg.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("From");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(73, 77, 86, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(73, 121, 86, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("To");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(73, 166, 86, 21);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Attachment");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(73, 213, 86, 21);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Subject");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(73, 260, 86, 21);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblMessage = new JLabel("Message");
		lblMessage.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMessage.setBounds(73, 300, 86, 28);
		contentPane.add(lblMessage);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				new Select().setVisible(true);
			}
		});
		btnNewButton.setBounds(159, 432, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String to=_to.getText();
				String user=_from.getText();
				String pass=_pass.getText();  
				String msg=_msg.getText();
				String sub=_subj.getText();
				String att=_attach.getText();
				Properties properties = System.getProperties();  
				properties.put("mail.smtp.host", "smtp.gmail.com");    
				properties.put("mail.smtp.socketFactory.port", "465");    
				properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");    
				properties.put("mail.smtp.auth", "true");    
				properties.put("mail.smtp.port", "465");    
				Session session = Session.getDefaultInstance(properties,new javax.mail.Authenticator() 
				{    
					protected PasswordAuthentication getPasswordAuthentication() 
					{    
						return new PasswordAuthentication(user,pass);  
					}    
				}); 
				try
				{  
					MimeMessage message = new MimeMessage(session);  
					message.setFrom(new InternetAddress(user));  
					message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
					message.setSubject(sub);    
					BodyPart messageBodyPart1 = new MimeBodyPart();  
					messageBodyPart1.setText(msg);  
					MimeBodyPart messageBodyPart2 = new MimeBodyPart();  
					String filename =att;
					DataSource source = new FileDataSource(filename);  
					messageBodyPart2.setDataHandler(new DataHandler(source));  
					messageBodyPart2.setFileName(filename);  
					Multipart multipart = new MimeMultipart();  
					multipart.addBodyPart(messageBodyPart1);  
					multipart.addBodyPart(messageBodyPart2);  
					message.setContent(multipart );  
					Transport.send(message);  
					System.out.println("message sent....");  
				}
				catch (MessagingException ex)
				{
					ex.printStackTrace(); 
				}
			}
		});
		btnSend.setBounds(350, 432, 89, 23);
		contentPane.add(btnSend);
		
		JLabel lblGmail = new JLabel("GMAIL");
		lblGmail.setFont(new Font("Consolas", Font.BOLD, 16));
		lblGmail.setBounds(281, 11, 52, 34);
		contentPane.add(lblGmail);
	}
}

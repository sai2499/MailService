package Demo1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Properties;
import java.awt.event.ActionEvent;

public class hotmail extends JFrame {

	private JPanel hi;
	private JTextField _to;
	private JTextField _from;
	private JTextField _sub;
	private JTextField _pass;
	private JTextField _msg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hotmail frame = new hotmail();
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
	public hotmail() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 537, 506);
		hi = new JPanel();
		hi.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(hi);
		hi.setLayout(null);
		
		JLabel lblHotmail = new JLabel("HOTMAIL");
		lblHotmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHotmail.setBounds(204, 29, 68, 38);
		hi.add(lblHotmail);
		
		JLabel lblTo = new JLabel("TO");
		lblTo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTo.setBounds(72, 193, 62, 14);
		hi.add(lblTo);
		
		JLabel lblFrom = new JLabel("FROM");
		lblFrom.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFrom.setBounds(72, 97, 62, 14);
		hi.add(lblFrom);
		
		JLabel lblSubject = new JLabel("Subject");
		lblSubject.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSubject.setBounds(72, 249, 62, 14);
		hi.add(lblSubject);
		
		JLabel lblMessage = new JLabel("Message");
		lblMessage.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMessage.setBounds(71, 295, 79, 14);
		hi.add(lblMessage);
		
		_to = new JTextField();
		_to.setBounds(204, 188, 242, 27);
		hi.add(_to);
		_to.setColumns(10);
		
		_from = new JTextField();
		_from.setBounds(204, 92, 244, 27);
		hi.add(_from);
		_from.setColumns(10);
		
		_sub = new JTextField();
		_sub.setBounds(204, 245, 242, 27);
		hi.add(_sub);
		_sub.setColumns(10);
		
		JButton btnNewButton = new JButton("Send");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String to,from,sub,pass,msg;
				to=_to.getText();
				from=_from.getText();
				sub=_sub.getText();
				pass=_pass.getText();
				msg=_msg.getText();
				Properties props = new Properties();    
		        props.put("mail.smtp.host", "smtp.live.com");    
		        props.put("mail.smtp.socketFactory.port", "587");    
		        props.put("mail.smtp.socketFactory.class",    
		                  "javax.net.ssl.SSLSocketFactory");    
		        props.put("mail.smtp.auth", "true");    
		        props.put("mail.smtp.port", "25");    
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
		        } catch (MessagingException e1) {throw new RuntimeException(e1);}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(297, 410, 89, 23);
		hi.add(btnNewButton);
		
		_pass = new JTextField();
		_pass.setBounds(204, 140, 242, 27);
		hi.add(_pass);
		_pass.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPassword.setBounds(70, 146, 64, 14);
		hi.add(lblPassword);
		
		_msg = new JTextField();
		_msg.setBounds(204, 290, 242, 75);
		hi.add(_msg);
		_msg.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
				new Select().setVisible(true);
			}
		});
		btnNewButton_1.setBounds(111, 410, 89, 23);
		hi.add(btnNewButton_1);
	}

}

package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.BasicConfigurator;

import chatting.data.Person;
import chatting.helper.XMLConvert;

public class UI_Sender extends JFrame implements ActionListener {

	private JPanel pnlShowChat, pnlChatAndBtn;
	private JTextField txtMess;
	private JButton btnSend;
	private JLabel lblDisplayMessYou, lblDisplayMessReceiver;
	
	public UI_Sender() {
		setTitle("App Send");
		setSize(600, 600);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel pnl = new JPanel();
		this.add(pnl);
		pnl.setLayout(null);
		pnl.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblTitle = new JLabel("Messenger Sender");
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblTitle.setBounds(230, 0, 200, 50);
		pnl.add(lblTitle);
		
		pnlShowChat = new JPanel();
		pnlShowChat.setLayout(null);
		pnlShowChat.setBounds(20, 60, 560, 350);
		pnl.add(pnlShowChat);
		
		lblDisplayMessYou = new JLabel("You: ");
		lblDisplayMessYou.setBounds(10, 10, 500, 20);
		pnlShowChat.add(lblDisplayMessYou);
		
//		lblDisplayMessReceiver = new JLabel("Receiver: ");
//		lblDisplayMessReceiver.setBounds(10, 40, 500, 20);
//		pnlShowChat.add(lblDisplayMessReceiver);
		
		pnlChatAndBtn = new JPanel();
		pnlChatAndBtn.setBounds(20, 430, 560, 120);
		pnlChatAndBtn.setLayout(null);
		pnl.add(pnlChatAndBtn);
		
		txtMess = new JTextField();
		txtMess.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtMess.setBounds(0, 0, 400, 120);
		pnlChatAndBtn.add(txtMess);
		
		btnSend = new JButton("Send");
		btnSend.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnSend.setBounds(410, 0, 150, 120);
		pnlChatAndBtn.add(btnSend);
		
		btnSend.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String mess = txtMess.getText().toString();
				lblDisplayMessYou.setText("You: " +mess);
				try {
					send(mess);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
	}
	
	public void send(String mess) throws Exception {
		BasicConfigurator.configure();
        //config environment for JNDI
        Properties settings = new Properties();
        settings.setProperty(Context.INITIAL_CONTEXT_FACTORY,
                "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
        settings.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");
        //create context
        Context ctx = new InitialContext(settings);
        //lookup JMS connection factory
        ConnectionFactory factory =
                (ConnectionFactory) ctx.lookup("ConnectionFactory");
        //lookup destination. (If not exist-->ActiveMQ create once)
        Destination destination =
                (Destination) ctx.lookup("dynamicQueues/thanthidet");
        //get connection using credential
        Connection con = factory.createConnection("admin", "admin");
        //connect to MOM
        con.start();
        //create session
        Session session = con.createSession(
                /*transaction*/false,
                /*ACK*/Session.AUTO_ACKNOWLEDGE
        );
        //create producer
        MessageProducer producer = session.createProducer(destination);
        //create text message
        Message msg = session.createTextMessage(mess);
        producer.send(msg);
//        Person p = new Person(1001, "Nguyen Thanh Nhan", new Date());
//        String xml = new XMLConvert<Person>(p).object2XML(p);
//        msg = session.createTextMessage(xml);
        producer.send(msg);
        //shutdown connection
        session.close();
        con.close();
	}
	
	public static void main(String[] args) {
		new UI_Sender().setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}

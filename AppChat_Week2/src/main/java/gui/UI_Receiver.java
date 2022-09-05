package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.log4j.BasicConfigurator;

public class UI_Receiver extends JFrame implements ActionListener{

	private JPanel pnlShowChat, pnlChatAndBtn;
	private JTextField txtMess;
	private JButton btnSend;
	private JLabel lblDisplayMessYou, lblDisplayMessReceiver;
	
	public UI_Receiver() {
		
		setTitle("App Receiver");
		setSize(600, 600);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel pnl = new JPanel();
		this.add(pnl);
		pnl.setLayout(null);
		pnl.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblTitle = new JLabel("Messenger Receiver");
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblTitle.setBounds(230, 0, 200, 50);
		pnl.add(lblTitle);
		
		pnlShowChat = new JPanel();
		pnlShowChat.setLayout(null);
		pnlShowChat.setBounds(20, 60, 560, 350);
		pnl.add(pnlShowChat);
		
//		lblDisplayMessYou = new JLabel("You: ");
//		lblDisplayMessYou.setBounds(10, 10, 500, 20);
//		pnlShowChat.add(lblDisplayMessYou);
		
		lblDisplayMessReceiver = new JLabel("Receiver: ");
		lblDisplayMessReceiver.setBounds(10, 40, 500, 20);
		pnlShowChat.add(lblDisplayMessReceiver);
		
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
		
		try {
			takeMess();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void takeMess() throws Exception {
		//thiết lập môi trường cho JMS
        BasicConfigurator.configure();
        //thiết lập môi trường cho JJNDI
        Properties settings = new Properties();
        settings.setProperty(Context.INITIAL_CONTEXT_FACTORY,
                "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
        settings.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");
        //tạo context
        Context ctx = new InitialContext(settings);
        //lookup JMS connection factory
        Object obj = ctx.lookup("ConnectionFactory");
        ConnectionFactory factory = (ConnectionFactory) obj;
        //lookup destination
        Destination destination
                = (Destination) ctx.lookup("dynamicQueues/thanthidet");
        //tạo connection
        Connection con = factory.createConnection("admin", "admin");
        //nối đến MOM
        con.start();
        //tạo session
        Session session = con.createSession(
                /*transaction*/false,
                /*ACK*/Session.CLIENT_ACKNOWLEDGE
        );
        //tạo consumer
        MessageConsumer receiver = session.createConsumer(destination);
        //blocked-method for receiving message - sync
        //receiver.receive();
        //Cho receiver lắng nghe trên queue, chừng có message thì notify - async
        System.out.println("Tý was listened on queue...");
        receiver.setMessageListener(new MessageListener() {
            //có message đến queue, phương thức này được thực thi

            public void onMessage(Message msg) {//msg là message nhận được
                try {
                    if (msg instanceof TextMessage) {
                        TextMessage tm = (TextMessage) msg;
                        String txt = tm.getText().toString();
                        lblDisplayMessReceiver.setText("Receiver: " +txt);
                        System.out.println("Nhận được '" + txt + "'");
                        msg.acknowledge();//gửi tín hiệu ack
                    } else if (msg instanceof ObjectMessage) {
                        ObjectMessage om = (ObjectMessage) msg;
                        System.out.println(om);
                    }
                //others message type....
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		new UI_Receiver().setVisible(true);
	}
	
}

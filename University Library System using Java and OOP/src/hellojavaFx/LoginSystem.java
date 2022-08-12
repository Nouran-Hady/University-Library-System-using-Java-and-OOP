package hellojavaFx;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginSystem implements ActionListener{
	
	JFrame frame = new JFrame();
	JButton loginbutton =new JButton("Login");
	JButton resetbutton =new JButton("Reset");
	JTextField namefield =new JTextField();
	JPasswordField passwordfield =new JPasswordField();
	
	JLabel usernamelabel=new JLabel("User Name");
	JLabel passwordlabel=new JLabel("Password");
	JLabel messagelabel=new JLabel();
	
	String Username;
	String Password;
	
	LoginSystem(){
		
	}
	
	LoginSystem(String username, String password){
		Username=username;
		Password=password;
		
		usernamelabel.setBounds(50, 100, 75, 25);
		passwordlabel.setBounds(50, 150, 75, 25);
		
		messagelabel.setBounds(125, 250, 250, 35);
		messagelabel.setFont(new Font(null,Font.HANGING_BASELINE,25));
		
		namefield.setBounds(125,100,200,25);
		passwordfield.setBounds(125,150,200,25);
		
		loginbutton.setBounds(125,200,100,25);
		loginbutton.setFocusable(false);
		loginbutton.addActionListener(this);
		
		resetbutton.setBounds(225,200,100,25);
		resetbutton.setFocusable(false);
		resetbutton.addActionListener(this);
		
		frame.add(messagelabel);
		frame.add(usernamelabel);
		frame.add(passwordlabel);
		
		frame.add(namefield);
		frame.add(passwordfield);
		
		frame.add(loginbutton);
		frame.add(resetbutton);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,500);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()==resetbutton) {
			namefield.setText("");
			passwordfield.setText("");
		}
		
		if (e.getSource()==loginbutton) {
			namefield.setText("");
			passwordfield.setText("");
		}
	}
	
	public void call_main() {
		System.out.println("in call_main function");
	}

}

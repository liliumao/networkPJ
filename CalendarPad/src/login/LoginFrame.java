package login;
import gui.MainFrame;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import launcher.CalendarPad;

/*
 * The Login Frame and the previledge control of user login.
 */
public class LoginFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel nameLabel = new JLabel("username:");
	private JLabel passLabel = new JLabel("password:");
	private JTextField nameField = new JTextField();
	private JPasswordField passField = new JPasswordField();
	private JButton loadButton = new JButton("��½");
	private JButton cancleButton = new JButton("ȡ��");
	private JLabel msgLabel = new JLabel();
	
	public LoginFrame(){
		
		//set the frame
		setResizable(false);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize.width/3, screenSize.height* 10/25);
		setLocation(screenSize.width/3, screenSize.height/4);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//set the components, fixed size
		passField.setEchoChar('*');
		
		nameLabel.setSize(100, 100);
		nameLabel.setLocation(80, 30);
		
		passLabel.setSize(100, 100);
		passLabel.setLocation(80, 90);
		
		nameField.setSize(140, 20);
		nameField.setLocation(170, 70);
		
		passField.setSize(140, 20);
		passField.setLocation(170, 130);
		
		loadButton.setSize(90, 25);
		loadButton.setLocation(80, 180);
		
		cancleButton.setSize(90,25);
		cancleButton.setLocation(220, 180);
		
		msgLabel.setSize(160,25);
		msgLabel.setLocation(80, 240);
		
		//background image of the frame
		ImageIcon bgim = new ImageIcon("images/bg_3.png");
		JLabel bglbl = new JLabel(bgim);
		bglbl.setSize(this.getSize().width,this.getSize().height);
		
		//add the components
		this.add(nameLabel);
		this.add(nameField);
		this.add(passLabel);
		this.add(passField);
		this.add(loadButton);
		this.add(cancleButton);
		this.add(bglbl);
		
		setVisible(true);
		
		loadButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String username = nameField.getText();
				String userpass = String.valueOf(passField.getPassword());
				//the username and password should not be empty.
				if(username.equals("") || username == null || userpass.equals("") || userpass == null){
					msgLabel.setText("�û������벻��Ϊ��");
					JOptionPane.showMessageDialog(null, "�û������벻��Ϊ��");
				}
				else{ // if the user has the right username and password.
					if(Validate.isValidate(username, userpass) == true){
						dispose();
						MainFrame.usernameLabel.setText(username + " �ѵ�¼");
						MainFrame.isLogin = true;
						MainFrame.jm_3.setText("�˳�");
						MainFrame.jm_3_1.setText("�˳�");
						MainFrame.calenderPanel.refresh();
						
					}
					else{// login failed
						JOptionPane.showMessageDialog(null, "��¼ʧ��");
					}
				}
				
			}
		});
		
		//event listening of the cancle button
		cancleButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}

}

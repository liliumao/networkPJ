package MyPackage;

//import java.awt.*;
import java.awt.event.*;
//import java.util.Calendar;
//import java.util.GregorianCalendar;

import javax.swing.*;

//import noteProcess.noteProcess;
import GUI.*;


public class CalendarPad 
{
//	public static JTextField jtf1=new JTextField(4);      //��ʾ��
//	public static JTextField jtf2=new JTextField(2);      //��ʾ��
//	public static JTextField jtf3=new JTextField(2); 
//	public static JTextField[] jtf=new JTextField[42];    //��ʾ��  
//	public static JButton jb1,jb2,jb3,jb4;        //���� ���� ���� ���� ��ť
//	public static JTextArea jta=new JTextArea(3,3);       //��¼��־
//	public static JLabel jla=new JLabel("          ");    //��ʾ��������
//	
//	public CalendarPad()
//	{		
//		JFrame mainframe=new JFrame("�������±�");        //������
//		Container cp=mainframe.getContentPane();//��ȡ�����������
//		cp.setLayout(new GridLayout(1,2));      //����
//		
//		JPanel leftpanel= new JPanel();  //��������
//		leftpanel.setBackground(Color.cyan);
//		leftpanel.setLayout(new BorderLayout());
//		
//		JPanel leftnorth=new JPanel();      //����ѡ�����µİ�ť���ı���
//		jb1=new JButton("����");
//		leftnorth.add(jb1);
//		jb1.addActionListener(new ShowCalender());//������ʾʱΪ��ť���������
//		
//		leftnorth.add(jtf1);
//		jb2=new JButton("����");
//		jb2.addActionListener(new ShowCalender());
//		leftnorth.add(jb2);
//		jb3=new JButton("����");
//		jb3.addActionListener(new ShowCalender());
//		leftnorth.add(jb3);
//		
//		leftnorth.add(jtf2);
//		jb4=new JButton("����");
//		leftnorth.add(jb4);
//		jb4.addActionListener(new ShowCalender());
//		leftnorth.add(jtf3);
//		
//		leftpanel.add(leftnorth, BorderLayout.NORTH);
//		
//		JPanel leftcenter=new JPanel();
//		leftcenter.setLayout(new GridLayout(7,7));//���в���
//		String[] xinqi={"������","����һ","���ڶ�","������","������","������","������"};
//		JLabel[] jl=new JLabel[7];
//		for(int i=0;i<7;i++)
//		{
//			jl[i]=new JLabel(xinqi[i]);
//			leftcenter.add(jl[i]);
//			
//		}
//		
//		for(int i=0;i<42;i++)
//		{
//			leftcenter.add(jtf[i]=new JTextField());
//			jtf[i].addMouseListener(new noteProcess());
//			jtf[i].setEditable(false);
//		}
//		leftpanel.add(leftcenter, BorderLayout.CENTER);
//		
//		JPanel rightpanel=new JPanel();                //���±�����
//		rightpanel.setLayout(new BorderLayout());
//		
//		rightpanel.add(jla,BorderLayout.NORTH);
//		
//		jta.setBorder(BorderFactory.createTitledBorder("�ռ�"));
//		rightpanel.add(jta,BorderLayout.CENTER);
//		JPanel rightsouth=new JPanel();
//		JButton jb5=new JButton("������־");
//		rightsouth.add(jb5);
//		jb5.addActionListener(new noteProcess());//Ϊ��ť�������
//		JButton jb6=new JButton("ɾ����־");
//		rightsouth.add(jb6);
//		jb6.addActionListener(new noteProcess());
//		rightpanel.add(rightsouth, BorderLayout.SOUTH);
//			
//		cp.add(leftpanel);
//		cp.add(rightpanel);
//		mainframe.setVisible(true);
//		mainframe.pack();
//		mainframe.addWindowListener(new WinLis());
//	}
	
	public static void main(String[] args)
	{
//		CalendarPad calpad=new CalendarPad();
//		GregorianCalendar gCalendar = (GregorianCalendar) Calendar.getInstance();
//		ShowCalender.showCalendar(gCalendar);
		
		// �������
		try {
			//UIManager.setLookAndFeel(new com.sun.java.swing.plaf.windows.WindowsLookAndFeel());
			String lookAndFeel = "com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel";
			UIManager.setLookAndFeel(lookAndFeel);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "���� plaf ģʽ��ʾ�������", "����",
					JOptionPane.WARNING_MESSAGE);
		}
		
		new MainFrame();

	}
}
class WinLis extends WindowAdapter//�������ڵĶ�̬
{
	public void windowClosing(WindowEvent we)
	{
		System.exit(0);
	}
}

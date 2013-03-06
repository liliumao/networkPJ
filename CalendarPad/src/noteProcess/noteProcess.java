package noteProcess;

import java.awt.Color;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTextField;

import GUI.*;
import MyPackage.*;
import calenderProcess.*;

public class noteProcess extends MouseAdapter implements ActionListener
{
	private String filepath = "src\\diary\\";
	private String filename;
	private String postfix = ".bak";

	public void actionPerformed(ActionEvent ae)
	{	
		if( (ae.getActionCommand()=="�����ռ�") && MainFrame.isLogin )
		{
			String note=NotePanel.noteArea.getText();
			if ( note == null || note.equals("") )
				return ;
			

			int yearInt = MyCalender.year ;
			Byte monthInt = Byte.parseByte(MyCalender.month+"") ;
			Byte dayInt = Byte.parseByte(MyCalender.selectedDay+"");
			String a = yearInt + "" ;
			StringBuffer b = new StringBuffer(monthInt + "") ;
			StringBuffer c = new StringBuffer(dayInt + "") ;
			
			if (b.length()==1)
				b.insert(0, "0");
			if (c.length()==1)
				c.insert(0, "0");
			//filename=filename+a+b+c+postfix;
			filename = new StringBuffer(filepath).append(a).append(b).append(c).append(postfix).toString();
			
			//System.out.println(filename + "\t" + note);
			char[] buffer=new char[note.length()];
			note.getChars(0, note.length(), buffer, 0);
			FileWriter f;
			try {
				f = new FileWriter(filename);
				f.write(Encryption.encryption(note));  
				  f.close();
			} catch (IOException e) {
				// û�б���
			}
			  
				//RSAEncrypt.encryption(note, filename);
				//filename = "src\\diary\\";
				
				// ˢ�½���
				CalenderPanel.cal.refreshDaysArray();
				MainFrame.calenderPanel.refresh() ;
				
				// ����Զ�����ݿ�
				SaveReminderProcess save = new SaveReminderProcess() ;
				save.start() ;
				
//				try {
//					Backup_db.addReminder(yearInt, monthInt, dayInt, RSAEncrypt.encryption(note)/*Encryption.encryption(note)*/);
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					//e.printStackTrace();
//					System.err.println("�޷�����Զ�����ݿ⣡");
//				}

		}
		else if( (ae.getActionCommand()=="ɾ���ռ�") && MainFrame.isLogin )
		{
			
			int yearInt = MyCalender.year ;
			Byte monthInt = Byte.parseByte(MyCalender.month+"") ;
			Byte dayInt = Byte.parseByte(MyCalender.selectedDay+"");
			String a = yearInt + "" ;
			StringBuffer b = new StringBuffer(monthInt + "") ;
			StringBuffer c = new StringBuffer(dayInt + "") ;
			
			if (b.length()==1)
				b.insert(0, "0");
			if (c.length()==1)
				c.insert(0, "0");
			filename = new StringBuffer(filepath).append(a).append(b).append(c).append(postfix).toString();
			
			File f = new File(filename);
			f.delete();
			
			// ˢ�½���
			CalenderPanel.cal.refreshDaysArray();
			MainFrame.calenderPanel.refresh() ;
			
			// ��Զ�����ݿ���ɾ��
			DeleteReminderProcess delete = new DeleteReminderProcess() ;
			delete.start() ;
			
			//filename = "src\\diary\\";
//			try {
//				Backup_db.deleteReminder(yearInt, monthInt, dayInt);
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				//e.printStackTrace();
//				System.err.println("�޷�����Զ�����ݿ⣡");
//			}
		}
		// ���ĳ����ʾ����
		else if ( MainFrame.isLogin )
		{
			int index = ((TransparentButton) ae.getSource()).index;
			String dayTitle = CalenderPanel.cal.daysArray[index].getDayTitle();
			if (index >= CalenderPanel.cal.startDay && index <= CalenderPanel.cal.endDay)
			{
				String title = "";
				title += dayTitle.substring(0, 4) + "��";
				title += dayTitle.substring(4, 6) + "��";
				title += dayTitle.substring(6, 8) + "�յ��ռ�";
				
				MyCalender.selectedDay = Integer.parseInt(dayTitle.substring(6, 8));
				
				NotePanel.refresh(title, "");
			}
			try {				
				FileReader fr = new FileReader(filepath + dayTitle + postfix);
				BufferedReader br=new BufferedReader(fr);
				String s=new String();  
				StringBuffer note = new StringBuffer();//noteΪ��־����
				while((s=br.readLine())!=null)//����־�ļ�
				{
					note.append(s);
				}
				NotePanel.noteArea.setText(Encryption.decryption(note.toString()));
				br.close();
				fr.close();
			} catch (Exception e) {
				// TODO �Զ����� catch ��
				//System.err.println("��ȡ��������") ;
			}
			
			//CalendarPad.jta.setText(Encryption.decryption(note.toString()));
			//System.out.println(CalenderPanel.cal.daysArray[index].getCalendar().toString());
		}
		
	}
	
//	public void mousePressed(MouseEvent me)
//	{
//		
//		System.out.println("hello");
//		
//		//String filename = "src\\diary\\";
//		//String postfix = ".bak";
//		
//		int index = ((TransparentButton) me.getSource()).index;
//		String dayTitle = CalenderPanel.cal.daysArray[index].getDayTitle();
//		if (index >= CalenderPanel.cal.startDay && index <= CalenderPanel.cal.endDay)
//		{
//			String title = "";
//			title += dayTitle.substring(0, 4) + "��";
//			title += dayTitle.substring(4, 6) + "��";
//			title += dayTitle.substring(6, 8) + "�յ��ռ�";
//			
//			MyCalender.selectedDay = Integer.parseInt(dayTitle.substring(6, 8));
//			
//			NotePanel.refresh(title, "");
//		}
//		
//		
//		String year=CalendarPad.jtf1.getText();
//		String month=CalendarPad.jtf2.getText();
//		JTextField source=(JTextField) me.getSource();
//		String day=source.getText();
//		CalendarPad.jtf3.setText(day);
//		CalendarPad.jla.setText("                 "+year+" �� "+month+" �� "+day+" �� ");
//		String a=CalendarPad.jtf1.getText();
//		String b=CalendarPad.jtf2.getText();
//		String c=CalendarPad.jtf3.getText();
//		if (b.length()==1)
//			b="0"+b;
//		if (c.length()==1)
//			c="0"+c;
//		/*FileReader fr=new FileReader(filepath + a + b + c + postfix);
//		BufferedReader br=new BufferedReader(fr);
//		String s=new String();  
//		StringBuffer note = new StringBuffer();//noteΪ��־����
//		while((s=br.readLine())!=null)//����־�ļ�
//		{
//			note.append(s);
//		}
//		//CalendarPad.jta.setText(Encryption.decryption(note.toString()));*/
//		NotePanel.noteArea.setText(RSAEncrypt.decryption(filepath + dayTitle + postfix));
//		//fr.close();
//		
//	}
//	
	
	/**
	 * ��ȡ���ص�ȫ������
	 */
	public ArrayList<Reminder> reach()
	{
		ArrayList<Reminder> reminders = new ArrayList<Reminder>();
		File dir = new File(filepath);
		if(dir.isDirectory())
		{
			//System.out.println("zccshome");
			String[] filelist = dir.list();
			for(String file:filelist)
			{
				int year = Integer.parseInt(file.substring(0,4));
				byte month = Byte.parseByte(file.substring(4,6));
				byte day = Byte.parseByte(file.substring(6,8));
				StringBuffer note = new StringBuffer();
				//System.out.println(year+"\n"+month+"\n"+day);
				FileReader fr;
				try {
					fr = new FileReader(filepath+file);
					BufferedReader br=new BufferedReader(fr);
					String s =new String();                   //noteΪ��־����
					while((s=br.readLine())!=null)//����־�ļ�
					{
						note.append(s);
					}
					br.close();
					fr.close();
					//System.out.println(note);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Reminder reminder = new Reminder(year,month,day,note.toString());
				reminders.add(reminder);
				//File fileF = new File(filelist+file);
			}
		}
		return reminders;
	}
	/**
	 * �����ر���ȫ����ӵ�Զ�����ݿ�
	 * @param reminders
	 */
	public void backup(ArrayList<Reminder> reminders)
	{
		for(Reminder r: reminders)
		{
			int year = r.getYear();
			byte month = r.getMonth();
			byte day = r.getDay();
			String content = r.getContent();
			try {
				Backup_db.addReminder(year, month, day, content);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * ��Զ�����ݿ������б���ȫ��ȡ�����ؽ��кϲ�����ĳ�յı��������Ѿ������򲻸��ǡ�
	 *
	 */
	public void download()
	{
		try {
			ArrayList<Reminder> reminders = Backup_db.getReminder();
			for(Reminder r: reminders)
			{
				String year = ""+r.getYear();
				String month = ""+r.getMonth();
				String day = ""+r.getDay();
				if (month.length()==1)
					month="0"+month;
				if (day.length()==1)
					day="0"+day;
				String filename = filepath + year + month + day + postfix;
				File file = new File(filename);
				if(!file.exists())
				{
					
					try {
						FileWriter f=new FileWriter(filename);
						f.write(r.getContent());
						f.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}  
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*public static void main(String[] args)
	{
		noteProcess temp = new noteProcess();
		temp.backup(temp.reach());
	}*/

}

package MyPackage;

import java.awt.Color;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JTextField;


public class noteProcess extends MouseAdapter implements ActionListener
{
	private String filepath = "src\\diary\\";
	private String filename;
	private String postfix = ".bak";

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getActionCommand()=="������־")
		{

			String a=CalendarPad.jtf1.getText();
			StringBuffer b=new StringBuffer(CalendarPad.jtf2.getText());
			StringBuffer c=new StringBuffer(CalendarPad.jtf3.getText());
			StringBuffer date= new StringBuffer();//��ʵ����
			
			if (b.length()==1)
				b.insert(0, "0");
			if (c.length()==1)
				c.insert(0, "0");
			//filename=filename+a+b+c+postfix;
			filename = new StringBuffer(filepath).append(a).append(b).append(c).append(postfix).toString();
			String note=CalendarPad.jta.getText();
			char[] buffer=new char[note.length()];
			note.getChars(0, note.length(), buffer, 0);
			try
			{
			  FileWriter f=new FileWriter(filename);
			  f.write(buffer);  
			  f.close();
				for (int i = 0; i < CalendarPad.jtf.length; i++) {
					String dt = CalendarPad.jtf[i].getText();
					if (dt.equals(date)) {
						CalendarPad.jtf[i].setBackground(Color.yellow);
					}
				}
				filename = "src\\diary\\";
			}
			catch(IOException e)
			{
				System.out.println(e.getMessage());
			}
			
		}
		else if(ae.getActionCommand()=="ɾ����־")
		{
			
			String a=CalendarPad.jtf1.getText();
			String b=CalendarPad.jtf2.getText();
			String c=CalendarPad.jtf3.getText();
			String date=c;//��ʵ����
			
			if (b.length()==1)
				b="0"+b;
			if (c.length()==1)
				c="0"+c;
			filename=filename+a+b+c+postfix;
			File f=new File(filename);
			f.delete();
			CalendarPad.jta.setText("");
			for (int i = 0; i < CalendarPad.jtf.length; i++) {
				String dt = CalendarPad.jtf[i].getText();
				if (dt.equals(date)) {
					CalendarPad.jtf[i].setBackground(Color.cyan);
				}
			}
			filename = "src\\diary\\";
		}
		
	}
	public void mousePressed(MouseEvent me)
	{
		//String filename = "src\\diary\\";
		//String postfix = ".bak";
		
		String year=CalendarPad.jtf1.getText();
		String month=CalendarPad.jtf2.getText();
		JTextField source=(JTextField) me.getSource();
		String day=source.getText();
		CalendarPad.jtf3.setText(day);
		CalendarPad.jla.setText("                 "+year+" �� "+month+" �� "+day+" �� ");
		try
		{
			String a=CalendarPad.jtf1.getText();
			String b=CalendarPad.jtf2.getText();
			String c=CalendarPad.jtf3.getText();
			if (b.length()==1)
				b="0"+b;
			if (c.length()==1)
				c="0"+c;
			FileReader fr=new FileReader(filepath + a + b + c + postfix);
			BufferedReader br=new BufferedReader(fr);
			String s,note=new String();                   //noteΪ��־����
			while((s=br.readLine())!=null)//����־�ļ�
			{
				note+=s;
			}
			CalendarPad.jta.setText(note);
			fr.close();
			
		}
		catch(FileNotFoundException e)
		{
			CalendarPad.jta.setText("");
		}
		catch (IOException e)
		{
	
		}
		
	}

}

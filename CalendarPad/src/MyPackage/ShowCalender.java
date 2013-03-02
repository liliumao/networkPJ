package MyPackage;

import java.util.*;
import java.awt.Color;
import java.awt.event.*;
//import java.io.BufferedReader;
import java.io.File;

import noteProcess.noteProcess;
//import java.io.FileReader;


public class ShowCalender implements ActionListener
{
	static int year,month,day;
	
	public static void  showCalendar(GregorianCalendar gCalendar)      //��ʾ����
	{
		// �õ��ļ������е��ļ���
		File file = new File("src\\diary\\");
		String fileList[] = file.list();

		String postfix = ".bak";

		int size = 0;
		if (fileList != null) {
			size = fileList.length;
		}
		
		for(int i=0;i<42;i++) {                  //����ϴ�����
			CalendarPad.jtf[i].setText(""); 
	    	CalendarPad.jtf[i].setBackground(Color.cyan);//��������text�ı���ɫΪ��ɫ
		}
		year=gCalendar.get(Calendar.YEAR);
		month=(gCalendar.get(Calendar.MONTH)+1);
	    day=gCalendar.get(Calendar.DATE);
		CalendarPad.jtf1.setText(""+year);
		CalendarPad.jtf2.setText(""+month);
		CalendarPad.jtf3.setText(""+day);
		GregorianCalendar cal=new GregorianCalendar(year,month-1,1);
		int d=cal.get(Calendar.DAY_OF_WEEK);     //dΪ���µ�һ����һ���е�λ��
		int maxday;   //�����������
		if(month==1||month==3||month==5||month==7||month==8||month==10||month==12)
			maxday=31;
		else 
			maxday=30;
		if(month==2 && gCalendar.isLeapYear(year))
			maxday--;
		if(month==2 && !gCalendar.isLeapYear(year))
			maxday=28;
		for(int i=d-1, j=1;j<=maxday;i++,j++)    //��ʾ������
		{
			CalendarPad.jtf[i].setText(""+j);
			
			//�õ���ǩ������ı�
			String dt = CalendarPad.jtf[i].getText();

			if (dt.length() == 1) {
				dt = "0" + dt;
			}			
			//CalendarPad.jtf[i].setBackground(Color.cyan);//��������text�ı���ɫΪ��ɫ	
			// ���ñ��
			for (int k = 0; k < size; k++) {
				String date = CalendarPad.jtf1.getText()
						+ CalendarPad.jtf2.getText() + dt + postfix;
				String fileName = fileList[k];
				if (fileName.equals(date)) {
					CalendarPad.jtf[i].setBackground(Color.yellow);
				}
			}

		}
		CalendarPad.jla.setText("                 "+year+" �� "+month+" �� "+day+" �� ");  

	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getActionCommand()=="����")
			year--;
		else if(ae.getActionCommand()=="����")
			year++;
		else if(ae.getActionCommand()=="����")
			month--;
		else if(ae.getActionCommand()=="����")
			month++;
		showCalendar(new GregorianCalendar(year,month-1,day));
		
	}

}

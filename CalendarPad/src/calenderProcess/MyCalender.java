package calenderProcess;

import java.io.File;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class MyCalender
{
	// ����ʱ��
	public static int curyear , curmonth , curday ;
	// ��ǰ��ʾ��ʱ��
	public static int year, month, day ;
	public static int selectedDay ;
	private GregorianCalendar cal;
	public OneDay[] daysArray = new OneDay[42];
	public int startDay, endDay;

	public MyCalender()
	{
		GregorianCalendar gCalendar = (GregorianCalendar) Calendar.getInstance();
		year = gCalendar.get(Calendar.YEAR);
		month = (gCalendar.get(Calendar.MONTH) + 1);
		day = gCalendar.get(Calendar.DATE);
		curyear = gCalendar.get(Calendar.YEAR);
		curmonth = (gCalendar.get(Calendar.MONTH) + 1);
		curday = gCalendar.get(Calendar.DATE);
		selectedDay = curday ;
		for (int i = 0; i < 42; i++)
		{
			daysArray[i] = new OneDay();
		}
	}

	public void refreshDaysArray()
	{
		for (int i = 0; i < 42; i++)
		{
			daysArray[i] = new OneDay();
		}
//		
//		for (int i = 0; i < 42; i++)
//		{
//			daysArray[i].setDayText("");
//		}

		cal = new GregorianCalendar(year, month - 1, day);
		int d = cal.get(Calendar.DAY_OF_WEEK); // dΪ���µ�һ����һ���е�λ��

		int maxday; // �����������
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
			maxday = 31;
		else
			maxday = 30;
		if (month == 2 && cal.isLeapYear(year))
			maxday--;
		if (month == 2 && !cal.isLeapYear(year))
			maxday = 28;

		startDay = d + 3;
		if (startDay < 0)
			startDay += 7;
		if (startDay > 6)
			startDay -= 7;
		endDay = startDay + maxday - 1;
//		System.out.println(d + " " + startDay + " " + endDay);
		
		// ��ȡ�����б�
		File file = new File("src\\diary\\");
		String fileList[] = file.list();
		String postfix = ".bak";
		int size = 0;
		if (fileList != null) {
			size = fileList.length;
		}		
		
		for (int i = startDay, j = 1; j <= maxday; i++, j++) // ��ʾ������
		{
			String dayText = "";
			if (j < 10)
				dayText = "0" + j;
			else
				dayText = "" + j;

			String dayTitle = year + "";
			if (month < 10)
				dayTitle += "0" + month;
			else
				dayTitle += month;
			dayTitle += dayText;
			
			// ����Ƿ��б���
			for ( int k = 0 ; k < size ; k ++ )
			{
				if ( dayTitle.equals(fileList[k].substring(0, 8 )) ) 
				{
					daysArray[i].setHasReminder(true) ;
					break ;
				}
			}

			daysArray[i].setDayText(dayText);
			daysArray[i].setDayTitle(dayTitle);
			
		}
		
//		for (int kk = 0; kk < 42; kk++)
//		{
//			System.out.print(daysArray[kk].getHasReminder()?1:0);
//		}
//		System.out.println();
		
		//System.out.println("DaysArray refreshed !");
	}

	public OneDay[] getDaysArray()
	{
		return daysArray;
	}

}

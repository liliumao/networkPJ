package calenderProcess;

import java.io.File;
import java.util.Calendar;
import java.util.GregorianCalendar;

import utils.ChinaDate;

/**
 * ��ȡ������ʾ�������Լ�����ҳ��ʾ�����Ĳ�������
 * 
 * @author weijinshi
 * 
 */
public class MyCalender
{
	// ����ʱ��
	public static int curyear, curmonth, curday;
	// ��ǰ��ʾ��ʱ��
	private Calendar cal = Calendar.getInstance();
	public static int year, month, day;
	public static int selectedDay; // ��ǵ��������Ա������ʾ
	// ��������ʾ���� 42 ��button ���Ӧ�� һ�� OneDay ���飬ÿһ���������˵������Ϣ
	public OneDay[] daysArray = new OneDay[42];
	// ÿ���µ�һ������һ���� 42 �����������ǰ�ť�е���ʼλ�úͽ���λ�õ������±�
	public int startDay, endDay;

	public MyCalender()
	{
		year = cal.get(Calendar.YEAR);
		month = (cal.get(Calendar.MONTH) + 1);
		day = cal.get(Calendar.DATE);
		// ���õ�������
		GregorianCalendar gCalendar = (GregorianCalendar) Calendar.getInstance();
		curyear = gCalendar.get(Calendar.YEAR);
		curmonth = (gCalendar.get(Calendar.MONTH) + 1);
		curday = gCalendar.get(Calendar.DATE);
		selectedDay = curday;
		// ��ʼ�� 42 �� OneDay
		for (int i = 0; i < 42; i++)
		{
			daysArray[i] = new OneDay();
		}
	}

	/**
	 * ��ÿһ�η�һ�»�һ��ʱˢ�� ������ʾ���� 42 ����ť��Ӧ�� 42 �� oneday �е�����
	 */
	public void refreshDaysArray()
	{
		for (int i = 0; i < 42; i++)
		{
			daysArray[i] = new OneDay();
		}

		cal.set(year, month - 1, 1);

		int maxday = cal.getActualMaximum(Calendar.DATE); // �����������

		startDay = cal.get(Calendar.DAY_OF_WEEK) - 1;
		endDay = startDay + maxday;

		// ��ȡ�����б�
		File file = new File("src\\diary\\");
		String fileList[] = file.list();
		int size = 0;
		if (fileList != null)
		{
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

			dayText = "<html><p style=\"font: 16px bold; color:red\">" + dayText + "</p><p style=\"font: 10px\">";
			// ũ����ʾ
			dayText += ChinaDate.toChinaDay(year + "", month + "", j + "") + "</p></html>";

			// ����Ƿ��б���
			for (int k = 0; k < size; k++)
			{
				if (dayTitle.equals(fileList[k].substring(0, 8)))
				{
					daysArray[i].setHasReminder(true);
					break;
				}
			}

			daysArray[i].setDayText(dayText);
			daysArray[i].setDayTitle(dayTitle);

		}

	}

	/**
	 * ��� 42 �� oneday
	 * 
	 * @return
	 */
	public OneDay[] getDaysArray()
	{
		return daysArray;
	}

}

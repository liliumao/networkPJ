package calenderProcess;

import noteProcess.Reminder;

/**
 * ����һ����Ӧ��ÿһ�����ڵ��࣬��Ϊ����������ʾ����ϵ�ÿһ����ť���Ӧ
 * 
 * @author weijinshi
 * 
 */
public class OneDay
{
	private String dayText; // ��������� button ������ʾ������
	private String dayTitle; // ��������ڣ�����20130101������ð�ťʱ�������ťʱ�ʼǱ��༭���ı��⴦��ʾ���������
								// 2013��01��01�յıʼ�
	private boolean hasReminder; // �������Ƿ��Ѿ����ռ�
	private Reminder reminder; // �����ڶ�Ӧ���ռ�

	public OneDay()
	{
		setDayText("");
		setDayTitle("");
		setHasReminder(false);
		setReminder(null);
	}

	/**
	 * ��ȡ dayText
	 * 
	 * @return
	 */
	public String getDayText()
	{
		return dayText;
	}

	/**
	 * ��ȡ dayTitle
	 * 
	 * @return
	 */
	public String getDayTitle()
	{
		return dayTitle;
	}

	/**
	 * ��ȡ hasReminder
	 * 
	 * @return
	 */
	public boolean getHasReminder()
	{
		return hasReminder;
	}

	/**
	 * ��ȡ reminder
	 * 
	 * @return
	 */
	public Reminder getReminder()
	{
		return reminder;
	}

	/**
	 * ���� dayText
	 * 
	 * @return
	 */
	public void setDayText(String dayText)
	{
		this.dayText = dayText;
	}

	/**
	 * ���� dayTitle
	 * 
	 * @return
	 */
	public void setDayTitle(String dayTitle)
	{
		this.dayTitle = dayTitle;
	}

	/**
	 * ���� hasReminder
	 * 
	 * @return
	 */
	public void setHasReminder(boolean hasReminder)
	{
		this.hasReminder = hasReminder;
	}

	/**
	 * ���� reminder
	 * 
	 * @return
	 */
	public void setReminder(Reminder reminder)
	{
		this.reminder = reminder;
	}
}

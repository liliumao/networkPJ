package Test;

import java.sql.SQLException;
import java.util.*;

import noteProcess.*;

public class testBackup_db {
	public static void main(String[] args) throws SQLException {
		//����һϵ�е�ÿ���¼������Խ����1000-5000���ڵ����ڣ���������Խ��յ�Ӱ�졣
		int length = 10; //���Դ���
		GregorianCalendar[] days = new GregorianCalendar[length];
		String[] contents = new String[length];
		System.out.println("----Generated----");
		//����length��������ݣ���ʾǰ�ϴ���������
		for (int i = 0; i < length; i++) {
			GregorianCalendar day = getRandomDate();
			days[i] = day;
			String content = generateString();
			contents[i] = content;
			Backup_db.addReminder(day.get(Calendar.YEAR), (byte)(day.get(Calendar.MONTH) + 1), (byte)(day.get(Calendar.DAY_OF_MONTH)), content);
			System.out.println(day.get(Calendar.YEAR) + " " + (day.get(Calendar.MONTH) + 1) + " " + day.get(Calendar.DAY_OF_MONTH) + "\t" + content);
		}
		
		//����Щ���ݴӷ����������������ٽ��бȽ�
		ArrayList<Reminder> res = Backup_db.getReminder();
		System.out.println("----From Server----");
		for (Reminder rd: res) {
			System.out.println(rd.getYear() + " " + rd.getMonth() + " " + rd.getDay() + "\t" + rd.getContent());
		}
		
		//����������ɾ��
		for (int i = 0; i < length; i++) {
			GregorianCalendar day = days[i];
			String content = contents[i];
			Backup_db.deleteReminder(day.get(Calendar.YEAR), (byte)(day.get(Calendar.MONTH) + 1), (byte)(day.get(Calendar.DAY_OF_MONTH)));
		}
		
		/*GregorianCalendar gc = new GregorianCalendar();
		gc.add(Calendar.DAY_OF_YEAR, 1000);
		
		for (int i = 0; i < 4000; i++) {
			Backup_db.deleteReminder(gc.get(Calendar.YEAR), (byte)(gc.get(Calendar.MONTH) + 1), (byte)(gc.get(Calendar.DAY_OF_MONTH)));
			gc.add(Calendar.DAY_OF_YEAR, 1);
			System.out.println(i);
		}*/
		
		
		
	}
	
	private static GregorianCalendar getRandomDate() {
		GregorianCalendar day = new GregorianCalendar();
		int off = (int) (4000 * Math.random() + 1000);
		day.add(Calendar.DAY_OF_YEAR, off);
		return day;
	}
	
	private static String generateString() {
		StringBuffer sb = new StringBuffer();
		int length = (int) (Math.random() * 50);
		for (int i = 0; i < length; i++) {
			char tmp = (char)(96 * Math.random() + 32);
			sb.append(tmp);
		}
		
		return sb.toString();
	}
	
}

package Test;

import noteProcess.*;

public class testEncryption {
	public static void main(String[] args) {
		for (int i = 0; i < 50; i++)
			System.out.println(test());
	}
	
	private static boolean test() {
		//���������һ��String
		String st = generateString();
		//���ӽ��ܺ�ʱ����ԭStringһ��
		return st.equals(Encryption.decryption(Encryption.encryption(st)));
	}
	
	private static String generateString() {
		StringBuffer sb = new StringBuffer();
		int length = (int) (Math.random() * 40);
		for (int i = 0; i < length; i++) {
			char tmp = (char)(96 * Math.random() + 32);
			sb.append(tmp);
		}
		
		return sb.toString();
	}
}

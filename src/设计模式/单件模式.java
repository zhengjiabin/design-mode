package ���ģʽ;

public class ����ģʽ {

	/*	ȷ������uniqueInstance��������ʼ���ɵ���ģʽʵ��ʱ��
	 *	����߳���ȷ�ش���uniqueInstance����
	 */
	private volatile static ����ģʽ uniqueInstance;
	
	private ����ģʽ(){
		
	}
	
	public static ����ģʽ getInstance(){
		if(uniqueInstance == null){
			synchronized (����ģʽ.class){
				if(uniqueInstance == null){
					uniqueInstance = new ����ģʽ();
				}
			}
		}
		return uniqueInstance;
	}
}

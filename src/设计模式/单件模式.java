package 设计模式;

public class 单件模式 {

	/*	确保：当uniqueInstance变量被初始化成单件模式实例时，
	 *	多个线程正确地处理uniqueInstance变量
	 */
	private volatile static 单件模式 uniqueInstance;
	
	private 单件模式(){
		
	}
	
	public static 单件模式 getInstance(){
		if(uniqueInstance == null){
			synchronized (单件模式.class){
				if(uniqueInstance == null){
					uniqueInstance = new 单件模式();
				}
			}
		}
		return uniqueInstance;
	}
}

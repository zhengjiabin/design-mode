package ���ģʽ;

abstract class Parents{
	final void doSomethings(){
		firstthing();
		secondthing();
		//����
		if(isDoThirdthing()){
			thirdthing();
		}
		lastting();
	}
	abstract void secondthing();
	abstract void lastting();
	
	public boolean isDoThirdthing(){
		return true;
	}
	public void firstthing(){
		System.out.println("firstthing");
	}
	public void thirdthing(){
		System.out.println("thirdthing");
	}
}

public class ģ�巽��ģʽ  extends Parents{
	@Override
	void secondthing() {
		System.out.println("secondthing");
	}
	@Override
	void lastting() {
		System.out.println("lastting");
	}
	public static void main(String[] args) {
		ģ�巽��ģʽ test = new ģ�巽��ģʽ();
		test.doSomethings();
	}
}

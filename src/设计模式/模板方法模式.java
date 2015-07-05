package 设计模式;

abstract class Parents{
	final void doSomethings(){
		firstthing();
		secondthing();
		//钩子
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

public class 模板方法模式  extends Parents{
	@Override
	void secondthing() {
		System.out.println("secondthing");
	}
	@Override
	void lastting() {
		System.out.println("lastting");
	}
	public static void main(String[] args) {
		模板方法模式 test = new 模板方法模式();
		test.doSomethings();
	}
}

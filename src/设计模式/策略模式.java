package 设计模式;

/**
 * 易变方法做成接口
 */
interface FlyBehavior{
	public void fly();
}
interface QuackBehavior{
	public void quack();
}

//实现相应接口功能
class FlyWithWings implements FlyBehavior{
	@Override
	public void fly() {
		//do somethings
	}
}
class FlyNoWay implements FlyBehavior{
	@Override
	public void fly() {
		//do somethings
	}
}
class Quack implements QuackBehavior{
	@Override
	public void quack() {
		// do somethings
	}
}

//父类---不易变的写成方法，易变的用接口代替
class Duck{
	public FlyBehavior flyBehavior;//易变的写成接口调用
	public QuackBehavior quackBehavior;
	
	public FlyBehavior getFlyBehavior() {
		return flyBehavior;
	}

	public void setFlyBehavior(FlyBehavior flyBehavior) {
		this.flyBehavior = flyBehavior;
	}

	public QuackBehavior getQuackBehavior() {
		return quackBehavior;
	}

	public void setQuackBehavior(QuackBehavior quackBehavior) {
		this.quackBehavior = quackBehavior;
	}

	public void performQuack(){
		quackBehavior.quack();
	}
	
	public void performFly(){
		flyBehavior.fly();
	}
	
	public void swim(){
	//do somethings
	}
	public void display(){
		//do somethings
	}
}

public class 策略模式  extends Duck{

	public static void main(String[] args) {
		策略模式  test = new 策略模式 ();
		test.setFlyBehavior(new FlyWithWings());
		test.performFly();
		
		test.setQuackBehavior(new Quack());
		test.performQuack();
	}
}
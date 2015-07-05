package ���ģʽ;

/**
 * �ױ䷽�����ɽӿ�
 */
interface FlyBehavior{
	public void fly();
}
interface QuackBehavior{
	public void quack();
}

//ʵ����Ӧ�ӿڹ���
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

//����---���ױ��д�ɷ������ױ���ýӿڴ���
class Duck{
	public FlyBehavior flyBehavior;//�ױ��д�ɽӿڵ���
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

public class ����ģʽ  extends Duck{

	public static void main(String[] args) {
		����ģʽ  test = new ����ģʽ ();
		test.setFlyBehavior(new FlyWithWings());
		test.performFly();
		
		test.setQuackBehavior(new Quack());
		test.performQuack();
	}
}
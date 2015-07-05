package ���ģʽ;

interface DuckTest{
	public void quack();
	public void fly();
}

interface TurkeyTest{
	public void gobble();
	public void fly();
}

class WildTurkey implements TurkeyTest{
	@Override
	public void gobble() {
		System.out.println("WildTurkey gobble");
	}
	@Override
	public void fly() {
		System.out.println("WildTurkey fly");
	}
}

class TurkeyAdapter implements DuckTest{
	TurkeyTest turkey;
	//���䷽ʽ--���
	public TurkeyAdapter(TurkeyTest turkey){
		this.turkey = turkey;
	}
	@Override
	public void quack() {
		turkey.gobble();
	}
	@Override
	public void fly() {
		turkey.fly();
	}
}
public class ������ģʽ {
	public static void main(String[] args) {
		WildTurkey wildTurkey = new WildTurkey();
		DuckTest duck = new TurkeyAdapter(wildTurkey);
		duck.quack();
		duck.fly();
	}
}

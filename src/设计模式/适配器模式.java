package 设计模式;

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
	//适配方式--组合
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
public class 适配器模式 {
	public static void main(String[] args) {
		WildTurkey wildTurkey = new WildTurkey();
		DuckTest duck = new TurkeyAdapter(wildTurkey);
		duck.quack();
		duck.fly();
	}
}

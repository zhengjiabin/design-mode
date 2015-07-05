package 设计模式;

//超类
abstract class Beverage{
	private String value = "Beverage";
	public String getValue(){
		return value;
	}
	public void setValue(String value){
		this.value = value;
	}
	public abstract double cost();
}

class Espresso extends Beverage{
	@Override
	public double cost() {
		return 1;
	}
	public Espresso(){
		setValue("Espresso");
	}
}

class HouseBlend extends Beverage{
	@Override
	public double cost() {
		return 2;
	}
	public HouseBlend(){
		setValue("HouseBlend");
	}
}

abstract class CondimentDecorator extends Beverage{
	public abstract String getValue();
}

class Mocha extends CondimentDecorator{
	Beverage beverage;
	public Mocha(Beverage beverage){
		this.beverage = beverage;
		setValue("Mocha");
	}
	@Override
	public String getValue() {
		return beverage.getValue()+",Mocha";
	}
	@Override
	public double cost() {
		return 3;
	}
}

class Soy extends CondimentDecorator{
	Beverage beverage;
	public Soy(Beverage beverage){
		this.beverage = beverage;
		setValue("Soy");
	}
	@Override
	public String getValue() {
		return beverage.getValue()+",Soy";
	}
	@Override
	public double cost() {
		return 3;
	}
}

public class 装饰者模式 {
	public static void main(String[] args) {
		Beverage beverage = new Espresso();
		System.out.println(beverage.getValue());
		
		Beverage beverage2 = new HouseBlend();
		beverage2 = new Mocha(beverage2);
		System.out.println(beverage2.getValue());
	}
}

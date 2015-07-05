package 设计模式;

//产品超类
abstract class Pizzax {
	public Pizzax() {
		System.out.println("Pizza");
	}
	abstract void doSomethings();
}

//产品子类1
class NYStyleCheesePizzax extends Pizzax {
	PizzaxIngredientFactory ingredientFactory;
	public NYStyleCheesePizzax(PizzaxIngredientFactory ingredientFactory) {
		System.out.println("NYStyleCheesePizza");
		this.ingredientFactory = ingredientFactory;
	}
	@Override
	void doSomethings() {
		ingredientFactory.detailPizzax();
	}
}

//产品子类2
class ChicagoStyleCheesePizzax extends Pizzax {
	PizzaxIngredientFactory ingredientFactory;
	public ChicagoStyleCheesePizzax(PizzaxIngredientFactory ingredientFactory) {
		System.out.println("ChicagoStyleCheesePizza");
		this.ingredientFactory = ingredientFactory;
	}

	@Override
	void doSomethings() {
		ingredientFactory.detailPizzax();
	}
}

//产品原材料接口
interface PizzaxIngredientFactory {
	public void detailPizzax();
}

//产品原材料实现类
class NYPizzaxIngredientFactory implements PizzaxIngredientFactory {
	@Override
	public void detailPizzax() {
		System.out.println("NYPizzaxIngredientFactory");
	}
}

//工厂超类--分离产品制作过程
abstract class PizzaStorex {
	public Pizzax orderPizza(String type) {
		Pizzax pizza = createPizza(type);
		pizza.doSomethings();
		return pizza;
	}
	public abstract Pizzax createPizza(String type);
}

//工厂子类1
class NYPizzaStorex extends PizzaStorex {
	public Pizzax createPizza(String type){
		PizzaxIngredientFactory ingredientFactory = new NYPizzaxIngredientFactory();
		if("cheese".equals(type)) {
			return new NYStyleCheesePizzax(ingredientFactory);
		}else {
			return null;
		}
	}
}

public class 工厂模式之抽象工厂 {
	public static void main(String[] args) {
		PizzaStorex nyStore = new NYPizzaStorex();
		
		Pizzax pizza1 = nyStore.orderPizza("cheese");
		pizza1.doSomethings();
	}
}

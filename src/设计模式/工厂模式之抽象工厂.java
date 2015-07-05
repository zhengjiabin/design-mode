package ���ģʽ;

//��Ʒ����
abstract class Pizzax {
	public Pizzax() {
		System.out.println("Pizza");
	}
	abstract void doSomethings();
}

//��Ʒ����1
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

//��Ʒ����2
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

//��Ʒԭ���Ͻӿ�
interface PizzaxIngredientFactory {
	public void detailPizzax();
}

//��Ʒԭ����ʵ����
class NYPizzaxIngredientFactory implements PizzaxIngredientFactory {
	@Override
	public void detailPizzax() {
		System.out.println("NYPizzaxIngredientFactory");
	}
}

//��������--�����Ʒ��������
abstract class PizzaStorex {
	public Pizzax orderPizza(String type) {
		Pizzax pizza = createPizza(type);
		pizza.doSomethings();
		return pizza;
	}
	public abstract Pizzax createPizza(String type);
}

//��������1
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

public class ����ģʽ֮���󹤳� {
	public static void main(String[] args) {
		PizzaStorex nyStore = new NYPizzaStorex();
		
		Pizzax pizza1 = nyStore.orderPizza("cheese");
		pizza1.doSomethings();
	}
}

package 设计模式;

//产品超类
abstract class Pizza {
	public Pizza() {
		System.out.println("Pizza");
	}
	public void doSomethings(){
		System.out.println("doSomethings");
	}
}

//产品子类1
class NYStyleCheesePizza extends Pizza {
	public NYStyleCheesePizza() {
		System.out.println("NYStyleCheesePizza");
	}
}

//产品子类2
class ChicagoStyleCheesePizza extends Pizza {
	public ChicagoStyleCheesePizza() {
		System.out.println("ChicagoStyleCheesePizza");
	}
}

//工厂超类
abstract class PizzaStore {
	public Pizza orderPizza(String type) {
		Pizza pizza = createPizza(type);
		pizza.doSomethings();
		return pizza;
	}
	public abstract Pizza createPizza(String type);
}

//工厂子类1
class NYPizzaStore extends PizzaStore {
	public Pizza createPizza(String type){
		if("cheese".equals(type)) {
			return new NYStyleCheesePizza();
		}else {
			return null;
		}
	}
}

//工厂子类2
class ChicagoPizzaStore extends PizzaStore {
	public Pizza createPizza(String type){
		if("cheese".equals(type)) {
			return new ChicagoStyleCheesePizza();
		}else {
			return null;
		}
	}
}

public class 工厂模式之工厂方法 {
	public static void main(String[] args) {
		PizzaStore nyStore = new NYPizzaStore();
		PizzaStore chicagoStore = new ChicagoPizzaStore();
		
		Pizza pizza1 = nyStore.orderPizza("cheese");
		pizza1.doSomethings();
		
		Pizza pizza2 = chicagoStore.orderPizza("cheese");
		pizza2.doSomethings();
	}
}

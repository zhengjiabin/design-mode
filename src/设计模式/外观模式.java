package 设计模式;

interface DoOnething{
	public void doOnethings();
}
interface DoTwothing{
	public void doTwothings();
}
interface DoThreething{
	public void doThreethings();
}
interface DoFourthing{
	public void doFourthings();
}

class TestDoOnething implements DoOnething{
	@Override
	public void doOnethings() {
		System.out.println("TestDoOnething");
	}
}
class TestDoTwothing implements DoTwothing{
	@Override
	public void doTwothings() {
		System.out.println("TestDoTwothing");
	}
}
class TestDoThreething implements DoThreething{
	@Override
	public void doThreethings() {
		System.out.println("TestDoThreething");
	}
}
class TestDoFourthing implements DoFourthing{
	@Override
	public void doFourthings() {
		System.out.println("TestDoFourthing");
	}
}

class Facade{
	DoOnething doOnething;
	DoTwothing doTwothing;
	DoThreething doThreething;
	DoFourthing doFourhing;
	public Facade(DoOnething doOnething,DoTwothing doTwothing,DoThreething doThreething,DoFourthing doFourhing){
		this.doOnething = doOnething;
		this.doTwothing = doTwothing;
		this.doThreething = doThreething;
		this.doFourhing = doFourhing;
	}
	public void doSomethings(){
		doOnething.doOnethings();
		doTwothing.doTwothings();
		
	}
	public void doOtherthings(){
		doThreething.doThreethings();
		doFourhing.doFourthings();
	}
}

public class 外观模式 {
	public static void main(String[] args) {
		DoOnething doOnething = new TestDoOnething();
		DoTwothing doTwothing = new TestDoTwothing();
		DoThreething doThreething = new TestDoThreething();
		DoFourthing doFourthing = new TestDoFourthing();
		
		Facade facade = new Facade(doOnething, doTwothing, doThreething, doFourthing);
		facade.doSomethings();
		facade.doOtherthings();
	}
}

package 设计模式;

import java.util.ArrayList;
import java.util.Observable;

//主题接口
interface Subject{
	//用于注册观察者
	public void registerObserver(Observer o);
	//用于删除观察者
	public void removeObserver(Observer o);
	//主题状态改变时，用于通知观察者
	public void notifyObserver();
}

//主题实现类
class WeatherData implements Subject{
	private ArrayList<Observer> observers;
	private Object value;
	
	public WeatherData(){
		observers = new ArrayList<Observer>();
	}

	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		observers.remove(o);
	}
	//通知观察者
	@Override
	public void notifyObserver() {
		for(Observer o:observers){
			o.update(value);
		}
	}
	//当发现状态改变时，通知观察者
	public void measurementsChanged(){
		notifyObserver();
	}
	//获取状态改变的数据
	public void setMeasurements(Object value){
		this.value=value;
		measurementsChanged();
	}
}

//观察者接口
interface Observer{
	//状态改变时，更新数据
	public void update(Object value);
}

//观察者行为接口
interface DisplayElement{
	//观察者预做的事情
	public void display();
}

//观察者实现类
class CurrentConditionsDisplay implements Observer,DisplayElement{
	
	private Object value;
	//主题，用于注册
	private Subject weatherData;
	
	public CurrentConditionsDisplay(Subject weatherData){
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}
	
	@Override
	public void update(Object value) {
		//更新数据
		this.value = value;
		display();
	}

	@Override
	public void display() {
		System.out.println(value);
	}
}

/**
 * 主题对象+观察者对象 = 观察者模式
 */
public class 观察者模式 {
	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		CurrentConditionsDisplay ccd = new CurrentConditionsDisplay(weatherData);
		weatherData.setMeasurements("test");
	}
}

//java内置观察者模式
//主题
class Title extends Observable{
	private Object value;
	
	public Title(){
		
	}
	
	public void measurementsChanged(){
		//需先调用setChanged(),指示状态已经改变
		setChanged();
		notifyObservers();
	}
	//做自己要做的事
	public void doSomething(){
		
	}
}
//观察者
class Weather implements java.util.Observer,DisplayElement{
	private Observable observable;
	
	public Weather(Observable observable){
		this.observable = observable;
		observable.addObserver(this);
	}
	@Override
	public void update(Observable observable, Object obj) {
		display();
	}
	//做自己要做的事
	public void display(){
		
	}
}
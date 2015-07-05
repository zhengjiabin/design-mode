package ���ģʽ;

import java.util.ArrayList;
import java.util.Observable;

//����ӿ�
interface Subject{
	//����ע��۲���
	public void registerObserver(Observer o);
	//����ɾ���۲���
	public void removeObserver(Observer o);
	//����״̬�ı�ʱ������֪ͨ�۲���
	public void notifyObserver();
}

//����ʵ����
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
	//֪ͨ�۲���
	@Override
	public void notifyObserver() {
		for(Observer o:observers){
			o.update(value);
		}
	}
	//������״̬�ı�ʱ��֪ͨ�۲���
	public void measurementsChanged(){
		notifyObserver();
	}
	//��ȡ״̬�ı������
	public void setMeasurements(Object value){
		this.value=value;
		measurementsChanged();
	}
}

//�۲��߽ӿ�
interface Observer{
	//״̬�ı�ʱ����������
	public void update(Object value);
}

//�۲�����Ϊ�ӿ�
interface DisplayElement{
	//�۲���Ԥ��������
	public void display();
}

//�۲���ʵ����
class CurrentConditionsDisplay implements Observer,DisplayElement{
	
	private Object value;
	//���⣬����ע��
	private Subject weatherData;
	
	public CurrentConditionsDisplay(Subject weatherData){
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}
	
	@Override
	public void update(Object value) {
		//��������
		this.value = value;
		display();
	}

	@Override
	public void display() {
		System.out.println(value);
	}
}

/**
 * �������+�۲��߶��� = �۲���ģʽ
 */
public class �۲���ģʽ {
	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		CurrentConditionsDisplay ccd = new CurrentConditionsDisplay(weatherData);
		weatherData.setMeasurements("test");
	}
}

//java���ù۲���ģʽ
//����
class Title extends Observable{
	private Object value;
	
	public Title(){
		
	}
	
	public void measurementsChanged(){
		//���ȵ���setChanged(),ָʾ״̬�Ѿ��ı�
		setChanged();
		notifyObservers();
	}
	//���Լ�Ҫ������
	public void doSomething(){
		
	}
}
//�۲���
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
	//���Լ�Ҫ������
	public void display(){
		
	}
}
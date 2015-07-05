package 设计模式;

import java.util.ArrayList;
import java.util.Iterator;

interface Menu{
	public Iterator<MenuItem> createIterator();
}
class MenuItem{
	String name;
	public MenuItem(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
}
class OneMenuItem implements Menu{
	ArrayList<MenuItem> menuItems;
	public OneMenuItem(){
		menuItems = new ArrayList<MenuItem>();
		addItem("OneMenuItem-1");
		addItem("OneMenuItem-2");
	}
	public void addItem(String name){
		MenuItem menuItem= new MenuItem(name);
		menuItems.add(menuItem);
	}
	public ArrayList<MenuItem> getMenuItems(){
		return menuItems;
	}
	@Override
	public Iterator<MenuItem> createIterator() {
		return menuItems.iterator();
	}
}
class TwoMenuItem implements Menu{
	static final int MAX_IDX = 6;
	int idx = 0;
	MenuItem[] menuItems;
	public TwoMenuItem(){
		menuItems = new MenuItem[MAX_IDX];
		addItem("TwoMenuItem-1");
		addItem("TwoMenuItem-2");
	}
	public void addItem(String name){
		MenuItem menuItem= new MenuItem(name);
		if(idx >= MAX_IDX){
			System.out.println("超值");
		}else{
			menuItems[idx] = menuItem;
			idx++;
		}
	}
	public MenuItem[] getMenuItems(){
		return menuItems;
	}
	@Override
	public Iterator<MenuItem> createIterator() {
		return new TwoMenuIterator(menuItems);
	}
}
//使用迭代模式
class TwoMenuIterator implements Iterator<MenuItem>{
	MenuItem[] menuItems;
	int idx = 0;
	public TwoMenuIterator(MenuItem[] menuItems){
		this.menuItems = menuItems;
	}
	@Override
	public boolean hasNext() {
		return idx >= menuItems.length || menuItems[idx] == null?false:true;
	}
	@Override
	public MenuItem next() {
		return menuItems[idx++];
	}
	@Override
	public void remove() {
		if(idx <=0){
			throw new IllegalStateException();
		}
		if(menuItems[idx-1] !=null){
			for(int i = idx -1;i<menuItems.length-1;i++){
				menuItems[i] = menuItems[i+1];
			}
			menuItems[menuItems.length-1] = null;
		}
	}
}

class TestMenuIterator{
	ArrayList<Menu> items = null;
	public TestMenuIterator(ArrayList<Menu> items){
		this.items = items;
	}
	public void printMenu(){
		
		for(Menu menu : items){
			Iterator<MenuItem> iterator = menu.createIterator();
			printMenu(iterator);
		}
	}
	private void printMenu(Iterator<MenuItem> iterator){
		while(iterator.hasNext()){
			MenuItem menuItem = iterator.next();
			System.out.println(menuItem.getName());
		}
	}
}

public class 迭代器模式 {
	public static void main(String[] args) {
		OneMenuItem oneMenuItem = new OneMenuItem();
		TwoMenuItem twoMenuItem = new TwoMenuItem();
		
		ArrayList<Menu> items = new ArrayList<Menu>();
		items.add(oneMenuItem);
		items.add(twoMenuItem);
		TestMenuIterator test = new TestMenuIterator(items);
		test.printMenu();
	}
}

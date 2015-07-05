package 设计模式;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

interface MenuIterface {
    public Iterator<MenuComponent> createIterator();
}

/**
 * 组合模式
 * 
 * @author Administrator
 * 
 */
abstract class MenuComponent implements MenuIterface {
    public void add(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }
    
    public void remove(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }
    
    public MenuComponent getChild(int i) {
        throw new UnsupportedOperationException();
    }
    
    public String getName() {
        throw new UnsupportedOperationException();
    }
    
    public void print() {
        throw new UnsupportedOperationException();
    }
}

class MenuItemTest extends MenuComponent {
    String name;
    
    public MenuItemTest(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void print() {
        System.out.println(name);
    }
    
    @Override
    public Iterator<MenuComponent> createIterator() {
        return new NullIterator();
    }
}

class MenuTest extends MenuComponent implements MenuIterface {
    ArrayList<MenuComponent> menuComponents = new ArrayList<MenuComponent>();
    
    String name;
    
    public MenuTest(String name) {
        this.name = name;
    }
    
    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }
    
    public void remove(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }
    
    public MenuComponent getChild(int i) {
        return menuComponents.get(i);
    }
    
    public String getName() {
        return name;
    }
    
    public void print() {
        for (MenuComponent menuComponent : menuComponents) {
            menuComponent.print();
        }
    }
    
    @Override
    public Iterator<MenuComponent> createIterator() {
        return new CompositeIterator(menuComponents.iterator());
    }
}

class CompositeIterator implements Iterator<MenuComponent> {
    Stack<Iterator<MenuComponent>> stack = new Stack<Iterator<MenuComponent>>();
    
    public CompositeIterator(Iterator<MenuComponent> iterator) {
        stack.push(iterator);
    }
    
    @Override
    public boolean hasNext() {
        if (stack.empty()) {
            return false;
        }
        Iterator<MenuComponent> iterator = (Iterator<MenuComponent>)stack.peek();
        if (!iterator.hasNext()) {
            stack.pop();
            return hasNext();
        }
        return true;
    }
    
    @Override
    public MenuComponent next() {
        if (hasNext()) {
            Iterator<MenuComponent> iterator = (Iterator<MenuComponent>)stack.peek();
            MenuComponent component = (MenuComponent)iterator.next();
            if (component instanceof MenuTest) {
                stack.push(((MenuTest)component).createIterator());
            }
            return component;
        }
        return null;
    }
    
    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
    
}

class MenuComponentTest {
    MenuComponent allMenus;
    
    public MenuComponentTest(MenuComponent allMenus) {
        this.allMenus = allMenus;
    }
    
    public void printMenu() {
        allMenus.print();
    }
    
    public void printAllMenu() {
        Iterator<MenuComponent> iterator = allMenus.createIterator();
        while (iterator.hasNext()) {
            MenuComponent menuComponent = (MenuComponent)iterator.next();
            menuComponent.print();
        }
    }
}

class NullIterator implements Iterator<MenuComponent> {
    @Override
    public boolean hasNext() {
        return false;
    }
    
    @Override
    public MenuComponent next() {
        return null;
    }
    
    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}

public class 组合模式 {
    public static void main(String[] args) {
        MenuComponent oneItem = new MenuItemTest("oneItem");
        
        MenuComponent oneMenu = new MenuTest("oneMenu");
        oneMenu.add(oneItem);
        
        MenuComponent allMenus = new MenuTest("allMenu");
        allMenus.add(oneMenu);
        
        MenuComponentTest test = new MenuComponentTest(allMenus);
        test.printMenu();
    }
}

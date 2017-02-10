package net.antra.springdemo.simulatedcontainer;

import java.util.HashMap;
import java.util.Map;

public class Container {
	Map<String, Object> namedBeans = new HashMap<>();
	Map<Class, Object> typedBeans = new HashMap<>();
	
	Container(){
		Apple a = new Apple("Green");
		namedBeans.put("apple", a);
		typedBeans.put(Apple.class, a);
		AppleTree at = new AppleTree();
		at.setApple(a);
		typedBeans.put(AppleTree.class, at);
	}
	
	public Object getBean(String beanName){
		return namedBeans.get(beanName);
	}
	public Object getBean(Class type){
		return typedBeans.get(type);
	}
	
	public static void main(String[] args) {
		Container c = new Container();
//		Apple a = (Apple)c.getBean("apple");
//		System.out.println(a.getColor());
//		a.setColor("Black");
//		Apple a1 = (Apple)c.getBean(Apple.class);
//		System.out.println(a.getColor());
		
		AppleTree at = (AppleTree)c.getBean(AppleTree.class);
		at.printApple();
	}
}

package net.antra.springdemo.simulatedcontainer;

public class AppleTree {
	
	private Apple apple;

	public AppleTree() {}

	public AppleTree(Apple apple) {
		this.apple = apple;
	}

	public Apple getApple() {
		return apple;
	}

	public void setApple(Apple apple) {
		this.apple = apple;
	}
	
	public void printApple(){
		System.out.println(apple.getColor());
	}

}

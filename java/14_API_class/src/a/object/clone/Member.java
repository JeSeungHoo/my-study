package a.object.clone;

import java.util.Arrays;

public class Member implements Cloneable{
	public String name;
	public int age;
	public int[] scores;
	public Car car;
	
	// alt + s + a
	public Member(String name, int age, int[] scores, Car car) {
		this.name = name;
		this.age = age;
		this.scores = scores;
		this.car = car;
	}
	// alt +s +s +s 
	@Override
	public String toString() {
		// return super.toString();
		return "Member [name=" + name + ", age=" + age + ", scores=" + Arrays.toString(scores) + ", car=" + car + "]";
	}
	//alt + s + v
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Member cloned = (Member)super.clone();
		int[] score = new int[this.scores.length];
		for(int i=0; i < this.scores.length; i++) {
			score[i] = this.scores[i];
		}
		cloned.scores = score;
		Car cae = new Car(this.car.model);
		cloned.car = cae;
		// return super.clone();
		return cloned;
	}

}










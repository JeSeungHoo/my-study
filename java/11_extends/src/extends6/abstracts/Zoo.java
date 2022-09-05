package extends6.abstracts;

public class Zoo {
	
	static void animalSound(Animal animal) {
		animal.sound();
		animal.breath();
	}

	public static void main(String[] args) {
//		Animal animal = new Animal();
		Dog dog = new Dog();
		dog.breath();
		dog.sound();
		dog.kind = "Jindo";
		
		Cat cat = new Cat();
		cat.breath();
		cat.sound();
		cat.kind = "load";
		
		animalSound(cat);
		animalSound(dog);
		
		Animal navi = new Cat();
		animalSound(navi);
		
		Animal tiger = new Animal() {
			@Override
			public void sound() {
				System.out.println("어흥");
			}
		};
		animalSound(tiger);
	}

}











package generic01_type;

public class BoxExample {

	public static void main(String[] args) {
		Box box1 = new Box();
		Apple apple = new Apple();
		// box1.obj = apple;	// 접근 불가
		box1.setObj(apple);
		
		Box box2 = new Box();
		Orange orange = new Orange();
		box2.setObj(orange);
		
		if(box1.getObj() instanceof Orange) {
			Orange oran = (Orange)box1.getObj();
			System.out.println("Orange 가 들어가 있습니다.");
		}
		
		// Apple ap = (Apple)box2.getObj();
		
		
		// showbox
		ShowBox<Apple> box = new ShowBox<Apple>();
		//box.setT(orange);
		box.setT(apple);
		
		Apple apple1 = box.getT();
		
		ShowBox<Orange> orangeBox = new ShowBox<>();
		orangeBox.setT(orange);
		Orange orange1 = orangeBox.getT();
	}

}












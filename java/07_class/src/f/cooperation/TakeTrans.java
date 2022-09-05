package f.cooperation;

public class TakeTrans {

	public static void main(String[] args) {
		Student studentPark = new Student("박태환",8000);
		Student studentSong = new Student("송아지",2,20000);
		
		Bus bus100 = new Bus(100);
		studentPark.takeBus(bus100);
		bus100.showInfo();
		
		Subway subwayGreen = new Subway("2호선");
		studentSong.takeSubway(subwayGreen);
		studentSong.showInfo();
		subwayGreen.showInfo();
		
		Worker workerChoi = new Worker("최기근",2100000000);
		workerChoi.takeVehicle(bus100);
		workerChoi.showInfo();
		bus100.showInfo();
		
		
	}

}












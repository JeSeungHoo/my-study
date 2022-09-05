package generic05_wildcard;

public class Course<S> {
	
	private String name;	// 수강 과정 이름
	private S[] students;	// 수강생 정보를 저장할 배열
	
	public Course(String name, int capacity) {
		this.name = name;
		this.students = (S[])new Object[capacity];
	}
	// alt + s + r : select getters
	public String getName() {
		return name;
	}

	public S[] getStudents() {
		return students;
	}
	
	public void add(S s) {
		for(int i=0; i<students.length; i++) {
			if(students[i] == null) {
				students[i] = s;
				break;
			}
		}
	}
}













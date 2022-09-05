package b.defaults;

public interface Printable {
	
	void print();
	
	default void colorPrint() {}
	
}

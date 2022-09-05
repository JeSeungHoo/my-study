package b.defaults;

public class Window {
	
	public void print(Printable printer) {
		printer.print();
	}

	public static void main(String[] args) {
		Window windows = new Window();
		Printable lgPrinter = new LGPrinter();
		Printable hpPrinter = new HPPrinter();
		windows.print(lgPrinter);
		windows.print(hpPrinter);
	}

}












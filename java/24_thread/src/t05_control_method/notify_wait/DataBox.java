package t05_control_method.notify_wait;

public class DataBox {
	
	private String data;

	synchronized public String getData() {
		if(this.data == null) {
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		String value = this.data;
		this.data = null;
		System.out.println("읽은 데이터 : " + value);
		notify();
		return value;
	}

	public synchronized void setData(String data) {
		if(this.data != null) {
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		this.data = data;
		System.out.println("생성한 데이터 : " + data);
		notify();
	}
	
	

}

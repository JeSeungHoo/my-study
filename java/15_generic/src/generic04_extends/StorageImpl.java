package generic04_extends;

public class StorageImpl<E> implements Storage<E>{
	
	private E[] array;
	
	@SuppressWarnings("unchecked")
	public StorageImpl(int capacity) {
		Object[] o = new Object[capacity];
		//this.array = new E[capacity];
		this.array = (E[])o;
	}
	
	@Override
	public void add(E item, int index) {
		array[index] = item;
	}

	@Override
	public E get(int index) {
		return array[index];
	}

}






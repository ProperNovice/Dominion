package utils;

import enums.ObjectPoolEnum;

public enum ObjectPoolSingleton {

	INSTANCE;

	private HashMap<ObjectPoolEnum, ArrayList<Object>> released = new HashMap<>();

	public Object pullObject(ObjectPoolEnum objectPoolEnum, ObjectPoolAble objectPoolAble) {

		if (!this.released.containsKey(objectPoolEnum))
			this.released.put(objectPoolEnum, new ArrayList<Object>());

		if (this.released.get(objectPoolEnum).isEmpty())
			this.released.get(objectPoolEnum).addFirst(objectPoolAble.getObject());

		return this.released.get(objectPoolEnum).removeFirst();

	}

	public void releaseObject(ObjectPoolEnum objectPoolEnum, Object object) {
		this.released.get(objectPoolEnum).addFirst(object);
	}

	public void print(ObjectPoolEnum objectPoolEnum) {
		Logger.logNewLine(this.released.get(objectPoolEnum).size() + " released");
	}

}

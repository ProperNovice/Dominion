package utils;

public enum ObjectPoolSingleton {

	INSTANCE;

	private HashMap<String, ArrayList<Object>> released = new HashMap<>();

	public Object pullObject(ObjectPoolAble hashMapKey) {
		return pullObject(hashMapKey.toString(), hashMapKey);
	}

	public Object pullObject(String hashMapKey, ObjectPoolAble objectPoolAble) {

		if (!this.released.containsKey(hashMapKey.toString()))
			this.released.put(hashMapKey.toString(), new ArrayList<Object>());

		if (this.released.get(hashMapKey.toString()).isEmpty())
			this.released.get(hashMapKey.toString()).addFirst(objectPoolAble.getObject());

		return this.released.get(hashMapKey.toString()).removeFirst();

	}

	public void releaseObject(Object object, ObjectPoolAble hashMapKey) {
		releaseObject(object, hashMapKey.toString());
	}

	public void releaseObject(Object object, String hashMapKey) {
		this.released.get(hashMapKey).addFirst(object);
	}

	public void print(ObjectPoolAble objectPoolAble) {
		Logger.logNewLine(this.released.get(objectPoolAble.toString()).size() + " released");
	}

}

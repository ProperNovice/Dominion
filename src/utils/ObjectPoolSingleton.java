package utils;

import enums.ObjectPoolEnum;

public enum ObjectPoolSingleton {

	INSTANCE;

	private ArrayList<ObjectPool> list = new ArrayList<>();

	public Object pullObject(ObjectPoolEnum objectPoolEnum) {

		ObjectPool objectPool = getObjectPool(objectPoolEnum);

		if (objectPool.getArrayList().isEmpty())
			return objectPool.getObjectPoolAble().getObject();
		else
			return objectPool.getArrayList().removeFirst();

	}

	public Object pullObject(ObjectPoolAble objectPoolAble) {

		for (ObjectPool objectPool : this.list)
			if (objectPool.getObjectPoolAble() == objectPoolAble)
				if (objectPool.getArrayList().isEmpty())
					return objectPool.getObjectPoolAble().getObject();
				else
					return objectPool.getArrayList().removeFirst();

		return null;

	}

	public void releaseObject(ObjectPoolEnum objectPoolEnum, Object object) {

		ObjectPool objectPool = getObjectPool(objectPoolEnum);
		objectPool.getArrayList().addFirst(object);

	}

	public void createObjectPool(ObjectPoolEnum objectPoolEnum, ObjectPoolAble objectPoolAble) {
		this.list.addLast(new ObjectPool(objectPoolEnum, objectPoolAble));
	}

	public void print(ObjectPoolEnum objectPoolEnum) {

		ObjectPool objectPool = getObjectPool(objectPoolEnum);
		Logger.logNewLine(objectPool.getArrayList().size() + " released");

	}

	private ObjectPool getObjectPool(ObjectPoolEnum objectPoolEnum) {

		for (ObjectPool objectPool : this.list)
			if (objectPool.getObjectPoolEnum() == objectPoolEnum)
				return objectPool;

		return null;

	}

	private class ObjectPool {

		private ObjectPoolEnum objectPoolEnum = null;
		private ObjectPoolAble objectPoolAble = null;
		private ArrayList<Object> objects = new ArrayList<>();

		public ObjectPool(ObjectPoolEnum objectPoolEnum, ObjectPoolAble objectPoolAble) {
			this.objectPoolEnum = objectPoolEnum;
			this.objectPoolAble = objectPoolAble;
		}

		public ObjectPoolEnum getObjectPoolEnum() {
			return this.objectPoolEnum;
		}

		public ObjectPoolAble getObjectPoolAble() {
			return this.objectPoolAble;
		}

		public ArrayList<Object> getArrayList() {
			return this.objects;
		}

	}

}

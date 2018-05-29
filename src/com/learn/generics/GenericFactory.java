package com.learn.generics;

public class GenericFactory<T> {
	
	Class<?> thisClass = null;

	public GenericFactory(Class<?> thisClass) {
		super();
		this.thisClass = thisClass;
	}
	
	public T createInstance() throws InstantiationException, IllegalAccessException{
		@SuppressWarnings("unchecked")
		T newInstance = (T) this.thisClass.newInstance();
		return newInstance;
	}

}

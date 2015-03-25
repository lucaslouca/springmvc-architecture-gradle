package com.mydomain.app;


public interface GenericDao<T>{
	
	T save(T o );
	
	T findById(Long id);
	
	T update(T o);
	
	void remove(T o);
	
	

}

package com.skilldistillery.mygamelist;

public interface CRUDObject<T,I> {
	T create(T object);
	T update(I id, T object);
	boolean deleteById(I id);
	T findById(I id);
	boolean existsById(I id);
}

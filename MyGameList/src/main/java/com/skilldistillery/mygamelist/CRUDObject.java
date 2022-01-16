package com.skilldistillery.mygamelist;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CRUDObject<T,I> {
	JpaRepository<T, I> getRepo();
	OptionalRetriever<T> getRetriever();
	
	default List<T> findAll() {
		return getRepo().findAll();
	}
	
	default T findById(I id) {
		if (id == null) {
			return null;
		}
		
		return getRetriever().get(
			getRepo().findById(id)
		);
	}
	
	default T create(T object) {
		return getRepo().saveAndFlush(object);
	}
	
	default T update(I id, T object) {
		T managed = findById(id);

		if (managed != null && object != null) {
			Class<T> typeClass = null;
			
			try {
				typeClass = (Class<T>) object.getClass();
				
				for(Field field : typeClass.getDeclaredFields())
				{
					if (field.isAnnotationPresent(SpringUpdate.class))
					{
						PropertyDescriptor desc = new PropertyDescriptor(field.getName(), typeClass);
						desc.getWriteMethod().invoke(
							managed,
							desc.getReadMethod().invoke(object)
						);
					}
				}
				
				getRepo().saveAndFlush(managed);
			} catch (Exception e) {
				e.printStackTrace();
				System.err.println("Failed to update " + typeClass + " entity with id: " + id);
			}
		}
		
		return managed;
	}
	
	
	default boolean deleteById(I id) {
		boolean deleted = false;
		if (id != null && existsById(id)) {
			try {
				getRepo().deleteById(id);
				if (!existsById(id)) {
					deleted = true;
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return deleted;
	}
	
	default boolean existsById(I id) {
		boolean exists = false;
		if (id != null) {
			exists = getRepo().existsById(id);
		}
		
		return exists;
	}
}

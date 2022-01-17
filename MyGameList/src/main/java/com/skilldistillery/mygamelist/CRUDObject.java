package com.skilldistillery.mygamelist;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import com.skilldistillery.mygamelist.entities.*;
import com.skilldistillery.mygamelist.compositeids.*;

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
			try {
				Class<?> typeClass = object.getClass();
				Method[] methods = typeClass.getDeclaredMethods();
				HashMap<String, Method> methodMap = new HashMap<>();
				for (Method method : methods) {
					methodMap.put(method.getName().toLowerCase(),method);
				}
				
				for(Field field : object.getClass().getDeclaredFields())
				{
					if (field.isAnnotationPresent(SpringUpdate.class))
					{
						String getterName = "get" + field.getName();
						String setterName = "set" + field.getName();
						Method getMethod = methodMap.getOrDefault(getterName.toLowerCase(), null);
						Method setMethod = methodMap.getOrDefault(setterName.toLowerCase(), null);
						if (getMethod != null && setMethod != null) {
							setMethod.invoke(
								managed,
								getMethod.invoke(object)
							);
						}
					}
				}
				
				getRepo().saveAndFlush(managed);
			} catch (Exception e) {
				e.printStackTrace();
				System.err.println("Failed to update " + object.getClass() + " entity with id: " + id);
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

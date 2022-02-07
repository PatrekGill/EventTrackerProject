package com.skilldistillery.mygamelist;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.mygamelist.repositories.UserRepository;

public interface CRUDObject<T,I> {
	public static final HashMap<Class<?>, HashMap<String, Method>> classMethodMap = new HashMap<>();
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
	
	default T findById(String username, I id) {
		if (id == null) {
			return null;
		}
		
		return getRetriever().get(
			getRepo().findById(id)
		);
	}
	
	default T removeId(T object) {
		if (object instanceof NumericId) {
			NumericId objectNumericId = (NumericId) object;
			if (objectNumericId.getId() > 0) {
				objectNumericId.setId(0);
			}
			
		} else if (object instanceof CompositeId) {
			boolean exists = existsById( ((CompositeId<I>) object).getId() );
			if (exists) {
				object = null;
			}
		}
		
		return object;
	}
	
	default T create(T object) {
		return getRepo().saveAndFlush(removeId(object));
	}
	
	default T update(I id, T object, Predicate<T> canUpdate) {
		T managed = findById(id);

		if (managed != null && object != null) {
			try {
				Class<?> typeClass = object.getClass();
				HashMap<String, Method> methodMap;
				if (classMethodMap.containsKey(typeClass)) {
					methodMap = classMethodMap.get(typeClass);
					
				} else {
					Method[] methods = typeClass.getDeclaredMethods();
					methodMap = new HashMap<>();
					for (Method method : methods) {
						methodMap.put(method.getName().toLowerCase(),method);
					}
					// cache method map
					classMethodMap.put(typeClass, methodMap);
					
				}
				
				for(Field field : object.getClass().getDeclaredFields())
				{
					if (field.isAnnotationPresent(SpringUpdate.class))
					{
						String fieldName = field.getName();
						String getterName = "get" + fieldName;
						String setterName = "set" + fieldName;
						
						Method getMethod = methodMap.getOrDefault(getterName.toLowerCase(), null);
						if (getMethod == null) {
							getMethod = methodMap.getOrDefault(("is" + fieldName).toLowerCase(), null);
						}
						
						Method setMethod = methodMap.getOrDefault(setterName.toLowerCase(), null);
						if (getMethod != null && setMethod != null) {
							setMethod.invoke(
								managed,
								getMethod.invoke(object)
							);
						} else {
							throw new Exception("Failed to find methods for: " + getterName + " and/or " + setterName);
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
	
	
	default boolean deleteById(I id, Predicate<T> canDelete) {
		boolean deleted = false;
		if (id != null) {
			T entity = findById(id);
			if (canDelete.test(entity)) {
				try {
					getRepo().deleteById(id);
					if (!existsById(id)) {
						deleted = true;
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
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

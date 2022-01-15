package com.skilldistillery.mygamelist;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public class CRUDObject<T,I> {
	@Autowired
	private OptionalRetriever<T> retriever;
	@Autowired
	private JpaRepository<T, I> repo;
	
	public List<T> findAll() {
		return repo.findAll();
	}
	
	public T findById(I id) {
		return retriever.get(
			repo.findById(id)
		);
	}
	
	public T create(T object) {
		return repo.saveAndFlush(object);
	}
	
	public T update(I id, T object) {
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
				
				repo.saveAndFlush(managed);
			} catch (Exception e) {
				e.printStackTrace();
				System.err.println("Failed to update " + typeClass + " entity with id: " + id);
			}
		}
		
		return managed;
	}
	
	
	public boolean deleteById(I id) {
		boolean deleted = false;
		try {
			repo.deleteById(id);
			if (!existsById(id)) {
				deleted = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return deleted;
	}
	
	public boolean existsById(I id) {
		return repo.existsById(id);
	}
}

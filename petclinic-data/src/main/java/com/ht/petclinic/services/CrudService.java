package com.ht.petclinic.services;



import java.util.Set;

public interface CrudService <T, I> {
    public T findById(I id);

    public Set<T> findAll();

    public T save(T t);
    
    public void delete(T t);
    
    public void deleteById(Long id);
}

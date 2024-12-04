package com.ht.petclinic.services;

import java.util.*;

import com.ht.petclinic.model.BaseEntity;

public abstract class AbstractMapService<T extends BaseEntity, I> implements CrudService<T, I> {
    protected Map<Long, T> map = new HashMap<>();

    public T findById(I id) {
        return map.get(id);
    }

    public Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    public T save(T t) {
        if (t != null) {
            if (t.getId() == null) {
                Long newId = getNextId();
                t.setId(newId);
            }

            map.put(t.getId(), t);
        }

        return t;
    }

    private Long getNextId() {
        return !map.isEmpty() ? Collections.max(map.keySet()) + 1 : 1L;
    }
}

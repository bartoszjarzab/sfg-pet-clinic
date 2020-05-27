package com.springframework.sfgpetclinic.services.map;

import com.springframework.sfgpetclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity,ID extends Long>{
    protected Map<Long, T> map = new HashMap<>();
    Set<T> findAll(){
        //System.out.println(map.values());
        return new HashSet<>(map.values());
    }
    T findById(ID id){
        return map.get(id);
    }

    T save(T object){
        //System.out.println("Saving:"+id+","+object);
        if(object!=null){
            if(object.getId()==null){
                object.setId(getNextId());
            }
            map.put(object.getId(),object);
        } else {
            throw new RuntimeException("Object cannot be a null");
        }
        return object;
    }
    void deleteById(ID id){
        map.remove(id);
    }
    void delete(T object){
        map.entrySet().removeIf(entry->entry.getValue().equals(object));
    }

    private Long getNextId(){

        Long nextId = null;
        try{
            nextId = Collections.max(map.keySet()) +1;
        } catch (NoSuchElementException e){
            nextId=1L;
        }

        return nextId;
    }

}

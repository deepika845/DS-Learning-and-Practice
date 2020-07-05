package com.deepika.problem.solving.HeapSection;

import java.util.LinkedList;

public class HashMaps {
    LinkedList<Entity> list = new LinkedList<>();
    public void put(String key,String value){
        for(Entity entity:list){
            if(entity.key.equals(key)){
                entity.value=value;
                return;
            }
        }
        list.add(new Entity(key,value));
    }
    public void remove(String key){
        Entity target =null;
        for(Entity entity:list){
            if(entity.key.equals(key)){
                target=entity;
                break;
            }
        }
        list.remove(target);
    }

    public String get(String key){
        for(Entity entity:list){
            if(entity.key.equals(key)){
                return entity.value;
            }
        }
        return null;
    }
    public String toString(){
        String s="";
        s=s+"[";
        for(Entity entity:list){
            s+=(entity.key + "=>"+entity.value+", ");
        }
        s+="]";
         return s;
    }

    class Entity {
        String key;
         String value;
        public Entity(String key,String value){
            this.key=key;
            this.value=value;
        }
    }
}

package com.deepika.problem.solving.HeapSection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;

public class MapUsingAl<K,V>{
    private int size=0;
    private float lf=0.5f;
    ArrayList<LinkedList<Entity>> entities=new ArrayList<>();
    public MapUsingAl(){
        for(int i=0;i<100;i++){
            entities.add(new LinkedList<>());
        }
    }
    public void put(K key,V value){
        int hashcode = Math.abs(key.hashCode()%entities.size());
        LinkedList<Entity> list=entities.get(hashcode);
        for(Entity entity:list){
            if (entity.key.equals(key)) {
                entity.value = value;
                return;
            }}
        list.add(new Entity(key,value));
    }
    public V get(K key){
        int hashcode=Math.abs(key.hashCode()%entities.size());
        LinkedList<Entity> list = entities.get(hashcode);
        for(Entity entity:list){
            if(entity.key.equals(key)){
                return entity.value;
            }
        }
        return null;
    }

    public void remove(K key){
        int hashcode = Math.abs(key.hashCode()%entities.size());
        LinkedList<Entity> list= entities.get(hashcode);
        Entity target=null;
        for(Entity entity:list){
            if(entity.key.equals(key)){
                target=entity;
                break;
            }
        }
        list.remove(target);
    }
    class Entity{
        K key;
        V value;
        public Entity(K key,V value){
            this.key=key;
            this.value=value;
        }
    }
}

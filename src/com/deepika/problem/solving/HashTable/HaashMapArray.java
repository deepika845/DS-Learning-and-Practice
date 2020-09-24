package com.deepika.problem.solving.HashTable;

public class HaashMapArray {
    Entity[] entity = new Entity[10];
    public void put(String key,String value){
    int hashcode=Math.abs(key.hashCode()%entity.length);
    entity[hashcode]=new Entity(key,value);
    }
    public String get(String key){
        int hashcode=Math.abs(key.hashCode()%entity.length);
        if(entity[hashcode]!=null || entity[hashcode].key.equals(key)){
            return entity[hashcode].value;
        }
        return null;
    }
    class Entity {
        String key;
        String value;
        public Entity(String key,String value){
            this.key=key;
            this.value=value;
        }
    }
    public void remove(String key){
        int hashcode=Math.abs(key.hashCode()%entity.length);
        if(entity[hashcode]!=null || entity[hashcode].key.equals(key)) {
            entity[hashcode] = null;
        }
    }
    public static void main(String[] args) {
        String s="Hello";
        System.out.println(s.hashCode());
        String k="Orange";
        System.out.println(s.hashCode());
    }
}

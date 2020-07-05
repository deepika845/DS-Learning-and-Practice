package com.deepika.problem.solving.HashMap;

public class HashTable<K,V> {
    private class HTPair{
        K key;
        V value;
        HTPair(K key,V value){
            this.key=key;
            this.value=value;
        }
        public boolean equals(Object another){
            HTPair op = (HTPair)another;
            return this.key.equals(op.key);
        }
        public String toString(){
            return "{"+this.key+"-"+this.value+"}"; // override
        }
    }
    public static final int DEFAULT_CAPACITY = 10;
    private HashMapNew<HTPair>[] bucketArray;
    private int size;
    public HashTable(){
        this(DEFAULT_CAPACITY);
    }
    public HashTable(int capacity){
        this.bucketArray = (HashMapNew<HTPair>[])new HashMapNew[capacity];
        this.size=0;
    }
    public  void put(K key,V value){
        int bi = hashFunction(key);
        HashMapNew<HTPair> bucket = this.bucketArray[bi];//basically the reference of that linked list is get
        HTPair pta = new HTPair(key,value);
        if(bucket==null){
            bucket = new HashMapNew<HTPair>();
            bucket.insertlast(pta);
            this.bucketArray[bi]=bucket;
            this.size++;
        }
        else{
            int findAt = bucket.find(pta);
            if(findAt==-1){
                bucket.insertlast(pta);
                this.size++;
            }
            else {
                HTPair puu = bucket.get(findAt);
                puu.value=value;
            }
        }
        double lambda =(this.size*1.0)/this.bucketArray.length;
        if(lambda>0.75){
            this.rehash();
        }
    }
    public V get(K key){
        int bi = hashFunction(key);
        HashMapNew<HTPair> bucket = this.bucketArray[bi];
        HTPair ptf = new HTPair(key,null);
        if(bucket == null){
            return null;
        }
        else{
            int findAt = bucket.find(ptf);
            if(findAt==-1){
               return null;
            }
            else {
                HTPair pair = bucket.get(findAt);
                return pair.value;
            }
        }
    }
    public V remove(K key){
        int bi = hashFunction(key);
        HashMapNew<HTPair> bucket = this.bucketArray[bi];
        HTPair ptf = new HTPair(key,null);
        if(bucket == null){
            return null;
        }
        else{
            int findAt = bucket.find(ptf);
            if(findAt==-1){
                return null;
            }
            else {
                HTPair pair = bucket.get(findAt);
                bucket.deleteatindex(findAt);
                this.size--;
                return pair.value;
            }
        }
    }
    private void rehash(){
        HashMapNew<HTPair>[] oba = this.bucketArray;
        this.bucketArray = (HashMapNew<HTPair>[])new HashMapNew[2*oba.length];
        this.size = 0;
        for(HashMapNew<HTPair> ob : oba){
            while (ob!=null && !ob.isEmpty()){
                HTPair pair = ob.deletefirst();
                this.put(pair.key,pair.value);
            }
        }
    }
    private int hashFunction(K key){
        int hc = key.hashCode();
        hc=Math.abs(hc);
        int bi = hc % this.bucketArray.length;
        return bi;
    }
    public void display(){
        for (HashMapNew<HTPair> bucket : this.bucketArray){
            if(bucket != null && !bucket.isEmpty() ){
                bucket.display();
                System.out.println();
            }
            else {
                System.out.println("Null");
            }
        }

    }
}

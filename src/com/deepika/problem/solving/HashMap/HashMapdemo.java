package com.deepika.problem.solving.HashMap;



import java.util.*;

public class HashMapdemo {

    public static void main(String[] args) {
        /*HashMap<String,Integer> map = new HashMap<String, Integer>();
        map.put("USA",200);
        map.put("UK",175);
        map.put("India",300);
        map.put("China",350);
        System.out.println(map);
        map.put("Sweden",100);
        System.out.println(map);
        map.put("India" ,325);
        System.out.println(map);
        System.out.println(map.get("India"));
        System.out.println(map.get("Rsa"));
        System.out.println(map.remove("USA"));
        System.out.println(map);
        System.out.println(map.containsKey("India"));
        System.out.println(map.containsKey("USA"));
        //All above functions have O(1) complexity..
        System.out.println("**********Key**************");
        Set<String> keys = map.keySet();
        for(String key: keys){
            System.out.print(key+" ");
            //drawback of this for each loop is that we can only display the collection but cannot make modification through it.
        }
        System.out.println("******** Values ********");
        Collection<Integer> values = map.values();
        for (Integer value: values){
            System.out.println(value);
        }
        System.out.println("*******EntrySet*********");
        Set<Map.Entry<String,Integer>> entries = map.entrySet();
        for(Map.Entry<String,Integer> entry : entries){
            System.out.println(entry.getKey()+" => "+entry.getValue());
        }
        System.out.println("********Max Occuring Character *************");
        String str = "abcddfggkbb";
        System.out.println(getMaxFreq(str));
        System.out.println("********Intersection*********");
        int[] one={5,1,3,4,7};
        int[] two={2,4,3,5,7,10,15};
        ArrayList<Integer> list = getIntersection(one,two);
        System.out.println(list);*/
        getDuplicates(new int[]{1,2,1,3,4,2,4});
    }




    
    public static char getMaxFreq(String str){
        HashMap<Character,Integer> map = new HashMap<Character, Integer>();
        for (int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(map.containsKey(ch)){
                int ov = map.get(ch);
                int nv = ov+1;
                map.put(ch,nv);
            }
            else{
                map.put(ch,1);
            }
        }
        char maxChar='\0';//null character
        int max= 0;
        Set<Map.Entry<Character,Integer>> entries = map.entrySet();
        for (Map.Entry<Character,Integer> entry : entries){
            if(entry.getValue() > max){
                max= entry.getValue();
                maxChar =entry.getKey();
            }
        }
        return maxChar;
    }
    public static void getDuplicates(int arr[]){
        HashMap<Integer,Integer> hll = new HashMap<Integer, Integer>();
        for(int  i =0 ;i<arr.length;i++){
            if(!hll.containsKey(arr[i])){
                hll.put(arr[i],1);
            }
            else{
                hll.put(arr[i],hll.get(arr[i])+1);
            }
        }
        for (Map.Entry<Integer,Integer> ent : hll.entrySet()){
            if(ent.getValue() == 2){
                System.out.print(ent.getKey()+" ");
            }
        }
    }
    public static ArrayList<Integer> getIntersection(int[] one,int[] two){
        //we have change the complexity O(mn) to O(m+n)
        HashMap<Integer,Boolean> map = new HashMap<Integer, Boolean>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<one.length;i++){
            map.put(one[i],false);
        }
        for (int j=0;j<two.length;j++){
            if(map.containsKey(two[j])){
                map.put(two[j],true);
            }
        }
        Set<Map.Entry<Integer,Boolean>> entries = map.entrySet();
        for(Map.Entry<Integer, Boolean> entry : entries){
            if(entry.getValue()){
                list.add(entry.getKey());
            }
        }
        return list;
    }
}

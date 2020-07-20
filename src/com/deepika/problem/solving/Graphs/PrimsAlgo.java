package com.deepika.problem.solving.Graphs;

import java.util.*;

class PrimsAlgo<T>{
//   HashMap<T,Vertex> vertices = new HashMap<T,Vertex>();
//   public void addVertex(T val){
//       vertices.put(val,new Vertex(val));
//   }
//   public void addEdgeWeight(T a, T b ,int weight){
//       if(vertices.containsKey(a) && vertices.containsKey(b)){
//           vertices.get(a).neighbours.put(vertices.get(b),weight);
//           vertices.get(b).neighbours.put(vertices.get(a),weight);
//       }
//   }
//   public PrimsAlgo<T> callPrins(){
//       HashMap<T,Pair> hm = new HashMap<T,Pair>();
//       PriorityQueue<Pair> pq= new PriorityQueue<Pair>();
//       PrimsAlgo<T> minSpan = new PrimsAlgo<T>();
//       HashSet<Vertex> hs = new HashSet<Vertex>();
//       Vertex first = vertices.values().iterator().next();
//       for (Vertex vv : vertices.values()){
//           Pair pp;
//           minSpan.addVertex(vv.value);
//           if(vv == first){
//                pp = new Pair(vv,0,null);
//           }
//           else{
//                pp = new Pair(vv,Integer.MAX_VALUE,null);
//           }
//           pq.add(pp);
//           hm.put(vv.value,pp);
//       }
//           while (!pq.isEmpty()){
//               Pair temp = pq.poll();
//               hm.remove(temp.vertex);
//               Set<Vertex> ss = temp.vertex.neighbours.keySet();
//
//
//               for (Vertex padosi : ss){
//                   if(hm.containsKey(padosi.value)){
//                       Pair pf = hm.get(padosi.value);
//                       int oldCost = pf.carry;
//                       int newCost = temp.carry + vertices.get(temp.vertex)
//                   }
//               }
//
//
//       }*/
//
//
//   }
//   class Pair implements Comparable<Pair>{
//       T vertex;
//       int carry;
//       T toVertex;
//       public Pair(T ver, int car,T toVertex){
//           vertex = ver;
//           carry = car;
//           this.toVertex= toVertex;
//       }
//       @Override
//       public int compareTo(Pair o) {
//           return  this.carry - o.carry;
//       }
//   }
//    class Vertex{
//        T value;
//        HashMap<Vertex,Integer> neighbours ;
//        public Vertex(T val){
//            value = val;
//            neighbours = new HashMap<Vertex,Integer>();
//        }
//    }
}
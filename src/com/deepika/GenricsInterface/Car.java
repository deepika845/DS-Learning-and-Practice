package com.deepika.GenricsInterface;

public class Car implements Comparable<Car> {
    int speed;
    int price;
    String colour;
    public Car(int speed,int price,String colour){
        this.speed=speed;
        this.price=price;
        this.colour=colour;
    }
    public String toString(){
        return(speed+" "+price+" "+colour+" ");
    }

    @Override
    public int compareTo(Car o) {
        return o.price - this.price;
    }

}

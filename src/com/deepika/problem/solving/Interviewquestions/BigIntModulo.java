package com.deepika.problem.solving.Interviewquestions;

public class BigIntModulo {
    public static int findModuloBigInt(byte[] array,int k){
        int m = 0 ;
        for (int i=0;i<array.length;i++){
            m<<=8;
            m+=(array[i] & 0xFF);
            m%=k;
        }
        return m;
    }

    public static void main(String[] args) {
       findModuloBigInt(new byte[]{0x03, (byte) 0xED},10);
    }
}

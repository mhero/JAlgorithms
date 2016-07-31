package com.mac.algorithms.zeta;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Zeta z = new Zeta();
        String text = "GEEK S FOR GEEKS";
        String pattern = "GEEK";
        List<Integer> search = z.search(text, pattern);
        for(Integer elem:search){
            System.out.println("Pattern found at index " + elem);
        }
    }

}

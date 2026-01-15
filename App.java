package com.example;

public class App {
    public static void main(String[] args) {
        System.out.println("Java App Started");

        // Keep app running so Docker container doesn't exit
        while(true){
            try {
                Thread.sleep(10000);
            } catch(Exception e){}
        }
    }
}

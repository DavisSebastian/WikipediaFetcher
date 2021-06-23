package tech.codingclub;

import java.util.Scanner;

public class ThreadExample extends Thread {


    public int counter;
    private String threadName;
    private int waitTime;



    public ThreadExample(String threadName,int counter,int waitTime){
        this.counter=counter;
        this.threadName=threadName;
        this.waitTime = waitTime;
    }
    public void run()
    {

        while(counter<100)
        {


            try {
                Thread.sleep(waitTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(threadName + " " + counter);
            counter++;
        }
    }

    public static void main(String[] args) {

        ThreadExample thread_1 = new ThreadExample("THREAD_1",0,500);

        ThreadExample thread_2 = new ThreadExample("THREAD_2",0,1000);
        ThreadExample thread_3 = new ThreadExample("THREAD_3",0,2000);


        thread_1.start();
        thread_2.start();
        thread_3.start();


     //   System.out.println(thread_1.counter);
       // System.out.println(thread_2.counter);
        //System.out.println(thread_3.counter);


        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
    }
}

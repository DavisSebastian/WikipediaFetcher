package tech.codingclub.utility;

import tech.codingclub.RunnableExample;

public class ThreadManager {

    public static void main(String[] args) {

        TaskManager taskManager = new TaskManager(10);
        for(int i =0;i<1000;i++)
        {
            RunnableExample temp = new RunnableExample("Thread "+i,0,500+i);
            taskManager.waitTillQueueIsFreeAndAddTask(temp);
        }
    }
}

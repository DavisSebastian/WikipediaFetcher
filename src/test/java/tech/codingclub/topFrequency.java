package tech.codingclub;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import tech.codingclub.utility.FileUtility;
import tech.codingclub.utility.TaskManager;
import tech.codingclub.utility.keywordCount;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class topFrequency implements Runnable {


    public final String filepath;

    public topFrequency(String filepath) {
        this.filepath = filepath;
    }



    public void run() {

        ArrayList<String> data = FileUtility.readAndPrint(filepath);
        HashMap<String, Integer> keywordCounter = new HashMap<String, Integer>();



        for(String row : data){
            String[] keywords = row.split(" ");
            for(String keyword:keywords)
            {
                String str = keyword.toString();
                if(!keywordCounter.containsKey((str)))
                    keywordCounter.put(str,1);
                else{
                    Integer value = keywordCounter.get(str);
                    keywordCounter.put(str,value +1);
                }
            }
        }

        ArrayList<keywordCount> keywordCountArrayList = new ArrayList<keywordCount>();

        for(String keyword : keywordCounter.keySet())
        {
            keywordCountArrayList.add(new keywordCount(keyword,keywordCounter.get(keyword)));
        }

        Collections.sort(keywordCountArrayList, new Comparator<keywordCount>() {

            public int compare(keywordCount o1, keywordCount o2) {
                if (o2.count == o1.count)
                    return o1.keyword.compareTo(o2.keyword);
                return o2.count - o1.count;
            }
        });

        for(keywordCount KeyWord : keywordCountArrayList )
        {

           System.out.println(KeyWord.keyword + " " + KeyWord.count);
        }

        String json = new Gson().toJson(keywordCountArrayList);
        System.out.println(json);

        String convert = "{\"keyword\":\"davis\",\"count\":100}";

        keywordCount Keyword = new Gson().fromJson(convert,keywordCount.class);
        System.out.println(Keyword.keyword + " " + Keyword.count);


        String convertArray = "[ {\"keyword\":\"davis\",\"count\":100} ,{\"keyword\":\"davis\",\"count\":100},{\"keyword\":\"davis\",\"count\":100}]";
        ArrayList<keywordCount> convertedArray = new Gson().fromJson(convertArray,new TypeToken<ArrayList<keywordCount>>(){}.getType());

        for(keywordCount KeyWord : convertedArray)
            System.out.println("Hai" + KeyWord.keyword + " " + KeyWord.count);
    }

    public static void main(String[] args) {

        TaskManager taskManager = new TaskManager(1);
        taskManager.waitTillQueueIsFreeAndAddTask(new topFrequency("C:\\Users\\davis\\Desktop\\toastmasters\\data\\practise\\File\\"+"janaganamana.txt"));




    }

}

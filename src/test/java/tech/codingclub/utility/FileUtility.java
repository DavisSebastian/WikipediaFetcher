package tech.codingclub.utility;



import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileUtility {



    public static boolean createFile(String fileNameWithPath) {
        File file = new File(fileNameWithPath);
        boolean x = false;

        try {
            x = file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return x;

    }
    public static ArrayList<String> readAndPrint(String filecreated) {

        ArrayList<String> string = new ArrayList<String>();
        Scanner scanner = null;

        try {
            File file = new File(filecreated);
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {

                String s = scanner.nextLine();
                string.add(s);

            }


        }

        catch(Exception e){
                e.printStackTrace();
            }
        finally {
            if(scanner!=null)
                scanner.close();
        }

        return string;


        }


        public static boolean writeToFile(String content , String fileNameWithPath){


            try {
                FileWriter fw = new FileWriter(fileNameWithPath);
                fw.append(content);
                fw.close();
            } catch (IOException e) {

                return false;
            }

            return true;


        }


    public static boolean appendToFile(String fileName , String content)
    {
        try {
            FileWriter filewriter = new FileWriter(fileName,true);
            filewriter.append(content);
            filewriter.close();
        } catch (IOException e) {
            return false;
        }

        return true;

    }




        public static void main(String[] args){


        System.out.println("Hi Iam Davis");
        System.out.println("Hi Iam Ds Fr");

        String path = "C:\\Users\\davis\\Desktop\\toastmasters\\data\\practise\\File\\" + "create_file.txt";
        boolean filecreated = createFile(path);



        System.out.println(filecreated);

        String fileNameWithPath = "C:\\Users\\davis\\Desktop\\toastmasters\\data\\practise\\File\\" + "write_file.txt";

        String content = "Ey Heirathe Aaashiqueeee";

            boolean v = writeToFile(content,fileNameWithPath);
            System.out.println(v);
            ArrayList<String> x = readAndPrint(path);

            for(int i=0;i<50;i++) {
                String data = i + "";
                boolean d = appendToFile(fileNameWithPath, data);
            }
            for(String s : x)
        {
            System.out.println(s);
        }
    }





}

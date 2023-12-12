package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

@Component
public class ReadClass {

    @Value("${regapp.filepath}")
    String filePath ;
    public void readPerson() throws IOException {



        File fileTOut  = new File(filePath);
        Path writeFilePath = Paths.get(filePath);


        Scanner in = new Scanner(System.in);
        System.out.print("напишите емейл для поиска ");
        String forFind = in.nextLine();

        String content = null;
        try {
            content = Files.readString(writeFilePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String delimeter = "\n";
        String[] subStr;
        subStr = content.split(delimeter); // Разделения строки str с помощью метода split()
        // Вывод результата на экран
//        for(int i = 0; i < subStr.length; i++) {
//            System.out.println("строка " + subStr[i]);
//        }

        ArrayList<String> slist = new ArrayList<String>();
        Collections.addAll(slist, subStr);
        int p=0;

        for(int i = 0; i < subStr.length; i++) {

            if(slist.get(i).contains(forFind)){
                           System.out.println("Find this" + slist.get(i));
            }


            for(int j = 0; j < subStr.length; j++) {

                if(slist.get(j).contains(forFind)){
                    p=1;}
            }

            if (p==0){System.out.println("НЕТ ЗАПИСЕЙ");}
            else {System.out.println(" ");}

        }

    }


}

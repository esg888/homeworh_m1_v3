package org.example;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

@Component
public class DelClass {

    @Value("${regapp.filepath}")
    String filePath;
    public void delPerson() throws IOException {

        Path writeFilePath = Paths.get(filePath);
        String content = Files.readString(writeFilePath);
        String delimeter = "\n";
        String[] subStr;
        subStr = content.split(delimeter); // Разделения строки с помощью метода split()
        ArrayList<String> slist = new ArrayList<String>();
        Collections.addAll(slist, subStr);

        Scanner in = new Scanner(System.in);
        System.out.print("Вы удаляете запись. Введите емейл и нажмите ввод: ");
        String forDel = in.nextLine();

        int p=0;
        for(int i = 0; i < subStr.length; i++) {

            if(slist.get(i).contains(forDel)){
                p=1;}
        }

        if (p==0){System.out.println("НЕТ ЗАПИСЕЙ ДЛЯ УДАЛЕНИЯ");}
        else {System.out.println("ВСЕ УДАЛЕНО");}

        slist.removeIf(x -> x.contains(forDel));

        File fileTOut  = new File(filePath);
        String delim = "\n";
        String res = StringUtils.join(slist, delim);

        try (OutputStream os = new FileOutputStream(fileTOut, false))
        {
            os.write(res.getBytes());
        }
        catch (FileNotFoundException e) {System.out.println("no file");}
        catch (IOException e) {System.out.println("no  writing");};
    }

}

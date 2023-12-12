package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Scanner;

//@Profile("prod")
@Component
public class WriteClassForProd implements WriteInterface{

    @Value("${regapp.filepath}")
    String filePath;
    public void writePerson(){

        File fileTOut  = new File(filePath);
        Scanner in = new Scanner(System.in);
        System.out.print("Введите ФИО, телефон и емейл через ';' ");

        try (OutputStream os = new FileOutputStream(fileTOut, true))
        {

            String textDraft = in.nextLine();
            String text1 = textDraft.replace(";", " | "); //  \n
            String text = text1+ "\n";;
            os.write(text.getBytes());
            System.out.println("ALL OK");
        }
        catch (FileNotFoundException e) {System.out.println("no file");}
        catch (IOException e) {System.out.println("no  writing");}
    }

}

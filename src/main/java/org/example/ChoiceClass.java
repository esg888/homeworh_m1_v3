package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Scanner;

@Component
public class ChoiceClass {

@Autowired
WriteClassForProd writeClassForProd;

    @Autowired
    CommonWriteClass commonWriteClass;

    @Autowired
    DelClass delClass;

    @Autowired
    ReadClass readClass;
    public void choceAction() throws IOException {

        Scanner in = new Scanner(System.in);
        System.out.println("Для ввода информации нажмите 1, потом ввод");
        System.out.println("Для поиска информации нажмите 2, потом ввод");
        System.out.println("Для удаления информации нажмите 3, потом ввод");
        String whatDo = in.nextLine();
        switch (whatDo) {
            case "1":
                commonWriteClass.commonWriting();
                break;
            case "2":
                readClass.readPerson();
                break;
            case "3":
                delClass.delPerson();
                break;
            default:
                System.out.println("Ошибка, перезапустите программу");
                break;
        }

    }
}

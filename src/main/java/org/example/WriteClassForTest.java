package org.example;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Scanner;

//@Profile(value = "test")
@Component
public class WriteClassForTest implements WriteInterface{

    public void writePerson() {

        System.out.print(" Вы не можете вводить новые данные в тестовом режиме ");}

}

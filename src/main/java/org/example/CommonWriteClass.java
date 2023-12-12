package org.example;

import org.springframework.stereotype.Component;

@Component
public class CommonWriteClass {

    private final WriteInterface writeInterface;


    public CommonWriteClass(WriteInterface writeInterface) {
        this.writeInterface = writeInterface;
    }

    public void commonWriting(){
        writeInterface.writePerson();
    }
}

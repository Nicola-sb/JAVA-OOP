package Logger.Appenders;

import Logger.Interfaces.File;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class LogFile implements File {
//custom file class which logs messages in a string builder using a method write().
//It should have a getter for its size which is the sum of the ascii codes of all alphabet characters it contains (e.g. a-z and A-Z).


    //Нашият LogFile държи в себе си име на файл private String fileName към който ще четем и ще пишем
    //има си size,което е сумата на asci стойностите
    //и има  builderText(private StringBuilder builderText) текст в който пазим текста,който имаме във файла

    //getSize Ни смята size и ни го връща
    //boolean write апендва към файла някакъв текст
    // public void append апендва към StringBuildera и съответно апендва към нашият истински текстов файл с помощта на write methoda

    private static final String DEDAUT_FILE_NAME= "default.txt";
    private StringBuilder builderText;
    private int size;
    private String fileName;

    public LogFile() {
        this.builderText=new StringBuilder();
        this.size=0;
        this.fileName=DEDAUT_FILE_NAME;
    }
    public LogFile(String fileName) {
        this.builderText=new StringBuilder();
        this.size=0;
        this.fileName=fileName;
    }

    @Override
    public int getSize() {
        return calculateSize();
    }
    private int calculateSize(){
        int size=0;
        for (char currentChar:this.builderText.toString().toCharArray()){
            if(Character.isAlphabetic(currentChar)){
                size+=currentChar;
            }
        }
        return size;
    }

    @Override
    public boolean write(String text) {
        try {
             Files.write(Paths.get(fileName),text.getBytes(), StandardOpenOption.APPEND);
             return true;
        } catch (IOException e) {
           e.printStackTrace();
        }
        return false;
    }

    public String addLineBreakLine(String text){
        StringBuilder sb=new StringBuilder(text);
        sb.append(System.lineSeparator());
        return sb.toString();
    }

    @Override
    public void append(String text) {
        text=addLineBreakLine(text);
        this.builderText.append(text);
        this.write(text);
    }
}

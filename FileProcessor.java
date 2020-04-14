/*
Christina Nguyen
CSC 331 - 002
Homework 5
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileProcessor {
    private ArrayList<String> words, lines;
    private String filename;
    private Scanner scanFile;


    public FileProcessor(String ifile) {
        this.filename = ifile;
    }

    public ArrayList<String> getWords() {
        return words;
    }

    public ArrayList<String> getLines() {
        return lines;
    }

    public void processWords() throws FileNotFoundException {
        this.scanFile = new Scanner(new File(this.filename));
        words = new ArrayList<String>();
        while (this.scanFile.hasNextLine()){
            String word = this.scanFile.next();
            this.words.add(word);
        }
        this.scanFile.close();

    }

    public void processLines() throws FileNotFoundException {
        this.scanFile = new Scanner(new File(this.filename));
        lines = new ArrayList<String>();
        String line = null;
        while (this.scanFile.hasNextLine()){
            line = this.scanFile.nextLine();
            lines.add(line);
        }
        this.scanFile.close();
    }


}

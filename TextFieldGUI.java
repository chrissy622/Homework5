/*
Christina Nguyen
CSC 331 - 002
Homework 5
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class TextFieldGUI {

    JButton saveFilename, wordsInFile, linesInFile;
    JTextField enterFile;
    JTextArea textArea;
    JFrame jfrm;
    JPanel topPanel, botPanel;
    ArrayList<String> words, lines;
    FileProcessor prog;


    public TextFieldGUI() {
        // Create new JFrame container and top and bottom panels
        jfrm = new JFrame("File Processing Frame");
        jfrm.setSize(600,375);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        topPanel = new JPanel();
        botPanel = new JPanel();


        // Create textfield to enter file name
        enterFile = new JTextField("Type filename and click button (with .txt)",25);
        topPanel.add(enterFile, BorderLayout.NORTH);

        // Create button to save file name
        saveFilename = new JButton("Save Filename");
        saveFilename.addActionListener(new ButtonListener());
        topPanel.add(saveFilename, BorderLayout.NORTH);

        //create text area
        textArea = new JTextArea(15,45);
        textArea.setText(null); // clears the text area of all content
        String line = "Hello professor :)";

        textArea.append(line + "\n");   // add a line of text and move to the next line
        //to make scrollable
        JScrollPane scroll = new JScrollPane(textArea);
        topPanel.add(scroll);   // add scroll to a panel / frame


        // create buttons wordsinfile and linesinfile
        wordsInFile = new JButton("Words in File");
        wordsInFile.addActionListener(new ButtonListener());
        botPanel.add(wordsInFile, BorderLayout.SOUTH);

        linesInFile = new JButton("Lines in File");
        linesInFile.addActionListener(new ButtonListener());
        botPanel.add(linesInFile, BorderLayout.SOUTH);

        // adding panels to frame and setting visibility to true
        jfrm.add(topPanel);
        jfrm.add(botPanel, BorderLayout.SOUTH);

        jfrm.setVisible(true);
    }


    class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton b = (JButton)e.getSource();
            Component jp = b.getParent();
            if (b.getText().contentEquals("Save Filename")){
                // saves user input to set file name
                String fileName = enterFile.getText();
                JOptionPane.showMessageDialog(null,"Saved filename: " + fileName);
                fileName = enterFile.getText();
                prog = new FileProcessor(fileName);

            }
            else if (b.getText().contentEquals("Words in File")) {
                // Prints out each token in the text file in a separate line
                words = new ArrayList<String>();
                try {
                    prog.processWords();
                    textArea.setText(null);
                    words = prog.getWords();
                    for (String s : words){
                        textArea.append(s + "\n");
                    }
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null,"Unable to print words, make sure you are entering the correct file name with .txt extension");
                }
            }
            else if (b.getText().contentEquals("Lines in File")) {
                // prints out each line followed by \n char
                lines = new ArrayList<String>();
                try {
                    prog.processLines();
                    textArea.setText(null);
                    lines = prog.getLines();
                    for (String l : lines){
                        textArea.append(l + "\n");
                    }
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null,"Unable to print lines, make sure you are entering the correct file name with .txt extension");
                }

            }

        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        new TextFieldGUI();
        }
}


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class TextFieldMenu {
    private JButton east, west;
    private JMenuBar menuBar;

    public TextFieldMenu() {
        //Create a new JFrame container
        JFrame jfrm = new JFrame("An Frame Example");

        //Give frame initial size
        jfrm.setSize(400, 200);

        //Terminate process when user closes application
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton north = new JButton("North Button");
        north.addActionListener(new ButtonListener());

        JButton south = new JButton("South Button");
        east = new JButton("East Button");
        east.setBackground(Color.green);
        east.addActionListener(new ButtonListener());
        west = new JButton("West Button");
        west.addActionListener(new ButtonListener());

        //Add buttons to content pane
        //The default layout manager is BorderLayout
        jfrm.add(east, BorderLayout.EAST);
        jfrm.add(west, BorderLayout.WEST);
        jfrm.add(north, BorderLayout.NORTH);
        jfrm.add(south, BorderLayout.SOUTH);

        JTextField tf = new JTextField("Enter text here", 20);
        tf.addKeyListener(new textFieldListener());
        jfrm.add(tf, BorderLayout.CENTER);

        // Add menuBar and 2 list of menus
        JMenuBar menuBar = new JMenuBar();
        jfrm.setJMenuBar(menuBar);

        // Add two menus to the menuBar
        JMenu homeLoan = new JMenu("Home Loans");
        menuBar.add(homeLoan);
        JMenu autoLoan = new JMenu("Auto Loans");
        menuBar.add(autoLoan);

        // Add menu items to autoLoan menu
        MyMenuItem hl1 = new MyMenuItem("Mortgage");
        MyMenuItem hl2 = new MyMenuItem("Refinances");
        MyMenuItem hl3 = new MyMenuItem("Home Equity");
        homeLoan.add(hl1);  homeLoan.add(hl2);  homeLoan.add(hl3);

        MyMenuItem al1 = new MyMenuItem("Apply Now");
        MyMenuItem al2 = new MyMenuItem("Auto Loan Rates");
        autoLoan.add(al1);  autoLoan.add(al2);

        //Display the frame
        jfrm.setVisible(true);

    }

    class MyMenuItem extends JMenuItem implements ActionListener {
        public MyMenuItem(String title) {
            super(title);
            addActionListener(this);
        }
        @Override
        public void actionPerformed(ActionEvent ae) {
            String title = ae.getActionCommand(); // determines the button
            //JOptionPane.showMessageDialog(null, title);
            if (title.contentEquals("Mortgage")){
                JOptionPane.showMessageDialog(null, "Mortgage");
            }

        }
    }

    class textFieldListener implements KeyListener {

        @Override
        // use this if you want to differentiate between upper and lowercase
        public void keyTyped(KeyEvent ke) {
            char ch = ke.getKeyChar();
            JOptionPane.showMessageDialog(null, ch + " typed");

        }

        @Override
        // this method traps all alpha numeric chars, Does not differentiate A from a
        public void keyPressed(KeyEvent ke) {
            if (ke.getKeyCode() == KeyEvent.VK_ENTER){
                JTextField c = (JTextField) ke.getSource();
                String s = c.getText();
                JOptionPane.showMessageDialog(null,s);
            }
            else {
                int code = ke.getKeyCode();
                String s = KeyEvent.getKeyText(code);
                //JOptionPane.showMessageDialog(null, code + " " + s);
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

    class ButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            JButton b = (JButton)ae.getSource();
            Component jp = b.getParent();
            Color c = b.getBackground();
            if(b.getText().contentEquals("North Button")) {
                if(c == Color.cyan) {
                    b.setBackground(Color.yellow);
                    jp.setBackground(Color.cyan);
                }
                else {
                    b.setBackground(Color.cyan);
                    jp.setBackground(Color.yellow);
                }
            }else if(b.getText().contentEquals("South Button")) {
                //code for south button
            }else if(b.getText().contentEquals("East Button")
                    || b.getText().contentEquals("West Button")) {
                //code for east-west buttons
                Color e = east.getBackground();
                Color w = west.getBackground();
                east.setBackground(w);
                west.setBackground(e);
            }
        }//end of method
    }//end of inner class


    public static void main(String[] args) {
        new TextFieldMenu();
    }
}//end of class

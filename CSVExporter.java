package CSVExporter;


import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JOptionPane;


import java.awt.BorderLayout;
import java.awt.Dimension;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;;

public class CSVExporter extends JOptionPane {
    public static void main(String[] args) {
        // Initialize Classes
        JFrame f = new JFrame("CSV Exporter v1.0");
        JPanel p = new JPanel();
        JButton b = new JButton("Create CSV");
        JTextArea jta = new JTextArea();
        // Set Rows To Make It Look Nicer
        jta.setRows(27);
        // Panel Operations (Set Layout, Add Variables)
        p.setLayout(new BorderLayout());
        p.add(jta, BorderLayout.NORTH);
        p.add(b, BorderLayout.SOUTH);
        // Button Operations
        b.setSize(new Dimension(100, b.getHeight()));
        b.addActionListener(new ActionListener() {
            // Saving File To CSV
            @Override
            public void actionPerformed(ActionEvent e) {
                SaveFile(jta.getText(), f);
            }
        });
        // Frame Operations
        f.setVisible(true);
        f.setSize(new Dimension(600, 500));
        f.add(p);
        f.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        f.addWindowListener(new WindowAdapter() {

    }
    // Method To Save Files
    public static void SaveFile(String text, JFrame frame) {
        // Replacing Spaces In Text To Semicolon
        text = text.replace(' ', ';');
        // Getting Current Date For The Name Of CSV File
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
        LocalDateTime year = LocalDateTime.now();
        String name = dtf.format(year).toString() + ".csv";
        // Creating A New File
        File f = new File(name);
        try {
            // Write Text To File.
            FileWriter fw = new FileWriter(f);
            fw.write(text);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Exit Program
        frame.setVisible(false);
        System.exit(0);
    }
}

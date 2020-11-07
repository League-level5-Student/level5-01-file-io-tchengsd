package _01_File_Recorder;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileRecorder {
	// Create a program that takes a message from the user and saves it to a file.
	public static void main(String[] args) {
		String input = JOptionPane.showInputDialog("Enter a message to add to the file");
		char[] chars = input.toCharArray();
		try {
			FileWriter fw = new FileWriter("src/_01_File_Recorder/output.txt");
			fw.write(chars);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
//Copyright © 2020 Tyler Cheng
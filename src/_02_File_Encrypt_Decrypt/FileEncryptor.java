package _02_File_Encrypt_Decrypt;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileEncryptor {
	char[] beforeShift = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	char[] afterShift = {'H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','a','b','c','d','e','f','g'};
	/*
	 * Encryption is the process of encoding a message or information
	 * in such a way that only authorized parties can access it and
	 * those who are not authorized cannot.
	 *
	 * A simple shift cipher works by shifting the letters of a message
	 * down based on a key. If our key is 4 then:
	 * 
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 * 
	 * becomes:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 * 
	 * "Hello World" changes to "Lipps Asvph"
	 *
	 * Create a program that takes a messager.
	 * Use any key you want (1 - 25) to shift each letter in the users input and save the final result to a file.
	 */
	public static void main(String[] args) {
		String message = JOptionPane.showInputDialog("Enter a message to encrypt.");
		char[] encrypted = new FileEncryptor().encrypt(message);
		try {
			FileWriter fw = new FileWriter("src/_02_File_Encrypt_Decrypt/message.txt");
			fw.write(encrypted);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	char[] encrypt(String input) {
		char[] chars = input.toCharArray();
		for(int i = 0; i < chars.length; i++) {
			for(int j = 0; j < beforeShift.length; j++) {
				if(chars[i] == beforeShift[j]) {
					chars[i] = afterShift[j];
					break;
				}
			}
		}
		return chars;
	}
}
//Copyright © 2020 Tyler Cheng
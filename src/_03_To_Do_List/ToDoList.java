package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener {
	ArrayList<String> tasks = new ArrayList<String>();
	FileWriter fw;
	JFrame frame;
	JPanel panel;
	JButton add;
	JButton view;
	JButton remove;
	JButton save;
	JButton load;
	
	public static void main(String[] args) {
		new ToDoList().createFrame();
	}
	
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save list, and load list. 
	 *
	 * When add task is clicked:
	 * 		Create a JOptionPane to ask the user for a task and add it to an ArrayList
	 * 
	 * When the view tasks button is clicked:
	 *		show all the tasks in the list
	 * 
	 * When the remove task button is clicked:
	 * 		Create a JOptionPane to prompt the user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked:
	 * 		Save the list to a file
	 * 
	 * When the load list button is clicked:
	 * 		Create a JOptionPane to Prompt the user for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file into the list. 
	 */
	
	void createFrame() {
		frame = new JFrame();
		panel = new JPanel();
		add = new JButton();
		view = new JButton();
		remove = new JButton();
		save = new JButton();
		load = new JButton();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		add.setText("Add task");
		panel.add(add);
		add.addActionListener(this);
		view.setText("View tasks");
		panel.add(view);
		view.addActionListener(this);
		remove.setText("Remove task");
		panel.add(remove);
		remove.addActionListener(this);
		save.setText("Save task file");
		panel.add(save);
		save.addActionListener(this);
		load.setText("Load task file");
		panel.add(load);
		load.addActionListener(this);
		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Object s = arg0.getSource();
		if (s == add) {
			tasks.add(JOptionPane.showInputDialog("Enter a task."));
		} else if (s == view) {
			for(int i = 0; i < tasks.size(); i++) {
				System.out.println(tasks.get(i));
			}
		} else if (s == remove) {
			String[] options = new String[tasks.size()];
			for(int i = 0; i < tasks.size(); i++) {
				options[i] = tasks.get(i);
			}
			int rm = JOptionPane.showOptionDialog(null, "What task would you like to remove?", "Task removal", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[options.length-1]);
			tasks.remove(rm);
		} else if (s == save) {
			try {
				fw = new FileWriter("src/_03_To_Do_List/taskList.txt");
				for(int i = 0; i < tasks.size(); i++) {
					if(i == tasks.size() - 1) {
						fw.write(tasks.get(i));
					} else {
						fw.write(tasks.get(i) + "\n");
					}
				}
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (s == load) {
			tasks = new ArrayList<String>();
			JFileChooser jfc = new JFileChooser();
			int returnVal = jfc.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				String fileName = jfc.getSelectedFile().getAbsolutePath();
				try {
					BufferedReader br = new BufferedReader(new FileReader(fileName));
					String line = br.readLine();
					while(line != null){
						tasks.add(line);
						line = br.readLine();
					}
					
					br.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
//Copyright © 2020 Tyler Cheng
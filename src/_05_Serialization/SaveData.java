package _05_Serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 * Complete this class so that it can be serialized.
 */

public class SaveData implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3622601664545405337L;
	public final String name;
	public final int age;

	public SaveData(String name, int age) {
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "SaveData [name=" + name + ", age=" + age + "]";
	}
}
//Copyright © 2020 Tyler Cheng
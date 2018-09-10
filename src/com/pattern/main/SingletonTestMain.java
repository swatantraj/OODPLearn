package com.pattern.main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

import com.creation.singleton.FirstSingleton;
import com.creation.singleton.SecondSingleton;
import com.creation.singleton.ThirdSingleton;

public class SingletonTestMain {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		FirstSingleton ins1 = FirstSingleton.getInstance();
		System.out.println(ins1);
		FirstSingleton ins2 = FirstSingleton.getInstance();
		System.out.println(ins2);
		System.out.println("--------------------------------------------");

		SecondSingleton ins3 = SecondSingleton.getInstance();
		System.out.println(ins3);
		SecondSingleton ins4 = SecondSingleton.getInstance();
		System.out.println(ins4);

//		breakWithReflection();
//		System.out.println("--------------------------------------------");
//		breakWithSerialization();
//		System.out.println("--------------------------------------------");
		breakwithCloning(ins3);
		System.out.println("--------------------------------------------");

		System.out.println("--------------------------------------------");

		ThirdSingleton.INSTANCE.doStuff();
		ThirdSingleton.INSTANCE.doStuff();

	}

	private static void breakwithCloning(SecondSingleton ins3) {
		// Breaking Singleton with Cloning > START
		SecondSingleton instance1 = ins3;
		SecondSingleton instance2 = null;
		try {
			instance2 = (SecondSingleton) instance1.clone();
		} catch (CloneNotSupportedException e) {e.printStackTrace();}

		finally {
			System.out.println("SERIALIZATION instance1.hashCode():- " + instance1.hashCode());
			System.out.println("SERIALIZATION instance2.hashCode():- " + instance2.hashCode());
			System.out.println(instance1);
			System.out.println(instance2);
		}
		// Breaking Singleton with Serialization > END
		// Override Cloning method to throw CloneNotSupported Exception
		// Override Cloning method to return same instance of Class
	}

	private static void breakWithSerialization() {
		// Breaking Singleton with Serialization > START
		SecondSingleton instance1 = SecondSingleton.getInstance();
		SecondSingleton instance2 = null;
		
		ObjectOutput out;
		ObjectInput in;
		try {
			out = new ObjectOutputStream(new FileOutputStream("myFile.txt"));
			out.writeObject(instance1);
			out.close();
			
			in = new ObjectInputStream(new FileInputStream("myFile.txt"));
			instance2 = (SecondSingleton) in.readObject();
			in.close();
		} catch (IOException | ClassNotFoundException e) {e.printStackTrace();}
		
		finally {
			System.out.println("SERIALIZATION instance1.hashCode():- " + instance1.hashCode());
			System.out.println("SERIALIZATION instance2.hashCode():- " + instance2.hashCode());
			System.out.println(instance1);
			System.out.println(instance2);
		}
		// Breaking singleton with Serialization > END
		// Implement readResolve Method to return the same instance
	}

	private static void breakWithReflection() {
		// Breaking singleton with Reflection > START
		FirstSingleton instance1 = FirstSingleton.getInstance();
		FirstSingleton instance2 = null;
		try {
			Constructor[] constructors = FirstSingleton.class.getDeclaredConstructors();
			for (Constructor constructor : constructors) {
				// Below code will destroy the singleton pattern
				constructor.setAccessible(true);
				instance2 = (FirstSingleton) constructor.newInstance();
				break;
			}
		}

		catch (Exception e) {e.printStackTrace();}
		
		finally {
			System.out.println("REFLECTION instance1.hashCode():- " + instance1.hashCode());
			System.out.println("REFLECTION instance2.hashCode():- " + instance2.hashCode());
			System.out.println(instance1);
			System.out.println(instance2);
		}

		// Breaking singleton with Reflection > END
		// Create with ENUM to byPass this > drawback LAZY initialization lost
		
	}

}

// TextLab08st.java
// The "Text File" Program
// This is the student, starting version of Text Lab 08.


import java.io.*;
import java.util.Arrays;


public class TextLab08v80Chivallati
{
	private static String names[];
	private static int fileSize;

	public static void main (String args[]) throws IOException
	{
		System.out.println("\nTextLab08\n");
		names = new String[100];
		readFile("src/Names1.txt");
		displayArray();
		sortArray();
		displayArray();           // Uncomment this line for 100 point version only.
		writeFile("src/Names2.txt");
	}

	public static void readFile(String fileName) throws IOException
	{

		ExpoInFile f = new ExpoInFile(fileName);
		String inString = f.readString();
		int i = 0;

		while(inString != null) {
			System.out.println(inString);
			inString = f.readString();
			names[i] = f.readString();
		}

		f.closeFile();
		System.out.println("\n\n");

	}

	public static void displayArray()
	{
		System.out.println("Names Array Contents\n");
		int i = 0;
		while (names[i] != null) {
			System.out.println(names[i]);
			i++;
		}


		System.out.println();
	}

	public static void sortArray()
	{
		Arrays.sort(names);
	}

	public static void writeFile(String fileName) throws IOException
	{

		ExpoInFile input = new ExpoInFile("src/Names1.txt");
		ExpoOutFile output = new ExpoOutFile(fileName);

		String inString = input.readString();
		while(inString != null)
		{
			output.writelnString(inString);
			inString = input.readString();
		}

		input.closeFile();
		output.closeFile();

	}

}
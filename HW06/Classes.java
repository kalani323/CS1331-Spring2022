import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
/**
 * HW06 : Classes.java .
 * @author kalanidissanayake
 * @version 1
 */
public class Classes {
    /**
     * creates an ArrayList from the courses specified on a file.
     * @param fileName : a String object representing the file name to read from
     * @return an Arraylist of course Objects
     */
    public static ArrayList<Course> outputCourses(String fileName) throws FileNotFoundException {
        ArrayList<Course> courses = new  ArrayList<Course>();
        File myFile = new File(fileName);
        Scanner s = new Scanner(myFile);
        while (s.hasNextLine()) {
            String sLine = s.nextLine();
            String[] splitLine = sLine.trim().split(",");
            if (splitLine[0].equals("ComputerScience")) {
                ComputerScience temp = new ComputerScience(splitLine[1], Integer.parseInt(splitLine[2]),
                    splitLine[3], splitLine[4]);
                courses.add(temp);
            } else if (splitLine[0].equals("LabScience")) {
                LabScience temp = new LabScience(splitLine[1], Integer.parseInt(splitLine[2]),
                    splitLine[3], Boolean.parseBoolean(splitLine[4]));
                courses.add(temp);
            } else {
                throw new InvalidCourseException();
            }
        }
        return courses;
    }
    /**
     * writes the courses to a file.
     * @param filename : a String object representing the file name to write to
     * @param courses : an ArrayList of Course objects
     * @return boolean value representing whether the write was successful
     */
    public static boolean writeCourses(String filename, ArrayList<Course> courses) throws FileNotFoundException {
        try {
            File myfile = new File(filename);
            PrintWriter printFile = new PrintWriter(myfile);
            for (int i = 0; i < courses.size(); i++) {
                printFile.println(courses.get(i).toString());
            }
            printFile.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    /**
     * shows the locations of the course object in the file.
     * @param fileName : a String representing the file name to read from
     * @param c : a course object
     * @return an ArrayList of Integer objects (that represents the locations the object is found)
     */
    public static ArrayList<Integer> readCourses(String fileName, Course c) throws FileNotFoundException {
        ArrayList<Integer> spots = new ArrayList<Integer>();
        ArrayList<Course> courses = outputCourses(fileName);
        for (int i = 0; i < courses.size(); i++) {
            if (c.equals(courses.get(i))) {
                spots.add(i + 1);
            }
        }
        if (spots.size() == 0) {
            throw new InvalidCourseException();
        }
        return spots;
    }
} // end class

/**
 * HW06 : LabScience.java .
 * @author kalanidissanayake
 * @version 1
 */
public class LabScience extends Course {
    private boolean labCoatRequired;
    /**
     * constructs LabScience.
     * @param courseName : the name of the course
     * @param id : the course identification number
     * @param professorName : the name of the professor teaching the course
     * @param labCoatRequired : a boolean representing wherher a lab coat is needed
     */
    public LabScience(String courseName, int id, String professorName, boolean labCoatRequired) {
        super(courseName, id, professorName);
        this.labCoatRequired = labCoatRequired;
    }
    /**
     * creates a String representation of LabScience.
     * @return String representation of LabScience
     */
    public String toString() {
        return ("LabScience," + super.toString() + "," + labCoatRequired);
    }
    /**
     * compares if one object is equal to this LabScience object.
     * @param o : object o (object being compared)
     * @return true (if the object equals this LabScience) or
     * false (if the object is not equal to this LabScience)
     */
    public boolean equals(Object o) {
        if (o instanceof LabScience) {
            LabScience oLS = (LabScience) o;
            return (super.equals(oLS) && this.labCoatRequired == oLS.labCoatRequired);
        }
        return false;
    }
}

/**
 * HW06 : Course.java .
 * @author kalanidissanayake
 * @version 1
 */
public abstract class Course {
    protected String courseName;
    protected int id;
    protected String professorName;
    /**
     * constructs Course.
     * @param courseName : the name of the course
     * @param id : the course identification number
     * @param professorName : the name of the professor teaching the course
     */
    public Course(String courseName, int id, String professorName) {
        setCourseName(courseName);
        setId(id);
        setProfessorName(professorName);
    }
    /**
     * creates a String representation of Course.
     * @return String representation of Course
     */
    public String toString() {
        return (courseName + "," + id + "," + professorName);
    }
    /**
     * compares if one object is equal to this course object.
     * @param o : object o (object being compared)
     * @return true (if the object equals this Course) or
     * false (if the object is not equal to this Course)
     */
    public boolean equals(Object o) {
        if (o instanceof Course) {
            Course oC = (Course) o;
            return ((oC.courseName.equals(this.courseName))
                    && (oC.professorName.equals(this.professorName))
                    && oC.id == this.id);
        }
        return false;
    }
    /**
     * set the courseName (throws InvalidArgumentException if invalid).
     * @param courseName : the name of the course
     */
    public void setCourseName(String courseName) {
        if (courseName == null || courseName.equals("")) {
            throw new IllegalArgumentException();
        } else {
            this.courseName = courseName;
        }
    }
    /**
     * set the id (throws InvalidArgumentException if invalid).
     * @param id : the course identification number
     */
    public void setId(int id) {
        if (id < 0 || String.valueOf(id).length() != 5) {
            throw new IllegalArgumentException();
        } else {
            this.id = id;
        }
    }
    /**
     * set the professorName (throws InvalidArgumentException if invalid).
     * @param professorName : the name of the professor teaching the course
     */
    public void setProfessorName(String professorName) {
        if (professorName == null || professorName.equals("")) {
            throw new IllegalArgumentException();
        } else {
            this.professorName = professorName;
        }
    }
}

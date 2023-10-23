/**
 * HW06 : InvalidCourseException.java .
 * @author kalanidissanayake
 * @version 1
 */
public class InvalidCourseException extends RuntimeException {
    /**
     * constructs InvalidCourseException.
     * @param message : String representing the exception message
     */
    public InvalidCourseException(String message) {
        super(message);
    }
    /**
     * constructs InvalidCourseException.
     */
    public InvalidCourseException() {
        super("Invalid couse type!");
    }
}

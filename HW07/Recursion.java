/**
 * HW07 : Recursion.java .
 * @author kalanidissanayake
 * @version 1
 */
public class Recursion {
    /**
     * sorts the array using merge sort.
     * @param strings : an array of strings (unsorted)
     * @return a string array containing the elements of the input sorted
     * in ascending lexicographical order
     */
    public static String[] mergeSort(String[] strings) {
        int l = 0;
        int r = strings.length;
        int m = r / 2;
        int size1 = m - l + 1;
        int size2 = r - m;
        String[] left = RecursionUtils.copyOfRange(strings, 0, m);
        for (int i = 0; i < left.length; i++) {
            for (int j = i + 1; j < left.length; j++) {
                String tmp = "";
                if (left[i].compareTo(left[j]) > 0) {
                    tmp = left[i];
                    left[i] = left[j];
                    left[j] = tmp;
                }
            }
        }
        String[] right = RecursionUtils.copyOfRange(strings, m + 1, r);
        for (int i = 0; i < right.length; i++) {
            for (int j = i + 1; j < right.length; j++) {
                String tmp = "";
                if (right[i].compareTo(right[j]) > 0) {
                    tmp = right[i];
                    right[i] = right[j];
                    right[j] = tmp;
                }
            }
        }
        String[] sorted = RecursionUtils.merge(left, right);
        return sorted;
    } // end mergeSort
    /**
     * combines a 2d array into a 1d array.
     * CALLS a recursive method.
     * @param strings : a 2d array, where each index stores an ascending sorted array of Strings
     * @return a 1d string array containing all strings from each index of the input in ascending
     * lexicographical order
     */
    public static String[] mergeAll(String[][] strings) {
        String[] newStrings = new String[strings.length * strings[0].length];
        String[] updatedStrings = mergeAllHelper(newStrings, strings, 0);
        return updatedStrings;
    }
    /**
     * helps the mergeAll method.
     * a recursive method
     * @param newStrings : the string array that will ultimately be containing all
     * Strings from each index of the input in ascendingnlexicographical order.
     * @param strings : a 2d array, where each index stores an ascending sorted array of Strings
     * @param k : the index
     * @return returned the merged array at a given index
     */
    public static String[] mergeAllHelper(String[] newStrings, String[][] strings, int k) {
        if (k == strings.length - 1) {
            return newStrings;
        } else {
            RecursionUtils.merge(newStrings, RecursionUtils.copyOfRange(strings[k], 0, strings[k].length));
            return (mergeAllHelper(newStrings, strings, k + 1));
        }
    }
    /**
     * counts the number of duplicate strings.
     * a recursive method.
     * @param strings : a string array, which will be sorted in ascending lexicographical order.
     * @return a string array containing all Strings from each index of the input in ascending
     * lexicographical order.
     */
    public static int countDuplicates(String[] strings) {
        int bottom = 0;
        int top = strings.length;
        if (bottom == top) {
            return 0;
        } else {
            int med = (bottom + top) / 2;
            String flag = "";
            String[] left = RecursionUtils.copyOfRange(strings, bottom, med);
            String[] right = RecursionUtils.copyOfRange(strings, med + 1, top);
            int n = countDuplicates(left) + countDuplicates(right);
            if (strings[med].equals(strings[med + 1])) {
                flag = strings[med - 1];
                if (flag != strings[med]) {
                    n++;
                }
            }
            return n;
        }
    }
    /**
     * A palindrome is a String that reads the same forwards and backwards.
     * this method verifies if a string is a palindrome or not
     * a recursive method.
     * @param s : String that we want to verify
     * @return boolean, representing if the input string was a palindrome.
     */
    public static boolean verifyPalindrome(String s) {
        s = s.toLowerCase();
        if (s.equals("")) {
            return true;
        } else if (s.equals(null)) {
            return false;
        } else {
            return s.length() <= 1 || (s.charAt(0) == s.charAt(s.length() - 1)
                     && verifyPalindrome(s.substring(1, s.length() - 1)));
        }
    }
    /**
     * checks how many of the points are in the given radius
     * a recursive method.
     * @param points : represents the Cartesian coordinates for a set of points.
     * @param radius : represents the radius of a circle centered at the origin
     * @return an int representing the number of points that are strictly within the circle
     */
    public static int numInteriorPoints(Point[] points, int radius) {
        int n = 0;
        if (n == points.length - 1 || points[n] == null) {
            return 0;
        } else {
            if ((Math.abs(points[n].getX()) + Math.abs(points[n].getY()) <= radius)) {
                Point[] newArray = new Point[points.length];
                for (int i = 0; i < points.length - 1; i++) {
                    newArray[i] = points[i + 1];
                }
                return 1 + numInteriorPoints(newArray, radius);
            } else {
                Point[] newArray = new Point[points.length];
                for (int i = 0; i < points.length - 1; i++) {
                    newArray[i] = points[i + 1];
                }
                return 0 + numInteriorPoints(newArray, radius);
            }
        }
    }
} // end class

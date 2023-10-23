// Kalani Dissanayake
// PE04
import java.util.Scanner;
public class Playlist {
    public static void main(String[] args) {
        String[] genres = {"Rap", "Pop", "Classical", "Hip Hop", "Rock", "Lo Fi"};
        String[] playlist1 = {"Classical", "Pop", "Classical", "Classical", "Rock", "Rap", "Lo fi"};
        String[] playlist2 = {"Pop", "Pop", "Pop", "Lo fi", "Hip Hop", "Rap", "Rap"};
        Scanner scan = new Scanner(System.in);
        addPlaylistInfo(scan);
        addPlaylistInfo(scan);
        int[] genreTally1 = genreTally(playlist1, genres);
        int[] genreTally2 = genreTally(playlist2, genres);
        playlistScores(playlist1, playlist2, genres);
    } // end main method
    public static void addPlaylistInfo(Scanner scan) {
        System.out.print("Enter number of songs in playlist: ");
        int numSongs = scan.nextInt();
        scan.nextLine();
        System.out.print("Enter a playlist name: ");
        String playlistName = scan.nextLine();
        System.out.println("Playlist created successfully. Here are the details:\nNumber of songs: "
                + numSongs + "\nName: " + playlistName);
    } // end addPlaylistInfo method
    public static int[] genreTally(String[] genreArray, String[] genres) {
        int[] tally = new int[genres.length];
        System.out.println("The following types of genres are in your playlist");
        for (String g: genreArray) {
            for (int i = 0; i < genres.length; i++) {
                if (g.equals(genres[i])) {
                    tally[i] += 1;
                } // end if
            } // end for
        } // end for each
        for (int i = 0; i < genres.length; i++) {
            System.out.println(genres[i] + " " + tally[i]);
        }
        return tally;
    } // end genreTally method
    public static void playlistScores(String[] playlist1, String[] playlist2, String[] genres) {
        int[] tallyArray1 = genreTally(playlist1, genres);
        int[] tallyArray2 = genreTally(playlist2, genres);
        int playlistOneScore = 0;
        int paylistTwoScore = 0;
        for (int i = 0; i < tallyArray1.length; i++) {
            playlistOneScore += (i * tallyArray1[i]);
        } // end for loop (calculating p1)
        for (int i = 0; i < tallyArray2.length; i++) {
            paylistTwoScore += (i * tallyArray2[i]);
        } // end for loop (calculating p2)
        if (playlistOneScore > paylistTwoScore) {
            System.out.println("The first playlist is likely to have more listeners than the second");
        } // end (greater than if)
        if (playlistOneScore < paylistTwoScore) {
            System.out.println("The second playlist is likely to have more listeners than the first");
        } // end (less than if)
        if (playlistOneScore == paylistTwoScore) {
            System.out.println("The two playlists are predicted to preform equally well.");
        } // end (equal to if)
    } // end playlistScores method

} // end class

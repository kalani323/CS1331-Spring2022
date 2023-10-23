/**
 * HW02 : GoldenTicket.java.
 * @author kalanidissanayake
 * @version 1
 */
public class GoldenTicket {
    private String catchphrase;
    private double discount;
   /**
    * Constrcuts the GoldenTicket object.
    * @param catchphrase : string that represents the catchphrase that is printed on every ticket
    * @param discount : a double representing the discunt offered by the ticket
    */
    public GoldenTicket(String catchphrase, double discount) {
        setCatchphrase(catchphrase);
        setDiscount(discount);
    }
   /**
    * creates string representation of object.
    * @return string representation of object
    */
    public String ticketString() {
        return String.format("Golden Ticket with %.2f%% discount! %s", discount, catchphrase);
    }
   /**
    * get catchphrase.
    * @return catchphrase : string that represents the catchphrase that is printed on every ticket
    */
    public String getCatchphrase() {
        return catchphrase;
    }
   /**
    * get discount.
    * @return discount : a double representing the discunt offered by the ticket
    */
    public double getDiscount() {
        return discount;
    }
   /**
    * set catchphrase.
    * @param catchphrase : string that represents the catchphrase that is printed on every ticket
    */
    public void setCatchphrase(String catchphrase) {
        this.catchphrase = catchphrase;
        if (catchphrase == null || catchphrase.equals("")) {
            this.catchphrase = "Congrats!";
        }
    }
   /**
    * set discount.
    * @param discount : a double representing the discunt offered by the ticket
    */
    public void setDiscount(double discount) {
        this.discount = discount;
        if (discount < 0 || discount > 25) {
            this.discount = 15.0;
        }
    }
}

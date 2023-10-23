/**
 * HW02 : Warehouse.java.
 * @author kalanidissanayake
 * @version 1
 */
public class Warehouse {
    /**
     * driver, used to test and execute all the other classes.
     * @param args : command line arguments
     */
    public static void main(String[] args) {
        PaperProduct pp1 =  new PaperProduct("Maddy", 360, 0.15);
        PaperProduct pp2 = new PaperProduct("Becca", 250);
        PaperProduct pp3 =  new PaperProduct("Mary");
        PaperProduct pp1Copy = new PaperProduct(pp1);

        GoldenTicket ticket = new GoldenTicket("HELLO!", 30);

        DiscountedPaper dp1 = new DiscountedPaper("Grace", 200, 0.3, 15, ticket);
        DiscountedPaper dp2 = new DiscountedPaper("Emily", 100);
        DiscountedPaper dp3 = new DiscountedPaper("Izzy");
        DiscountedPaper dp1Copy = new DiscountedPaper(dp1);

        PhotoPaper p1 = new PhotoPaper("Sara", 400, 0.1, 45);
        PhotoPaper p2 = new PhotoPaper("Emma", 50);
        PhotoPaper p3 = new PhotoPaper("Cassie");
        PhotoPaper p1Copy = new PhotoPaper(p1);

        System.out.println(pp1.paperString());
        System.out.println(pp2.paperString());
        System.out.println(pp3.paperString());
        System.out.println(pp1Copy.paperString());

        System.out.println(ticket.ticketString());

        System.out.println(dp1.shipDiscounted("Kalani and Co."));
        System.out.println(dp2.shipDiscounted("Kalani and Co."));
        System.out.println(dp3.shipDiscounted("Kalani and Co."));
        System.out.println(dp1Copy.shipDiscounted("Kalani and Co."));

        System.out.println(p1.shipPhoto("Kalani and Co."));
        System.out.println(p2.shipPhoto("Kalani and Co."));
        System.out.println(p3.shipPhoto("Kalani and Co."));
        System.out.println(p1Copy.shipPhoto("Kalani and Co."));

        System.out.println(dp1.botherAccounting());
        System.out.println(dp2.botherAccounting());
        System.out.println(dp3.botherAccounting());
        System.out.println(dp1Copy.botherAccounting());
    }
}

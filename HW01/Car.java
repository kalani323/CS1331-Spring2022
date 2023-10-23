public class Car {
    private int year;
    private String make;
    private String model;
    private String color;
    private int conditionCategory;
    private boolean isRestored;

    public Car(int year, String make, String model, String color, int conditionCategory) {
        this.year = year;
        this.make = make;
        this.model = model;
        this.color = color;
        this.conditionCategory = conditionCategory;
        if (conditionCategory < 40 || conditionCategory > 100) {
            this.conditionCategory = 80;
        }
        if (conditionCategory >= 90 && conditionCategory <= 100) {
            System.out.println("Perfect");
        }
        if (conditionCategory >= 80 && conditionCategory <= 89) {
            System.out.println("Excellent");
        }
        if (conditionCategory >= 70 && conditionCategory <= 79) {
            System.out.println("Fine");
        }
        if (conditionCategory >= 60 && conditionCategory <= 69) {
            System.out.println("Very Good");
        }
        if (conditionCategory >= 50 && conditionCategory <= 59) {
            System.out.println("Good");
        }
        if (conditionCategory >= 40 && conditionCategory <= 49) {
            System.out.println("Driver");
        }
        if (this.conditionCategory >= 90) {
            this.isRestored = true;
        } else {
            this.isRestored = false;
        }
    }

    public Car(int year, String make, String model) {
        this(year, make, model, "blue", 80);
    }
    public Car() {
        this(1960, "Jaguar", "E-Type", "silver", 89);
    }
    public String getColor() {
        return color;
    }
    public int getYear() {
        return year;
    }
    public String getMake() {
        return make;
    }
    public String getModel() {
        return model;
    }
    public int getConditionCategory() {
        return conditionCategory;
    }

} //end class

/**
 * Represents a policy holder with personal details such as name, age, height, weight, 
 * and smoking status, along with methods to calculate the Body Mass Index (BMI).
 */
public class PolicyHolder {
    // Attributes
    private String firstName;
    private String lastName;
    private int age;
    private String smokingStatus;
    private double height; // in inches
    private double weight; // in pounds

    // Constants
    private static final double BMI_CONVERSION_FACTOR = 703.0;

    /**
     * Default no-argument constructor that initializes all attributes to default values.
     */
    public PolicyHolder() {
        this.firstName = "";
        this.lastName = "";
        this.age = 0;
        this.smokingStatus = "non-smoker";
        this.height = 0.0;
        this.weight = 0.0;
    }

    /**
     * Constructor with all parameters to initialize a PolicyHolder instance.
     *
     * @param firstName     the first name of the policy holder
     * @param lastName      the last name of the policy holder
     * @param age           the age of the policy holder
     * @param smokingStatus the smoking status of the policy holder
     * @param height        the height of the policy holder in inches
     * @param weight        the weight of the policy holder in pounds
     */
    public PolicyHolder(String firstName, String lastName, int age, String smokingStatus, double height, double weight) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.smokingStatus = smokingStatus;
        this.height = height;
        this.weight = weight;
    }

    // Getters and Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSmokingStatus() {
        return smokingStatus;
    }

    public void setSmokingStatus(String smokingStatus) {
        this.smokingStatus = smokingStatus;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Calculates the Body Mass Index (BMI) of the policy holder.
     *
     * @return the calculated BMI value
     */
    public double calculateBMI() {
        return (weight * BMI_CONVERSION_FACTOR) / (height * height);
    }
}
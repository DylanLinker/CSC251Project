/**
 * Represents an insurance policy with attributes for policy number, provider name,
 * policy holder's details (name, age, height, weight, smoking status), and methods
 * for calculating Body Mass Index (BMI) and the total policy price.
 */
public class Policy {
    // Attributes
    private String policyNumber;
    private String providerName;
    private String policyHolderFirstName;
    private String policyHolderLastName;
    private int policyHolderAge;
    private String smokingStatus;
    private double policyHolderHeight; // in inches
    private double policyHolderWeight; // in pounds

    // Constants
    private static final double BASE_FEE = 600.0;
    private static final double AGE_FEE = 75.0;
    private static final double SMOKER_FEE = 100.0;
    private static final double BMI_THRESHOLD = 35.0;
    private static final double BMI_EXTRA_FEE_PER_UNIT = 20.0;
    private static final double BMI_CONVERSION_FACTOR = 703.0;

    /**
     * Default no-argument constructor that initializes all attributes to default values.
     */
    public Policy() {
        this.policyNumber = "";
        this.providerName = "";
        this.policyHolderFirstName = "";
        this.policyHolderLastName = "";
        this.policyHolderAge = 0;
        this.smokingStatus = "non-smoker";
        this.policyHolderHeight = 0.0;
        this.policyHolderWeight = 0.0;
    }

    /**
     * Constructor with all parameters to initialize a Policy instance.
     *
     * @param policyNumber  the policy number
     * @param providerName  the name of the provider
     * @param firstName     the first name of the policy holder
     * @param lastName      the last name of the policy holder
     * @param age           the age of the policy holder
     * @param smokingStatus the smoking status of the policy holder (e.g., "smoker" or "non-smoker")
     * @param height        the height of the policy holder in inches
     * @param weight        the weight of the policy holder in pounds
     */
    public Policy(String policyNumber, String providerName, String firstName,
                  String lastName, int age, String smokingStatus,
                  double height, double weight) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.policyHolderFirstName = firstName;
        this.policyHolderLastName = lastName;
        this.policyHolderAge = age;
        this.smokingStatus = smokingStatus;
        this.policyHolderHeight = height;
        this.policyHolderWeight = weight;
    }

    /**
     * Gets the policy number.
     *
     * @return the policy number
     */
    public String getPolicyNumber() {
        return policyNumber;
    }

    /**
     * Sets the policy number.
     *
     * @param policyNumber the policy number to set
     */
    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    /**
     * Gets the provider name.
     *
     * @return the provider name
     */
    public String getProviderName() {
        return providerName;
    }

    /**
     * Sets the provider name.
     *
     * @param providerName the provider name to set
     */
    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    /**
     * Gets the first name of the policy holder.
     *
     * @return the first name of the policy holder
     */
    public String getPolicyHolderFirstName() {
        return policyHolderFirstName;
    }

    /**
     * Sets the first name of the policy holder.
     *
     * @param firstName the first name of the policy holder to set
     */
    public void setPolicyHolderFirstName(String firstName) {
        this.policyHolderFirstName = firstName;
    }

    /**
     * Gets the last name of the policy holder.
     *
     * @return the last name of the policy holder
     */
    public String getPolicyHolderLastName() {
        return policyHolderLastName;
    }

    /**
     * Sets the last name of the policy holder.
     *
     * @param lastName the last name of the policy holder to set
     */
    public void setPolicyHolderLastName(String lastName) {
        this.policyHolderLastName = lastName;
    }

    /**
     * Gets the age of the policy holder.
     *
     * @return the age of the policy holder
     */
    public int getPolicyHolderAge() {
        return policyHolderAge;
    }

    /**
     * Sets the age of the policy holder.
     *
     * @param age the age of the policy holder to set
     */
    public void setPolicyHolderAge(int age) {
        this.policyHolderAge = age;
    }

    /**
     * Gets the smoking status of the policy holder.
     *
     * @return the smoking status of the policy holder
     */
    public String getSmokingStatus() {
        return smokingStatus;
    }

    /**
     * Sets the smoking status of the policy holder.
     *
     * @param smokingStatus the smoking status to set
     */
    public void setSmokingStatus(String smokingStatus) {
        this.smokingStatus = smokingStatus;
    }

    /**
     * Gets the height of the policy holder.
     *
     * @return the height of the policy holder in inches
     */
    public double getPolicyHolderHeight() {
        return policyHolderHeight;
    }

    /**
     * Sets the height of the policy holder.
     *
     * @param height the height of the policy holder in inches
     */
    public void setPolicyHolderHeight(double height) {
        this.policyHolderHeight = height;
    }

    /**
     * Gets the weight of the policy holder.
     *
     * @return the weight of the policy holder in pounds
     */
    public double getPolicyHolderWeight() {
        return policyHolderWeight;
    }

    /**
     * Sets the weight of the policy holder.
     *
     * @param weight the weight of the policy holder in pounds
     */
    public void setPolicyHolderWeight(double weight) {
        this.policyHolderWeight = weight;
    }

    /**
     * Calculates the Body Mass Index (BMI) of the policy holder.
     *
     * @return the calculated BMI value
     */
    public double calculateBMI() {
        return (policyHolderWeight * BMI_CONVERSION_FACTOR) / (policyHolderHeight * policyHolderHeight);
    }

    /**
     * Calculates the total policy price based on the base fee, age, smoking status,
     * and BMI of the policy holder.
     *
     * @return the calculated total policy price
     */
    public double calculatePolicyPrice() {
        double totalPrice = BASE_FEE;

        if (policyHolderAge > 50) {
            totalPrice += AGE_FEE;
        }

        if (smokingStatus.equalsIgnoreCase("smoker")) {
            totalPrice += SMOKER_FEE;
        }

        double bmi = calculateBMI();
        if (bmi > BMI_THRESHOLD) {
            totalPrice += (bmi - BMI_THRESHOLD) * BMI_EXTRA_FEE_PER_UNIT;
        }

        return totalPrice;
    }
}

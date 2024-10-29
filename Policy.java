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

    // No-arg constructor
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

    // Constructor with all parameters
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

    // Getters and Setters
    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getPolicyHolderFirstName() {
        return policyHolderFirstName;
    }

    public void setPolicyHolderFirstName(String firstName) {
        this.policyHolderFirstName = firstName;
    }

    public String getPolicyHolderLastName() {
        return policyHolderLastName;
    }

    public void setPolicyHolderLastName(String lastName) {
        this.policyHolderLastName = lastName;
    }

    public int getPolicyHolderAge() {
        return policyHolderAge;
    }

    public void setPolicyHolderAge(int age) {
        this.policyHolderAge = age;
    }

    public String getSmokingStatus() {
        return smokingStatus;
    }

    public void setSmokingStatus(String smokingStatus) {
        this.smokingStatus = smokingStatus;
    }

    public double getPolicyHolderHeight() {
        return policyHolderHeight;
    }

    public void setPolicyHolderHeight(double height) {
        this.policyHolderHeight = height;
    }

    public double getPolicyHolderWeight() {
        return policyHolderWeight;
    }

    public void setPolicyHolderWeight(double weight) {
        this.policyHolderWeight = weight;
    }

    public double calculateBMI() {
        return (policyHolderWeight * BMI_CONVERSION_FACTOR) / (policyHolderHeight * policyHolderHeight);
    }
    
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

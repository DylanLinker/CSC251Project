/**
 * Represents an insurance policy with attributes for policy number, provider name, 
 * and an associated policy holder, along with methods for calculating the total policy price.
 */
public class Policy {
    // Attributes
    private String policyNumber;
    private String providerName;
    private PolicyHolder policyHolder;
   
    // Static field to track the number of Policy objects created
    private static int policyCount = 0;
   
    // Constants
    private static final double BASE_FEE = 600.0;
    private static final double AGE_FEE = 75.0;
    private static final double SMOKER_FEE = 100.0;
    private static final double BMI_THRESHOLD = 35.0;
    private static final double BMI_EXTRA_FEE_PER_UNIT = 20.0;
   
    /**
     * Default no-argument constructor that initializes all attributes to default values.
     * Increments the policy count.
     */
    public Policy() {
        this.policyNumber = "";
        this.providerName = "";
        this.policyHolder = new PolicyHolder();
        policyCount++;
    }
   
    /**
     * Constructor with all parameters to initialize a Policy instance.
     * Increments the policy count.
     *
     * @param policyNumber  the policy number
     * @param providerName  the name of the provider
     * @param policyHolder  the associated policy holder
     */
    public Policy(String policyNumber, String providerName, PolicyHolder policyHolder) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.policyHolder = policyHolder;
        policyCount++;
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
   
    public PolicyHolder getPolicyHolder() {
        return policyHolder;
    }
   
    public void setPolicyHolder(PolicyHolder policyHolder) {
        this.policyHolder = policyHolder;
    }
   
    /**
     * Gets the current number of Policy objects created.
     *
     * @return the number of Policy objects created
     */
    public static int getPolicyCount() {
        return policyCount;
    }
   
    /**
     * Calculates the total policy price based on the base fee, age, smoking status,
     * and BMI of the policy holder.
     *
     * @return the calculated total policy price
     */
    public double calculatePolicyPrice() {
        double totalPrice = BASE_FEE;
   
        if (policyHolder.getAge() > 50) {
            totalPrice += AGE_FEE;
        }
   
        if (policyHolder.getSmokingStatus().equalsIgnoreCase("smoker")) {
            totalPrice += SMOKER_FEE;
        }
   
        double bmi = policyHolder.calculateBMI();
        if (bmi > BMI_THRESHOLD) {
            totalPrice += (bmi - BMI_THRESHOLD) * BMI_EXTRA_FEE_PER_UNIT;
        }
   
        return totalPrice;
    }
   
   @Override
   public String toString() {
       return "Policy Number: " + policyNumber + "\n" +
              "Provider Name: " + providerName + "\n" +
              policyHolder + "\n" + // Implicitly calls the PolicyHolder's toString method
              String.format("Policy Price: $%.2f", calculatePolicyPrice());
   }

}

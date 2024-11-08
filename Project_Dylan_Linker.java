import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Project_Dylan_Linker {

    public static void main(String[] args) {
        List<Policy> policies = new ArrayList<>();

        // Read policies from PolicyInformation.txt
        try (Scanner fileScanner = new Scanner(new File("PolicyInformation.txt"))) {
            while (fileScanner.hasNextLine()) {
                try {
                    // Read and process lines only if they are not blank
                    String policyNumberLine = getNextValidLine(fileScanner);
                    String providerName = getNextValidLine(fileScanner);
                    String firstName = getNextValidLine(fileScanner);
                    String lastName = getNextValidLine(fileScanner);

                    int age = Integer.parseInt(getNextValidLine(fileScanner));
                    String smokingStatus = getNextValidLine(fileScanner);
                    double height = Double.parseDouble(getNextValidLine(fileScanner));
                    double weight = Double.parseDouble(getNextValidLine(fileScanner));

                    // Create a Policy object and add it to the list
                    Policy policy = new Policy(policyNumberLine, providerName, firstName, lastName, age, smokingStatus, height, weight);
                    policies.add(policy);

                } catch (NumberFormatException e) {
                    System.out.println("Error parsing a number in the policy data.");
                } catch (Exception e) {
                    System.out.println("An error occurred while reading the policy data.");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file PolicyInformation.txt was not found.");
        }

        // Display the policy information for each policy in the list
        for (Policy policy : policies) {
            System.out.println();
            System.out.println("Policy Number: " + policy.getPolicyNumber());
            System.out.println("Provider Name: " + policy.getProviderName());
            System.out.println("Policyholder's First Name: " + policy.getPolicyHolderFirstName());
            System.out.println("Policyholder's Last Name: " + policy.getPolicyHolderLastName());
            System.out.println("Policyholder's Age: " + policy.getPolicyHolderAge());
            System.out.println("Policyholder's Smoking Status (smoker/non-smoker): " + policy.getSmokingStatus());
            System.out.println("Policyholder's Height: " + policy.getPolicyHolderHeight() + " inches");
            System.out.println("Policyholder's Weight: " + policy.getPolicyHolderWeight() + " pounds");

            // Calculate and display the BMI and Policy Price
            System.out.printf("Policyholder's BMI: %.2f%n", policy.calculateBMI());
            System.out.printf("Policy Price: $%.2f%n", policy.calculatePolicyPrice());
        }
    }

    /**
     * Reads the next non-blank line from the scanner.
     * 
     * @param scanner the scanner reading the file
     * @return the next non-blank line as a string
     */
    private static String getNextValidLine(Scanner scanner) {
        String line;
        do {
            line = scanner.nextLine().trim();
        } while (line.isEmpty() && scanner.hasNextLine());
        return line;
    }
}

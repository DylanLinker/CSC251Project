import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Project_Dylan_Linker {

    public static void main(String[] args) {
        List<Policy> policies = new ArrayList<>();
        int nonSmokerCount = 0;
        int smokerCount = 0;

        // Read policies from PolicyInformation.txt
        try (Scanner fileScanner = new Scanner(new File("PolicyInformation.txt"))) {
            while (fileScanner.hasNextLine()) {
                try {
                    // Read and process lines only if they are not blank
                    String policyNumber = getNextValidLine(fileScanner);
                    String providerName = getNextValidLine(fileScanner);
                    String firstName = getNextValidLine(fileScanner);
                    String lastName = getNextValidLine(fileScanner);

                    int age = Integer.parseInt(getNextValidLine(fileScanner));
                    String smokingStatus = getNextValidLine(fileScanner);

                    // Count smokers and non-smokers
                    if (smokingStatus.equalsIgnoreCase("smoker")) {
                        smokerCount++;
                    } else {
                        nonSmokerCount++;
                    }

                    double height = Double.parseDouble(getNextValidLine(fileScanner));
                    double weight = Double.parseDouble(getNextValidLine(fileScanner));

                    // Create a PolicyHolder and Policy, then add to the list
                    PolicyHolder policyHolder = new PolicyHolder(firstName, lastName, age, smokingStatus, height, weight);
                    Policy policy = new Policy(policyNumber, providerName, policyHolder);
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

        // Display the policy information using the toString method
        for (Policy policy : policies) {
            System.out.println(policy);
            System.out.println();
        }

        // Display the total number of policies and smoker/non-smoker counts
        System.out.println("There were " + Policy.getPolicyCount() + " Policy objects created.");
        System.out.println("The number of policies with a smoker is: " + smokerCount);
        System.out.println("The number of policies with a non-smoker is: " + nonSmokerCount);
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

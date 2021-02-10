/** CSC 151 Project
 *
 * Author: Neil Svedberg
 * Date: 2021-02-05
 * Instructor: Jean Schoenheit
*/

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Get the policy number.
        int policyNumber;
        while (true) {
            System.out.print("Please enter the Policy Number: ");
            policyNumber = in.nextInt();

            if (policyNumber > 0) {
                break;
            } else {
                System.out.println("The policy number must be a positive integer.");
            }
        }

        // Clear the scanner's input buffer.
        in.nextLine();

        // Get the provider's name.
        System.out.print("Please enter the Provider Name: ");
        String provider = in.nextLine();

        // Get the policy holder's first name.
        System.out.print("Please enter the Policyholder’s First Name: ");
        String firstName = in.nextLine();

        // Get the policy holder's last name.
        System.out.print("Please enter the Policyholder’s Last Name: ");
        String lastName = in.nextLine();

        // Get the policy holder's age.
        int holderAge;
        while (true) {
            System.out.print("Please enter the Policyholder’s Age: ");
            holderAge = in.nextInt();

            if (holderAge > 0) {
                break;
            } else {
                System.out.println("The policy holder's age must be a positive integer.");
            }
        }

        // Clear the scanner's input buffer.
        in.nextLine();

        // Get whether or not the policy holder smokes.
        boolean isSmoking;
        String isSmokingStr;

        while (true) {
            System.out.print("Please enter the Policyholder’s Smoking Status (smoker/non-smoker): ");
            isSmokingStr = in.nextLine().trim();

            if (isSmokingStr.equals("smoker")) {
                isSmoking = true;
                break;
            } else if (isSmokingStr.equals("non-smoker")) {
                isSmoking = false;
                break;
            } else {
                System.out.println("Please enter either smoker or non-smoker.");
            }
        }

        // Get the policy holder's height.
        float holderHeightInches;
        while (true) {
            System.out.print("Please enter the Policyholder’s Height (in inches): ");
            holderHeightInches = in.nextFloat();

            if (holderHeightInches > 0) {
                break;
            } else {
                System.out.println("The policy holder's height must be a positive decimal.");
            }
        }

        // Get the policy holder's weight.
        float holderWeightPounds;
        while (true) {
            System.out.print("Please enter the Policyholder’s Weight (in pounds): ");
            holderWeightPounds = in.nextFloat();

            if (holderWeightPounds > 0) {
                break;
            } else {
                System.out.println("The policy holder's weight must be a positive decimal.");
            }
        }

        Policy policy = new Policy(
            policyNumber,
            provider,
            firstName,
            lastName,
            holderAge,
            isSmoking,
            holderHeightInches,
            holderWeightPounds
        );

        // Display the contents of the policy.
        System.out.printf("Policy Number: %d\n", policy.getPolicyNumber());
        System.out.printf("Provider Name: %s\n", policy.getProvider());
        System.out.printf("Policyholder’s First Name: %s\n", policy.getFirstName());
        System.out.printf("Policyholder’s Last Name: %s\n", policy.getLastName());
        System.out.printf("Policyholder’s Age: %d\n", policy.getAge());
        System.out.print("Policyholder’s Smoking Status: ");
        if (policy.isSmoking()) {
            System.out.println("smoking");
        } else {
            System.out.println("non-smoking");
        }
        System.out.printf("Policyholder’s Height: %.1f\n", policy.getHolderHeight());
        System.out.printf("Policyholder’s Weight: %.1f\n", policy.getHolderWeight());
        System.out.printf("Policyholder’s BMI: %.2f\n", policy.bmi());
        System.out.printf("Policy Price: $%.2f\n", policy.totalPrice());
    }
}

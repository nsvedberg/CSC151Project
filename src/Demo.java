/** CSC 151 Project
 *
 * Author: Neil Svedberg
 * Instructor: Jean Schoenheit
*/

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        ArrayList<Policy> policies = new ArrayList<Policy>();
        File policyInformation = new File("PolicyInformation.txt");

        try (Scanner in = new Scanner(policyInformation, StandardCharsets.UTF_8.name())) {
            // Iterate over the lines in the policy information file.
            //
            // Policy fields are seperated by a newline, policies are seperated
            // by two newlines.
            while (in.hasNextLine()) {
                int policyNumber = in.nextInt();
                in.nextLine();

                String provider = in.nextLine();
                String firstName = in.nextLine();
                String lastName = in.nextLine();

                int holderAge = in.nextInt();
                in.nextLine();

                boolean isSmoking = in.nextLine().equals("smoker");

                float holderHeightInches = in.nextFloat();
                in.nextLine();

                float holderWeightPounds = in.nextFloat();
                in.nextLine();

                Policy newPolicy = new Policy(
                    policyNumber,
                    provider,
                    firstName,
                    lastName,
                    holderAge,
                    isSmoking,
                    holderHeightInches,
                    holderWeightPounds
                );

                policies.add(newPolicy);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        int totalSmokers = 0;
        int totalNonSmokers = 0;

        for (Policy policy : policies) {
            System.out.printf("Policy Number: %d\n", policy.getPolicyNumber());
            System.out.printf("Provider Name: %s\n", policy.getProvider());
            System.out.printf("Policyholder’s First Name: %s\n", policy.getFirstName());
            System.out.printf("Policyholder’s Last Name: %s\n", policy.getLastName());
            System.out.printf("Policyholder’s Age: %d\n", policy.getAge());
            System.out.print("Policyholder’s Smoking Status: ");
            if (policy.isSmoking()) {
                System.out.println("smoking");
                totalSmokers++;
            } else {
                System.out.println("non-smoking");
                totalNonSmokers++;
            }
            System.out.printf("Policyholder’s Height: %.1f\n", policy.getHolderHeight());
            System.out.printf("Policyholder’s Weight: %.1f\n", policy.getHolderWeight());
            System.out.printf("Policyholder’s BMI: %.2f\n", policy.bmi());
            System.out.printf("Policy Price: $%.2f\n", policy.totalPrice());
            System.out.println("");
        }

        System.out.printf("There are %d smokers and %d non-smokers in total.\n",
                totalSmokers, totalNonSmokers);
    }
}

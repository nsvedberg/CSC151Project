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

                PolicyHolder newHolder = new PolicyHolder(
                    firstName,
                    lastName,
                    holderAge,
                    isSmoking,
                    holderHeightInches,
                    holderWeightPounds
                );

                Policy newPolicy = new Policy(
                    policyNumber,
                    provider,
                    newHolder
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
            System.out.println(policy);

            if (policy.getPolicyHolder().isSmoking()) {
                totalSmokers++;
            } else {
                totalNonSmokers++;
            }
        }

        System.out.printf("There were %d Policy objects created.\n", Policy.getTotalPolicies());
        System.out.printf("The number of policies with a smoker is: %d\n", totalSmokers);
        System.out.printf("The number of policies with a non-smoker is: %d\n", totalNonSmokers);
    }
}

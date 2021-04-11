import java.util.Formatter;

public class Policy {
    /** The total number of policies. */
    static int totalPolicies;

    /** The policy number. */
    int policyNumber;

    /** The name of the provider. */
    String provider;

    /** The policy holder. */
    PolicyHolder policyHolder;

    /** Empty constructor. */
    public Policy() {
        policyNumber = 0;
        provider = "";
        policyHolder = new PolicyHolder();

        totalPolicies++;
    }

    /**
     * Full constructor.
     * 
     * @param policyNumber the policy number
     * @param provider the name of the provider
     * @param policyHolder the policy holder
     */
    public Policy(
        int policyNumber,
        String provider,
        PolicyHolder policyHolder
    ) {
        this.policyNumber = policyNumber;
        this.provider = provider;
        this.policyHolder = new PolicyHolder(policyHolder);

        totalPolicies++;
    }

    /**
     * Get the number of total policies.
     *
     * @return the number of total policies
     */
    public static int getTotalPolicies() {
        return totalPolicies;
    }

    /**
     * Get the policy number.
     *
     * @return the policy number
     */
    public int getPolicyNumber() {
        return policyNumber;
    }

    /**
     * Get the policy provider name.
     *
     * @return the provider name
     */
    public String getProvider() {
        return provider;
    }

    /**
     * Get the policy holder.
     *
     * @return the policy holder
     */
    public PolicyHolder getPolicyHolder() {
        return policyHolder;
    }

    /**
     * Calculate the total price of the insurance policy.
     *
     * @return the total price of the insurance policy
     */
    public float totalPrice() {
        float price = 600;

        if (policyHolder.getAge() > 50) {
            price += 75;
        }

        if (policyHolder.isSmoking()) {
            price += 100;
        }

        if (policyHolder.bmi() > 35) {
            price += (policyHolder.bmi() - 35) * 20;
        }

        return price;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        Formatter fmt = new Formatter(builder);

        fmt.format("Policy Number: %d\n", policyNumber);
        fmt.format("Provider Name: %s\n", provider);
        fmt.format("%s", policyHolder);
        fmt.format("Policy Price: $%.2f\n", totalPrice());

        return builder.toString();
    }
}

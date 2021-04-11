public class Policy {
    /** The policy number. */
    int policyNumber;

    /** The name of the provider. */
    String provider;

    /** Empty constructor. */
    public Policy() {
        policyNumber = 0;
        provider = "";
    }

    /**
     * Full constructor.
     * 
     * @param policyNumber the policy number
     * @param provider the name of the provider
     */
    public Policy(
        int policyNumber,
        String provider,
    ) {
        this.policyNumber = policyNumber;
        this.provider = provider;
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
     * Calculate the total price of the insurance policy.
     *
     * @return the total price of the insurance policy
     */
    public float totalPrice() {
        float price = 600;

        if (holderAge > 50) {
            price += 75;
        }

        if (isSmoking) {
            price += 100;
        }

        if (bmi() > 35) {
            price += (bmi() - 35) * 20;
        }

        return price;
    }
}

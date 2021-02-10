public class Policy {
    /** The policy number. */
    int policyNumber;

    /** The name of the provider. */
    String provider;

    /** The first name of the policy holder. */
    String firstName;

    /** The last name of the policy holder. */
    String lastName;

    /** The age of the policy holder. */
    int holderAge;

    /** Whether or not the policy holder smokes. */
    boolean isSmoking;

    /** The height of the policy holder, in inches. */
    float holderHeightInches;

    /** The weight of the policy holder, in pounds. */
    float holderWeightPounds;

    /** Empty constructor. */
    public Policy() {
        policyNumber = 0;
        provider = "";
        firstName = "";
        lastName = "";
        holderAge = 0;
        isSmoking = false;
        holderHeightInches = 0;
        holderWeightPounds = 0;
    }

    /** Full constructor. */
    public Policy(
        int policyNumber,
        String provider,
        String firstName,
        String lastName,
        int holderAge,
        boolean isSmoking,
        float holderHeightInches,
        float holderWeightPounds
    ) {
        this.policyNumber = policyNumber;
        this.provider = provider;
        this.firstName = firstName;
        this.lastName = lastName;
        this.holderAge = holderAge;
        this.isSmoking = isSmoking;
        this.holderHeightInches = holderHeightInches;
        this.holderWeightPounds = holderWeightPounds;
    }

    /** Get the policy number. */
    public int getPolicyNumber() {
        return policyNumber;
    }

    /** Get the policy provider name. */
    public String getProvider() {
        return provider;
    }

    /** Get the first name of the policy holder. */
    public String getFirstName() {
        return firstName;
    }

    /** Get the last name of the policy holder. */
    public String getLastName() {
        return lastName;
    }

    /** Get the age of the policy holder */
    public int getAge() {
        return holderAge;
    }

    /** Whether the policy holder smokes. */
    public boolean isSmoking() {
        return isSmoking;
    }

    /** Get the height of the policy holder, in inches. */
    public float getHolderHeight() {
        return holderHeightInches;
    }

    /** Get the weight of the policy holder, in pounds */
    public float getHolderWeight() {
        return holderWeightPounds;
    }

    /** Calculate the policy holder's BMI. */
    public float bmi() {
        return (holderWeightPounds * 703) / (holderHeightInches * holderHeightInches);
    }

    /** Calculate the total price of the insurance policy. */
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

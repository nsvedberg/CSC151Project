import java.util.Formatter;

public class PolicyHolder {
    /** The first name of the policy holder. */
    String firstName;

    /** The last name of the policy holder. */
    String lastName;

    /** The age of the policy holder. */
    int age;

    /** Whether or not the policy holder smokes. */
    boolean isSmoking;

    /** The height of the policy holder, in inches. */
    float heightInches;

    /** The weight of the policy holder, in pounds. */
    float weightPounds;

    /** Empty constructor. */
    public PolicyHolder() {
        firstName = "";
        lastName = "";
        age = 0;
        isSmoking = false;
        heightInches = 0;
        weightPounds = 0;
    }

    /**
     * Full constructor.
     *
     * @param firstName the policy holder's first name
     * @param lastName the policy holder's last name
     * @param age the policy holder's age
     * @param isSmoking whether the policy holder smokes
     * @param heightInches the policy holder's height in inches
     * @param weightPounds the policy holder's weight in pounds
    */
    public PolicyHolder(
        String firstName,
        String lastName,
        int age,
        boolean isSmoking,
        float heightInches,
        float weightPounds
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.isSmoking = isSmoking;
        this.heightInches = heightInches;
        this.weightPounds = weightPounds;
    }

    /**
     * Get the first name of the policy holder.
     *
     * @return the first name of the policy holder
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Get the last name of the policy holder.
     *
     * @return the last name of the policy holder
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Get the age of the policy holder
     *
     * @return the age of the policy holder
     */
    public int getAge() {
        return age;
    }

    /**
     * Whether the policy holder smokes.
     *
     * @return whether the policy holder smokes
     */
    public boolean isSmoking() {
        return isSmoking;
    }

    /**
     * Get the height of the policy holder, in inches.
     *
     * @return the height of the policy holder, in inches
     */
    public float getHeight() {
        return heightInches;
    }

    /**
     * Get the weight of the policy holder, in pounds.
     *
     * @return the weight of the policy holder, in pounds
     */
    public float getWeight() {
        return weightPounds;
    }

    /**
     * Calculate the policy holder's BMI.
     *
     * @return the policy holder's BMI
     */
    public float bmi() {
        return (weightPounds * 703) / (heightInches * heightInches);
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        Formatter fmt = new Formatter(builder);

        fmt.format("Policyholder’s First Name: %s\n", firstName);
        fmt.format("Policyholder’s Last Name: %s\n", lastName);
        fmt.format("Policyholder’s Age: %d\n", age);
        fmt.format("Policyholder’s Smoking Status: ");

        if (isSmoking) {
            fmt.format("smoking\n");
        } else {
            fmt.format("non-smoking\n");
        }

        fmt.format("Policyholder’s Height: %.1f\n", holderHeight);
        fmt.format("Policyholder’s Weight: %.1f\n", holderWeight);
        fmt.format("Policyholder’s BMI: %.2f\n", bmi());
    }
}

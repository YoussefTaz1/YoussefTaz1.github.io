public class Monkey extends RescueAnimal {

    // Instance Variables
    private String tailLength;
    private String height;
    private String bodyLength;
    private String species;

    // Constructor
    public Monkey(String name, String gender, String age, String weight,
    String acquisitionDate, String acquisitionCountry, String trainingStatus,
    boolean reserved, String inServiceCountry, String tailLength,
    String height, String bodyLength, String species) {

        // Enhancement category 2 change:
        // Using the parent class setter methods to initialize inherited fields.
        setName(name);
        setGender(gender);
        setAge(age);
        setWeight(weight);
        setAcquisitionDate(acquisitionDate);
        setAcquisitionLocation(acquisitionCountry);
        setTrainingStatus(trainingStatus);
        setReserved(reserved);
        setInServiceCountry(inServiceCountry);

        // Enhancement category 2 change:
        // Using the Monkey setter methods so monkey-specific values stay managed in this class.
        setTailLength(tailLength);
        setHeight(height);
        setBodyLength(bodyLength);
        setSpecies(species);

        setAnimalType("monkey"); // This line ensures animalType is set.
    }

    // Accessor Method
    public String getTailLength() {
        return tailLength;
    }

    // Mutator Method
    public void setTailLength(String monkeyTailLength) {
        // Enhancement category 2 change:
        // Trimmed extra spaces before saving the tail length value.
        tailLength = monkeyTailLength.trim();
    }

    // Accessor Method
    public String getHeight() {
        return height;
    }

    // Mutator Method
    public void setHeight(String monkeyHeight) {
        // Enhancement category 2 change:
        // Trimmed extra spaces before saving the height value.
        height = monkeyHeight.trim();
    }

    // Accessor Method
    public String getBodyLength() {
        return bodyLength;
    }

    // Mutator Method
    public void setBodyLength(String monkeyBodyLength) {
        // Enhancement category 2 change:
        // Trimmed extra spaces before saving the body length value.
        bodyLength = monkeyBodyLength.trim();
    }

    // Accessor Method
    public String getSpecies() {
        return species;
    }

    // Mutator Method
    public void setSpecies(String monkeySpecies) {
        // Enhancement category 2 change:
        // Trimmed extra spaces before saving the species value.
        species = monkeySpecies.trim();
    }
}
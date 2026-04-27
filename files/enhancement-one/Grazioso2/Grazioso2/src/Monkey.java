public class Monkey extends RescueAnimal {

    // specific instance variables for Monkeys 
    private String tailLength;
    private String height;
    private String bodyLength;
    private String species;

    //  constructor 
    public Monkey(String name, String gender, String age, String weight,
                  String acquisitionDate, String acquisitionCountry,
                  String trainingStatus, boolean reserved, String inServiceCountry,
                  String tailLength, String height, String bodyLength, String species) {

        // Set inherited attributes
        setName(name);
        setGender(gender);
        setAge(age);
        setWeight(weight);
        setAcquisitionDate(acquisitionDate);
        setAcquisitionLocation(acquisitionCountry);
        setTrainingStatus(trainingStatus);
        setReserved(reserved);
        setInServiceCountry(inServiceCountry);
        setAnimalType("monkey"); 

        // Set specific attributes for monkey

        // Enhancement change:
        // Using setter methods instead of direct assignment to keep the code
        // more organized and consistent.
        setTailLength(tailLength);
        setHeight(height);
        setBodyLength(bodyLength);
        setSpecies(species);
    }

    // Accessors - getters
    public String getTailLength() {
        return tailLength;
    }

    public String getHeight() {
        return height;
    }

    public String getBodyLength() {
        return bodyLength;
    }

    public String getSpecies() {
        return species;
    }

    // Mutators - setters
    public void setTailLength(String tailLength) {
        // Enhancement change:
        // Trimmed extra spaces before saving the tail length.
        this.tailLength = tailLength.trim();
    }

    public void setHeight(String height) {
        // Enhancement change:
        // Trimmed extra spaces before saving the height.
        this.height = height.trim();
    }

    public void setBodyLength(String bodyLength) {
        // Enhancement change:
        // Trimmed extra spaces before saving the body length.
        this.bodyLength = bodyLength.trim();
    }

    public void setSpecies(String species) {
        // Enhancement change:
        // Trimmed extra spaces before saving the species value.
        this.species = species.trim();
    }
}
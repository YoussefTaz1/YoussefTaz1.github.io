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
        this.tailLength = tailLength;
        this.height = height;
        this.bodyLength = bodyLength;
        this.species = species;
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
        this.tailLength = tailLength;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public void setBodyLength(String bodyLength) {
        this.bodyLength = bodyLength;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
}

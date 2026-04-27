public class Monkey extends RescueAnimal {

    // Instance variables
    private String tailLength;
    private String height;
    private String bodyLength;
    private String species;

    // Default constructor
    public Monkey() {
        setAnimalType("monkey");
    }

    // Constructor with parameters
    public Monkey(String name, String gender, String age, String weight,
                  String acquisitionDate, String acquisitionLocation,
                  String trainingStatus, boolean reserved, String inServiceCountry,
                  String tailLength, String height, String bodyLength, String species) {

        setAnimalType("monkey");
        setName(name);
        setGender(gender);
        setAge(age);
        setWeight(weight);
        setAcquisitionDate(acquisitionDate);
        setAcquisitionLocation(acquisitionLocation);
        setTrainingStatus(trainingStatus);
        setReserved(reserved);
        setInServiceCountry(inServiceCountry);
        setTailLength(tailLength);
        setHeight(height);
        setBodyLength(bodyLength);
        setSpecies(species);
    }

    // Get tail length
    public String getTailLength() {
        return tailLength;
    }

    // Set tail length
    public void setTailLength(String tailLength) {
        this.tailLength = tailLength;
    }

    // Get height
    public String getHeight() {
        return height;
    }

    // Set height
    public void setHeight(String height) {
        this.height = height;
    }

    // Get body length
    public String getBodyLength() {
        return bodyLength;
    }

    // Set body length
    public void setBodyLength(String bodyLength) {
        this.bodyLength = bodyLength;
    }

    // Get species
    public String getSpecies() {
        return species;
    }

    // Set species
    public void setSpecies(String species) {
        this.species = species;
    }
}
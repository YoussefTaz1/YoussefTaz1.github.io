public class RescueAnimal {

    // Instance variables
    private String name;
    private String animalType;
    private String gender;
    private String age;
    private String weight;
    private String acquisitionDate;
    private String acquisitionCountry;
    private String trainingStatus;
    private boolean reserved;
    private String inServiceCountry;

    // Default constructor
    public RescueAnimal() {

    }

    // Accessor Method
    public String getName() {
        return name;
    }

    // Mutator Method
    public void setName(String animalName) {
        // Enhancement category 2 change:
        // Trimmed extra spaces before saving the animal name.
        name = animalName.trim();
    }

    // Accessor Method
    public String getAnimalType() {
        return animalType;
    }

    // Mutator Method
    public void setAnimalType(String animalType) {
        // Enhancement category 2 change:
        // Trimmed extra spaces before saving the animal type.
        this.animalType = animalType.trim();
    }

    // Accessor Method
    public String getGender() {
        return gender;
    }

    // Mutator Method
    public void setGender(String animalGender) {
        // Enhancement category 2 change:
        // Trimmed extra spaces before saving the gender value.
        gender = animalGender.trim();
    }

    // Accessor Method
    public String getAge() {
        return age;
    }

    // Mutator Method
    public void setAge(String animalAge) {
        // Enhancement category 2 change:
        // Trimmed extra spaces before saving the age value.
        age = animalAge.trim();
    }

    // Accessor Method
    public String getWeight() {
        return weight;
    }

    // Mutator Method
    public void setWeight(String animalWeight) {
        // Enhancement category 2 change:
        // Trimmed extra spaces before saving the weight value.
        weight = animalWeight.trim();
    }

    // Accessor Method
    public String getAcquisitionDate() {
        return acquisitionDate;
    }

    // Mutator Method
    public void setAcquisitionDate(String animalAcquisitionDate) {
        // Enhancement category 2 change:
        // Trimmed extra spaces before saving the acquisition date.
        acquisitionDate = animalAcquisitionDate.trim();
    }

    // Accessor Method
    public String getAcquisitionLocation() {
        return acquisitionCountry;
    }

    // Mutator Method
    public void setAcquisitionLocation(String animalAcquisitionCountry) {
        // Enhancement category 2 change:
        // Trimmed extra spaces before saving the acquisition country.
        acquisitionCountry = animalAcquisitionCountry.trim();
    }

    // Accessor Method
    public boolean getReserved() {
        return reserved;
    }

    // Mutator Method
    public void setReserved(boolean animalReserved) {
        reserved = animalReserved;
    }

    // Accessor Method
    public String getInServiceCountry() {
        return inServiceCountry;
    }

    // Mutator Method
    public void setInServiceCountry(String animalInServiceCountry) {
        // Enhancement category 2 change:
        // Trimmed extra spaces before saving the in-service country.
        inServiceCountry = animalInServiceCountry.trim();
    }

    // Accessor Method
    public String getTrainingStatus() {
        return trainingStatus;
    }

    // Mutator Method
    public void setTrainingStatus(String animalTrainingStatus) {
        // Enhancement category 2 change:
        // Trimmed extra spaces before saving the training status.
        trainingStatus = animalTrainingStatus.trim();
    }
}
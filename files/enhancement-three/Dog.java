public class Dog extends RescueAnimal {

    // Instance variable
    private String breed;

    // Default constructor
    public Dog() {
        setAnimalType("dog");
    }

    // Constructor with parameters
    public Dog(String name, String breed, String gender, String age, String weight,
               String acquisitionDate, String acquisitionLocation,
               String trainingStatus, boolean reserved, String inServiceCountry) {

        setAnimalType("dog");
        setName(name);
        setBreed(breed);
        setGender(gender);
        setAge(age);
        setWeight(weight);
        setAcquisitionDate(acquisitionDate);
        setAcquisitionLocation(acquisitionLocation);
        setTrainingStatus(trainingStatus);
        setReserved(reserved);
        setInServiceCountry(inServiceCountry);
    }

    // Get breed
    public String getBreed() {
        return breed;
    }

    // Set breed
    public void setBreed(String breed) {
        this.breed = breed;
    }
}
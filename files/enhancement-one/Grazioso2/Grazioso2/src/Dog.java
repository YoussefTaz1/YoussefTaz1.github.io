public class Dog extends RescueAnimal {

    // Instance variable
    private String breed;

    // Constructor
    public Dog(String name, String breed, String gender, String age,
    String weight, String acquisitionDate, String acquisitionCountry,
	String trainingStatus, boolean reserved, String inServiceCountry) {

        // Enhancement change:
        // Using the parent class setter methods to initialize inherited fields.
        setName(name);

        // Enhancement change:
        // Using the Dog setter to keep breed assignment inside this class.
        setBreed(breed);

        setGender(gender);
        setAge(age);
        setWeight(weight);
        setAcquisitionDate(acquisitionDate);
        setAcquisitionLocation(acquisitionCountry);
        setTrainingStatus(trainingStatus);
        setReserved(reserved);
        setInServiceCountry(inServiceCountry);

		setAnimalType("dog"); // This line ensures animalType is set.

    }

    // Accessor Method
    public String getBreed() {
        return breed;
    }

    // Mutator Method
    public void setBreed(String dogBreed) {
        // Enhancement change:
        // Trimmed extra spaces before saving the breed value.
        breed = dogBreed.trim();
    }

}
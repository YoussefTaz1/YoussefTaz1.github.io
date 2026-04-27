import java.lang.String;

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


    // Constructor
    public RescueAnimal() {
    }

    // Enhancement change:
    // Added a parameterized constructor so the object can be created
    // with all main values already set.
    public RescueAnimal(String name, String animalType, String gender, String age,
                        String weight, String acquisitionDate, String acquisitionCountry,
                        String trainingStatus, boolean reserved, String inServiceCountry) {
        this.name = name;
        this.animalType = animalType;
        this.gender = gender;
        this.age = age;
        this.weight = weight;
        this.acquisitionDate = acquisitionDate;
        this.acquisitionCountry = acquisitionCountry;
        this.trainingStatus = trainingStatus;
        this.reserved = reserved;
        this.inServiceCountry = inServiceCountry;
    }


	public String getName() {
		return name;
	}


	public void setName(String name) {
        // Enhancement change:
        // Trimmed extra spaces before saving input.
		this.name = name.trim();
	}


	public String getAnimalType() {
		return animalType;
	}


	public void setAnimalType(String animalType) {
        // Enhancement change:
        // Trimmed extra spaces before saving input.
		this.animalType = animalType.trim();
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
        // Enhancement change:
        // Trimmed extra spaces before saving input.
		this.gender = gender.trim();
	}


	public String getAge() {
		return age;
	}


	public void setAge(String age) {
        // Enhancement change:
        // Trimmed extra spaces before saving input.
		this.age = age.trim();
	}


	public String getWeight() {
		return weight;
	}


	public void setWeight(String weight) {
        // Enhancement change:
        // Trimmed extra spaces before saving input.
		this.weight = weight.trim();
	}


	public String getAcquisitionDate() {
		return acquisitionDate;
	}


	public void setAcquisitionDate(String acquisitionDate) {
        // Enhancement change:
        // Trimmed extra spaces before saving input.
		this.acquisitionDate = acquisitionDate.trim();
	}


	public String getAcquisitionLocation() {
		return acquisitionCountry;
	}


	public void setAcquisitionLocation(String acquisitionCountry) {
        // Enhancement change:
        // Trimmed extra spaces before saving input.
		this.acquisitionCountry = acquisitionCountry.trim();
	}


	public boolean getReserved() {
		return reserved;
	}


	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}


	public String getInServiceCountry() {
		return inServiceCountry;
	}


	public void setInServiceCountry(String inServiceCountry) {
        // Enhancement change:
        // Trimmed extra spaces before saving input.
		this.inServiceCountry = inServiceCountry.trim();
	}




	public String getTrainingStatus() {
		return trainingStatus;
	}


	public void setTrainingStatus(String trainingStatus) {
        // Enhancement change:
        // Trimmed extra spaces before saving input.
		this.trainingStatus = trainingStatus.trim();
	}
}
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    // Instance variables (if needed)
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();

    
    public static void main(String[] args) {


        initializeDogList();
        initializeMonkeyList();

        // Add a loop that displays the menu, accepts the users input
        // and takes the appropriate action.
	// For the project submission you must also include input validation
        // and appropriate feedback to the user.
        // Hint: create a Scanner and pass it to the necessary
        // methods 
	// Hint: Menu options 4, 5, and 6 should all connect to the printAnimals() method.
        Scanner scanner = new Scanner(System.in);
        String userChoice = "";

        while (!userChoice.equalsIgnoreCase("q")) {
            displayMenu();
            userChoice = scanner.nextLine().trim();

            switch (userChoice.toLowerCase()) {
                case "1":
                    intakeNewDog(scanner);
                    break;
                case "2":
                    intakeNewMonkey(scanner);
                    break;
                case "3":
                    reserveAnimal(scanner);
                    break;
                case "4":
                    printAnimals("dog");
                    break;
                case "5":
                    printAnimals("monkey");
                    break;
                case "6":
                    printAnimals("available");
                    break;
                case "q":
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid selection. Please choose 1-6 or q.");
                    break;
            }
        }

        scanner.close();

    }

    // This method prints the menu options
    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection");
    }


    // Adds dogs to a list for testing
    public static void initializeDogList() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake", false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false, "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", true, "Canada");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
    }


    // Adds monkeys to a list for testing
    //Optional for testing
    public static void initializeMonkeyList() {
    	Monkey monkey1 = new Monkey("Spike", "male", "3", "13",
                "02-08-2022", "United States", "intake", false, "United States",
                "18", "24", "20", "Capuchin");

        monkeyList.add(monkey1);

    }


    // Complete the intakeNewDog method
    // The input validation to check that the dog is not already in the list
    // is done for you
    public static void intakeNewDog(Scanner scanner) {
        System.out.println("What is the dog's name?");
        String name = scanner.nextLine();
        for(Dog dog: dogList) {
            if(dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis dog is already in our system\n\n");
                return; //returns to menu
            }
        }

        // Add the code to instantiate a new dog and add it to the appropriate list
        System.out.println("What is the dog's breed?");
        String breed = scanner.nextLine().trim();

        System.out.println("What is the dog's gender?");
        String gender = scanner.nextLine().trim();

        System.out.println("What is the dog's age?");
        String age = scanner.nextLine().trim();

        System.out.println("What is the dog's weight?");
        String weight = scanner.nextLine().trim();

        System.out.println("What is the acquisition date? (example: 02-03-2020)");
        String acquisitionDate = scanner.nextLine().trim();

        System.out.println("What is the acquisition country?");
        String acquisitionCountry = scanner.nextLine().trim();

        System.out.println("What is the training status? (example: intake, Phase I, in service)");
        String trainingStatus = scanner.nextLine().trim();

        
        boolean reserved;
        while (true) {
            System.out.println("Is the dog reserved? (true/false)");
            String reservedInput = scanner.nextLine().trim().toLowerCase();

            if (reservedInput.equals("true")) {
                reserved = true;
                break;
            } else if (reservedInput.equals("false")) {
                reserved = false;
                break;
            } else {
                System.out.println("Invalid input. Please type true or false.");
            }
        }

        System.out.println("What is the in-service country?");
        String inServiceCountry = scanner.nextLine().trim();

        Dog newDog = new Dog(name, breed, gender, age, weight,
                acquisitionDate, acquisitionCountry, trainingStatus,
                reserved, inServiceCountry);

        dogList.add(newDog);
        System.out.println("\n\nDog added to the system!\n\n");
    }


        // Complete intakeNewMonkey
	//Instantiate and add the new monkey to the appropriate list
        // For the project submission you must also  validate the input
	// to make sure the monkey doesn't already exist and the species type is allowed
        public static void intakeNewMonkey(Scanner scanner) {
        	System.out.println("What is the monkey's name?");
            String name = scanner.nextLine().trim();

            
            for (Monkey monkey : monkeyList) {
                if (monkey.getName().equalsIgnoreCase(name)) {
                    System.out.println("\n\nThis monkey is already in our system\n\n");
                    return; //returns to menu
                }
            }
            
            System.out.println("What is the monkey's gender?");
            String gender = scanner.nextLine().trim();

            System.out.println("What is the monkey's age?");
            String age = scanner.nextLine().trim();

            System.out.println("What is the monkey's weight?");
            String weight = scanner.nextLine().trim();

            System.out.println("What is the acquisition date? (example: 02-03-2020)");
            String acquisitionDate = scanner.nextLine().trim();

            System.out.println("What is the acquisition country?");
            String acquisitionCountry = scanner.nextLine().trim();

            System.out.println("What is the training status? (example: intake, Phase I, in service)");
            String trainingStatus = scanner.nextLine().trim();

           
            boolean reserved;
            while (true) {
                System.out.println("Is the monkey reserved? (true/false)");
                String reservedInput = scanner.nextLine().trim().toLowerCase();

                if (reservedInput.equals("true")) {
                    reserved = true;
                    break;
                } else if (reservedInput.equals("false")) {
                    reserved = false;
                    break;
                } else {
                    System.out.println("Invalid input. Please type true or false.");
                }
            }

            System.out.println("What is the in-service country?");
            String inServiceCountry = scanner.nextLine().trim();

            System.out.println("What is the tail length?");
            String tailLength = scanner.nextLine().trim();

            System.out.println("What is the height?");
            String height = scanner.nextLine().trim();

            System.out.println("What is the body length?");
            String bodyLength = scanner.nextLine().trim();

            System.out.println("What is the species? (Capuchin, Guenon, Macaque, Marmoset, Squirrel monkey, Tamarin)");
            String species = scanner.nextLine().trim();

            // validate species type is allowed
            if (!isAllowedMonkeySpecies(species)) {
                System.out.println("\n\nInvalid species. This species is not eligible for training.\n\n");
                return; //returns to menu
            }

            Monkey newMonkey = new Monkey(name, gender, age, weight,
                    acquisitionDate, acquisitionCountry, trainingStatus,
                    reserved, inServiceCountry, tailLength, height, bodyLength, species);

            monkeyList.add(newMonkey);
            System.out.println("\n\nMonkey added to the system!\n\n");
        }

        // Complete reserveAnimal
        // You will need to find the animal by animal type and in service country
        public static void reserveAnimal(Scanner scanner) {
        	System.out.println("Enter animal type (dog or monkey):");
            String animalType = scanner.nextLine().trim().toLowerCase();

            System.out.println("Enter in-service country:");
            String inServiceCountry = scanner.nextLine().trim();

            if (animalType.equals("dog")) {

                for (Dog dog : dogList) {
                    if (dog.getInServiceCountry().equalsIgnoreCase(inServiceCountry)
                            && dog.getTrainingStatus().equalsIgnoreCase("in service")
                            && !dog.getReserved()) {

                        dog.setReserved(true);
                        System.out.println("\n\nDog reserved successfully: " + dog.getName() + "\n\n");
                        return; // returns to menu
                    }
                }

                System.out.println("\n\nNo available dogs found in " + inServiceCountry + ".\n\n");
                return;
            }

            if (animalType.equals("monkey")) {

                for (Monkey monkey : monkeyList) {
                    if (monkey.getInServiceCountry().equalsIgnoreCase(inServiceCountry)
                            && monkey.getTrainingStatus().equalsIgnoreCase("in service")
                            && !monkey.getReserved()) {

                        monkey.setReserved(true);
                        System.out.println("\n\nMonkey reserved successfully: " + monkey.getName() + "\n\n");
                        return; // returns to menu
                    }
                }

                System.out.println("\n\nNo available monkeys found in " + inServiceCountry + ".\n\n");
                return;
            }

            System.out.println("\n\nInvalid animal type. Please enter dog or monkey.\n\n");
        }

        

        // Complete printAnimals
        // Include the animal name, status, acquisition country and if the animal is reserved.
	// Remember that this method connects to three different menu items.
        // The printAnimals() method has three different outputs
        // based on the listType parameter
        // dog - prints the list of dogs
        // monkey - prints the list of monkeys
        // available - prints a combined list of all animals that are
        // fully trained ("in service") but not reserved 
	// Remember that you only have to fully implement ONE of these lists. 
	// The other lists can have a print statement saying "This option needs to be implemented".
	// To score "exemplary" you must correctly implement the "available" list.
        public static void printAnimals(String listType) {
        	
        	// prints the list of dogs
        	if (listType.equalsIgnoreCase("dog")) {

                System.out.println("\nList of Dogs");
                System.out.println("------------------------------------------------");

                for (Dog dog : dogList) {
                    System.out.println("Name: " + dog.getName()
                            + " | Status: " + dog.getTrainingStatus()
                            + " | Acquisition Country: " + dog.getAcquisitionLocation()
                            + " | Reserved: " + dog.getReserved());
                }

                return;
            }

        	// prints the list of monkeys
            if (listType.equalsIgnoreCase("monkey")) {

                System.out.println("\nList of Monkeys");
                System.out.println("------------------------------------------------");

                for (Monkey monkey : monkeyList) {
                    System.out.println("Name: " + monkey.getName()
                            + " | Status: " + monkey.getTrainingStatus()
                            + " | Acquisition Country: " + monkey.getAcquisitionLocation()
                            + " | Reserved: " + monkey.getReserved());
                }

                return;
            }

            if (listType.equalsIgnoreCase("available")) {

                System.out.println("\nAvailable Animals (in service and not reserved)");
                System.out.println("------------------------------------------------");

                // Dogs: in service and not reserved
                for (Dog dog : dogList) {
                    if (dog.getTrainingStatus().equalsIgnoreCase("in service") && !dog.getReserved()) {
                        System.out.println("Name: " + dog.getName()
                                + " | Status: " + dog.getTrainingStatus()
                                + " | Acquisition Country: " + dog.getAcquisitionLocation()
                                + " | Reserved: " + dog.getReserved());
                    }
                }

                // Monkeys: in service and not reserved
                for (Monkey monkey : monkeyList) {
                    if (monkey.getTrainingStatus().equalsIgnoreCase("in service") && !monkey.getReserved()) {
                        System.out.println("Name: " + monkey.getName()
                                + " | Status: " + monkey.getTrainingStatus()
                                + " | Acquisition Country: " + monkey.getAcquisitionLocation()
                                + " | Reserved: " + monkey.getReserved());
                    }
                }

                return;
            }

            System.out.println("The method printAnimals needs to be implemented");

        }

        // helper method used by intakeNewMonkey() for species validation
        private static boolean isAllowedMonkeySpecies(String species) {
            String s = species.trim().toLowerCase();

            return s.equals("capuchin")
                    || s.equals("guenon")
                    || s.equals("macaque")
                    || s.equals("marmoset")
                    || s.equals("squirrel monkey")
                    || s.equals("tamarin"); 

        }
}


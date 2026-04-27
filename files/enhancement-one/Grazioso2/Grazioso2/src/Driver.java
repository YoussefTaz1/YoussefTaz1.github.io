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

            // Enhancement change:
            // Moved the switch logic into a helper method to make main() shorter and easier to read.
            handleMenuChoice(userChoice, scanner);
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
        // Enhancement change:
        // Using a helper method to require non-empty input and keep prompts consistent.
        String name = readRequiredInput(scanner, "What is the dog's name?");

        // Enhancement change:
        // Moved duplicate-check logic into a helper method for better reuse.
        if (dogExists(name)) {
            System.out.println("\n\nThis dog is already in our system\n\n");
            return; //returns to menu
        }

        // Add the code to instantiate a new dog and add it to the appropriate list
        String breed = readRequiredInput(scanner, "What is the dog's breed?");
        String gender = readRequiredInput(scanner, "What is the dog's gender?");
        String age = readRequiredInput(scanner, "What is the dog's age?");
        String weight = readRequiredInput(scanner, "What is the dog's weight?");
        String acquisitionDate = readRequiredInput(scanner, "What is the acquisition date? (example: 02-03-2020)");
        String acquisitionCountry = readRequiredInput(scanner, "What is the acquisition country?");
        String trainingStatus = readRequiredInput(scanner, "What is the training status? (example: intake, Phase I, in service)");

        
        // Enhancement change:
        // Moved repeated true/false validation into a helper method.
        boolean reserved = readBooleanInput(scanner, "Is the dog reserved? (true/false)");

        String inServiceCountry = readRequiredInput(scanner, "What is the in-service country?");

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
        	String name = readRequiredInput(scanner, "What is the monkey's name?");

            // Enhancement change:
            // Moved duplicate-check logic into a helper method for better organization.
            if (monkeyExists(name)) {
                System.out.println("\n\nThis monkey is already in our system\n\n");
                return; //returns to menu
            }
            
            String gender = readRequiredInput(scanner, "What is the monkey's gender?");
            String age = readRequiredInput(scanner, "What is the monkey's age?");
            String weight = readRequiredInput(scanner, "What is the monkey's weight?");
            String acquisitionDate = readRequiredInput(scanner, "What is the acquisition date? (example: 02-03-2020)");
            String acquisitionCountry = readRequiredInput(scanner, "What is the acquisition country?");
            String trainingStatus = readRequiredInput(scanner, "What is the training status? (example: intake, Phase I, in service)");

           
            // Enhancement change:
            // Reused the same boolean validation helper from intakeNewDog().
            boolean reserved = readBooleanInput(scanner, "Is the monkey reserved? (true/false)");

            String inServiceCountry = readRequiredInput(scanner, "What is the in-service country?");
            String tailLength = readRequiredInput(scanner, "What is the tail length?");
            String height = readRequiredInput(scanner, "What is the height?");
            String bodyLength = readRequiredInput(scanner, "What is the body length?");
            String species = readRequiredInput(scanner, "What is the species? (Capuchin, Guenon, Macaque, Marmoset, Squirrel monkey, Tamarin)");

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
        	String animalType = readRequiredInput(scanner, "Enter animal type (dog or monkey):").toLowerCase();
            String inServiceCountry = readRequiredInput(scanner, "Enter in-service country:");

            if (animalType.equals("dog")) {

                // Enhancement change:
                // Moved the search logic into a helper method to reduce repeated code.
                Dog availableDog = findAvailableDog(inServiceCountry);

                if (availableDog != null) {
                    availableDog.setReserved(true);
                    System.out.println("\n\nDog reserved successfully: " + availableDog.getName() + "\n\n");
                    return; // returns to menu
                }

                System.out.println("\n\nNo available dogs found in " + inServiceCountry + ".\n\n");
                return;
            }

            if (animalType.equals("monkey")) {

                // Enhancement change:
                // Moved the search logic into a helper method to reduce repeated code.
                Monkey availableMonkey = findAvailableMonkey(inServiceCountry);

                if (availableMonkey != null) {
                    availableMonkey.setReserved(true);
                    System.out.println("\n\nMonkey reserved successfully: " + availableMonkey.getName() + "\n\n");
                    return; // returns to menu
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
                    // Enhancement change:
                    // Reused one helper method to print animal details in one format.
                    printAnimalDetails(dog);
                }

                return;
            }

        	// prints the list of monkeys
            if (listType.equalsIgnoreCase("monkey")) {

                System.out.println("\nList of Monkeys");
                System.out.println("------------------------------------------------");

                for (Monkey monkey : monkeyList) {
                    // Enhancement change:
                    // Reused one helper method to print animal details in one format.
                    printAnimalDetails(monkey);
                }

                return;
            }

            if (listType.equalsIgnoreCase("available")) {

                System.out.println("\nAvailable Animals (in service and not reserved)");
                System.out.println("------------------------------------------------");

                // Enhancement change:
                // Added a flag so the program can tell the user when no animals are available.
                boolean foundAvailableAnimal = false;

                // Dogs: in service and not reserved
                for (Dog dog : dogList) {
                    // Enhancement change:
                    // Reused one helper method to check if an animal is available.
                    if (isAvailableAnimal(dog)) {
                        printAnimalDetails(dog);
                        foundAvailableAnimal = true;
                    }
                }

                // Monkeys: in service and not reserved
                for (Monkey monkey : monkeyList) {
                    // Enhancement change:
                    // Reused one helper method to check if an animal is available.
                    if (isAvailableAnimal(monkey)) {
                        printAnimalDetails(monkey);
                        foundAvailableAnimal = true;
                    }
                }

                // Enhancement change:
                // Gives feedback when no animals match the available condition.
                if (!foundAvailableAnimal) {
                    System.out.println("No animals are currently available.");
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

        // Enhancement change:
        // New helper method to keep menu handling separate from main().
        private static void handleMenuChoice(String userChoice, Scanner scanner) {
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

        // Enhancement change:
        // New helper method to prevent blank input and improve validation.
        private static String readRequiredInput(Scanner scanner, String prompt) {
            String value = "";

            while (value.isEmpty()) {
                System.out.println(prompt);
                value = scanner.nextLine().trim();

                if (value.isEmpty()) {
                    System.out.println("Input cannot be empty. Please try again.");
                }
            }

            return value;
        }

        // Enhancement change:
        // New helper method to reuse true/false validation in more than one place.
        private static boolean readBooleanInput(Scanner scanner, String prompt) {
            while (true) {
                System.out.println(prompt);
                String reservedInput = scanner.nextLine().trim().toLowerCase();

                if (reservedInput.equals("true")) {
                    return true;
                } else if (reservedInput.equals("false")) {
                    return false;
                } else {
                    System.out.println("Invalid input. Please type true or false.");
                }
            }
        }

        // Enhancement change:
        // New helper method to check whether a dog name already exists.
        private static boolean dogExists(String name) {
            for (Dog dog : dogList) {
                if (dog.getName().equalsIgnoreCase(name)) {
                    return true;
                }
            }
            return false;
        }

        // Enhancement change:
        // New helper method to check whether a monkey name already exists.
        private static boolean monkeyExists(String name) {
            for (Monkey monkey : monkeyList) {
                if (monkey.getName().equalsIgnoreCase(name)) {
                    return true;
                }
            }
            return false;
        }

        // Enhancement change:
        // New helper method to find the first available dog in the requested country.
        private static Dog findAvailableDog(String inServiceCountry) {
            for (Dog dog : dogList) {
                if (dog.getInServiceCountry().equalsIgnoreCase(inServiceCountry)
                        && isAvailableAnimal(dog)) {
                    return dog;
                }
            }
            return null;
        }

        // Enhancement change:
        // New helper method to find the first available monkey in the requested country.
        private static Monkey findAvailableMonkey(String inServiceCountry) {
            for (Monkey monkey : monkeyList) {
                if (monkey.getInServiceCountry().equalsIgnoreCase(inServiceCountry)
                        && isAvailableAnimal(monkey)) {
                    return monkey;
                }
            }
            return null;
        }

        // Enhancement change:
        // New helper method to reuse the same availability check for dogs and monkeys.
        private static boolean isAvailableAnimal(RescueAnimal animal) {
            return animal.getTrainingStatus().equalsIgnoreCase("in service") && !animal.getReserved();
        }

        // Enhancement change:
        // New helper method to print dog and monkey details in one shared format.
        private static void printAnimalDetails(RescueAnimal animal) {
            System.out.println("Name: " + animal.getName()
                    + " | Status: " + animal.getTrainingStatus()
                    + " | Acquisition Country: " + animal.getAcquisitionLocation()
                    + " | Reserved: " + animal.getReserved());
        }
}
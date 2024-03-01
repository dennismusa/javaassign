import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Animals {
    // Define pet data (urls of images)
    private static final Map<String, String> petData = new HashMap<>();
    static {
        petData.put("cat", "/images/cat.jpg");
        petData.put("dog", "/img/dog.jpg");
        petData.put("rabbit", "/images/rabbit.jpg");

        petData.put("pig", "/images/pig.jpg");
        petData.put("bird", "/images/bird.jpg");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String selectedPet = null;

        System.out.println("Select a Pet:");

        for (String pet : petData.keySet()) {
            System.out.println(pet);
        }

        while (selectedPet == null) {
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine().toLowerCase();
            if (petData.containsKey(choice)) {
                selectedPet = choice;
            } else {
                System.out.println("Invalid choice. Please select a valid pet.");
            }
        }

        System.out.println("You selected: " + selectedPet);
        System.out.println("Image URL: " + petData.get(selectedPet));
    }
}

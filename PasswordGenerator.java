import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {

    public static String generatePassword(int length) {
        if (length < 4) {
            System.out.println("Password length should be at least 4 to include a mix of characters.");
            return null;
        }

        // Character sets
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String digits = "0123456789";
        String special = "!@#$%^&*()-_=+<>?";

        // Combined character set
        String allCharacters = lower + upper + digits + special;
        Random random = new Random();

        // Ensure at least one character from each category
        StringBuilder password = new StringBuilder();
        password.append(lower.charAt(random.nextInt(lower.length())));
        password.append(upper.charAt(random.nextInt(upper.length())));
        password.append(digits.charAt(random.nextInt(digits.length())));
        password.append(special.charAt(random.nextInt(special.length())));

        // Fill the remaining length with random characters from the combined set
        for (int i = 4; i < length; i++) {
            password.append(allCharacters.charAt(random.nextInt(allCharacters.length())));
        }

        // Convert StringBuilder to array and shuffle to ensure randomness
        char[] passwordArray = password.toString().toCharArray();
        for (int i = 0; i < passwordArray.length; i++) {
            int swapIndex = random.nextInt(passwordArray.length);
            char temp = passwordArray[i];
            passwordArray[i] = passwordArray[swapIndex];
            passwordArray[swapIndex] = temp;
        }

        return new String(passwordArray);
    }
        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the desired length for the password: ");
        int length = scanner.nextInt();

        String password = generatePassword(length);
        if (password != null) {
            System.out.println("Generated Password: " + password);
        }
        scanner.close();
    }
}

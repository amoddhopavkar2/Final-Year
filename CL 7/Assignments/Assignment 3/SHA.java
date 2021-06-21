import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class SHA {
    public static String hash(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1"); // getInstance() method is called with algorithm
                                                                   // SHA-1
            byte[] digestedMessage = md.digest(input.getBytes()); // generate the digest
            BigInteger bi = new BigInteger(1, digestedMessage); // store big hash values
            String hash = bi.toString(16); // Convert message digest into hex value of 40 characters
            return hash;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n--- SHA 1 ALGORITHM ---\n");
        System.out.print("ENTER A STRING: ");
        String str = sc.nextLine();
        System.out.println("\nHASH OF '" + str + "' IS: " + hash(str));
    }
}
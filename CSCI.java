import java.util.Scanner;


interface Cipher {
    public static String encrypt(String alphabet, String plainText, String Key) {
        return null;
    }

    public static String descrypt(String alphabet, String plainText, String Key) {
        return null;
    }
}

class Caesar implements Cipher {
    public static String encrypt(String alphabet, String plainText, String Key) {
        String encrypted = "";
        int temp, temp1, temp2;
        for (int i = 0; i < plainText.length(); i++) {
            temp = alphabet.indexOf(plainText.charAt(i));
            temp1 = Integer.parseInt(Key);
            temp2 = (temp - temp1);
            if(temp2 < 0) temp2= (temp2 % 26)+26;
            temp2 = temp2 % 26;
            encrypted += alphabet.charAt(temp2);
        }
        return encrypted;
    }

    public static String descrypt(String alphabet, String plainText, String Key){
        String descrypted = "";
        int temp, temp1, temp2;
        for (int i = 0; i < plainText.length(); i++) {
            temp = alphabet.indexOf(plainText.charAt(i));
            temp1 = Integer.parseInt(Key);
            temp2 = (temp + temp1)% 26;
            descrypted += alphabet.charAt(temp2);
        }
        return descrypted;
    }

}

class Vigenere implements Cipher{
    static int temp1, temp2, temp3;
    public static String encrypt(String alphabet, String plainText, String Key){

        String encrypted ="";
        int j=0;

        for (int i = 0; i < plainText.length() ; i++) {
            if(j == Key.length()) j=0;
            temp1 = alphabet.indexOf(plainText.charAt(i));
            temp2 = alphabet.indexOf(Key.charAt(j));
            temp3 = (temp1 - temp2);
            if(temp3 < 0) temp3= (temp3 % 26)+26;
            temp3 = temp3 % 26;
            encrypted += alphabet.charAt(temp3);
            j++;
        }

        return encrypted;
    }

    public static String descrypt(String alphabet, String plainText, String Key){

        String descrypted ="";
        int j=0;

        for(int i=0; i < plainText.length(); i++){
            if(j == Key.length()) j=0;
            temp1 = alphabet.indexOf(plainText.charAt(i));
            temp2 = alphabet.indexOf(Key.charAt(j));
            temp3 = (temp1+temp2) % 26;
            descrypted += alphabet.charAt(temp3);
            j++;
        }
        return descrypted;
    }

}

public class CSCI {
    public static void main(String[] args) {
        boolean exit = false;
        boolean rep = true;

        while (!exit) {

            String alphabet;
            String ciphert;
            String key;
            String encrypted;
            String descrypted;
            String res;

            if(rep == true) {
                System.out.println("CSCI Cipher Operations:\n" +
                        "-------------------------------------\n" +
                        "1. Decrypt and verify Caesar cipher\n" +
                        "2. Decrypt and verify Vigenere cipher\n" +
                        "3. Display this menu again\n" +
                        "4. Quit\n" );
                rep = false;
            }
            System.out.println("Choice :");
            Scanner inputS = new Scanner(System.in);
            String choice = inputS.nextLine();

            if (choice.equals("1")) {
                System.out.println("Enter alphabet    :");
                Scanner inputScanner = new Scanner(System.in);
                alphabet = inputScanner.nextLine();

                System.out.println("Enter cipher text :");
                Scanner input = new Scanner(System.in);
                ciphert = input.nextLine();

                System.out.println("Enter key         :");
                Scanner in = new Scanner(System.in);
                key = in.nextLine();

                encrypted = Caesar.encrypt(alphabet, ciphert, key);
                descrypted = Caesar.descrypt(alphabet, encrypted, key);

                if (descrypted.equals(ciphert)) res = "true";
                else res = "false";

                System.out.println("Plain text                               : " +
                        encrypted + "\nPlain text re-encrypted for verification : " +
                        descrypted + "\nAre cipher text and encrypted text equal : " +
                        res
                );

            } else if (choice.equals("2")) {
                System.out.println("Enter alphabet    :");
                Scanner inputScanner = new Scanner(System.in);
                alphabet = inputScanner.nextLine();

                System.out.println("Enter cipher text :");
                Scanner input = new Scanner(System.in);
                ciphert = input.nextLine();

                System.out.println("Enter key         :");
                Scanner in = new Scanner(System.in);
                key = in.nextLine();

                encrypted = Vigenere.encrypt(alphabet, ciphert, key);
                descrypted = Vigenere.descrypt(alphabet, encrypted, key);

                if (descrypted.equals(ciphert)) res = "true";
                else res = "false";

                System.out.println("\nPlain text                               : " +
                        encrypted + "\nPlain text re-encrypted for verification : " +
                        descrypted + "\nAre cipher text and encrypted text equal : " +
                        res
                );
            }
            else if (choice.equals("3")) {
                rep = true ;
                continue;
            }
            else if (choice.equals("4")) exit = true;
            else {
                System.out.println("Invalid choice! Try again.");
                continue;
            }
        }
    }
}



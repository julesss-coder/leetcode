import java.util.Random;

public class CrackThePassword2 {
    public static void main(String[] args) {
        /* STRATEGY 1
        * Summary: Brute-force
        *
        * Top-down outline:
        *
        * Generate random password:
        *
        * chars = array of possible characters in password
        * guess = ''  // length 4, amount of loops
        * password =  String with length 4

        * For each char i in chars:
        *   For each char j in chars:
        *       For each char k in chars:
        *           For each char l in chars:
        *               guess = chars[i] + chars[j] + chars[k] + chars[l]
        *               if guess === password:
        *                   print guess to console
        *
        * */
        String chars = "0123456789!@#$%^&*()_+";
        char[] possibleChars = chars.toCharArray();
        String guess = "";
        String password = "";
        int attempts = 0;

        for (int i = 0; i < 4; i++) {
            Random random = new Random();
            int randomInt = random.nextInt(possibleChars.length);
            password += possibleChars[randomInt];
        }
        System.out.println("password: " + password);


        for (int i = 0; i < possibleChars.length; i++) {
            for (int j = 0; j < possibleChars.length; j++) {
                for (int k = 0; k < possibleChars.length; k++) {
                    for (int l = 0; l < possibleChars.length; l++) {
                        guess = "" + possibleChars[i] + possibleChars[j] + possibleChars[k] + possibleChars[l];
                        attempts++;
                        System.out.println(guess);
                        if (guess.equals(password)) {
                            System.out.println("guessed correct password: " + guess + ", attempts: " + attempts);
                            return;
                        }
                        guess = "";
                    }
                }
            }
        }
    }
}
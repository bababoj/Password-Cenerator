import java.util.Random;

public class PasswordGenerator {

    public static final String LOWERCASE_CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
    public static final String UPPERCASE_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String NUMBERS = "012345679";
    public static final String SPECIAL_SYMBOLS = "!@#$%^&*()-_=+[]{};:,.<>/?";


    private final Random random;
    StringBuilder passwordBuilder;
    String validCharacters;


    public PasswordGenerator(){

        random = new Random();

    }
    public String generatePassword(int l, boolean up, boolean low, boolean num, boolean sym){

        passwordBuilder = new StringBuilder();

        validCharacters = "";
        if(up) validCharacters += UPPERCASE_CHARACTERS;
        if(low) validCharacters += LOWERCASE_CHARACTERS;
        if(num) validCharacters += NUMBERS;
        if(sym) validCharacters += SPECIAL_SYMBOLS;

        for(int i = 0; i < l; i++){
            int randomIndex = random.nextInt(validCharacters.length());

            char randomChar = validCharacters.charAt(randomIndex);

            passwordBuilder.append(randomChar);

        }

        return passwordBuilder.toString();

    }

}

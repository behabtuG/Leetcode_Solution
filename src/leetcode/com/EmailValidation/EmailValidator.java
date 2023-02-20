package leetcode.com.EmailValidation;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {

    public static boolean isValidEmail(String email) {
        // Define the regular expression for a valid email address
        String regex = "^[\\w\\.]+@[\\w-]+\\.(com|org|net)$";
        // Compile the regular expression into a pattern
        Pattern pattern = Pattern.compile(regex);
        // Attempt to match the email against the pattern
        Matcher matcher = pattern.matcher(email);
        // Return true if the email matches the pattern, false otherwise
        return matcher.matches();
    }

    public static void main(String[] args) {
        // Test the isValidEmail function
        /**String[] emails = {
                "name@domain.com",
                "name@domain.org",
                "name@domain.net",
                "name.123@domain.com",
                "name_123@domain.com",
                "name@sub.domain.com",
                "name@domain-.com",
                "name@domain.c",
                "name@domain",
                "name@.com",
                "@domain.com",
                "name@com"
        };
         */
        String[] emails = {"name_123@domain.com"};

        System.out.println(isValidEmail(String.valueOf(emails)));
    }
}
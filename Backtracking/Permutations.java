import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static List<String> generatePermutations(String s) {
        List<String> result = new ArrayList<>();
        char[] chars = s.toCharArray();  // Convert string to char array
        generatePermutationsHelper(chars, 0, result);  // Start generating permutations
        return result;
    }

    private static void generatePermutationsHelper(char[] chars, int index, List<String> result) {
        // If index is equal to the length of the string, add the permutation to the result
        if (index == chars.length) {
            result.add(new String(chars));
            return;
        }

        // Generate permutations by swapping characters
        for (int i = index; i < chars.length; i++) {
            // Swap chars[index] with chars[i]
            char temp = chars[index];
            chars[index] = chars[i];
            chars[i] = temp;

            // Recursively generate the remaining permutations
            generatePermutationsHelper(chars, index + 1, result);

            // Backtrack by swapping back
            temp = chars[index];
            chars[index] = chars[i];
            chars[i] = temp;
        }
    }

    public static void main(String[] args) {
        String s = "abc";  // Example string
        List<String> permutations = generatePermutations(s);

        // Print all permutations
        System.out.println("All permutations of the string: " + permutations);
    }
}

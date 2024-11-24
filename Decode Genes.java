/**
 * In bioinformatics, decode a numeric sequence representing gene codes to understand potential protein expressions.
 */

import java.util.*;

public class GeneDecodeDP {

    // Map to represent gene code to protein codons
    private static final Map<String, String> GENE_CODE_MAP = new HashMap<>();

    static {
        // Example mapping (you can update with actual mappings)
        GENE_CODE_MAP.put("1", "Ala"); // Alanine
        GENE_CODE_MAP.put("2", "Cys"); // Cysteine
        GENE_CODE_MAP.put("3", "Asp"); // Aspartic acid
        GENE_CODE_MAP.put("4", "Glu"); // Glutamic acid
        GENE_CODE_MAP.put("5", "Phe"); // Phenylalanine
        GENE_CODE_MAP.put("6", "Gly"); // Glycine
        GENE_CODE_MAP.put("7", "His"); // Histidine
        GENE_CODE_MAP.put("8", "Ile"); // Isoleucine
        GENE_CODE_MAP.put("9", "Leu"); // Leucine
        GENE_CODE_MAP.put("0", "Pro"); // Proline
        GENE_CODE_MAP.put("10", "Arg");  // Arginine
        GENE_CODE_MAP.put("12", "Ser"); // Serine
        GENE_CODE_MAP.put("23", "Trp"); // Tryptophan
    }

    // Method to calculate all decoding ways using DP
    public static List<String> decodeGene(String str) {
        int n = str.length();
        List<String>[] dp = new ArrayList[n + 1];
        
        // Initialize DP array
        for (int i = 0; i <= n; i++) {
            dp[i] = new ArrayList<>();
        }
        
        // Base case
        dp[0].add(""); // Empty sequence has one decoding

        // Fill DP table
        for (int i = 1; i <= n; i++) {
            // Decode single digit
            String singleDigit = str.substring(i - 1, i);
            if (GENE_CODE_MAP.containsKey(singleDigit)) {
                for (String prev : dp[i - 1]) {
                    dp[i].add(prev + GENE_CODE_MAP.get(singleDigit) + " ");
                }
            }

            // Decode two digits (if explicitly defined in the map)
            if (i > 1) {
                String twoDigits = str.substring(i - 2, i);
                if (GENE_CODE_MAP.containsKey(twoDigits)) {
                    for (String prev : dp[i - 2]) {
                        dp[i].add(prev + GENE_CODE_MAP.get(twoDigits) + " ");
                    }
                }
            }
        }

        // Return all decoding ways
        return dp[n];
    }

    public static void main(String[] args) {
        // Example numeric sequence
        String numericSequence = "123";

        // Decode the sequence
        List<String> decodedSequences = decodeGene(numericSequence);

        // Print all possible protein expressions
        System.out.println("Possible Protein Expressions:");
        for (String expression : decodedSequences) {
            System.out.println(expression.trim());
        }
    }
}

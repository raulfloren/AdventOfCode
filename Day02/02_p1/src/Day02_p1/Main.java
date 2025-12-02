package Day02_p1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Day02, part1\n");

        if (args.length != 1) {
            System.err.println("Try: <inputFileName>");
            return;
        }

        try {
            // Open file
            File fileName = new File(args[0]);
            Scanner scanner = new Scanner(fileName);

            // Read until ","
            scanner.useDelimiter(",");

            long totalSumInvalidIDs = 0;

            while (scanner.hasNext()) {
                String range = scanner.next().trim();

                String[] IDs = range.split("-");
                long startID = Long.parseLong(IDs[0]);
                long endID = Long.parseLong(IDs[1]);

                // If range is not of even digit, continue
                if (numberOfDigits(startID) == numberOfDigits(endID)) {
                    if (!hasEvenDigits(startID)) {
                        continue;
                    }
                }

                for (long i = startID; i <= endID; i++) {
                    // Number has even digits
                    if (hasEvenDigits(i)) {
                        if (isIDInvalid(i)) {
                            System.out.println("Invalid ID found: " + i);
                            totalSumInvalidIDs += i;
                        }
                    }
                }
            }

            System.out.println("Adding up all the invalid IDs: " + totalSumInvalidIDs);

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private static boolean isIDInvalid(long number) {
        //8989
        // Digist must be even at this point
        int digits = numberOfDigits(number);
        int half = digits / 2;

        String numberStr = String.valueOf(number);

        String leftPart = numberStr.substring(0, half);
        String rightPart = numberStr.substring(half);

        return leftPart.equals(rightPart);

    }

    private static int numberOfDigits(Long number) {
        return String.valueOf(number).length();
    }

    private static boolean hasEvenDigits(Long number) {
        return numberOfDigits(number) % 2 == 0;
    }
}
/*
Possible ranges:
    100-800 (X) odd - odd
    89-99 (99) even - even
    1-15 (11) odd - even
    10-100 (99) even - odd
    1-100 (11/22.../99) odd - odd (diferent number of digits)
    10-1000 (...) even - even (different number of digits)
                
 */

// Read ID range, one by one
// if digits are equal
//  if number has even digits
//      -> candidate
//  else 
//      the range has no invalid IDs
// else
//  one by one
// 
// Process whole range or candidates
// Contar numero de digitos
// Separar en partes iguales
// Comparar las partes
// Si son iguales añadir invalido si no nada

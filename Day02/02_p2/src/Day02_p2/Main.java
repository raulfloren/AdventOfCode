package Day02_p2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Day02, part2:\n");
        
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

                for (long i = startID; i <= endID; i++) {
                    if (isIDInvalid(i)) {
                        System.out.println("Invalid ID found: " + i);
                        totalSumInvalidIDs += i;
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
        String numberStr = String.valueOf(number);
        int digits = numberOfDigits(number);
        int half = digits / 2;

        // Si el patrón no cabe un número exacto de veces, no puede ser una repetición.
        // Un string de 5 no puede estar hecho por varios de 2 letras, falta 1
        for (int sequenceLength = 1; sequenceLength <= half; sequenceLength++) {
            if (digits % sequenceLength != 0) {
                continue;
            }

            String sequence = numberStr.substring(0, sequenceLength);
            int reps = digits / sequenceLength;

            String sequenceCompleted = sequence.repeat(reps);

            if (sequenceCompleted.equals(numberStr)) {
                return true;
            }
        }

        return false;

    }

    private static int numberOfDigits(Long number) {
        return String.valueOf(number).length();
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

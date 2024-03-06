package org.example;

import java.io.*;

public class RemoveSpecialCharacters {
    public static void main(String[] args) {
        String io = "input.txt";
        String output = "output.txt";

        try {
            removeSpecialChracters(io, output);
            System.out.println("Special characters removed");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void removeSpecialChracters(String io, String output) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(io));
            BufferedWriter writer = new BufferedWriter(new FileWriter(output))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String cleanedLine = removeSpecialCharactersFromLine(line);
                    writer.write(cleanedLine);
                    writer.newLine();
                }
        }
    }

    private static String removeSpecialCharactersFromLine(String line) {
        //replace any special characters with an empty String
        return line.replaceAll("['a-zA-Z0-9]", "");
    }
}

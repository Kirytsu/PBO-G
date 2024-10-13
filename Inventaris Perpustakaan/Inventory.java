/**
 * Implementasi Class Inventory
 *
 * Kelompok 17
 * Nathanael Valen Susilo   -   5025231099
 * Basten Andika Salim      -   5025231132
 * 
 */

import java.io.*;
import java.util.*;

public class Inventory implements Storable {
    private Map<String, Integer> itemMap;
    private int totalItems;
    private final String FILE_PATH = "inventory.csv";
    
    private static final int COLUMN_WIDTH_NAME = 80;

    public Inventory() {
        itemMap = new HashMap<>();
        totalItems = 0;
        loadFromFile();
    }

    @Override
    public void tambahItem(String item, int jumlah) throws IOException {
        itemMap.put(item, itemMap.getOrDefault(item, 0) + jumlah);
        totalItems += jumlah;
        System.out.println("\nBook added successfully!");
        saveToFile();
    }

    @Override
    public void hapusItem(String item) throws IOException {
        if (itemMap.containsKey(item)) {
            totalItems -= itemMap.get(item);
            itemMap.remove(item);
            System.out.println("\nBook removed successfully!");
            saveToFile();
        } else {
            System.out.println("Book not found.");
        }
    }

    @Override
    public void tampilkanItem() throws IOException {
        if (itemMap.isEmpty()) {
            System.out.println("\n No book in inventory.");
            return;
        }

        System.out.println("\n/-----------------------------------------------------------------------------------------------\\");
        System.out.println("|                                        LIBRARY INVENTORY                                      |");
        System.out.println("|-----------------------------------------------------------------------------------------------|");
        System.out.printf( "| %-80s | %-10s |%n", "Book Name", "Quantity");
        System.out.println("|-----------------------------------------------------------------------------------------------|");


        List<String> sortedKeys = new ArrayList<>(itemMap.keySet());
        Collections.sort(sortedKeys);
        
        for (String key : sortedKeys) {
            List<String> wrappedText = wrapText(key, COLUMN_WIDTH_NAME);
            int quantity = itemMap.get(key);


            for (int i = 0; i < wrappedText.size(); i++) {
                if (i == 0) {
                    System.out.printf("| %-80s | %-10d |%n", wrappedText.get(i), quantity);
                } else {
                    System.out.printf("| %-80s | %-10s |%n", wrappedText.get(i), "");  // Empty quantity for subsequent lines
                }
            }
        }

        System.out.println("|-----------------------------------------------------------------------------------------------|");
        System.out.printf ("| %-80s | %-10d |%n", "Total Items", totalItems);
        System.out.println("\\-----------------------------------------------------------------------------------------------/");
    }

    private void saveToFile() throws IOException {

        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(itemMap.entrySet());
        sortedEntries.sort(Map.Entry.comparingByKey());

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Map.Entry<String, Integer> entry : sortedEntries) {
                writer.write(entry.getKey() + "," + entry.getValue());
                writer.newLine();
            }
        }
    }

    private void loadFromFile() {
        File file = new File(FILE_PATH);
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts.length == 2) {
                        String item = parts[0];
                        int quantity = Integer.parseInt(parts[1]);
                        itemMap.put(item, quantity);
                        totalItems += quantity;
                    }
                }
            } catch (IOException except) {
                except.printStackTrace();
            }
        }
    }


    private List<String> wrapText(String text, int maxWidth) {
        List<String> wrappedLines = new ArrayList<>();
        String[] words = text.split(" ");
        StringBuilder currentLine = new StringBuilder();

        for (String word : words) {
            if (currentLine.length() + word.length() + 1 <= maxWidth) {
                if (currentLine.length() > 0) {
                    currentLine.append(" ");
                }
                currentLine.append(word);
            } else {
                wrappedLines.add(currentLine.toString());
                currentLine = new StringBuilder(word);
            }
        }


        if (currentLine.length() > 0) {
            wrappedLines.add(currentLine.toString());
        }

        return wrappedLines;
    }
}

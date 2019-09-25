package com.codegym.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Transactionality

*/

public class Solution {
    public static List<String> allLines = new ArrayList<>();
    public static List<String> linesForRemoval = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String allLinesFileName = reader.readLine();
        String linesForRemovalFileName = reader.readLine();
        reader.close();

        fileReader(allLines, allLinesFileName);
        fileReader(linesForRemoval, linesForRemovalFileName);

        Solution solution = new Solution();
        solution.joinData();
    }

    public void joinData() throws CorruptedDataException {

        if (allLines.containsAll(linesForRemoval)) {
            allLines.removeAll(linesForRemoval);
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }

    public static void fileReader(List<String> target, String source) {
        try {
            BufferedReader rd = new BufferedReader(new FileReader(source));
            String line;
            while ((line = rd.readLine()) != null) {
                target.add(line);
            }
            rd.close();
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist!");
        } catch (IOException e) {
            System.out.println("Input error!");
        }
    }
}

import javax.swing.*;
import java.io.*;

public class PanCakeFlipper {

    public static void main(String[] args) throws Exception{

        String inputFilePath = "";
        String outputFilePath = "";

        //select directory to open file
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            inputFilePath = selectedFile.getAbsolutePath();
        }

        //location of data file
        FileReader file = new FileReader(inputFilePath);
        BufferedReader reader = new BufferedReader(file);


        //select directory to save file
        int saveResult = fileChooser.showSaveDialog(null);
        if (saveResult == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            outputFilePath = selectedFile.getAbsolutePath();
        }

        //output of data file
        File newFile = new File(outputFilePath);

        if(newFile.exists()){
            System.out.println("File already exists");
        }

        newFile.createNewFile();
        FileWriter fileWriter = new FileWriter(newFile);
        final BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        int caseNumber = 0;
        String s = "";
        String output = "";
        int k;
        int count;
        char minus = '-';
        char plus = '+';

        String line = reader.readLine();

        while(line!=null){
            //if condition prevents the 1st input from being checked as a test case
            if(caseNumber < 1){
                caseNumber +=1;
                line = reader.readLine();
            }else if(caseNumber >=1){
                count = 0;
                s = line;
                //split the input string by space
                String[] splitStr = s.split("\\s+");
                s = splitStr[0];
                k = Integer.valueOf(splitStr[1]);

                final char ar[] = new char [s.length()];
                for (int c = 0; c < s.length(); c++)
                {
                    ar[c] = s.charAt(c);
                }

                for (int l = 0; l < s.length(); l++) {
                    if (ar[l] == minus) {
                        count++;
                        ar[l] = plus;
                        for (int j = l + 1; j < (l + k); j++) {
                            //check if the next flippable characters are greater than the length of the input string
                            //if true, set count to -1 and exit out of the loop since this is an impossible case
                            if ((l + k) > s.length()) {
                                count = -1;
                                break;
                            } else {
                                if (ar[j] == plus) {
                                    ar[j] = minus;
                                } else if (ar[j] == minus) {
                                    ar[j] = plus;
                                }
                            }
                        }
                    }
                }

                if(count >= 0) {
                    output = "Case #"+ caseNumber + ": " + count + "\n";
                }else {
                    output = "Case #"+ caseNumber + ": " + "Impossible" + "\n";
                }
                bufferedWriter.write(output);

                line = reader.readLine();
                caseNumber += 1;
            }
        }
        reader.close();
        bufferedWriter.close();
    }
}

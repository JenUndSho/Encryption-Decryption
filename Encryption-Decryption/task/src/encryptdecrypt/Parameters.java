package encryptdecrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Parameters {
    private String command = "enc";
    private String strInput = "";
    private boolean isOutputExist = false;
    private File fileOutput = null;
    private int key = 0;
    private String algorithm = "";

    public Parameters(String[] args) {
        for (int i = 0; i < args.length; i++){
            if (args[i].equals("-alg")) {
                algorithm = args[i+1];
            }
            if (args[i].equals("-mode")) {
                command = args[i+1];
            }
            if (args[i].equals("-key")) {
                key = Integer.parseInt(args[i+1]);
            }
            if (args[i].equals("-data")) {
                strInput = args[i+1];
            }
            if (args[i].equals("-in")) {
                File f = new File(args[i+1]);
                try (Scanner scanner = new Scanner(f)) {
                    strInput = scanner.nextLine();
                } catch (NoSuchElementException | FileNotFoundException e) {
                    System.out.println("Error: Cannot read file: " + e.getMessage());
                }
            }
            if (args[i].equals("-out")) {
                fileOutput = new File("./" + args[i+1]);
                isOutputExist = true;
            }
        }
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getStrInput() {
        return strInput;
    }

    public void setStrInput(String strInput) {
        this.strInput = strInput;
    }

    public boolean isOutputExist() {
        return isOutputExist;
    }

    public void setOutputExist(boolean outputExist) {
        isOutputExist = outputExist;
    }

    public File getFileOutput() {
        return fileOutput;
    }

    public void setFileOutput(File fileOutput) {
        this.fileOutput = fileOutput;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }


}

package encryptdecrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Parameters params = new Parameters(args);

        EncodingDecoding ed = new EncodingDecoding();
        if (params.getCommand().equals("enc")) {
            ed.setMethod(new Encoding());
        } else if (params.getCommand().equals("dec")) {
            ed.setMethod(new Decoding());
        }
        String result = ed.implement(params.getStrInput(), params.getKey(), params.getAlgorithm());

        if (params.isOutputExist()) {
            try (FileWriter fw = new FileWriter(params.getFileOutput())) {
                fw.write(result);
            } catch (IOException e) {
                System.out.printf("Error: An exception occurs %s", e.getMessage());
            }
        }
        else {
            System.out.print(result);
        }
    }
}

interface AlgorithmMethod {
    String implement(String input, int key, String alg);
}

class Encoding implements AlgorithmMethod {
    StringBuilder res = null;

    @Override
    public String implement(String input, int key, String alg) {
        res = new StringBuilder();
        if (alg.equals("shift")) {
            for(char c : input.toCharArray()){
                if (c == ' ') {
                    res.append(c);
                    continue;
                }

                if ((int) c + key > 122)
                    res.append((char) ((int) c + key - 122 + 97 - 1));
                else
                    res.append((char) (c + key));
            }
        } else if (alg.equals("unicode")) {
            for(char c : input.toCharArray()) {
                res.append((char) (c + key));
            }
        }
        return res.toString().replace('|', '\\');
    }
}

class Decoding implements AlgorithmMethod {
    StringBuilder res = null;

    @Override
    public String implement(String input, int key, String alg) {
        res = new StringBuilder();
        if (alg.equals("shift")) {
            for(char c : input.toCharArray()){
                if (c == ' ') {
                    res.append(c);
                    continue;
                }
                if ((int) c - key < 97)
                    res.append((char) ((int) c - key + 122 - 97 + 1));
                else
                    res.append((char) (c - key));
            }
        } else if (alg.equals("unicode")) {
            for(char c : input.toCharArray()) {
                res.append((char) (c - key));
            }
        }
        return res.toString().replace('|', '\\');
    }
}

class EncodingDecoding {
    public AlgorithmMethod method;

    public void setMethod(AlgorithmMethod method) {
        this.method = method;
    }

    public String implement(String input, int key, String alg) {
        return this.method.implement(input, key, alg);
    }
}

class Parameters {
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


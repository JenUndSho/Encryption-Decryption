package encryptdecrypt;

import java.io.FileWriter;
import java.io.IOException;

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



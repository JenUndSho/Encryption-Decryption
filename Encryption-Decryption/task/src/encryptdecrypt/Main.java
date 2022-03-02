package encryptdecrypt;

import static encryptdecrypt.FileUsage.writeToFile;

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
            writeToFile(params.getFileOutput(), result);
        }
        else {
            System.out.print(result);
        }
    }
}



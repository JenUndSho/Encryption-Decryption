package encryptdecrypt;

import encryptdecrypt.encodeMethods.Shift;
import encryptdecrypt.encodeMethods.Unicode;

import static encryptdecrypt.FileUsage.writeToFile;

public class Main {
    public static void main(String[] args) {
        Parameters params = new Parameters(args);

        EncodingDecoding ed = new EncodingDecoding();
        if (params.getAlgorithm().equals("shift")) {
            ed.setMethod(new Shift());
        } else if (params.getAlgorithm().equals("unicode")) {
            ed.setMethod(new Unicode());
        }

        String result = ed.implement(params.getStrInput(), params.getKey(), params.getCommand());

        if (params.isOutputExist()) {
            writeToFile(params.getFileOutput(), result);
        }
        else {
            System.out.print(result);
        }
    }
}



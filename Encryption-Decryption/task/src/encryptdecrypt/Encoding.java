package encryptdecrypt;

import encryptdecrypt.encodeMethods.Shift;
import encryptdecrypt.encodeMethods.Unicode;

public class Encoding implements AlgorithmMethod {
    StringBuilder res = null;

    @Override
    public String implement(String input, int key, String alg) {
        res = new StringBuilder();
        if (alg.equals("shift")) {
            res = new Shift().encode(input, key);
        } else if (alg.equals("unicode")) {
            res = new Unicode().encode(input, key);
        }
        return res.toString().replace('|', '\\');
    }
}

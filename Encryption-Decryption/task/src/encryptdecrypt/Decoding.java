package encryptdecrypt;

public class Decoding implements AlgorithmMethod {
    StringBuilder res = null;

    @Override
    public String implement(String input, int key, String alg) {
        res = new StringBuilder();
        if (alg.equals("shift")) {
            shift(input, key);
        } else if (alg.equals("unicode")) {
            unicode(input, key);
        }
        return res.toString().replace('|', '\\');
    }

    private void shift(String input, int key) {
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
    }

    private void unicode(String input, int key) {
        for(char c : input.toCharArray()) {
            res.append((char) (c - key));
        }
    }
}

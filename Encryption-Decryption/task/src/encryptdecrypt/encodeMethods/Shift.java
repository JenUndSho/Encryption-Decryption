package encryptdecrypt.encodeMethods;

import encryptdecrypt.AlgorithmMethod;

public class Shift implements AlgorithmMethod {
    private StringBuilder res;

    public Shift() {
        res = new StringBuilder();
    }

    @Override
    public String implement(String input, int key, String command) {
        res = new StringBuilder();

        if (command.equals("enc")) {
            res = encode(input, key);
        } else if (command.equals("dec")) {
            res = decode(input, key);
        }

        return res.toString().replace('|', '\\');
    }

    public StringBuilder encode(String input, int key) {
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

        return res;
    }

    public StringBuilder decode(String input, int key) {
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

        return res;
    }
}

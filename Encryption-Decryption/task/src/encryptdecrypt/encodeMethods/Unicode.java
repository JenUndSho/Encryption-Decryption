package encryptdecrypt.encodeMethods;

import encryptdecrypt.AlgorithmMethod;

public class Unicode implements AlgorithmMethod {
    private StringBuilder res;

    public Unicode() {
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
        for(char c : input.toCharArray()) {
            res.append((char) (c + key));
        }

        return res;
    }

    public StringBuilder decode(String input, int key) {
        for(char c : input.toCharArray()) {
            res.append((char) (c - key));
        }

        return res;
    }
}

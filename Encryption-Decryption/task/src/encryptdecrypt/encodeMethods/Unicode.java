package encryptdecrypt.encodeMethods;

public class Unicode {
    private StringBuilder res;

    public Unicode() {
        res = new StringBuilder();
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

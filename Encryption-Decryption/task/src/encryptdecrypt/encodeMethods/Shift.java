package encryptdecrypt.encodeMethods;

public class Shift {
    private StringBuilder res;

    public Shift() {
        res = new StringBuilder();
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

package encryptdecrypt;

public class EncodingDecoding {
    public AlgorithmMethod method;

    public void setMethod(AlgorithmMethod method) {
        this.method = method;
    }

    public String implement(String input, int key, String alg) {
        return this.method.implement(input, key, alg);
    }
}

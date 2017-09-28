/**
 * Created by Sachouw on 28/09/2017.
 */
public class Result {

    private String label;
    private int value;

    public Result(String l) {
        label = l;
        value = 0;
    }

    public void setValue(int v) {
        value = v;
    }

    public int getValue() {
        return value;
    }

    public String toString() {
        return "\n" + label + "\n value : " + value;
    }
}

/**
 * Created by Sachouw on 28/09/2017.
 */
public class Environment {

    public Environment() {
    }

    public int getResult(String action) {

        switch(action) {
            case "1" :
                return 1; //r1

            case "2" :
                return 2; //r2

            default:
                return 3;
        }

    }
}

import java.util.HashMap;

/**
 * Created by Sachouw on 28/09/2017.
 */
public class Environment {

    private int count;
    private HashMap<Experience, Result> resultat1;
    private HashMap<Experience, Result> resultat2;

    public Environment() {
        count = 0;
        resultat1 = new HashMap<>();
        resultat2 = new HashMap<>();
    }

    public void addRule1(Experience experience, Result result, int value) {
        resultat1.put(experience, result);
    }

    public void addRule2(Experience experience, Result result, int value) {
        resultat2.put(experience, result);
    }

    public Result getResult(Experience experience) {

        //? Comment savoir quel résultat retourner ?

        if(count == 0) {
            //env1
            count++;
            return resultat1.get(experience);
        }

        count--;
        return resultat2.get(experience);
    }
}

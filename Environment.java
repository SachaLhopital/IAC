import java.util.HashMap;

/**
 * Created by Sachouw on 28/09/2017.
 */
public class Environment {

    private HashMap<Experience, Result> resultat;

    public Environment() {
        resultat = new HashMap<>();
    }

    public void addRule(Experience experience, Result result, int value) {
        result.setValue(value);
        resultat.put(experience, result);
    }

    public Result getResult(Experience experience) {

        //? Comment savoir quel résultat retourner ?

        return resultat.get(experience);
    }
}

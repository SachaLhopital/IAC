package src.Environments;

/**
 * Created by Sachouw on 05/10/2017.
 */
public class Env2 extends Environment {

    @Override
    public int getResultat(int action) {
        return (action == 1) ? 2 /*r2*/ : 1 /* r1 */;
    }
}

package Environments;

/**
 * Created by Sachouw on 05/10/2017.
 */
public class Env1 extends Environment {

    @Override
    public int getResultat(int action) {
        return (action == 1) ? 1 /*r1*/ : 2 /* r2 */;
    }
}

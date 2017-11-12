package src.Environments;

public class Env4 extends Environment {

    private int nbIterations;

    public Env4() {
        super();
        nbIterations = 0;
    }

    @Override
    public int getResultat(int action) {
        int resultat;

        if(nbIterations < 10) {
            resultat = (action == 1) ? 1 /*r1*/ : 2 /* r2 */;
            nbIterations++;
        } else {
            resultat = (action == 1) ? 2 /*r2*/ : 1 /* r1 */;
        }
        return resultat;
    }
}

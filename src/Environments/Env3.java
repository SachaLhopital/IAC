package src.Environments;

/**
 * Environnement for the sequential agent
 * Return 1 if the agent changed his action
 * Created by Sachouw on 17/10/2017.
 */
public class Env3 extends Environment {

    private int lastActionByAgent;

    public Env3() {
        super();
        lastActionByAgent = -1;
    }

    protected int getLastActionByAgent() {
        return lastActionByAgent;
    }

    protected void setLastActionByAgent(int action) {
        lastActionByAgent = action;
    }

    @Override
    public int getResultat(int action) {
        int resultat;

        if(getLastActionByAgent() == -1 || action == getLastActionByAgent()) {
            resultat = 1; //r1
        } else {
            resultat = 2; //r2
        }
        setLastActionByAgent(action);
        return resultat;
    }
}

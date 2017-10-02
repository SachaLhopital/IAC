public class Main {

    public static void main(String[] args) {

        int count = 0;

        Motivation motivation = new Motivation();
        Agent agent = new Agent(motivation);
        Environment env = new Environment();

        /*Experience e1 = new Experience("e1");
        Experience e2 = new Experience("e2");

        Result r1 = new Result("r1");
        Result r2 = new Result("r2");
        Result r = null;

        agent.addPossibility(e1);
        agent.addPossibility(e2);*/

        /*Agent.Interaction i11 = new Agent.Interaction(e1, r1);
        Agent.Interaction i12 = new Agent.Interaction(e1, r2);
        Agent.Interaction i21 = new Agent.Interaction(e2, r1);
        Agent.Interaction i22 = new Agent.Interaction(e2, r2);*/

        /*env.addRule1(e1, r1, 1);
        env.addRule2(e1, r2, -1);
        env.addRule1(e2, r1, 1);
        env.addRule2(e2, r2, -1);*/

        while(count != 50) {

            String action = agent.chooseExperience();
            int r = env.getResult(action);

            System.out.println("DO : " + action.toString());
            System.out.println("RESULT Environnement " + r);
            System.out.println("RESULT Motivation " + motivation.getReward(action));
            System.out.println("---------------------");

            agent.updateReward(r);

            count++;
        }
    }
}

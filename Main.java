public class Main {

    public static void main(String[] args) {

        int count = 0;

        Agent agent = new Agent();
        Environment env = new Environment();

        Experience e1 = new Experience("e1");
        Experience e2 = new Experience("e2");

        Result r1 = new Result("r1");
        Result r2 = new Result("r2");
        Result r = null;

        agent.addPossibility(e1);
        agent.addPossibility(e2);

        /*Agent.Interaction i11 = new Agent.Interaction(e1, r1);
        Agent.Interaction i12 = new Agent.Interaction(e1, r2);
        Agent.Interaction i21 = new Agent.Interaction(e2, r1);
        Agent.Interaction i22 = new Agent.Interaction(e2, r2);*/

        env.addRule1(e1, r1, 1);
        env.addRule2(e1, r2, -1);
        env.addRule1(e2, r1, 1);
        env.addRule2(e2, r2, -1);

        while(count != 50) {

            Experience e = agent.chooseExperience(r); //r ?
            r = env.getResult(e);

            System.out.println("DO : " + e.toString());
            System.out.println("RESULT " + r.toString());
            System.out.println("---------------------");

            count++;
        }
    }
}

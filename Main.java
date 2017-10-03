public class Main {

    public static void main(String[] args) {

        int r = 0;
        int count = 0;
        String action = "";

        Motivation motivation = new Motivation();
        Agent agent = new Agent(motivation);
        Environment env = new Environment();

        while(count != 50) {

            action = agent.chooseExperience(r);
            r = env.getResult(action);

            System.out.println("DO : " + action.toString());
            System.out.println("RESULT Environnement " + r);
            System.out.println("RESULT Motivation " + motivation.getReward(action));
            System.out.println("---------------------");

            agent.updateReward(r);

            count++;
        }
    }
}

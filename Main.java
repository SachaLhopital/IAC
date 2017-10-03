public class Main {

    public static void main(String[] args) {

        int count = 0;

        Motivation motivation = new Motivation();
        Agent agent = new Agent(motivation);
        Environment env = new Environment();

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

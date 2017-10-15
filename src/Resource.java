
public class Resource {
    private State[] states;

    public Resource(String resource){

        String[] temp = resource.split("[(),]");
        states = new State[(temp.length - 2)/3];
        for (int i = 0, j = 0; i < temp.length; i += 4, j++) {
            states[j] = new State(temp[i], Integer.parseInt(temp[i + 1]), Integer.parseInt(temp[i + 2]));
        }
    }

    public String getStateName(int time) {
        if(time > states[states.length - 1].getEnd()) return null;
        for (int i = 0; i < states.length; i++) {
            if(time >= states[i].getStart() && time <= states[i].getEnd()){
                return states[i].getName();
            }
        }
        return null;
    }

    public State getState(){
        return states[states.length - 1];
    }
}

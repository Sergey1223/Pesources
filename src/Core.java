import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class Core {
    private ArrayList<Resource> resources;

    public Core(BufferedReader bufferedReader) throws IOException {
        resources = new ArrayList<>();
        String temp = bufferedReader.readLine();
        while (temp != null){
            resources.add(new Resource(temp));
            temp = bufferedReader.readLine();
        }
    }

    public String getEqualsStateResources(){
        StringBuilder result = new StringBuilder();
        String stateName;
        int start = 1, end = -1, maxTime = getMaxTime(), j;
        for (int time = 1; time <= maxTime; time++) {
            stateName = resources.get(0).getStateName(time);
            for (j = 1; j < resources.size(); j++) {
                if(!resources.get(j).getStateName(time).equals(stateName)){
                    if(end == time - 1){
                        result.append(stateName + "(" + start + "," + end + "),");
                    }
                    start = time + 1;
                    break;
                }
            }
            if(j == resources.size()){
                end = time;
                if(time == maxTime){
                    result.append(stateName + "(" + start + "," + end + "),");
                }
            }
        }
        return result.replace(result.length() - 1, result.length(), "").toString();
    }

    private int getMaxTime(){
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < resources.size(); i++) {
            if (resources.get(i).getState().getEnd() < max) {
                max = resources.get(i).getState().getEnd();
            }
        }
        return max;
    }
}
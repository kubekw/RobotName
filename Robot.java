import java.util.ArrayList;
import java.util.Random;

public class Robot{
    private static ArrayList<String> allRobotsNames = new ArrayList<>();

    private Random random = new Random();
    private String name;


    public Robot(){
        name = generateRobotRandomName();
        allRobotsNames.add(name);
    }

    public String getName(){
        return name;
    }

    public void reset(){
        allRobotsNames.remove(name);
        name = generateRobotRandomName();
        allRobotsNames.add(name);
    }

    public static ArrayList<String> getAllRobotsNames() {
        return allRobotsNames;
    }

    private String generateRobotRandomName(){
        String randomName;

        do {
            randomName = new String();
            StringBuilder stringBuilder = new StringBuilder();

            stringBuilder
                    .append(randomChar())
                    .append(randomChar())
                    .append(randomDigit())
                    .append(randomDigit())
                    .append(randomDigit());

            randomName = stringBuilder.toString();
        }
        while(!randomNameIsUnique(randomName));

        return randomName;
    }

    private boolean randomNameIsUnique(String randomNameToCheck) {
        if(allRobotsNames.contains(randomNameToCheck)){
            System.out.println("Name "+randomNameToCheck+" is not availabe");
            return false;
        }
        else {
            return true;
        }
    }

    private char randomChar(){
        return (char) (random.nextInt(26) + 'A');
    }

    private int randomDigit(){
        return random.nextInt(10);
    }



}

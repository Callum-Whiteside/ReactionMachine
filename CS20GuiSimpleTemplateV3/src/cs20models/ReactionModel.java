package cs20models;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;

/**
 * A class to model the problem or situation your program solves
 *
 * @author cheng
 */
public class ReactionModel {

    private boolean start;
    private int random;
    private long time;
    private int attempts;
    private long totalTime;
    private long[] Times = new long[11];
    private long[] superSaveString = new long[10000];
    private int numOfSaves;
    private boolean instructions;
    ReactionTime[] reactionList;

    public ReactionModel() {
        this.start = false;
        this.instructions = false;
        this.random = 0;
        this.time = 0;
        this.numOfSaves = 0;
        this.totalTime = 0;
        reactionList = new ReactionTime[9999];
    }

    public boolean getStart() {
        return this.start;
    }

    public void setStart(boolean boo) {
        this.start = boo;
    }

    public boolean getInstructions() {
        return this.instructions;
    }

    public void setInstructions(boolean boo) {
        this.instructions = boo;
    }

    public int getRandom() {
        return this.random;
    }

    public void setRandom(int i) {
        this.random = i;
    }

    public int getAttempts() {
        return this.attempts;
    }

    public void setAttempts(int i) {
        this.attempts = i;
    }

    public long getSuperTime() { // gets the average time inbetween reactions and sets it to totalTime
        if (this.attempts == 0) {
            this.time = System.currentTimeMillis();
        }
        this.Times[this.attempts] = new Date().getTime() - this.time;
        this.time = System.currentTimeMillis();
        if (this.attempts == 10) {
            for (int i = 0; i < 9; i++) {
                this.totalTime = this.totalTime + this.Times[i];
            }
            this.totalTime = this.totalTime / 9;
            ReactionTime RT = new ReactionTime();
            RT.setReactionTime(this.totalTime);
            RT.setMode("hand");
            this.addReactionTime(RT);
        }
        this.attempts = this.attempts + 1;
        return this.totalTime;
    }

    public int superRandom() { //gets random number for random button
        int r = (int) (Math.random() * 9);
        this.random = r;
        return this.random;
    }

    public void setConcussionTotalTime(long lo) { //sets the array for the new mode time
        ReactionTime RT = new ReactionTime();
        RT.setReactionTime(lo);
        RT.setMode("one");
        this.addReactionTime(RT);
    }

    public String getSaveString() { //gets the save string for the save
        String saveStr = "";
        int count = 0;
        long smallestNumber = 900000001;
        for (int i = 0; i <= reactionList.length - 1; i++) {
            if (reactionList[i] != null && reactionList[i].getReactionTime() > 0) {
                count = count + 1;
            }
        }
        long[] finishedArrayOfNumbers = new long[count];

        for (int x = 0; x <= finishedArrayOfNumbers.length - 1; x++) {
            for (int i = 0; i <= reactionList.length - 1; i++) {
                if (reactionList[i] != null && smallestNumber > reactionList[i].getReactionTime()) {
                    smallestNumber = reactionList[i].getReactionTime();
                }
            }
            for (int i = 0; i <= reactionList.length - 1; i++) {
                if (reactionList[i] != null && smallestNumber == reactionList[i].getReactionTime()) {
                    reactionList[i].setReactionTime(999999999);
                }
            }
            finishedArrayOfNumbers[x] = smallestNumber;
            smallestNumber = 999999998;
        }
        for (int i = 0; i <= finishedArrayOfNumbers.length - 1; i++) {
            if (finishedArrayOfNumbers[i] > 0 && finishedArrayOfNumbers[i] < 999999997 && reactionList[i].getMode().equals("hand")) {
                saveStr = saveStr + "Your reaction time and hand eye is " + finishedArrayOfNumbers[i] + " milliseconds.\n";
            }
            if (finishedArrayOfNumbers[i] > 0 && finishedArrayOfNumbers[i] < 999999997 && reactionList[i].getMode().equals("one")) {
                saveStr = saveStr + "Your reaction Time with one button is " + finishedArrayOfNumbers[i] + " milliseconds.\n";
            }
        }
        return saveStr;
    }

    public void saveToFile(String pathToFile) throws IOException {
        FileWriter fw = new FileWriter(pathToFile);
        PrintWriter pw = new PrintWriter(fw);
        String saveStr = this.getSaveString();
        pw.println(saveStr);
        pw.close();
    }

    public void openFromFile(String pathToFile) throws IOException {
        File f = new File(pathToFile);
        Scanner sc = new Scanner(f);

        reactionList = new ReactionTime[9999];
        numOfSaves = 0;

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] fields = line.split(" ");
            ReactionTime RT = new ReactionTime();
            if (!"".equals(fields[0])) {
            System.out.println(fields[7]);
            RT.setMode(fields[4]);
            long reactionTime = Long.parseLong(fields[7]);
            RT.setReactionTime(reactionTime);

//            System.out.println(RT.getReactionTime());
            
            this.addReactionTime(RT);
            }
        }
    }

    public void addReactionTime(ReactionTime RT) {
        if (numOfSaves >= reactionList.length) {
            return;
        }
        reactionList[numOfSaves] = RT;
        numOfSaves = numOfSaves + 1;
    }
}

// Zakwan Ashfaq Zian - zazian
// 201950250

import java.util.concurrent.ThreadLocalRandom;

public class backend {
    // global variables
    int score;
    int intArr[];
    boolean state;
    // constructor
    public backend() {
        // initializing score
        this.score = 0;
        // initializing array to hold 25 random integer
        this.intArr = new int[25];
        // creating random integer and storing in the array
        for (int i = 0; i < 25; i++) {
            int randomNum = ThreadLocalRandom.current().nextInt(1, 6);
            intArr[i] = randomNum;
        }
        // randomizing which player gets first turn
        int randomNum = ThreadLocalRandom.current().nextInt(0, 2);
        if (randomNum == 0) state = true;
        else state = false;
    }
    // checks score to see if total crossed 21
    public boolean checkScore(){
        if (score>21){
            return false;
        }else{
            return true;
        }
    }
    // adding to total
    public void add(int num){
        score += intArr[num];
    }
    // reset
    public void reset(){
        // initializing score
        this.score = 0;
        // initializing array to hold 25 random integer
        this.intArr = new int[25];
        // creating random integer and storing in the array
        for (int i = 0; i < 25; i++) {
            int randomNum = ThreadLocalRandom.current().nextInt(1, 6);
            intArr[i] = randomNum;
        }
        // randomizing which player gets first turn
        int randomNum = ThreadLocalRandom.current().nextInt(0, 2);
        if (randomNum == 0) state = true;
        else state = false;
    }
    // check method
    public boolean check(int num){
        add(num);
        if (!checkScore()) {
            System.out.println("Stopped");
            return false;
        }
        return true;
    }
    // state
    public String state(){
        String returnVal;
        if (state) returnVal = "Player 1`s turn";
        else returnVal = "Player 2`s turn";
        if (state) state=false;
        else state = true;
        return returnVal;
    }
    // main method for testing
    public static void main(String[] args) {
        backend b = new backend();
        for (int i = 0; i < 25; i++) {
            System.out.print(b.intArr[i]+"");
        }
        System.out.println();
        b.check(0);
        b.check(1);
        b.check(2);
        b.check(15);
        b.check(20);
        b.check(24);
        b.check(6);
        b.check(12);
        System.out.println(b.score);
        int randomNum = ThreadLocalRandom.current().nextInt(0, 2);
        System.out.println(randomNum);

    }
}

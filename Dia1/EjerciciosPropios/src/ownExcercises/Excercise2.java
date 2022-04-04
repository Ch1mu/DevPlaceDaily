package ownExcercises;

public class Excercise2 {

    public static void main(String[] args) {
        int speed=25;
        isGood(speed);
        
    }
    public static void isGood(int speed)
    {
        if (speed<15){
            System.out.println("the participant have a bad performance");
        } else if (speed < 25)
        {
            System.out.println("the participant have a standar performance");
        } else {
            System.out.println("the participant have a good performance");
        }
        
    }
}

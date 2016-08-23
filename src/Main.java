import java.util.Scanner;

public class Main {
    static Scanner keyboard = new Scanner(System.in); //Keyboard to collect user info
    public static void main(String[] args) {
        String person[] = new String[2];    //collect names into an array
        getName(person);   //call get name to get persons names
        float numOfTrans1[] = new float[getTrans(person[0])];   //get number of transactions made by person 1
        float numOfTrans2[] = new float[getTrans(person[1])];   //get number of transactions made by person 1
        float totalPerson1 = getTotal1(numOfTrans1,person[0]);  //calculates the total amount spent by person 1
        float totalPerson2 = getTotal1(numOfTrans2,person[1]);  //calculate the total amount spent by person 2

        //prints total for person 1
        System.out.printf("Total for "+ person[0] + " is $%.2f%n", totalPerson1);
        //prints total for person 2
        System.out.printf("Total for "+ person[1] + " is $%.2f%n", totalPerson2);

        //Calculate how much each person owes each
        getTotalEach(totalPerson1, totalPerson2 ,person);
    }

    //calculate and prints how each the person owes the other person
    public static float getTotalEach(float totalPerson1, float totalPerson2, String person[]){
        float totalCombined = 0;
        float halfPerson1 = 0;
        float halfPerson2 = 0;

        halfPerson1 = totalPerson1/2;
        halfPerson2 = totalPerson2/2;

        if(halfPerson1 > halfPerson2){
            totalCombined = halfPerson1 - halfPerson2;
            System.out.printf(person[1] + " owes " + person[0] + " $%.2f%n", totalCombined);
        }
        else{
            totalCombined = halfPerson2 - halfPerson1;
            System.out.printf(person[0] + " owes " + person[1] + " $%.2f%n", totalCombined);
        }

        return totalCombined;
    }

    //get the number of transaction made by person
    public static int getTrans(String person){
        int trans = 0;

        System.out.println("Enter number of transactions made for " + person);
        trans = keyboard.nextInt();

        String str1 = keyboard.nextLine();

        return trans;
    }

    //get the name of the persons
    public static String[] getName(String[] person){

        for (int i = 0; i < person.length; i++) {
            System.out.println("Enter name for person " + (i+1));
            person[i] = keyboard.nextLine();
        }
        return person;
    }


    //get total amount spent by person
    public static float getTotal1(float numOfTrans[], String person){
        float total = 0;
        for(int i = 0; i < numOfTrans.length; i++){
            System.out.println("Enter amount for transaction number " + (i+1) + " for " + person);
            numOfTrans[i] = keyboard.nextFloat();
            total = total + numOfTrans[i];
        }
        return total;
    }
}

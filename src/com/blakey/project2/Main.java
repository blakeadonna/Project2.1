package com.blakey.project2;
import java.util.*;

//Johnny Nguyen | 04.03.19 | Task list that adds tasks, removes, updates, and lists priority

//Task class
class thing {
    private String title;
    private String description;
    private int priority;

    public thing(String title, String description, int priority) {
        this.title = title;
        this.description = description;
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return title +": "+ description +". Priority "+ priority;
    }
}

//Checks for format
class UserInput{
    Scanner scanner = new Scanner(System.in);
    public String promptString(String message){
        System.out.println(message);
        String userInput= scanner.nextLine();
        String stringInput = "";
        boolean isString = false;
        while(!isString){
            try{
                stringInput= userInput;
                isString= true;
            }
            catch(Exception e){
                System.out.println(userInput+" is not a valid string."+message);
                userInput = scanner.nextLine();
            }
        }
        return stringInput;
    }
    public int promptInt(String message){
        System.out.println(message);
        String userInput = scanner.nextLine();

        int intInput = 0;
        boolean isInt = false;
        while(!isInt){
            try{
                intInput = Integer.parseInt(userInput);
                isInt=true;
            }
            catch(NumberFormatException e){
                System.out.println(userInput+" is not a valid integer. "+message);
                userInput = scanner.nextLine();
            }
        }

        return intInput;
    }
}

public class Main {
    static String menu(){
        String choose="Please choose an option: " +
                "\n(1) Add a task." +
                "\n(2) Remove a task." +
                "\n(3) Update a task." +
                "\n(4) List all tasks." +
                "\n(5) Exit.";
        return choose;
    }

    //Initializes menu and will repeat until user presses 5
    public static void main(String[] args) {
        List<thing> list = new ArrayList<>();
        while(true){
            UserInput input = new UserInput();
            int selection = input.promptInt(menu());

            //Add a task
            if(selection==1) {
                UserInput inputT = new UserInput();
                String title = inputT.promptString("Please enter the title of the task: ");
                UserInput inputD = new UserInput();
                String desc = inputD.promptString("Please enter a description: ");
                UserInput inputP = new UserInput();
                int priority = inputP.promptInt("Priority (1-5)");
                thing t1 = new thing(title, desc, priority);
                list.add(t1);
            }

            //Remove a task
            if(selection==2){
                int currentPosition =0;
                for(thing items: list){
                    System.out.println("("+currentPosition+") "+items); }
                UserInput inputR = new UserInput();
                int remove = inputR.promptInt("Which task do you want to remove?");
                list.remove(remove);
            }

            //Update a task
            if(selection==3){
                int currentPosition = 0;
                for (thing items: list){
                    System.out.println("("+currentPosition+") "+items);
                    currentPosition++; }
                UserInput inputU = new UserInput();
                int update = inputU.promptInt("Which task do you want to update?");
                UserInput inputT = new UserInput();
                String title =inputT.promptString("Please enter the new title of the task: ");
                UserInput inputD = new UserInput();
                String desc = inputD.promptString("Please enter a new description: ");
                UserInput inputP = new UserInput();
                int priority = inputP.promptInt("Priority (1-5)");
                thing t1 = new thing(title,desc,priority);
                list.set(update, t1);
            }

            //List all tasks
            if(selection==4){
                for(thing items: list){
                    System.out.println(items);}
            }
            else{
                System.out.println("That is not a one of the choices.");
            }

            //Exit
            if(selection == 5){
                System.out.println("Have a nice day~");
                System.exit(5);}
        }
    }
}

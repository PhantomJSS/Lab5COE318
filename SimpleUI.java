package coe318.lab5;

import java.util.Scanner;

public class SimpleUI implements UserInterface {
    private BlackJackGame game;
    public String choice;
    public Boolean hit;
    public int userScore, houseScore;
    private Scanner user = new Scanner(System.in);

  @Override
    public void setGame(BlackJackGame game) {
        this.game = game;
    }

  @Override
    public void display() {
        System.out.println ("House Holds: \n" + this.game.getHouseCards().toString());
        System.out.println ("You Hold: \n" + this.game.getYourCards().toString());
    }

  @Override
    public boolean hitMe() {
        System.out.println("Another card?");
        choice = user.nextLine();
        switch(choice)
        {
            case "y":
            hit = true;
            break;
            
            case "n":
            hit = false;
            break;
        }
        return hit;
    }

  @Override
    public void gameOver() {
        this.display();
        houseScore = game.score(game.getHouseCards());
        userScore = game.score(game.getYourCards());
        System.out.println ("House Score:" + houseScore);
        System.out.println ("Your Score:" + userScore);
        if ((userScore > houseScore || houseScore > 21) && (userScore <=21))
        {
            System.out.println ("You Win");
        }
        else
        {
            System.out.println ("House Wins");
        }
        
    }

}
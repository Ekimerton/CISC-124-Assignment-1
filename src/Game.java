/*
Name: Ekim Karabey
NetId: 18ebk
Student Number: 20121769
Date: 19/01/2019
*/

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Game{

  Team team1 = null;
  Team team2 = null;
  int p1 = 0;
  int p2 = 0;
  int g1 = 0;
  int g2 = 0;
  int t1 = 0;
  int t2 = 0;
  
  //Constructor takes in two Team objects, and generates g1, g2, gets p1 and p2, uses those to generate t1 and t2.
  public Game(Team team1, Team team2){
    this.team1 = team1;
    this.team2 = team2;
    this.p1 = team1.getP();
    this.p2 = team2.getP();
    this.g1 = team1.goalie[NHLSimulator.generator.nextInt(4)].getSkill();
    this.g2 = team2.goalie[NHLSimulator.generator.nextInt(4)].getSkill();
    this.t1 = p1 + g1;
    this.t2 = p2 + g2;
  }

  /*
  First, the t values are changed according to a randomized performance of the forwards, defenders and goalies. Then, their scores
  (points but I didn't know hockey lol) are calculated according to the rules, using the simulateRegulation() method. Then, an if else
  statement is entered to see if the game will go on to overtime, or if team1/team2 won. 
  
  If overtime is entered the getOvertimeSkill() method is run, to determine who scores the final goal. If both teams have equal overtime
  skill, a hypothetical coin is flipped. 
  */
  public void simulateGame(){
    t1 = + forwardsPlay() + defendersPlay() + goaliesPlay();
    t2 = + forwardsPlay() + defendersPlay() + goaliesPlay();
    int score1 = simulateRegulation(t1);
    int score2 = simulateRegulation(t2);
    if(score1 == score2){
      int ot1 = getOvertimeSkill(team1);
      int ot2 = getOvertimeSkill(team2);
      if (ot1 < ot2){ //Overtime when team2 wins
        score2++;
        team2.wins++;
        team1.overtimeLoss++;
        team2.points = team2.points + 2;
        team1.points = team1.points + 1;
      } else if (o1 > ot2){ //Overtime when team1 wins
        score1++;
        team1.wins++;
        team2.overtimeLoss++;
        team1.points = team1.points + 2;
        team2.points = team2.points + 1;
      } else {
        int decide = NHLSimulator.generator.nextInt(2);
        if(decide == 0){ //Overtime tie then team2 wins
          score2++;
          team2.wins++;
          team1.overtimeLoss++;
          team2.points = team2.points + 2;
          team1.points = team1.points + 1;
        } else { //Overtime tie then team1 wins
          score1++;
          team1.wins++;
          team2.overtimeLoss++;
          team1.points = team1.points + 2;
          team2.points = team2.points + 1;
        }
      }
    } else if (score1 < score2){ //No overtime, team 2 wins
      team2.wins++;
      team1.losses++;
      team2.points = team2.points + 2;
    } else { //No overtime, team 1 wins
      team1.wins++;
      team2.losses++;
      team1.points = team1.points + 2;
    }
    //Score is added to goalsFor and goalsAgainst for scorekeeping, plus both teams games played goes up by 1.
    team1.goalsFor = team1.goalsFor + score1;
    team1.goalsAgainst = team1.goalsAgainst + score2;
    team2.goalsFor = team2.goalsFor + score2;
    team2.goalsAgainst = team2.goalsAgainst + score1;
    team1.played++;
    team2.played++;
  }

  /*
  This simulates the entire season, using nested for loops, similar to a selection sort. Since selection sort compares every number to
  every other number exactly once, this method uses the same methodology, and simulates a game with every team pair twice. 
  */
  public static void simulateSeason(){
    int count = 0;
    for(int i = 0; i < Team.teams.length; i++){
      Team teamOne = Team.teams[i];
      for(int j = i+1; j < Team.teams.length; j++){
        Team teamTwo = Team.teams[j];
        Game game = new Game(teamOne, teamTwo);
        game.simulateGame();
        game.simulateGame();
        count = count + 2;
      }
    }
  }
  
  /*
  Just randomly returns -25, 0, 25.
  */
  public static int forwardsPlay(){
    int rand = NHLSimulator.generator.nextInt(3);
    if(rand == 0){
      return 25;
    } else if (rand == 1){
      return 0;
    } else if (rand == 2){
      return -25;
    } else {
      return -10000;
    }
  }

  /*
  Just randomly returns 40, 0, -40.
  */
  public static int defendersPlay(){
    int rand = NHLSimulator.generator.nextInt(3);
    if(rand == 0){
      return 40;
    } else if (rand == 1){
      return 0;
    } else if (rand == 2){
      return -40;
    } else {
      return -10000;
    }
  }

  /*
  Just randomly returns 60, 0, -60.
  */
  public static int goaliesPlay(){
    int rand = NHLSimulator.generator.nextInt(3);
    if(rand == 0){
      return 60;
    } else if (rand == 1){
      return 0;
    } else if (rand == 2){
      return -60;
    } else {
      return -10000;
    }
  }
  
  /*
  For every 50 point partition, either 0, 1, or 2 points are scored. This while loop runs until the score is less than 50, and then the 
  rest of the score translates to either 0 or 1 point. 
  */
  public static int simulateRegulation(int score){
    int points = 0;
    int rand = 0;
    while(score >= 50){
      rand = NHLSimulator.generator.nextInt(3);
      if(rand == 0){
        points = points + 0;
      } else if (rand == 1){
        points = points + 1;
      } else if (rand == 2){
        points = points + 2;
      }
      score = score - 50;

    }
    if(score > 0){
      rand = NHLSimulator.generator.nextInt(2);
      if(rand == 0){
        points = points + 0;
      } else if (rand == 1){
        points = points + 1;
      }
    }
    return points;
  }

  /*
  To get three random unique numbers I generate an array of numbers between 0-20 (13 forwards + 8 defence = 21 total player pool). Then,
  the array is shuffled, and the first three numbers are picked. A single random integer is generated for the goalie. Then, the sum of 
  the picked players' skills are added and returned as an int. 
  */
  public int getOvertimeSkill(Team team){
    int totalSkill = 0;
    totalSkill = totalSkill + team.goalie[NHLSimulator.generator.nextInt(4)].getSkill();
    int[] randomNumbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
    shuffleArray(randomNumbers);
    for(int i = 0; i < 3; i++){
      int x = randomNumbers[i];
      if(x < 13){
        totalSkill = totalSkill + team.forward[x].getSkill();
      } else {
        totalSkill = totalSkill + team.defense[x - 13].getSkill();
      }
    }
    return totalSkill;
  }

  /*
  Implementing Fisher–Yates shuffle from https://stackoverflow.com/questions/1519736/random-shuffling-of-an-array
  */
  static void shuffleArray(int[] ar)
  {
    Random rnd = ThreadLocalRandom.current();
    for (int i = ar.length - 1; i > 0; i--)
    {
      int index = rnd.nextInt(i + 1);
      int a = ar[index];
      ar[index] = ar[i];
      ar[i] = a;
    }
  }

  /*
  Used for debugging, making sure the game generation isn't messed up. 
  */
  public void printGame(){
    System.out.println("Game between " + team1.getName() + " and "  + team2.getName());
    System.out.println(this.p1 + this.g1);
    System.out.println(this.p2 + this.g2);
    System.out.println(this.t1);
    System.out.println(this.t2);
  }
}

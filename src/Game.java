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

  public void simulateGame(){
    t1 = + forwardsPlay() + defendersPlay() + goaliesPlay();
    t2 = + forwardsPlay() + defendersPlay() + goaliesPlay();
    int score1 = simulateRegulation(t1);
    int score2 = simulateRegulation(t2);
    if(score1 == score2){
      if (getOvertimeSkill(team1) < getOvertimeSkill(team2)){ //Overtime when team2 wins
        score2++;
        team2.wins++;
        team1.overtimeLoss++;
        team2.points = team2.points + 2;
        team1.points = team1.points + 1;
      } else if (getOvertimeSkill(team1) > getOvertimeSkill(team2)){ //Overtime when team1 wins
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

    team1.goalsFor = team1.goalsFor + score1;
    team1.goalsAgainst = team1.goalsAgainst + score2;
    team2.goalsFor = team2.goalsFor + score2;
    team2.goalsAgainst = team2.goalsAgainst + score1;
    team1.played++;
    team2.played++;
  }

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
    System.out.println("Total Games: " + count);
  }

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

  // Implementing Fisher–Yates shuffle from https://stackoverflow.com/questions/1519736/random-shuffling-of-an-array
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

  public void printGame(){
    System.out.println("Game between " + team1.getName() + " and "  + team2.getName());
    System.out.println(this.p1 + this.g1);
    System.out.println(this.p2 + this.g2);
    System.out.println(this.t1);
    System.out.println(this.t2);
  }
}

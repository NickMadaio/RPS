# Rock, Paper, Scissors Game

## Introduction

This game allows users to compete against the computer in the classic Rock, Paper, Scissors game. Players select one of the three options, and the computer randomly selects an option. The game then determines and displays the winner.

## Components

**RockPaperScissors.java:** This is the main UI class. It sets up the JavaFX window and handles user interaction. This class creates the game layout, displays the user's choice, and shows the computer's choice and the result.

**GameLogic.java:** This class contains the core logic for the game. It determines the computer's choice, evaluates the user's choice against the computer's choice, and decides the outcome of the game.

## Gameplay

1. The game starts by prompting the user to make a choice between "Rock", "Paper", and "Scissors".
2. The computer's choice is randomly determined.
3. After the user selects an option, the result is displayed in the form of "Tie!", "You win!", or "You lose :(".
4. The user can click "Play Again" to restart the game.

## Getting Started

1. **Prerequisities:**

   * Java Development Kit (JDK) with JavaFX
   * A suitable IDE for Java, like VS Code, Eclipse, or IntelliJ IDEA

2. **Setup:**

   * Clone the repo and open in your IDE

3. **Running the App:**

   * Run `App.java` to start the application.

## Possible Enhancements

* **Score Tracking:** Add a feature to track the player's and computer's scores over multiple rounds.
* **Sounds:** Add sound effects for winning, losing, or tying a round.
* **Extended Version:** Introduce variants of the game, like Rock, Paper, Scissors, Lizard, Spock.
* **Player Profiles:** Allow players to create profiles with avatars, names, and track their all-time win/loss ratios.
* **Multiplayer Mode:** Allow two players to play against each other on the same machine.

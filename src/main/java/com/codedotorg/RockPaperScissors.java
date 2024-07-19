package com.codedotorg;

import java.util.Arrays;
import java.util.List;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RockPaperScissors {
    
    /** The primary stage of the game */
    private Stage window;

    /** The width of the stage */
    private int width;

    /** The height of the stage */
    private int height;

    /** The label to display the status of the game */
    private Label promptLabel;

    /** The label to display the computer's choice */
    private Label computerChoiceLabel;

    /** The logic for playing the game */
    private GameLogic logic;

    public RockPaperScissors(Stage primaryStage, int width, int height) {
        this.window = primaryStage;
        window.setTitle("Rock, Paper, Scissors");

        this.width = width;
        this.height = height;

        promptLabel = new Label("Make a choice");
        computerChoiceLabel = new Label("");
        logic = new GameLogic(); 
    }
    
    /**
     * This method starts the Rock Paper Scissors game by creating the main layout, scene, and displaying it. 
     * It also calls the getComputerChoice() method from the logic class to get the computer's choice.
     */
    public void startGame() {
        VBox mainLayout = createLayout();

        Scene mainScene = createMainScene(mainLayout);

        setSceneAndShow(mainScene);
        logic.getComputerChoice();
    }

    /**
     * Sets the current scene and shows the window.
     * 
     * @param currentScene the scene to be set and shown
     */
    public void setSceneAndShow(Scene currentScene) {
        window.setScene(currentScene);
        window.show();
    }

    /**
     * Creates the main scene for the game.
     * 
     * @param layout the layout of the scene
     * @return the main scene for the game
     */
    public Scene createMainScene(VBox layout) {
        Scene tempScene = new Scene(layout, width, height);
        return tempScene;
    }

    /**
     * Creates a VBox layout for the Rock Paper Scissors game.
     * 
     * @return the VBox layout containing the prompt label, computer choice label, and buttons list.
     * 
     * @see createSceneButtons
     */
    public VBox createLayout() {
        VBox tempLayout = new VBox();

        List<Node> buttonsList = createSceneButtons();

        tempLayout.getChildren().addAll(promptLabel, computerChoiceLabel);
        tempLayout.getChildren().addAll(buttonsList);

        return tempLayout;
    }

    /**
     * Creates a list of buttons for the Rock Paper Scissors game scene.
     * 
     * @return A list of buttons containing "Rock", "Paper", "Scissors", and "Play Again".
     */
    public List<Node> createSceneButtons() {
        Button rockButton = new Button("Rock");
        Button paperButton = new Button("Paper");
        Button scissorsButton = new Button("Scissors");
        Button playAgainButton = new Button("Play Again");
        
        List<Node> buttonsList = Arrays.asList(rockButton, paperButton, scissorsButton, playAgainButton);

        setButtonActions(buttonsList);

        return buttonsList;
    }

    /**
     * Sets the actions for a list of buttons.
     * If the button text is "Play Again", it resets the game.
     * Otherwise, it gets the game result based on the button text.
     * 
     * @param buttonsList the list of buttons to set actions for
     */
    public void setButtonActions(List<Node> buttonsList) {
        for (Node item : buttonsList) {
            Button currentButton = (Button) item;

            currentButton.setOnAction(event -> {
                if (currentButton.getText().equals("Play Again")) {
                    resetGame();
                }
                else {
                    getGameResult(currentButton.getText());
                }
            });
        }
    }

    /**
     * This method sets the user's choice, gets the computer's choice, plays
     * the game and updates the UI with the results.
     * 
     * @param userChoice the user's choice of rock, paper or scissors
     */
    public void getGameResult(String userChoice) {
        logic.setUserChoice(userChoice);

        String computerResult = logic.getComputerChoice();
        computerChoiceLabel.setText(computerResult);
        
        String userResult = logic.play();
        promptLabel.setText(userResult);
    }

    /**
     * Resets the game by setting the user choice to an empty string, generating a new computer choice,
     * setting the prompt label to "Make a choice", and clearing the computer choice label.
     */
    public void resetGame() {
        logic.setUserChoice("");
        logic.setComputerChoice();
        promptLabel.setText("Make a choice");
        computerChoiceLabel.setText("");
    }

}

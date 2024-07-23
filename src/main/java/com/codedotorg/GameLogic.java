package com.codedotorg;
import org.tensorflow.SavedModelBundle;

public class GameLogic {

    /** The list of available choices */
    private String[] choices;

    /** The option the user chose */
    private String userChoice;

    /** The option the computer chose */
    private String computerChoice;

    /**
     * This constructor initializes the choices array with "Rock", "Paper", and "Scissors" strings,
     * sets the userChoice to an empty string, and calls the setComputerChoice method to set the computer's choice.
     */
    public GameLogic() {
        choices = new String[]{"Rock", "Paper", "Scissors"};
        userChoice = "";
        setComputerChoice();
    }

    /**
     * Returns a string representation of the computer's choice.
     * 
     * @return a string containing the phrase "Computer chose" followed by the computer's choice.
     */
    public String getComputerChoice() {
        return "Computer chose " + computerChoice;
    }
    
    /**
     * Sets the user's choice for the game.
     * 
     * @param currentChoice the user's current choice
     */
    public void setUserChoice(String currentChoice) {
        userChoice = currentChoice;
    }

    /**
     * Sets the computer's choice randomly from the available choices.
     */
    public void setComputerChoice() {
        int randomIndex = (int)(Math.random() * choices.length);
        computerChoice = choices[randomIndex];
    }

    /**
     * Determines the result of the game based on the user's choice and the computer's choice.
     * 
     * @return a String indicating the result of the game ("Tie!", "You win!", or "You lose :(")
     */
    public String play() {
        if (userChoice.equals(computerChoice)) {
            return "Tie!";
        }
        else if ((userChoice.equals("Rock") && computerChoice.equals("Scissors")) ||
            (userChoice.equals("Paper") && computerChoice.equals("Rock")) ||
            (userChoice.equals("Scissors") && computerChoice.equals("Paper"))) {
                return "You win!";
        }
        else {
            return "You lose :(";
        }
    }
    
    //access the "saved_model.pb" file
    public void loadModel() {
        //initialize the model
        SavedModelBundle model = null;

        try 
        {
            // Load the TensorFlow model
            model = SavedModelBundle.load("src/main/resources/saved_model.pb", "serve");
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

    //use the visual recognition model to get the image and assign the user choice to the image
    public void getVisualRecognition() {
        //use the camera input and the visual recognition model to get the image
        
    }
    

}

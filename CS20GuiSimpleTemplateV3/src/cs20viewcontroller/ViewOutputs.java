package cs20viewcontroller;

import java.io.File;
import javax.swing.JFileChooser;

/**
 * Write methods in this class for displaying data in the DrawnView.
 *
 * You can use all the public instance variables you defined in AllModelsForView
 * and DrawnView as though they were part of this class! This is due to the
 * magic of subclassing (i.e. using the extends keyword).
 *
 * The methods for displaying data in the DrawnView are written as methods in
 * this class.
 *
 * Make sure to use these methods in the ViewUserActions class though, or else
 * they will be defined but never used!
 *
 * @author cheng
 */
public class ViewOutputs extends DrawnView {

    public void displayReaction() {
        System.out.print(aReactionModel.getAttempts());
        switch (aReactionModel.getRandom()) {
            case 0:
                this.button1.setText("0");
                break;
            case 1:
                this.button2.setText("0");
                break;
            case 2:
                this.button3.setText("0");
                break;
            case 3:
                this.button4.setText("0");
                break;
            case 4:
                this.button5.setText("0");
                break;
            case 5:
                this.button6.setText("0");
                break; 
            case 6:
                this.button7.setText("0");
                break;
            case 7:
                this.button8.setText("0");
                break;
            case 8:
                this.button9.setText("0");
                break;
            default:
                break;
        }
    }
    public void clearAllButton() {
        this.reactionLabel3.setText("");
        this.reactionLabel2.setText("");
        this.button1.setText("");
        this.button2.setText("");
        this.button3.setText("");
        this.button4.setText("");
        this.button5.setText("");
        this.button6.setText("");
        this.button7.setText("");
        this.button8.setText("");
        this.button9.setText("");   
    }
    public void displayReactionTime() {
        String s = Long.toString(aReactionModel.getSuperTime());
        this.reactionLabel3.setText("Your reaction time is: " + s + " milliseconds");
        this.button1.setText("");
        this.button2.setText("");
        this.button3.setText("");
        this.button4.setText("");
        this.button5.setText("");
        this.button6.setText("");
        this.button7.setText("");
        this.button8.setText("");
        this.button9.setText("");   
    }
    
    public void displayConcussionReactionTime() {
        String s = Long.toString(aNewModeModel.getTotalTime());
        this.reactionLabel3.setText("Your reaction time is: " + s + " milliseconds");
        this.button5.setText("");
    }
    
    public void errorMessage(){
        this.reactionLabel3.setText("WRONG BUTTON!"); 
    }
    
    public void displayInstructions(){
        this.reactionLabel3.setText("Click on any button to see the");
        this.reactionLabel2.setText(" instructions for that button.");
    }
    
    public void displayInstructionsStart(){
        this.reactionLabel3.setText("Click Start, then click the buttons");
        this.reactionLabel2.setText(" with \"0\" as fast as you can!");
        aReactionModel.setInstructions(false);
    }
    
    public void displayInstructionsOpen(){
        this.reactionLabel3.setText("If you want to save your time with previous");
        this.reactionLabel2.setText(" times you should press the open button");
        aReactionModel.setInstructions(false);
    }
    
    public void displayInstructionsSave(){
        this.reactionLabel3.setText("You can save your bes times by");
        this.reactionLabel2.setText(" clicking save!");
        aReactionModel.setInstructions(false);
    }
    
    public void wrongReaction(){
        this.reactionLabel3.setText("Wrong Time!");
    }
    
    public String showSaveDialog() {
        JFileChooser jfc = new JFileChooser();
        int status = jfc.showSaveDialog(this);
        if (status == JFileChooser.APPROVE_OPTION) {
            File theFile = jfc.getSelectedFile();
            String thePath = theFile.getAbsolutePath();
            return thePath;
        }
        return null;
    }
    
    public String showOpenDialog(){
        JFileChooser jfc = new JFileChooser();
        int status = jfc.showOpenDialog(this);
        if (status == JFileChooser.APPROVE_OPTION) {
            File theFile = jfc.getSelectedFile();
            String thePath = theFile.getAbsolutePath();
            return thePath;
        }
        return null;
    }
    
    public void successfullyOpened(){
        this.reactionLabel3.setText("Successfully opened file");
    }
}

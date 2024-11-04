/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs20models;

/**
 *
 * @author 105075008
 */
public class ReactionTime { //getters and setters for save and open function
    private long reactionTime;
    private String mode;
    
    public ReactionTime(){
        this.reactionTime = 0;
        this.mode = "";
    }
    
    public long getReactionTime() {
        return this.reactionTime;
    }

    public void setReactionTime(long i) {
        this.reactionTime = i;
    }
    
    public String getMode() {
        return this.mode;
    }

    public void setMode(String i) {
        this.mode = i;
    }
}

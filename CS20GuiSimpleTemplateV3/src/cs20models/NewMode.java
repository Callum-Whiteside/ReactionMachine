/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs20models;

import java.util.Date;

/**
 *
 * @author 105075008
 */
public class NewMode {

    private boolean start;
    private long time;
    private int attempts;
    private long totalTime;
    private long timeInBetween;
    private long[] Times = new long[11];
    private boolean concussionBoo;
    
    public NewMode(){
       this.start = false;
       this.time = 0;
       this.attempts = 0;
       this.totalTime = 0;
       this.timeInBetween = 0;
       this.concussionBoo = false;
    }

    public boolean getStart() {
        return this.start;
    }

    public void setStart(boolean boo) {
        this.start = boo;
    }
    
    public void setConcussionBoo(boolean boo) {
        this.concussionBoo = boo;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime() {
        this.time = System.currentTimeMillis() + (long)(Math.random() * 5000) + 300;
    }

    public int getAttempts() {
        return this.attempts;
    }

    public void setAttempts(int i) {
        this.attempts = i;
    }

    public long getTimeInBetween() {
        return this.timeInBetween;
    }

    public void setTimeInBetween(long lo) {
        this.timeInBetween = lo;
    }

    public void getConcussionTime(long lo) {
        this.Times[this.attempts] = new Date().getTime() - this.time;
        if (this.attempts == 10) {
            for (int i = 0; i < 9; i++) {
                this.totalTime = this.totalTime + this.Times[i];
            }
            this.totalTime = this.totalTime / 9;
        }
        this.attempts = this.attempts + 1;
        
    }
    
    public long getTotalTime(){
        return this.totalTime;
    }
    
    public boolean getConcussionBoo() {
        return this.concussionBoo;
    }
    
}

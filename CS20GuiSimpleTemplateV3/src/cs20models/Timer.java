/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs20models;

/**
 *
 * @author 105075008
 */
import java.util.Date;
import javax.swing.JButton;

/**
 * A class to model the problem or situation your program solves
 *
 * @author cheng
 */
public class Timer implements Runnable {

    public boolean stopRunning;
    private JButton textField;
    public long timeInBetween;

    public Timer(JButton textField) {
        this.textField = textField;
        this.stopRunning = false;
        this.timeInBetween = 0;
    }

    @Override
    public void run() {
        while (true) {
            if (this.stopRunning) {
                return;
            }
            long date = new Date().getTime();
            System.out.println(this.timeInBetween - date);
            long thisJoke = this.timeInBetween - date;
            if (thisJoke <= 0) { //Once randomly selected time is equal to the current date, displays "0" that the user must click
                this.textField.setText("0");
            } else {
                this.textField.setText("");
            }
        }
    }
}

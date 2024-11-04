/*
 * The controller classes (like the ViewUserActions class) provides actions
 * that the user can trigger through the view classes.  Those actions are 
 * written in this class as private inner classes (i.e. classes 
 * declared inside another class).
 *
 * You can use all the public instance variables you defined in AllModelsForView, 
 * DrawnView, and ViewOutputs as though they were part of this class! This is 
 * due to the magic of subclassing (i.e. using the extends keyword).
 */
package cs20viewcontroller;

import cs20models.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * ViewUserActions is a class that contains actions users can trigger.
 *
 * User actions are written as private inner classes that implements the
 * ActionListener interface. These actions must be "wired" into the DrawnView in
 * the ViewUserActions constructor, or else they won't be triggered by the user.
 *
 * Actions that the user can trigger are meant to manipulate some model classes
 * by sending messages to them to tell them to update their data members.
 *
 * Actions that the user can trigger can also be used to manipulate the GUI by
 * sending messages to the view classes (e.g. the DrawnView class) to tell them
 * to update themselves (e.g. to redraw themselves on the screen).
 *
 * @author cheng
 */
public class ViewUserActions extends ViewOutputs {

    /*
     * Step 1 of 2 for writing user actions.
     * -------------------------------------
     *
     * User actions are written as private inner classes that implement
     * ActionListener, and override the actionPerformed method.
     *
     * Use the following as a template for writting more user actions.
     */
    private class StartButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (aReactionModel.getInstructions() == true) {
                displayInstructionsStart();
            } else {
                clearAllButton();
                aReactionModel.setStart(true);
                aReactionModel.setAttempts(0);
                aReactionModel.superRandom();
                displayReaction();
            }
        }
    }

    private class StartConcussionButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (aReactionModel.getInstructions() == true) {
                displayInstructionsStart();
            } else {
                aNewModeModel.setConcussionBoo(true);
                clearAllButton();
                aNewModeModel.setStart(true);
                aNewModeModel.setAttempts(0);
                aNewModeModel.setConcussionBoo(true);
                theTimer = new Timer(button5);
                theThreadedTimer = new Thread(theTimer);
                theThreadedTimer.start();
                aNewModeModel.setTime();
                theTimer.timeInBetween = aNewModeModel.getTime();
            }
        }
    }

    private class ButtonReaction1 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (aReactionModel.getStart() == true && aReactionModel.getRandom() == 0) {
                clearAllButton();
                aReactionModel.superRandom();
                displayReaction();
                aReactionModel.getSuperTime();

                if (aReactionModel.getAttempts() == 10) {
                    displayReactionTime();
                    aReactionModel.setRandom(234);
                    aReactionModel.setStart(false);
                }
            } else if (aReactionModel.getRandom() != 0 && aReactionModel.getStart() == true) {
                clearAllButton();
                aReactionModel.setStart(false);
                errorMessage();
                aReactionModel.setRandom(234);
            }
        }
    }

    private class ButtonReaction2 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (aReactionModel.getStart() == true && aReactionModel.getRandom() == 1) {
                clearAllButton();
                aReactionModel.superRandom();
                displayReaction();
                aReactionModel.getSuperTime();
                if (aReactionModel.getAttempts() == 10) {
                    displayReactionTime();
                    aReactionModel.setRandom(234);
                    aReactionModel.setStart(false);
                }
            } else if (aReactionModel.getRandom() != 1 && aReactionModel.getStart() == true) {
                clearAllButton();
                aReactionModel.setStart(false);
                errorMessage();
                aReactionModel.setRandom(234);
            }
        }
    }

    private class ButtonReaction3 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (aReactionModel.getStart() == true && aReactionModel.getRandom() == 2) {
                clearAllButton();
                aReactionModel.superRandom();
                displayReaction();
                aReactionModel.getSuperTime();
                if (aReactionModel.getAttempts() == 10) {
                    displayReactionTime();
                    aReactionModel.setRandom(234);
                    aReactionModel.setStart(false);
                }
            } else if (aReactionModel.getRandom() != 2 && aReactionModel.getStart() == true) {
                clearAllButton();
                aReactionModel.setStart(false);
                errorMessage();
                aReactionModel.setRandom(234);
            }
        }
    }

    private class ButtonReaction4 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (aReactionModel.getStart() == true && aReactionModel.getRandom() == 3) {
                clearAllButton();
                aReactionModel.superRandom();
                displayReaction();
                aReactionModel.getSuperTime();
                if (aReactionModel.getAttempts() == 10) {
                    displayReactionTime();
                    aReactionModel.setRandom(234);
                    aReactionModel.setStart(false);
                }
            } else if (aReactionModel.getRandom() != 3 && aReactionModel.getStart() == true) {
                clearAllButton();
                aReactionModel.setStart(false);
                errorMessage();
                aReactionModel.setRandom(234);
            }
        }
    }

    private class ButtonReaction5 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (aReactionModel.getStart() == true && aReactionModel.getRandom() == 4) {
                clearAllButton();
                aReactionModel.superRandom();
                displayReaction();
                aReactionModel.getSuperTime();
                if (aReactionModel.getAttempts() == 10) {
                    displayReactionTime();
                    aReactionModel.setRandom(234);
                    aReactionModel.setStart(false);
                }
            } else if (aReactionModel.getRandom() != 4 && aReactionModel.getStart() == true) {
                clearAllButton();
                aReactionModel.setStart(false);
                errorMessage();
                aReactionModel.setRandom(234);
            }
            long caution = 0;
            if (aNewModeModel.getStart() == true) {
                caution = theTimer.timeInBetween - System.currentTimeMillis();
            }
            if (aNewModeModel.getStart() == true && caution <= 0) {
                clearAllButton();
                aNewModeModel.getConcussionTime(theTimer.timeInBetween);
                aNewModeModel.setTime();
                theTimer.timeInBetween = aNewModeModel.getTime();
                if (aNewModeModel.getAttempts() == 10) {
                    clearAllButton();
                    aNewModeModel.getConcussionTime(theTimer.timeInBetween);
                    theTimer.timeInBetween = 0;
                    theTimer.stopRunning = true;
                    displayConcussionReactionTime();
                    aReactionModel.setConcussionTotalTime(aNewModeModel.getTotalTime());
                    aNewModeModel.setStart(false);
                }
            } else if (aNewModeModel.getStart() == true && caution > 0) {
                clearAllButton();
                wrongReaction();
                aNewModeModel.setStart(false);
                theTimer.stopRunning = true;
            }

            System.out.println(aNewModeModel.getStart());
        }
    }

    private class ButtonReaction6 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (aReactionModel.getStart() == true && aReactionModel.getRandom() == 5) {
                clearAllButton();
                aReactionModel.superRandom();
                displayReaction();
                aReactionModel.getSuperTime();
                if (aReactionModel.getAttempts() == 10) {
                    displayReactionTime();
                    aReactionModel.setRandom(234);
                    aReactionModel.setStart(false);
                }
            } else if (aReactionModel.getRandom() != 5 && aReactionModel.getStart() == true) {
                clearAllButton();
                aReactionModel.setStart(false);
                errorMessage();
                aReactionModel.setRandom(234);
            }
        }
    }

    private class ButtonReaction7 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (aReactionModel.getStart() == true && aReactionModel.getRandom() == 6) {
                clearAllButton();
                aReactionModel.superRandom();
                displayReaction();
                aReactionModel.getSuperTime();
                if (aReactionModel.getAttempts() == 10) {
                    displayReactionTime();
                    aReactionModel.setRandom(234);
                    aReactionModel.setStart(false);
                }
            } else if (aReactionModel.getRandom() != 6 && aReactionModel.getStart() == true) {
                clearAllButton();
                aReactionModel.setStart(false);
                errorMessage();
                aReactionModel.setRandom(234);
            }
        }
    }

    private class ButtonReaction8 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (aReactionModel.getStart() == true && aReactionModel.getRandom() == 7) {
                clearAllButton();
                aReactionModel.superRandom();
                displayReaction();
                aReactionModel.getSuperTime();
                if (aReactionModel.getAttempts() == 10) {
                    displayReactionTime();
                    aReactionModel.setRandom(234);
                    aReactionModel.setStart(false);
                }
            } else if (aReactionModel.getRandom() != 7 && aReactionModel.getStart() == true) {
                clearAllButton();
                aReactionModel.setStart(false);
                errorMessage();
                aReactionModel.setRandom(234);
            }
        }
    }

    private class ButtonReaction9 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (aReactionModel.getStart() == true && aReactionModel.getRandom() == 8) {
                clearAllButton();
                aReactionModel.superRandom();
                displayReaction();
                aReactionModel.getSuperTime();
                if (aReactionModel.getAttempts() == 10) {
                    displayReactionTime();
                    aReactionModel.setRandom(234);
                    aReactionModel.setStart(false);
                }
            } else if (aReactionModel.getRandom() != 8 && aReactionModel.getStart() == true) {
                clearAllButton();
                aReactionModel.setStart(false);
                errorMessage();
                aReactionModel.setRandom(234);
            }
        }
    }

    private class instruction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            aReactionModel.setInstructions(true);
            displayInstructions();
        }
    }

    private class saveButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (aReactionModel.getInstructions() == true) {
                displayInstructionsSave();
            } else {
                try {
                    String pathToFile = showSaveDialog();
                    if (pathToFile == null) {
                        return;
                    }
                    aReactionModel.saveToFile(pathToFile);
                } catch (IOException ex) {
                    Logger.getLogger(ViewUserActions.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private class openButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (aReactionModel.getInstructions() == true) {
                displayInstructionsOpen();
            } else {
                try {
                    String pathToFile = showOpenDialog();
                    successfullyOpened();
                    if (pathToFile == null) {
                        return;
                    }
                    aReactionModel.openFromFile(pathToFile);
                } catch (IOException ex) {
                    Logger.getLogger(ViewUserActions.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    /*
     * ViewUserActions constructor used for wiring user actions to GUI elements
     */
    public ViewUserActions() {
        /*
         * Step 2 of 2 for writing user actions.
         * -------------------------------------
         *
         * Once a private inner class has been written for a user action, you
         * can wire it to a GUI element (i.e. one of GUI elements you drew in
         * the DrawnView class and which you gave a memorable public variable
         * name!).
         *
         * Use the following as a template for wiring more user actions.
         */
        startButton.addActionListener(new StartButton());
        button1.addActionListener(new ButtonReaction1());
        button2.addActionListener(new ButtonReaction2());
        button3.addActionListener(new ButtonReaction3());
        button4.addActionListener(new ButtonReaction4());
        button5.addActionListener(new ButtonReaction5());
        button6.addActionListener(new ButtonReaction6());
        button7.addActionListener(new ButtonReaction7());
        button8.addActionListener(new ButtonReaction8());
        button9.addActionListener(new ButtonReaction9());
        instructionButton.addActionListener(new instruction());
        NewModeStartButton.addActionListener(new StartConcussionButton());
        saveButton.addActionListener(new saveButton());
        openButton.addActionListener(new openButton());
    }
}

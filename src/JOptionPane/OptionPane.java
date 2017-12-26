package JOptionPane;

import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
/*
    --uses--
    MessageDialog
    OptionDialog
    InputDialog
    ConfirmDialog


*/
public class OptionPane {
    public static void main(String[] args) {
        new OptionPane();
    }

    public OptionPane() {
        boolean done = false;
        while (!done) {
            done = true;

            String[] ans = new String[11];

            JOptionPane.showMessageDialog(null, "Let's make a story", "Fill in the Blank Game", JOptionPane.INFORMATION_MESSAGE);
            //0- color :
            String[] colors = {
                    "Orange",
                    "Green",
                    "Blue",
                    "Yellow",
                    "Red",
                    "Puple"
            };
            int color_index = JOptionPane.showOptionDialog(null, "What's your favorite color ?", "color", 0, JOptionPane.QUESTION_MESSAGE, null, colors, 0);
            ans[0] = colors[color_index];
            //1- liquide :
            ans[1] = JOptionPane.showInputDialog(null, "What is your favorite thing to dring ?", "Liquide", JOptionPane.QUESTION_MESSAGE);
            //2- plural noun
            ans[2] = JOptionPane.showInputDialog("Name something people bring with them to school(plural noun)");
            //3- adjective
            ans[3] = JOptionPane.showInputDialog("What is one aspect would wat an " + "imaginary friend to have? (adjective)");
            //4- present tense verbe
            ans[4] = JOptionPane.showInputDialog("What is something you do when you drive " + "a car (present tense verb)");
            //5- plural noun
            ans[5] = JOptionPane.showInputDialog("Name something you own multiple of " + "(plural noun)");
            //6- singular noun
            ans[6] = JOptionPane.showInputDialog("What is something you might find in " + "the U.S.A. (singular noun)");
            //7- adjective
            ans[7] = JOptionPane.showInputDialog("Describe your current leader in one " + "word (adjective)");
            //8- present tense verb
            ans[8] = JOptionPane.showInputDialog("What is something you do while " + "travelling(present tense verb)");
            //9- present tense verb
            ans[9] = JOptionPane.showInputDialog("Name something you do when you go to the " + "gym (present tense verb)");
            //10- singular noun
            ans[10] = JOptionPane.showInputDialog("If you could have one thing in the " + "what would it be? (singular noun)");

            //confirm with user
            //yes, no, cancel
            int input = JOptionPane.showConfirmDialog(null, "Are you sure you are ready " + "to see the result");
            if (input == 1 || input == 2) {
                done = false;
            } else {
                input = JOptionPane.showConfirmDialog(
                        null,
                        "Really this is your last chance to bail, are you certain?",
                        "",
                        JOptionPane.YES_NO_OPTION
                );
                if (input == 1) {
                    done = false;
                } else {
                    input = JOptionPane.showConfirmDialog(
                            null,
                            "Ok, we'll move on (but you can stull press cancel if you're " + "not ready)",
                            "",
                            JOptionPane.OK_CANCEL_OPTION
                    );

                }

            }
            if (done) {
                JOptionPane.showMessageDialog(
                        null,
                        "Each spring, the sky turns " + ans[0] + ". Giant drops of " + ans[1] + " fall from the sky. All this " + ans[1] + " helps the grass and the " + ans[2] + " to grow, but it can make things really " + ans[3] + " too.\n" +
                                "\n" +
                                "Some places get so much " + ans[1] + ", that rivers " + ans[4] + " into the streets. Driving can be tricky when this happens, so some people put special " + ans[5] + " on their cars.\n" +
                                "\n" +
                                "And when the" + ans[1] + " is falling, don't forget your " + ans[6] + ". Otherwise, your feet might get " + ans[7] + " if you " + ans[8] + " in puddl es!\n" +
                                "\n" +
                                "After all the " + ans[1] + " has fallen, the skies begin to " + ans[9] + ". If you are lucky, you might see a huge " + ans[10] + " stretched across the sky. "

                );

            } else {
                JOptionPane.showMessageDialog(null, "Ok we'll start over then");
            }
        }
    }
}
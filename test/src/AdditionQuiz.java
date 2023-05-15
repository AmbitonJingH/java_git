import javax.swing.*;

public class AdditionQuiz {
    public static void main(String[] args) {
        int number1 = (int)(Math.random() * 100);
        int number2 = (int)(Math.random() * 100);
        String input= JOptionPane.showInputDialog(null,
                "What is " + number1 + " + " + number2 + "? ",
                "两位数加法练习", JOptionPane.QUESTION_MESSAGE);

        int answer=Integer.parseInt(input);

        if (number1 + number2 == answer)
            JOptionPane.showMessageDialog(null, "You are correct!",
                    "Congratulations!", JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(null,
                    number1 + " + " + number2  +" should be " + (number1 + number2),
                    "Errors!", JOptionPane.OK_OPTION);
    }
}


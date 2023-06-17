package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.QuizzSlangView;
import view.SlangWordView;

/**
 *
 * @author MSI VN
 */
public class QuizzSlangController implements ActionListener {

    public QuizzSlangView panel;
    public SlangWordView rootPanel;

    public QuizzSlangController(QuizzSlangView panel) {
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        if (src.equals("Ans_A")) {
            System.out.println("Ans_A");
        } else if (src.equals("Ans_B")) {
            System.out.println("Ans_B");

        } else if (src.equals("Ans_C")) {
            System.out.println("Ans_C");

        } else if (src.equals("Ans_D")) {
            System.out.println("Ans_D");

        } else if (src.equals("beginQuizz")) {
            System.out.println("beginQuizz");
        }
    }

}

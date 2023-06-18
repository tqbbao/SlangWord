package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import javax.swing.JOptionPane;
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
        int keyA = 0;
        int keyB = 1;
        int keyC = 2;
        int keyD = 3;

        String src = e.getActionCommand();
        if (src.equals("Ans_A")) {
            System.out.println("Ans_A");
            if (this.panel.traLoi == keyA) {
                this.panel.ansA.setBackground(Color.GREEN);
                this.panel.ansA.setEnabled(false);

                this.panel.ansB.setEnabled(false);
                this.panel.ansC.setEnabled(false);
                this.panel.ansD.setEnabled(false);
            } else {
                this.panel.ansA.setBackground(Color.RED);
                this.panel.ansA.setEnabled(false);
                this.panel.ansB.setEnabled(false);
                this.panel.ansC.setEnabled(false);
                this.panel.ansD.setEnabled(false);
                switch (this.panel.traLoi) {
                    case 0:
                        this.panel.ansA.setBackground(Color.GREEN);
                        break;
                    case 1:
                        this.panel.ansB.setBackground(Color.GREEN);
                        break;
                    case 2:
                        this.panel.ansC.setBackground(Color.GREEN);
                        break;
                    case 3:
                        this.panel.ansD.setBackground(Color.GREEN);
                        break;
                }

            }

        } else if (src.equals("Ans_B")) {
            System.out.println("Ans_B");
            if (this.panel.traLoi == keyB) {
                this.panel.ansA.setEnabled(false);

                this.panel.ansB.setBackground(Color.GREEN);
                this.panel.ansB.setEnabled(false);
                this.panel.ansC.setEnabled(false);
                this.panel.ansD.setEnabled(false);

            } else {
                this.panel.ansB.setBackground(Color.RED);
                this.panel.ansA.setEnabled(false);
                this.panel.ansB.setEnabled(false);
                this.panel.ansC.setEnabled(false);
                this.panel.ansD.setEnabled(false);
                switch (this.panel.traLoi) {
                    case 0:
                        this.panel.ansA.setBackground(Color.GREEN);
                        break;
                    case 1:
                        this.panel.ansB.setBackground(Color.GREEN);
                        break;
                    case 2:
                        this.panel.ansC.setBackground(Color.GREEN);
                        break;
                    case 3:
                        this.panel.ansD.setBackground(Color.GREEN);
                        break;
                }

            }

            //String sample = random.nextInt(tmp.toArray().length);
        } else if (src.equals("Ans_C")) {
            System.out.println("Ans_C");
            if (this.panel.traLoi == keyC) {
                this.panel.ansA.setEnabled(false);

                this.panel.ansB.setEnabled(false);
                this.panel.ansC.setBackground(Color.GREEN);
                this.panel.ansC.setEnabled(false);
                this.panel.ansD.setEnabled(false);

            } else {
                this.panel.ansC.setBackground(Color.RED);
                this.panel.ansA.setEnabled(false);
                this.panel.ansB.setEnabled(false);
                this.panel.ansC.setEnabled(false);
                this.panel.ansD.setEnabled(false);
                switch (this.panel.traLoi) {
                    case 0:
                        this.panel.ansA.setBackground(Color.GREEN);
                        break;
                    case 1:
                        this.panel.ansB.setBackground(Color.GREEN);
                        break;
                    case 2:
                        this.panel.ansC.setBackground(Color.GREEN);
                        break;
                    case 3:
                        this.panel.ansD.setBackground(Color.GREEN);
                        break;
                }

            }

        } else if (src.equals("Ans_D")) {
            System.out.println("Ans_D");
            if (this.panel.traLoi == keyD) {
                this.panel.ansA.setEnabled(false);

                this.panel.ansB.setEnabled(false);
                this.panel.ansC.setEnabled(false);
                this.panel.ansD.setBackground(Color.GREEN);
                this.panel.ansD.setEnabled(false);

            } else {
                this.panel.ansD.setBackground(Color.RED);
                this.panel.ansA.setEnabled(false);
                this.panel.ansB.setEnabled(false);
                this.panel.ansC.setEnabled(false);
                this.panel.ansD.setEnabled(false);
                switch (this.panel.traLoi) {
                    case 0:
                        this.panel.ansA.setBackground(Color.GREEN);
                        break;
                    case 1:
                        this.panel.ansB.setBackground(Color.GREEN);
                        break;
                    case 2:
                        this.panel.ansC.setBackground(Color.GREEN);
                        break;
                    case 3:
                        this.panel.ansD.setBackground(Color.GREEN);
                        break;
                }

            }

        } else if (src.equals("beginQuizz")) {
            System.out.println("beginQuizz");
            khoiTaoGiaTriChoButton(this.rootPanel.dictionary);
            this.panel.ansA.setEnabled(true);
            this.panel.ansB.setEnabled(true);
            this.panel.ansC.setEnabled(true);
            this.panel.ansD.setEnabled(true);
            this.panel.ansA.setBackground(Color.lightGray);
            this.panel.ansB.setBackground(Color.lightGray);
            this.panel.ansC.setBackground(Color.lightGray);
            this.panel.ansD.setBackground(Color.lightGray);
            this.panel.ansA.setFocusable(false);
            this.panel.ansB.setFocusable(false);
            this.panel.ansC.setFocusable(false);
            this.panel.ansD.setFocusable(false);
        }
    }

    public void traLoiCauHoi(int luaChon) {

    }

    public void khoiTaoGiaTriChoButton(HashMap<String, String> dictionary) {

        Random random = new Random();
        int answer = random.nextInt(0, 4);
        System.out.println("random: " + answer);
        Set<String> tmp = this.rootPanel.dictionary.keySet();
        //String sample = new Random().nextInt(tmp);

        ArrayList<Integer> quizzRandom = new ArrayList<Integer>(4);

        int check = 0;
        int waittingAns = 0;
        do {
            int index = random.nextInt(dictionary.size());
            System.out.println(index);

            if (quizzRandom.contains(index)) {
                waittingAns = 0;
            } else {
                if (check == 4) {
                    waittingAns = 1;
                } else {
                    quizzRandom.add(index);
                    check++;
                    waittingAns = 0;
                }
            }
        } while (waittingAns != 1);

        System.out.println(quizzRandom);
//
        Set<String> keySet = this.rootPanel.dictionary.keySet();
        List<String> keyList = new ArrayList<>(keySet);

        int size = keyList.size();
        int randIdx = new Random().nextInt(size);
//
        for (int i = 0; i < 4; i++) {
            String randomKey = keyList.get(quizzRandom.get(i));
            String randomValue = this.rootPanel.dictionary.get(randomKey);
            if (answer == i) {
                this.panel.traLoi = answer;
                this.panel.questionLabel.setText(randomKey);
            }
            if (i == 0) {

                this.panel.ansA.setText(randomValue);

            } else if (i == 1) {

                this.panel.ansB.setText(randomValue);

            } else if (i == 2) {

                this.panel.ansC.setText(randomValue);
            } else if (i == 3) {

                this.panel.ansD.setText(randomValue);

            }

        }

    }
}

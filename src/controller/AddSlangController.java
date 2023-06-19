package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.AddSlangView;
import view.HistoryView;
import view.SlangWordView;

/**
 *
 * @author MSI VN
 */
public class AddSlangController implements ActionListener {

    public AddSlangView panel;
    public SlangWordView rootPanel;
    public HistoryView panel1;

    public AddSlangController(AddSlangView panel) {
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        if (src.equals("add")) {
            themSlang();
        }
    }

    public void themSlang() {
        String ans = this.rootPanel.dictionary.get(this.panel.slangTextField.getText());
        System.out.println(ans);
        if (ans != null) {
            System.out.println("1");
            if (this.panel.meaningTextField.getText().equals("")) {
                JOptionPane.showMessageDialog(panel, "Vui long khong de trong thong tin");

            } else {

                String[] options = {"Overwrite it", "Only add meaning", "Cancel"};
                int choice = JOptionPane.showOptionDialog(panel, "Slang is already existed!",
                        "Slang existed", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                        options, options[2]);

                switch (choice) {
                    case 0 -> {
                        this.rootPanel.dictionary.put(this.panel.slangTextField.getText(), this.panel.meaningTextField.getText());
                        JOptionPane.showMessageDialog(panel, "A slang has been overwritten!");
                    }
                    case 1 -> {
                        this.rootPanel.dictionary.put(this.panel.slangTextField.getText(), this.rootPanel.dictionary.get(this.panel.slangTextField.getText()) + "| " + this.panel.meaningTextField.getText());
                        JOptionPane.showMessageDialog(panel, "A meaning has been added to a slang!");
                    }
                }
            }
        } else {
            System.out.println("2");
            if ((this.panel.slangTextField.getText().equals("")) || (this.panel.meaningTextField.getText().equals(""))) {
                JOptionPane.showMessageDialog(panel, "Vui long khong de trong thong tin!");
            } else {
                this.rootPanel.dictionary.put(this.panel.slangTextField.getText(), this.panel.meaningTextField.getText());
                capNhatHistoryView();
                refreshData();
                JOptionPane.showMessageDialog(panel, "Slang added!");
            }
        }
    }

    public void refreshData() {

        panel.slangTextField.setText("");
        panel.meaningTextField.setText("");
    }

    public void capNhatHistoryView() {
        if (!this.rootPanel.historySlangs.contains(this.panel.slangTextField.getText())) {
            System.out.println("duoc");

            this.rootPanel.historySlangs.add(this.panel.slangTextField.getText());

            panel1.historyList.setListData(this.rootPanel.historySlangs);
        }
    }
}

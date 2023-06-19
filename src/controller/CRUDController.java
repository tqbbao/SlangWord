package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JOptionPane;
import view.CRUDView;
import view.HistoryView;
import view.SlangWordView;

/**
 *
 * @author MSI VN
 */
public class CRUDController implements ActionListener {

    public CRUDView panel;
    public SlangWordView rootPanel;
    public HistoryView panel1;

    public CRUDController(CRUDView panel) {
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();

        if (src.equals("Find")) {
            timkiem(this.rootPanel.dictionary, this.panel.findTextField.getText());
        } else if (src.equals("edit")) {
            capnhat(this.rootPanel.dictionary, this.panel.meaningTextField.getText());
        } else if (src.equals("delete")) {
            xoa(this.rootPanel.dictionary, this.panel.slangTextField.getText());
        }

    }

    public void timkiem(HashMap<String, String> dictionary, String str) {
        String ans = dictionary.get(str);
        this.panel.slangTextField.setText(ans != null ? str : "");
        this.panel.meaningTextField.setText(ans != null ? ans : "No slang!");
    }

    public void capnhat(HashMap<String, String> dictionary, String str) {
        if (this.panel.slangTextField.getText().equals("")) {
            JOptionPane.showMessageDialog(panel, "Please find a correct slang!");
        } else {
            if (this.panel.meaningTextField.getText().equals("")) {
                JOptionPane.showMessageDialog(panel, "Vui long khong de trong thong tin");

            } else {
                dictionary.put(this.panel.slangTextField.getText(), str);
                refreshData();
                JOptionPane.showMessageDialog(panel, "Slang edited!");

            }
        }
    }

    public void xoa(HashMap<String, String> dictionary, String str) {
        String ans = dictionary.get(str);

        if (ans != null) {
            int choice = JOptionPane.showConfirmDialog(
                    panel,
                    "Slang: " + str + "\nMeanng: " + ans
                    + "\nDo you really want to delete this slang?",
                    "Delete slang",
                    JOptionPane.YES_NO_OPTION);
            if (choice == 0) {
                dictionary.remove(str);
                capnhathistoryList(str);
                refreshData();
                JOptionPane.showMessageDialog(panel, "Deleted: " + str);
            }
        } else {
            JOptionPane.showMessageDialog(panel, "No slang: " + str + " to delete.");
        }
    }

    public void capnhathistoryList(String str) {
        this.rootPanel.historySlangs.remove(str);
        System.out.println("historySlang sau khi xoa: " + this.rootPanel.historySlangs);
    }

    public void refreshData() {
        panel.findTextField.setText("");
        panel.slangTextField.setText("");
        panel.meaningTextField.setText("");
    }

}

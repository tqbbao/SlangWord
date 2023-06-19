package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import view.HistoryView;
import view.ResetSlangView;
import view.SlangWordView;
import static view.SlangWordView.FILENAME1;
import static view.SlangWordView.dictionary;

/**
 *
 * @author MSI VN
 */
public class ResetSlangController implements ActionListener {

    public ResetSlangView panel;
    public SlangWordView rootPanel;
    public HistoryView panel1;

    public ResetSlangController(ResetSlangView panel) {
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        if (src.equals("reset")) {
            resetSlang(this.rootPanel.dictionary, this.rootPanel.historySlangs);

        }
    }

    public void resetSlang(HashMap<String, String> dictionary, Vector<String> historySlangs) {
        int choice = JOptionPane.showConfirmDialog(panel,
                "Bạn có muốn khôi phục lại từ điển",
                "Reset dictionary",
                JOptionPane.YES_NO_OPTION);

        //
        if (choice == 0) {
            reloadData(this.rootPanel.dictionary, this.rootPanel.historySlangs);
            JOptionPane.showMessageDialog(panel, "Dictionary reset!");

        }
    }

    public void reloadData(HashMap<String, String> dictionary, Vector<String> historySlangs) {
        dictionary.clear();
        historySlangs.clear();

        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(this.rootPanel.FILENAME1);
            br = new BufferedReader(fr);
            String line = null;
            while ((line = br.readLine()) != null) {
                if (line.isEmpty()) {
                    continue;
                }
                String[] tmp = line.split("`");
                if (tmp.length == 2) {
                    dictionary.put(tmp[0], tmp[1]);
                }
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ResetSlangController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ResetSlangController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException ex) {
                    Logger.getLogger(ResetSlangController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (br != null) {
                try {
                    br.close();
                } catch (IOException ex) {
                    Logger.getLogger(ResetSlangController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

}

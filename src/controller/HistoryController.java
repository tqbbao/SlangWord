package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.HistoryView;
import view.SlangWordView;

/**
 *
 * @author MSI VN
 */
public class HistoryController implements ActionListener {
    public HistoryView panel;
    public SlangWordView rootPanel;

    public HistoryController(HistoryView panel) {
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

}

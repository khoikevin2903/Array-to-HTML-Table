package View;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class PrefsDialog extends JDialog {
    private final JButton okBtn, cancelBtn;
    private final JTextField userField;
    private final JPasswordField passwordField;
    private final JSpinner spinner;


    public PrefsDialog(JFrame parent) {
        super(parent, "Preferences", false);

        okBtn = new JButton("OK");
        cancelBtn = new JButton("Cancel");
        SpinnerNumberModel spinnerNumberModel = new SpinnerNumberModel(1433, 0, 9999, 1);
        spinner = new JSpinner(spinnerNumberModel);
        userField = new JTextField(10);
        passwordField = new JPasswordField(10);

        initComponents();
        setSize(300, 200);
        setLocationRelativeTo(parent);
    }

    private void initComponents() {
        JPanel ctrlPanel = new JPanel(new GridBagLayout());
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        GridBagConstraints gc = new GridBagConstraints();
        gc.insets = new Insets(5, 5, 5, 5);

        Border spaceBorder = BorderFactory.createEmptyBorder(2, 2, 2, 2);
        Border titleBorder = BorderFactory.createTitledBorder("Database profile");
        ctrlPanel.setBorder(BorderFactory.createCompoundBorder(spaceBorder, titleBorder));

        gc.gridx = 0;
        gc.gridy = 0;
        gc.fill = GridBagConstraints.NONE;
        gc.weightx = 1;
        gc.weighty = 1;
        gc.anchor = GridBagConstraints.EAST;
        ctrlPanel.add(new JLabel("Port:"), gc);
        gc.gridx++;
        gc.anchor = GridBagConstraints.WEST;
        ctrlPanel.add(spinner, gc);

        gc.gridy++;
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.EAST;
        ctrlPanel.add(new JLabel("Username:"), gc);
        gc.gridx++;
        gc.anchor = GridBagConstraints.WEST;
        ctrlPanel.add(userField, gc);

        gc.gridy++;
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.EAST;
        ctrlPanel.add(new JLabel("Password:"), gc);
        gc.gridx++;
        gc.anchor = GridBagConstraints.WEST;
        ctrlPanel.add(passwordField, gc);

        btnPanel.add(okBtn);
        btnPanel.add(cancelBtn);
        Dimension btnSize = cancelBtn.getPreferredSize();
        okBtn.setPreferredSize(btnSize);

        setLayout(new BorderLayout());
        add(ctrlPanel, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.SOUTH);

    }

    public JButton getOkBtn() {
        return okBtn;
    }

    public JButton getCancelBtn() {
        return cancelBtn;
    }

    public JTextField getUserField() {
        return userField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public JSpinner getSpinner() {
        return spinner;
    }
    public static void main(String[] args) {
    }
}

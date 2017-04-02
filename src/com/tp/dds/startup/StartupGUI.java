package com.tp.dds.startup;

import javax.swing.*;

public class StartupGUI extends JFrame {
    private JPanel startupPanel;
    private JTabbedPane tabbedPanel;
    private JList listEmpresas;

    public StartupGUI() {
        setContentPane(startupPanel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

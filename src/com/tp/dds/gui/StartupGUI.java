package com.tp.dds.gui;

import com.tp.dds.empresa.Empresa;

import javax.swing.*;
import java.util.List;

public class StartupGUI extends JFrame {
    private final List<Empresa> empresas;

    private JPanel startupPanel;
    private JTabbedPane tabbedPanel;
    private JList<String> listEmpresas;
    private JTextArea cuentaDescripcion;
    private JScrollPane jScrollPane;

    public StartupGUI(List<Empresa> empresas) {
        this.empresas = empresas;

        setContentPane(startupPanel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

        DefaultListModel<String> defaultListModel = new DefaultListModel<>();
        for (Empresa empresa : empresas)
            defaultListModel.addElement(empresa.getNombre());

        listEmpresas.setModel(defaultListModel);
        listEmpresas.addListSelectionListener((listSelectionEvent) -> {
            Empresa empresa = empresas.get(listEmpresas.getSelectedIndex());
            cuentaDescripcion.setText(empresa.toString());
            cuentaDescripcion.setCaretPosition(0);
        });
        listEmpresas.setSelectedIndex(0);
    }
}

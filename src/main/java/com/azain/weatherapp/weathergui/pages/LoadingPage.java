package com.azain.weatherapp.weathergui.pages;

/**
 *
 * @author Azain
 */

public class LoadingPage extends javax.swing.JPanel
{

    private String details;
    public LoadingPage(String details) {
        this.details = details;
        initComponents();
    }

    private void initComponents() {

        centerPanel = new javax.swing.JPanel();
        loadingIconLabel = new javax.swing.JLabel();
        loadingDetailLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(74, 20, 140));
        setForeground(new java.awt.Color(171, 71, 188));
        setToolTipText("Loading, Please wait!");
        setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        setMaximumSize(new java.awt.Dimension(400, 600));
        setMinimumSize(new java.awt.Dimension(400, 600));
        setName("Loading Page"); // NOI18N
        setPreferredSize(new java.awt.Dimension(400, 600));
        setRequestFocusEnabled(false);
        setLayout(null);

        centerPanel.setBackground(new java.awt.Color(225, 190, 231));
        centerPanel.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        centerPanel.setMaximumSize(new java.awt.Dimension(400, 80));
        centerPanel.setMinimumSize(new java.awt.Dimension(400, 80));
        centerPanel.setLayout(null);

        loadingIconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/loading.gif"))); // NOI18N
        centerPanel.add(loadingIconLabel);
        loadingIconLabel.setBounds(180, 20, 36, 36);

        loadingDetailLabel.setBackground(new java.awt.Color(0, 0, 0));
        loadingDetailLabel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        loadingDetailLabel.setForeground(new java.awt.Color(171, 71, 188));
        loadingDetailLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loadingDetailLabel.setText(this.details);
        centerPanel.add(loadingDetailLabel);
        loadingDetailLabel.setBounds(30, 60, 340, 20);

        add(centerPanel);
        centerPanel.setBounds(0, 270, 400, 100);

    }


    private javax.swing.JPanel centerPanel;
    private javax.swing.JLabel loadingDetailLabel;
    private javax.swing.JLabel loadingIconLabel;
}

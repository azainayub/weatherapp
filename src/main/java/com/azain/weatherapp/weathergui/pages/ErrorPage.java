package com.azain.weatherapp.weathergui.pages;

import com.azain.weatherapp.weathergui.WeatherApplicationGUI;

import javax.swing.*;

/**
 *
 * @author Azain
 */

public class ErrorPage extends javax.swing.JPanel
{

    private String detail;
    private ImageIcon errorIcon;
    private WeatherApplicationGUI app;

    public ErrorPage(String detail, ImageIcon errorIcon, WeatherApplicationGUI app) {
        this.app = app;
        this.errorIcon = errorIcon;
        this.detail = detail;
        initComponents();
    }

    private void initComponents() {

        centerPanel = new javax.swing.JPanel();
        errorIconLabel = new javax.swing.JLabel();
        errorDetailLabel = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(176, 0, 32));
        setToolTipText("Looks like there is an error!");
        setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        setMaximumSize(new java.awt.Dimension(400, 600));
        setMinimumSize(new java.awt.Dimension(400, 600));
        setPreferredSize(new java.awt.Dimension(400, 600));
        setLayout(null);

        centerPanel.setBackground(new java.awt.Color(249,209,216));
        centerPanel.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        centerPanel.setMaximumSize(new java.awt.Dimension(400, 80));
        centerPanel.setMinimumSize(new java.awt.Dimension(400, 80));
        centerPanel.setLayout(null);

        errorIconLabel.setIcon(errorIcon);
        centerPanel.add(errorIconLabel);
        errorIconLabel.setBounds(180, 20, 36, 36);

        errorDetailLabel.setBackground(new java.awt.Color(0, 0, 0));
        errorDetailLabel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        errorDetailLabel.setForeground(new java.awt.Color(176, 0, 32));
        errorDetailLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errorDetailLabel.setText(this.detail);
        centerPanel.add(errorDetailLabel);
        errorDetailLabel.setBounds(30, 60, 340, 20);

        add(centerPanel);
        centerPanel.setBounds(0, 270, 400, 100);

        backButton.setBackground(new java.awt.Color(255, 255, 255));
        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/back.png"))); // NOI18N
        backButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        backButton.setToolTipText("Press this button to go back!");
        backButton.setMaximumSize(new java.awt.Dimension(48, 24));
        backButton.setMinimumSize(new java.awt.Dimension(48, 24));
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        add(backButton);
        backButton.setBounds(20, 20, 40, 30);
    }

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt)
    {
        goBackToHome();
    }

    private void goBackToHome()
    {
        JPanel prevPage = app.getPreviousPage();
        app.changeCurrentPage(prevPage, false);
    }

    private javax.swing.JButton backButton;
    private javax.swing.JPanel centerPanel;
    private javax.swing.JLabel errorDetailLabel;
    private javax.swing.JLabel errorIconLabel;
}

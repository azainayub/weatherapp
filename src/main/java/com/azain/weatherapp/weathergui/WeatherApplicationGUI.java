package com.azain.weatherapp.weathergui;

import com.azain.weatherapp.weathergui.pages.HomePage;

import java.util.EmptyStackException;
import java.util.Stack;

import javax.swing.*;

/**
 *
 * @author Azain
 */

public class WeatherApplicationGUI extends javax.swing.JFrame
{

    private Stack<JPanel> prevPages;
    public WeatherApplicationGUI() {
        prevPages = new Stack<>();
        initComponents();
    }

    private void initComponents() {

        currentPage = new HomePage(this);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Weather Application ");
        setBackground(new java.awt.Color(0, 0, 0));
        setBounds(new java.awt.Rectangle(500, 120, 0, 0));
        setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        setIconImage(new ImageIcon(getClass().getResource("/Logo/outer-logo.png")).getImage());
        setMaximumSize(new java.awt.Dimension(415, 630));
        setMinimumSize(new java.awt.Dimension(415, 630));
        setName("Weather Application"); // NOI18N
        setPreferredSize(new java.awt.Dimension(415, 630));
        setResizable(false);
        setSize(new java.awt.Dimension(415, 630));
        getContentPane().setLayout(null);

        currentPage.setMaximumSize(new java.awt.Dimension(400, 600));
        currentPage.setLayout(null);
        getContentPane().add(currentPage);
        currentPage.setBounds(0, -1, 400, 600);

        pack();
    }


    public void changeCurrentPage(JPanel newPage, boolean savePrevious)
    {
        if(savePrevious)
        {
            prevPages.push(currentPage);
        }

        currentPage.setVisible(false);
        currentPage = newPage;
        currentPage.setVisible(true);
        this.getContentPane().add(currentPage);
        currentPage.setBounds(0, 0, 400, 600);
    }

    public JPanel getCurrentPage()
    {
        return this.currentPage;
    }

    public JPanel getPreviousPage()
    {
        try
        {
            JPanel prevPage = prevPages.peek();
            prevPages.pop();
            return prevPage;
        }
        catch(EmptyStackException e)
        {

        }

        return null;
    }

    private javax.swing.JPanel currentPage;
}

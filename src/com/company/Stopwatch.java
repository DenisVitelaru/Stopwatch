package com.company;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Stopwatch extends JFrame implements ActionListener {

    JFrame frame = new JFrame();
    JButton startButton = new JButton("START");
    JButton resetButton = new JButton("RESET");
    JButton stopButton = new JButton("STOP");
    JLabel timeLabel = new JLabel();
    int elapsedTime = 0;
    int seconds = 0;
    int minutes = 0;
    int hours = 0;
    String seconds_string = String.format("%02d", seconds);
    String minutes_string = String.format("%02d", minutes);
    String hours_string = String.format("%02d", hours);
    JComboBox fontBoxTimer;
    JComboBox fontBoxButtons;

    Timer timer = new Timer(1000, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {

            elapsedTime=elapsedTime+1000;
            hours = (elapsedTime / 3600000);
            minutes = (elapsedTime / 60000) % 60;
            seconds = (elapsedTime / 1000) % 60;

            seconds_string = String.format("%02d", seconds);
            minutes_string = String.format("%02d", minutes);
            hours_string = String.format("%02d", hours);
            timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
        }
    });

    Stopwatch() {

        timeLabel.setBounds(5, 5, 250, 75);
        timeLabel.setFont(new Font("Verdana", Font.PLAIN, 35));
        timeLabel.setBorder(BorderFactory.createBevelBorder(1));
        timeLabel.setOpaque(true);
        timeLabel.setHorizontalAlignment(JTextField.CENTER);

        startButton.setBounds(5, 80, 125, 50);
        startButton.setFont(new Font("Ink Free", Font.PLAIN, 20));
        startButton.setFocusable(false);
        startButton.addActionListener(this);

        stopButton.setBounds(130, 80, 125, 50);
        stopButton.setFont(new Font("Ink Free", Font.PLAIN, 20));
        stopButton.setFocusable(false);
        stopButton.addActionListener(this);

        resetButton.setBounds(5, 130, 250, 50);
        resetButton.setFont(new Font("Ink Free", Font.PLAIN, 20));
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

        fontBoxTimer = new JComboBox(fonts);
        fontBoxTimer.addActionListener(this);
        fontBoxTimer.setSelectedItem("Arial");
        fontBoxTimer.setBounds(5, 180, 125, 20);
        fontBoxButtons = new JComboBox(fonts);
        fontBoxButtons.addActionListener(this);
        fontBoxButtons.setSelectedItem("Ink Free");
        fontBoxButtons.setBounds(130, 180, 125, 20);

        frame.add(fontBoxTimer);
        frame.add(fontBoxButtons);
        frame.add(startButton);
        frame.add(resetButton);
        frame.add(stopButton);
        frame.add(timeLabel);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(275, 245);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Stopwatch");
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == startButton) {
            start();
        }

        if (e.getSource() == stopButton) {
            stop();
        }
        if (e.getSource() == resetButton) {
            reset();
        }
        if (e.getSource() == fontBoxTimer) {
            timeLabel.setFont(new Font((String) fontBoxTimer.getSelectedItem(), Font.PLAIN, timeLabel.getFont().getSize()));
        }
        if (e.getSource() == fontBoxButtons) {
            startButton.setFont(new Font((String) fontBoxButtons.getSelectedItem(), Font.PLAIN, startButton.getFont().getSize()));
            resetButton.setFont(new Font((String) fontBoxButtons.getSelectedItem(), Font.PLAIN, resetButton.getFont().getSize()));
            stopButton.setFont(new Font((String) fontBoxButtons.getSelectedItem(), Font.PLAIN, stopButton.getFont().getSize()));
            timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
        }


    }

    void start() {
        timer.start();
    }

    void stop() {
        timer.stop();
    }

    void reset() {
        timer.stop();
        elapsedTime = 0;
        seconds = 0;
        minutes = 0;
        hours = 0;
        seconds_string = String.format("%02d", seconds);
        minutes_string = String.format("%02d", minutes);
        hours_string = String.format("%02d", hours);
        timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);

    }
}

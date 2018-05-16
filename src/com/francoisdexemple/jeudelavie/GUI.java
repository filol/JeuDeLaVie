package com.francoisdexemple.jeudelavie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Transient;
import java.util.ArrayList;

public class GUI extends JPanel {
    private ArrayList<ArrayList<Integer>> grid;

    private GUI() {
        this.grid = new ArrayList<>();

        int valeur = (int) (Math.random() * 2 );

        ArrayList<int[]> lists = new ArrayList<>();

        if (valeur==0) {
            int[] i1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            int[] i2 = {0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0};
            int[] i3 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            int[] i4 = {0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0};
            int[] i5 = {0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0};
            int[] i6 = {0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0};
            int[] i7 = {0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0};
            int[] i8 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            int[] i9 = {0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0};
            int[] i10 = {0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0};
            int[] i11 = {0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0};
            int[] i12 = {0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0};
            int[] i13 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            int[] i14 = {0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0};
            int[] i15 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

            lists.add(i1);
            lists.add(i2);
            lists.add(i3);
            lists.add(i4);
            lists.add(i5);
            lists.add(i6);
            lists.add(i7);
            lists.add(i8);
            lists.add(i9);
            lists.add(i10);
            lists.add(i11);
            lists.add(i12);
            lists.add(i13);
            lists.add(i14);
            lists.add(i15);
        }else {
            int[] i1 = {0,0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            int[] i2 = {0,0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            int[] i3 = {0,0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            int[] i4 = {0,0,0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0};
            int[] i5 = {0,0,0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0};
            int[] i6 = {0,0,0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0};
            int[] i7 = {0,0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            int[] i8 = {0,0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            int[] i9 = {0,0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

            lists.add(i1);
            lists.add(i2);
            lists.add(i3);
            lists.add(i4);
            lists.add(i5);
            lists.add(i6);
            lists.add(i7);
            lists.add(i8);
            lists.add(i9);
        }
        for (int[] list : lists) {
            ArrayList<Integer> values = new ArrayList<>();
            for (int value : list)
                values.add(value);
            this.grid.add(values);
        }
    }

    @Override
    @Transient
    public Dimension getPreferredSize() {
        return new Dimension(grid.size() * 4, grid.get(0).size() * 4);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Color gColor = g.getColor();

        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(i).size(); j++) {
                if (grid.get(i).get(j) == Main.ALIVE) {
                    g.setColor(Color.blue);
                    g.fillRect(j * 10, i * 10, 10, 10);
                }
            }
        }
        g.setColor(gColor);
    }

    private void refreshGrid() {
        this.grid = Main.getNextTable(grid);
    }

    public static void main(String[] args) {
        final GUI gui = new GUI();
        JFrame frame = new JFrame();
        frame.getContentPane().add(gui);
        frame.pack();
        frame.setSize(200, 200);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.repaint();
                gui.refreshGrid();
            }
        }).start();
    }
}

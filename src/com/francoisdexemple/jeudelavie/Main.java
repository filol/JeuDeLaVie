package com.francoisdexemple.jeudelavie;

import java.util.ArrayList;

public class Main {

    public static final int DEAD = 0;
    public static final int ALIVE = 1;

    private static int getNextState(ArrayList<Integer> neighbours, int actualState) {
        int neighbourAliveSum = 0;
        for (int neighbour : neighbours)
            neighbourAliveSum += neighbour;

        if (actualState == DEAD && neighbourAliveSum == 3)
            return ALIVE;

        if (actualState == ALIVE && (neighbourAliveSum <2 || neighbourAliveSum>3))
            return DEAD;

        return actualState;
    }

    private static ArrayList<Integer> getNeighbours(ArrayList<ArrayList<Integer>> table, int x, int y) {
        ArrayList<Integer> listNeighbours = new ArrayList<>();

        //Voisin de droite
        if (x > 0)
            listNeighbours.add(table.get(x - 1).get(y));

        //Voisin de gauche
        if (x < table.size()-1)
            listNeighbours.add(table.get(x + 1).get(y));

        //Voisin du haut
        if (y > 0)
            listNeighbours.add(table.get(x).get(y - 1));

        //Voisin du bas
        if (y < table.get(x).size()-1)
            listNeighbours.add(table.get(x).get(y + 1));

        //Diagonal haut-gauche
        if (x > 0 && y > 0)
            listNeighbours.add(table.get(x - 1).get(y - 1));

        //Diagonale haut-droite
        if (x > 0 && y < table.get(x).size()-1)
            listNeighbours.add(table.get(x - 1).get(y + 1));

        //Diagonale bas-gauche
        if (x < table.size()-1 && y >0)
            listNeighbours.add(table.get(x + 1).get(y - 1));

        //Diagonal bas-droite
        if (x < table.size()-1 && y < table.get(x).size()-1)
            listNeighbours.add(table.get(x + 1).get(y + 1));

        return listNeighbours;
    }

    public static ArrayList<ArrayList<Integer>> getNextTable(ArrayList<ArrayList<Integer>> table) {
        ArrayList<ArrayList<Integer>> newTable = new ArrayList<>();
        for (int x = 0; x < table.size(); x++) {
            ArrayList<Integer> newColonne = new ArrayList<>();
            for (int y = 0; y < table.get(x).size(); y++) {
                ArrayList<Integer> neighbours = getNeighbours(table, x, y);
                int nextState = getNextState(neighbours, table.get(x).get(y));
                newColonne.add(nextState);
            }
            newTable.add(newColonne);
        }
        return newTable;
    }
}

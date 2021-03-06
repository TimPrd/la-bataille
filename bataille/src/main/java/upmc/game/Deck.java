/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.game;

import java.util.ArrayList;
import java.util.Collections;


/**
 * This Class enables you to create a Deck of Cards (A list of x cards)
 * It's a kind of factory of cards. It is composed of 52 cards in this game but can be changed in the final fiedl "NB_CARDS"
 * In the game we have only one deck but each player has 50% of it (check .splitDeck())
 *
 * @author Timothé Pardieu
 */
public class Deck
{
    private static final int NB_CARDS = 15;

    public ArrayList<Card> getAlCards() {
        return alCards;
    }

    //NB : all the arrayList are called alXXXX where al means array list (personnal convention to know when we are dealing with an arraylist)
    private ArrayList<Card> alCards;

    /**
     * Creating the deck by giving to each value a color
     */
    public Deck()
    {
        this.alCards = new ArrayList<Card>();
        //Build th deck, for each number from 2 to 14..
        for (int i = 2; i < NB_CARDS; i++)
        {
            String[] arrayColors = {"TREFLE", "COEUR", "PICQUE", "CARREAU"};
            for (String arrayColor : arrayColors) //..we assign a color
            {
                alCards.add(new Card(arrayColor, i)); //Add in the deck the new card
            }
        }
        //Shuffle the deck that so the cards have a new rank (==> math.random)
        Collections.shuffle(alCards);
    }


    /**
     * Split the deck in 2 so the both players have 26 cards
     *
     * @param deck the main deck with 52 cards
     * @param j1   the player 1 who will get the 26 cards
     * @param j2   the second player who will get the last 26 cards remaining
     */
    public void splitDeck(Deck deck, Player j1, Player j2)
    {
        int numberOfCardEachPlayer = deck.alCards.size() / 2;
        j1.createPlayerDeck(0, numberOfCardEachPlayer, alCards);
        j2.createPlayerDeck(numberOfCardEachPlayer, deck.alCards.size(), alCards);
    }

}

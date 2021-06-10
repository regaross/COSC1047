//Regan Ross, 0369345
//Assignment 4 Question 6
//For Dr.Aaron Langille, master of computer languages, not light switches.

package question6;

import java.util.Random;
import java.util.*;
/**
 * A CardDeck object represents a deck of 52 Card objects.
 */
public class CardDeck
{
   private static final int DECK_SIZE = 52;
   private LinkedList<Card> deck;
   private int topCardIndex;
   
   /**
    * Construct a deck of cards initialized in the standard order 0 to 51
    */
   public CardDeck()
   {
      deck = new LinkedList<Card>();
      initialize();
   }
   
   // put cards in standard order
   private void initialize()
   {
      topCardIndex = 0;
      for (int k = 0; k < DECK_SIZE; k++)
      {
        deck.add(k, new Card(k));
      }     
   }
   
   /**
    * Return all the cards in the deck to standard order and
    * then shuffle them into a random order.
    */
   public void shuffle()
   {
      // randomly choose position among 0 to 51  to swap with position 0
      // randomly choose position among 1 to 51  to swap with position 1
      // ...
      // randomly choose position among k to 51  to swap with position k
      // ...
      // randomly choose position among 50 to 51 to swap with position 50
      
      Random rand = new Random();
      initialize();
      for (int k = 0; k <= DECK_SIZE - 2; k++)
      {
         int index = rand.nextInt(DECK_SIZE - k) + k;
         Card temp = deck.get(k);
         deck.set(k,deck.get(index));
         deck.set(index, temp);
      }
   }
   
   /**
    * Deal a card from the deck.
    * If there are no more cards null is returned.
    * @return the card or null if there are no more cards.
    */
   public Card deal()
   {
      if (topCardIndex == DECK_SIZE) return null;
      Card topCard = deck.get(topCardIndex);
      topCardIndex++;
      return topCard;
   }
   
   /**
    * Return the number of cards remaining in the deck.
    * @return the number of cards remaining in the deck.
    */
   public int cardsInDeck()
   {
      return DECK_SIZE - topCardIndex;
   }
   
   /**
    * Return true if deck is empty, false otherwise.
    * @return true if deck is empty, false otherwise.
    */
   public boolean empty()
   {
      return topCardIndex == DECK_SIZE;
   }
   
   /**
    * Return a string representation of the cards remaining in the deck.
    */
   public String toString()
   {
      StringBuilder b = new StringBuilder(215);
      for (int k = topCardIndex; k < DECK_SIZE; k++)
      {
         Card card = deck.get(k);
         b.append(card.getCardName());   
         if ( (k+1) % 13 == 0)
            b.append("\n");
         else
            b.append(" ");
      }
      return b.toString();
   } 
}

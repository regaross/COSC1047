package question6;
/**
 *  A Card object encapsulates a standard playing card in terms
 *  of 4 suits and 13 ranks. Each card can also be described in
 *  terms of an index in the range 0 to 51:
 *  <pre>
 *  index  0 to 12:   A-C, 2-C, 3-C, ..., K-C
 *  index 13 to 25:   A-D, 2-D, 3-D, ..., K-D
 *  index 26 to 38:   A-H, 2-H, 3-H, ..., K-H
 *  index 39 to 51:   A-S, 2-S, 3-S, ..., K-S</pre>
 *  The index, rank (0-12) and suit (0-3) are related by
 *  <pre>
 *  index = 13*suit + rank
 *  suit = index / 13
 *  rank = index % 13</pre>
 */
public class Card
{
   private static String[] ranks
      = { "Ace", "Two", "Three", "Four", "Five", "Six", "Seven",
         "Eight", "Nine", "Ten", "Jack", "Queen", "King" };
 
   private static String rankLetter = "A23456789TJQK";
 
   private static String[] suits
      = { "Clubs", "Diamonds", "Hearts", "Spades" };
      
   private static String suitLetter = "CDHS";
       
   private int rank;  // 0 to 12
   private int suit;  // 0 to 3
   private int index; // 0 to 51
   
   private String rankName; // "Ace", "Two", ... "King"
   private String suitName; // "Clubs" ... "Spades"
   private String cardName; // e.g. A-C for ace of clubs
   
   /**
    * Construct a card given its rank and suit.
    * @param rank card rank in range 0 (Ace) to 12 (King)
    * @param suit card suit in range 0 (Clubs} to 3 (Spades)
    */
   public Card(int rank , int suit)
   {
      this.rank = rank;
      this.suit = suit;
      index = 13*suit + rank;
      rankName = ranks[rank];
      suitName = suits[suit];
      cardName = rankLetter.substring(rank,rank+1) + "-" 
         + suitLetter.substring(suit,suit+1);
   }
   
   /**
    * Construct a card given its index.
    * @param index card index in the range 0 (A-C) to 51 (K-S)
    */
   public Card(int index)
   {
      this.index = index;
      rank = this.index % 13;
      suit = this.index / 13;
      rankName = ranks[rank];
      suitName = suits[suit];
      cardName = rankLetter.substring(rank,rank+1) + "-" 
         + suitLetter.substring(suit,suit+1);
   }
     
   /**
    * Return the rank name of the card.
    * @return rank name of card: "Ace" to "King"
    */
   public String getRankName()
   {
      return rankName;
   }
   
   /**
    * Return the suit name of the card.
    * @return suit name if card: "Clubs" to "Spades"
    */
   public String getSuitName()
   {
      return suitName;
   }
   
   /**
    * Return the card name.
    * @return the card name in format A-C to K-S
    */
   public String getCardName()
   {
      return cardName;
   } 
   
   /**
    * Return a string representation of a card.
    * @return a string representation of a card.
    */
   public String toString()
   {
      return cardName;
   }
}

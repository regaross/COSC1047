package question6;
/**
 * A simple test class for CardDeck class
 */
public class CardDeckTester
{  
   public void run()
   {
      CardDeck deck = new CardDeck();
      System.out.println("Initilized deck:");
      System.out.println(deck);
      System.out.println("Shuffled deck:");
      deck.shuffle();
      System.out.println(deck);
      
      // Deal a few cards
      
      Card card;
      
      for(int i = 0; i<10; i++){
    	  card = deck.deal();
    	  System.out.println("dealing " + card.getCardName());
      }
      System.out.println("\n");
      System.out.println("There are " + deck.cardsInDeck() + 
    		  " cards left in the deck.  Dealing the rest, 7 per line.\n");
      
      // Deal the cards left in the deck and display them 13 per line
      int count = 0;
      while ( ! deck.empty() )
      {
         Card c = deck.deal();
         count++;
         System.out.print(c.getCardName());
         if (count == 7)
         {
            System.out.println();
            count = 0;
         }
         else
         {
            System.out.print(" ");
         }
      }
      if (count != 0) System.out.println();
   }
   
   public static void main(String[] args)
   {
      new CardDeckTester().run();
   }
}

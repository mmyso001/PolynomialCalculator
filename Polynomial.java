/**
 *
 * @author Meekaeel Mysorewala
 */
public class Polynomial {
    private Node head ;              // points to the first Node of a Polynomial

   /**
    * Default constructor creates a Polynomial with no terms
    */
   public Polynomial()  
   {
      head = null ;
   }
   
   /**
    * Creates a "deep copy" of a given Polynomial. I.e. a new Polynomial with
    * identical terms
    * @param p Polynomial to be copied
    */
   public Polynomial(Polynomial p)  // a "copy" constructor
   {
      head = p.head;
   }
   
   /**
    * Creates a new Term and Node containing it and inserts it in its proper
    * place in this Polynomial (i.e. in ascending order by exponent) 
    * @param coeff the coefficient of the new Term
    * @param expo the exponent of the new Term
    */
   public void addTerm(int coeff, int expo)
   {
       //creates a new term and loads it into a node
      Node n = new Node(new Term(coeff, expo)); 
      
      Node a = head; // trails the list 
      
      if( head == null)
      {
          head = n;
      }
      // checks if it is smaller
      else if (n.info.getExponent() < a.info.getExponent())
      {
          n.next = head;
          head = n;
      }
      else
      {
          Node b = head.next;
          while (b != null)
          {
            if(n.info.getExponent() < b.info.getExponent())
            {
              break;
            }
            else
            {
              a = b;
              b = b.next;
            }
          }   
          n.next = b;
          a.next = n;
      }
   }
              
      
      
      
         
  
   /**
    * Returns a polynomial as a String in this form: x + 3x^2 + 7x^3 + x^5
    * @return the polynomial as a String
    */
   @Override
   public String toString()
   {
       if ( head == null ) //Check if list is empty
        {
            return "0" ; //the polynomial is '0'
        }
        collectTerms() ; //Collect the terms for formating
        String s = " " ; //the polynomial in string format
        Node temp = head; //start from the first node of the list
        while( temp != null ) //traverse the list
        {
            s = s + temp.info.toString() ; //add term to the string
            temp = temp.next ; //move to next node
        }
        return s ; //Formated polynomial
   }
   
   // collect terms of a Polynomial object. I.e. replace all terms having the 
   // same exponent with a single term which is their sum
   private void collectTerms()
   {
      Node temp = head ; //start at first node
        while( temp.next != null ) //Traverse the list
        {
            Term thisTerm = temp.info ; //'this' term
            Term thatTerm = temp.next.info ; //the next term
            //compare and add the coefficients while the exponents of the next
            //term is the same as 'this' terms exponent
            while ( thisTerm.getExponent() == thatTerm.getExponent() )
            {
                int newCoef = thisTerm.getCoefficient() + thatTerm.getCoefficient() ;
                Term newTerm = new Term( newCoef, thisTerm.getExponent() ) ;
                temp.info = newTerm ; //'this' get new resulting term
                temp.next = temp.next.next ; //point to the term after next
                thisTerm = temp.info ; //new term 
                thatTerm = temp.next.info ; //new next term 
            }
            //check if there is a next term
            if ( temp.next == null )
            {
                break ; //exit the loop
            }    
            temp = temp.next ; //move to next term
        }
   }
   
   /**
    * Multiply this Polynomial by another Polynomial
    * @param p the other Polynomial
    * @return the Polynomial product
    */
   public Polynomial polyMultiply(Polynomial p)
   {
       //resulting polynomial starts as the multiplying polynomial 
        Polynomial poly = new Polynomial() ; 
        Node temp1 = head ; //start from first node of 'this' list
        Node temp2 = p.head ; //start from first node of 'multiplying' list
       
        while ( temp1 != null ) //traverse 'this' list
        {
            while ( temp2 != null ) //traverse 'multiplying' list 
            {
                //multiply the coeficients
                int newCoef = temp2.info.getCoefficient() * temp1.info.getCoefficient() ;
                //add the exponents
                int newExp = temp2.info.getExponent() + temp1.info.getExponent() ;
                //add the new term to the resulting 
                poly.addTerm( newCoef, newExp ) ; 
                temp2 = temp2.next ;  //move to the next node
            }
            temp2 = p.head ; //reset the 'multiplying' list 
            temp1 = temp1.next ; //move to the next node of 'this' list
        }
        return poly  ; //resulting polynomial
    }
   
   
   /**
    * Add this Polynomial and another Polynomial
    * @param p the other Polynomial
    * @return the Polynomial sum
    */
   public Polynomial polyAdd(Polynomial p)
   {      
       Polynomial p1 = new Polynomial(p);
       Node H = head;
       while (H != null)
       {
       p1.addTerm(H.info.getCoefficient(), H.info.getExponent());
       
       H = H.next;
       }
       
       return  p1;
       
   }
   
   // Node class definition - DO NOT MODIFY!
   class Node <E extends Term>
   {
      private E info ;     // each node stores an object of the 
                           // type-parameter class...
      private Node next ;  // ...and a pointer to another node

      // Node Constructor 
      // parameter x is an object of the type-parameter class
      Node(E x)         
      {
         info = x;	// set info portion to parameter passed
         next = null;	// not necessary, null is default value
      }
   } 


}

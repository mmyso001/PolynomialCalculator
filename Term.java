/**
 *
 * @author Meekaeel Mysorewala
 */
public class Term {
    private int coefficient;
    private int exponent;
    
    public Term(int C, int E)
    {
        coefficient = C;
        exponent = E;
    }
    
    public int getCoefficient()
    {
       return coefficient;
    }
    
    public int getExponent()
    {
        return exponent;
    }
    
    @Override
    public String toString()
    {
        if (getCoefficient() == 1 && getExponent() == 1)
        {
            return "x ";
        }
        
        else if(getCoefficient() != 1 && getExponent() == 0)
        {
            return getCoefficient() + " ";
        }
        
        else if(getCoefficient() != 1 && getExponent() == 1)
        {
            return getCoefficient() + "x ";
        }
        else 
        {
       
            return getCoefficient() + "x^" + getExponent() + " ";  
        }
    }

    
}

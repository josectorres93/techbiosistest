/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pragmaticlottery;

/**
 *
 * @author José
 */
public class PragmaticLottery {

    /**
     * @param args the command line arguments
     */
   
    public  int[] sortBalls(int number[])
	{
                int n=number.length;
		// percorre os numberos do array
		for (int i = 0; i < n; i++)
		{
                        //
			for (int j = 1; j < (n - i); j++)
			{
				if (number[j - 1] > number[j])
				{
					int temp = number[j - 1];
					number[j - 1] = number[j];
					number[j] = temp;
				}

			}
		}

		return number;
	}
    public static void main(String[] args) {
        // TODO code application logic here
        
    } 
}

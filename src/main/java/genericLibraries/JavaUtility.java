package genericLibraries;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
/**
 * This class contains reusable methods to perform java related actions
 * @author Jayanth
 *
 */
public class JavaUtility 
{
   /**
    * This method generate random number within the limit specified
    * @param limit
    * @return
    */
	
	  public int generateRandomNum(int limit)
	  {
		  Random random = new Random();
		  return random.nextInt(limit);
	  }
	  /**
	   * this method generate current time
	   * @return
	   */
	public String getCurrentTime()
	{
		Date date = new Date ();
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yy_hh_mm_SSS");
		return sdf.format(date);
	}
}

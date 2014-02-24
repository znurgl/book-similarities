package io.kiiro.booksimilarities

import org.scalatest._
import java.text.DecimalFormat

/**
 * Testing basic statistics
 * 
 * @author Greg Bakos
 */
class BasicCorrelationTest extends FlatSpec with Matchers {

  /** Correlation measurement Test
   *  
   *  online calculator to validate the result:
   *  http://www.socscistatistics.com/tests/pearson/Default2.aspx
   *  
   */
  it should "equal to " in {
    
    // need two Int arrays
    val sim1 = Array(5,5,4,3,4,5,4,3,3,2,3,2,4,3,2,2,3,4,4,3,2,1,1,3,4,5,4,4,3,2,1,2,3,4,3,2,1,1,2,3,1)
    val sim2 = Array(5,4,4,3,4,5,4,3,3,2,3,2,4,3,2,2,3,4,4,2,2,1,1,3,4,5,4,4,3,2,1,2,3,4,3,2,5,5,2,3,1)
    
    // monitoring value from socscistatistics
    val r = "0.71"
    
    // compute basics
    val size = sim1.length
    val item = (sim1,sim2).zipped.map{ case (a,b) => a*b }.reduceLeft(_+_)
    val ratingFirstSum = sim1.reduceLeft(_+_)
    val ratingSecondSum = sim2.reduceLeft(_+_)
    val ratingFirstNormSq = sim1.map{ case a => scala.math.pow(a, 2) }.reduceLeft(_+_)
    val ratingSecondNormSq = sim2.map{ case a => scala.math.pow(a, 2) }.reduceLeft(_+_)
    
    // create a dummy class from abstract class
    class TestCorrelation extends BasicCorrelation
    val tc = new TestCorrelation
    
    // it needs because socscistatistics yields a two decimal point precision result
    val formatter = new DecimalFormat("#.##")
    
    assert(r ===  formatter.format(tc.pearsonCorrelation(size, item, ratingFirstSum, ratingSecondSum, 
        ratingFirstNormSq, ratingSecondNormSq)) )
	  
  }

}
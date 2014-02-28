package io.kiiro.booksimilarities

import org.scalatest._
import java.text.DecimalFormat

/**
 * Testing basic statistics
 *
 * @author Greg Bakos
 */
class BasicCorrelationTest extends FlatSpec with Matchers {

  // need two Int arrays
  val sim1 = Array(5, 5, 4, 3, 4, 5, 4, 3, 3, 2, 3, 2, 4, 3, 2, 2, 3, 4, 4, 3, 2, 1, 1, 3, 4, 5, 4, 4, 3, 2, 1, 2, 3, 4, 3, 2, 1, 1, 2, 3, 1)
  val sim2 = Array(5, 4, 4, 3, 4, 5, 4, 3, 3, 2, 3, 2, 4, 3, 2, 2, 3, 4, 4, 2, 2, 1, 1, 3, 4, 5, 4, 4, 3, 2, 1, 2, 3, 4, 3, 2, 5, 5, 2, 3, 1)

  // compute basics
  val items = (sim1, sim2).zipped.map { case (a, b) => a * b }.reduceLeft(_ + _)
  val ratingFirstSum = sim1.reduceLeft(_ + _)
  val ratingSecondSum = sim2.reduceLeft(_ + _)
  val ratingFirstNormSq = sim1.map { case a => scala.math.pow(a, 2) }.reduceLeft(_ + _)
  val ratingSecondNormSq = sim2.map { case a => scala.math.pow(a, 2) }.reduceLeft(_ + _)

  // create a dummy class from abstract class
    class TestCorrelation extends BasicCorrelation
    val tc = new TestCorrelation
  
  /**
   * Correlation measurement Test
   *
   *  online calculator to validate the result:
   *  http://www.socscistatistics.com/tests/pearson/Default2.aspx
   *
   */
  "0.71 correlation value" should "equal to " in {

    // monitoring value from socscistatistics
    val r = 0.71

    assert(r === BigDecimal(tc.pearsonCorrelation(sim1.length, items, ratingFirstSum, ratingSecondSum,
      ratingFirstNormSq, ratingSecondNormSq)).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble)
  }
  
  /**
   * Cosine similarity test
   *
   *  online calculator to validate the result:
   *  http://www.appliedsoftwaredesign.com/archives/cosine-similarity-calculator/
   *
   */
  "0.960949230409 similarity" should "equal to " in {

    // monitoring value from appliedsoftwaredesign
    val similarity = 0.960949230409

    assert(similarity === 
      BigDecimal(tc.cosineSimilarity(items, 
        scala.math.sqrt(ratingFirstNormSq), scala.math.sqrt(ratingSecondNormSq))).setScale(12, BigDecimal.RoundingMode.HALF_UP).toDouble)
  }

}
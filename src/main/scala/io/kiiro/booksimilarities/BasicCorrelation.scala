package io.kiiro.booksimilarities

/**
 * Measuring basic statistics
 * 
 * @author Greg Bakos
 */
abstract class BasicCorrelation {

  /** Correlation measurement
   *  
   *  More about Pearson product-moment correlation here:
   *  http://en.wikipedia.org/wiki/Pearson_product-moment_correlation_coefficient
   * 
   * @param size
   * @param item
   * @param ratingFirstSum
   * @param ratingSecondSum
   * @param ratingFirstNormSq
   * @param ratingSecondNormSq
   * @return correlation value in Double
   */
  def pearsonCorrelation(size: Double, item: Double, ratingFirstSum: Double, ratingSecondSum: Double, ratingFirstNormSq: Double,
    ratingSecondNormSq: Double) = {
	  ( size * item - ratingFirstSum * ratingSecondSum ) /
	  ( scala.math.sqrt( size * ratingFirstNormSq - ratingFirstSum * ratingFirstSum ) *
	    scala.math.sqrt( size * ratingSecondNormSq - ratingSecondSum * ratingSecondSum ) )
  }

}
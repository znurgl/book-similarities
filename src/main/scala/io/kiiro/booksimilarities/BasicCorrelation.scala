package io.kiiro.booksimilarities

/**
 * Measuring basic statistics
 * 
 * @author Greg Bakos
 */
abstract class BasicCorrelation {

  /** 
   *  Correlation measurement
   *  
   *  More about Pearson product-moment correlation here:
   *  http://en.wikipedia.org/wiki/Pearson_product-moment_correlation_coefficient
   * 
   * @param size
   * @param items
   * @param ratingFirstSum
   * @param ratingSecondSum
   * @param ratingFirstNormSq
   * @param ratingSecondNormSq
   * @return correlation value in Double
   */
  def pearsonCorrelation(size: Double, items: Double, ratingFirstSum: Double, ratingSecondSum: Double, ratingFirstNormSq: Double,
    ratingSecondNormSq: Double) = {
	  ( size * items - ratingFirstSum * ratingSecondSum ) /
	  ( scala.math.sqrt( size * ratingFirstNormSq - ratingFirstSum * ratingFirstSum ) *
	    scala.math.sqrt( size * ratingSecondNormSq - ratingSecondSum * ratingSecondSum ) )
  }
  
  /**
   * Cosine similarity
   * 
   * More about Cosine Similarity here:
   * http://en.wikipedia.org/wiki/Cosine_similarity
   * 
   * @param item
   * @param ratingFirstNorm
   * @param ratingSecondNorm
   * @return similarity value in Double
   */
  def cosineSimilarity(items : Double, ratingFirstNorm : Double, ratingSecondNorm : Double) = {
    items / (ratingFirstNorm * ratingSecondNorm)
  }

}
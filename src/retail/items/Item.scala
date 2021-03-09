package retail.items

import currency.CurrencyAmount
import retail.RetailConstants

import java.awt.Image

abstract class Item(val sku: String, descriptor: String) {
  var description: String = descriptor
  var upc = 0L
  var price = new CurrencyAmount(0, RetailConstants.U_S_DOLLARS)
  var avgStarRating = 0.0
  var salesRank = 0
  var relevanceRanking = 0.0
  var frontImage: Image = null

  override def toString: String = this.description

  def relevance(searchTerm: String): Double = this.relevanceRanking

}

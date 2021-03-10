package retail.items

import currency.CurrencyAmount
import retail.RetailConstants.U_S_DOLLARS
import retail.items.electronics.ElectronicsItem
import retail.items.miscellaneous.MiscellaneousItem
import retail.items.petsupplies.PetSuppliesItem

object FictItems {

  val LARGE_DOGS_FOOD_BOWL = new PetSuppliesItem("67890",
    "Food bowl for large dogs")
  val GENERIC_AA_BATTERIES_4PK = new ElectronicsItem("AA447",
    "Generic brand batteries 4-pack AA")
  val CAT_FOOD = new PetSuppliesItem("67895", "Cat food 5-lb. bag")
  val DOG_FOOD = new PetSuppliesItem("67889", "Dog food 5-lb. bag")
  val FREE_SAMPLE = new MiscellaneousItem("99999", "Free sample")
  val PET_FOOD_BOWL = new PetSuppliesItem("67878", "Pet food bowl")
  val NAME_BRAND_BATTERIES_AA_4PK = new ElectronicsItem("AA420",
    "Name brand batteries 4-pack AA")

  def setUpItems(): Unit = {
    LARGE_DOGS_FOOD_BOWL.price = new CurrencyAmount(1899, U_S_DOLLARS)
    LARGE_DOGS_FOOD_BOWL.avgStarRating = 4.2
    LARGE_DOGS_FOOD_BOWL.salesRank = 528
    LARGE_DOGS_FOOD_BOWL.upc = 12345678905L
    LARGE_DOGS_FOOD_BOWL.relevanceRanking = 1.0
    GENERIC_AA_BATTERIES_4PK.price = new CurrencyAmount(349, U_S_DOLLARS)
    GENERIC_AA_BATTERIES_4PK.avgStarRating = 3.0
    GENERIC_AA_BATTERIES_4PK.salesRank = 348
    GENERIC_AA_BATTERIES_4PK.upc = 99999012347L
    GENERIC_AA_BATTERIES_4PK.relevanceRanking = 0.0
    CAT_FOOD.price = new CurrencyAmount(498, U_S_DOLLARS)
    CAT_FOOD.avgStarRating = 4.0
    CAT_FOOD.salesRank = 548
    CAT_FOOD.upc = 12345678950L
    CAT_FOOD.relevanceRanking = 0.2
    DOG_FOOD.price = new CurrencyAmount(698, U_S_DOLLARS)
    DOG_FOOD.avgStarRating = 5.0
    DOG_FOOD.salesRank = 503
    DOG_FOOD.upc = 12345678899L
    DOG_FOOD.relevanceRanking = 0.8
    FREE_SAMPLE.price = new CurrencyAmount(0, U_S_DOLLARS)
    FREE_SAMPLE.avgStarRating = 0.0
    FREE_SAMPLE.salesRank = 1
    FREE_SAMPLE.upc = 12345999994L
    FREE_SAMPLE.relevanceRanking = 0.0
    PET_FOOD_BOWL.price = new CurrencyAmount(1099, U_S_DOLLARS)
    PET_FOOD_BOWL.avgStarRating = 3.1
    PET_FOOD_BOWL.salesRank = 880
    PET_FOOD_BOWL.upc = 12345678783L
    PET_FOOD_BOWL.relevanceRanking = 0.6
    NAME_BRAND_BATTERIES_AA_4PK.price = new CurrencyAmount(549, U_S_DOLLARS)
    NAME_BRAND_BATTERIES_AA_4PK.avgStarRating = 3.2
    NAME_BRAND_BATTERIES_AA_4PK.salesRank = 789
    NAME_BRAND_BATTERIES_AA_4PK.upc = 55555000203L
    NAME_BRAND_BATTERIES_AA_4PK.relevanceRanking = 0.0
  }

}

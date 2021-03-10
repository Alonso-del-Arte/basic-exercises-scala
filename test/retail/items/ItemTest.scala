package retail.items

import scala.math.Ordering.Double.TotalOrdering

import org.junit.Test
import org.junit.Assert._

class ItemTest {
  FictItems.setUpItems()

  @Test def testSortByPrice(): Unit = {
    val unsorted = List(FictItems.LARGE_DOGS_FOOD_BOWL,
      FictItems.GENERIC_AA_BATTERIES_4PK,
      FictItems.CAT_FOOD,
      FictItems.DOG_FOOD,
      FictItems.FREE_SAMPLE,
      FictItems.PET_FOOD_BOWL,
      FictItems.NAME_BRAND_BATTERIES_AA_4PK)
    val expected = List(FictItems.FREE_SAMPLE,
      FictItems.GENERIC_AA_BATTERIES_4PK,
      FictItems.CAT_FOOD,
      FictItems.NAME_BRAND_BATTERIES_AA_4PK,
      FictItems.DOG_FOOD,
      FictItems.PET_FOOD_BOWL,
      FictItems.LARGE_DOGS_FOOD_BOWL)
    val actual = unsorted.sortBy(_.price)
    assertEquals(expected, actual)
  }

  @Test def testSortByPriceDescending(): Unit = {
    val unsorted = List(FictItems.LARGE_DOGS_FOOD_BOWL,
      FictItems.GENERIC_AA_BATTERIES_4PK,
      FictItems.CAT_FOOD,
      FictItems.DOG_FOOD,
      FictItems.FREE_SAMPLE,
      FictItems.PET_FOOD_BOWL,
      FictItems.NAME_BRAND_BATTERIES_AA_4PK)
    val expected = List(FictItems.LARGE_DOGS_FOOD_BOWL,
      FictItems.PET_FOOD_BOWL,
      FictItems.DOG_FOOD,
      FictItems.NAME_BRAND_BATTERIES_AA_4PK,
      FictItems.CAT_FOOD,
      FictItems.GENERIC_AA_BATTERIES_4PK,
      FictItems.FREE_SAMPLE)
    val actual = unsorted.sortBy(_.price).reverse
    assertEquals(expected, actual)
  }

  @Test def testSortByRelevanceDescending(): Unit = {
    val unsorted = List(FictItems.LARGE_DOGS_FOOD_BOWL,
      FictItems.CAT_FOOD,
      FictItems.DOG_FOOD,
      FictItems.PET_FOOD_BOWL)
    val expected = List(FictItems.LARGE_DOGS_FOOD_BOWL,
      FictItems.DOG_FOOD,
      FictItems.PET_FOOD_BOWL,
      FictItems.CAT_FOOD)
    val actual = unsorted.sortBy(_.relevance("dog food bowl")).reverse
    assertEquals(expected, actual)
  }

  // TODO: Write more tests

}

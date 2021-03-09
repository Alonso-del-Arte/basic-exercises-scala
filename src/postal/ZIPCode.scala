package postal

import java.util.Locale

// TODO: Write tests
class ZIPCode(val zip5: Int, val zip4: Int)
  extends PostalCode(zip5 * 10000 + zip4, Locale.US) {

  override def toString: String = this.number.toString

}

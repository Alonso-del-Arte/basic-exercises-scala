package basicexercises

class SomeClass(private[this] val label: String) {

  protected def getLabel: String = this.label.toUpperCase

}

import scala.util.Random

/**
    Classes and objects
 */

trait IntroClasses

class IntroClass(name: String) extends IntroClasses {

}
// Companion object
object IntroClass {
  val demoIntro = new IntroClass("Hallo")
}

case class IntroCaseClass(name: String) extends IntroClasses

case object IntroCaseObject


// New object
val introClass = new IntroClass("Hallo")

// Static access
// hashCode() not present
// val className = IntroClass.demoIntro.name

// Case class object creation
// hashCode() present
val caseClassName = IntroCaseClass("Hallo").name
// Singleton
val introCaseObject = IntroCaseObject









/**
   Methoden und Funktionen
*/

case class IntroCaseClassWithMethod(name: String) {

  def lengthOfName(toAdd: Int): Int = {
    name.length + toAdd
  }
}

IntroCaseClassWithMethod("LaLeLu").lengthOfName(2)

case class IntroCaseClassWithMethodRequiringAFunction(name: String) {

  def lengthName(transformer: String => Int): Int = {
    name.length + transformer(name)
  }
}

IntroCaseClassWithMethodRequiringAFunction("LaLeLu").lengthName(name => Random.nextInt(name.length))






/**
    Options and Pattern Matching
*/

case class IntroCaseClassWithOption(maybeName: Option[String] = None)

val maybeIntroClass = IntroCaseClassWithOption(Some("LaLeLu"))
val maybeIntroClassNone = IntroCaseClassWithOption()

val maybeName = maybeIntroClass.maybeName
maybeIntroClassNone.maybeName

maybeName match {
  case None => None
  case Some(x) => x
}

maybeIntroClassNone.maybeName match {
  case None => None
  case Some(x) => x
}






/**
    Collections
*/

val aList = IntroCaseClassWithMethod("LaLeLu") :: IntroCaseClassWithMethod("Lulu") :: Nil

aList map (_.name)

aList map (_.lengthOfName(2))
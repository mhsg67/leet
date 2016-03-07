/**
  * User: tyson.hamilton
  * Date: 25/09/13
  * Time: 11:10 AM
  */
object Main extends App {

  object Leet {

    trait Leetable[T] {
      def toLeet(in: T): String
    }

    def apply[T: Leetable](in: T): String = implicitly[Leetable[T]].toLeet(in)
  }

  // add your implementation below this line

  /**
    * Context bound for String to Leetable
    * @return Leetable for String
    */
  implicit def strToLeetable = new Leet.Leetable[String] {
    /**
      * Mapping of char to numbers
      * [a,A] -> 4
      * [e,E] -> 3
      * [i,I] -> 1
      * [o,O] -> 0
      * [s,S] -> 5
      * [t,T] -> 7
      */
    private val leetMap = Map(('a' -> '4'), ('e' -> '3'), ('i' -> '1'), ('o' -> '0'), ('s' -> '5'), ('t' -> '7'))

    override def toLeet(rawString: String) = rawString.map(char => leetMap.get(char.toLower).getOrElse(char))
  }

  println(Leet(scala.io.StdIn.readLine()))
}

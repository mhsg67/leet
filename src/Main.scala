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
}

package functions

import scala.math.sqrt
import cats.instances.int
import scala.collection.View

object QuadraticFormula {//
  // TASK:
  //      Write a test to validate the following function.
  //      List(...).sorta
  //      Array: odered list --> accessed by index

  def quadraticFormula(a: Int, b: Int, c: Int): List[Double] = {
    ???
      
  }  
       
  


  // TASK:
  //    Update the formula to compute the discriminant,
  //    and detect whether there are zero, one, or two real roots.
  //    refactor the function to return a list of length 0, 1, or 2
  //    accordingly.  If there are two roots return them in increasing
  //    order.

  // TASK:
  //    Do your tests still work?  If not, do you need to
  //    update your tests, or do you need to update the function?
  //    Make sure your tests are up to date, and that they test the
  //    new features you implemented in previous step.

  def main(argv: Array[String]): Unit = {
    println("Hello this is main of QuadraticFormula")
    println(quadraticFormula(1, 2, -3))
    println(quadraticFormula(-1, 3, 7))
  }
}

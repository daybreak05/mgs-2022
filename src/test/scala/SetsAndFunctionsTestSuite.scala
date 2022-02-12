// Permission is hereby granted, free of charge, to any person obtaining
// a copy of this software and associated documentation
// files (the "Software"), to deal in the Software without restriction,
// including without limitation the rights to use, copy, modify, merge,
// publish, distribute, sublicense, and/or sell copies of the Software,
// and to permit persons to whom the Software is furnished to do so,
// subject to the following conditions:
//
// The above copyright notice and this permission notice shall be
// included in all copies or substantial portions of the Software.
//
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
// EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
// MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
// NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
// LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
// OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
// WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

import org.scalatest.funsuite.AnyFunSuite

class SetsAndFunctionsTestSuite extends AnyFunSuite {

  import SetsAndFunctions._

  test("quadraticFormula") {
    assert(quadraticFormula(1, 0, 0) == List(0.0))
    assert(
      quadraticFormula(1, 2, 3).size == 2
    ) // assert that there are two roots
    println(quadraticFormula(1, 1, 1))
  }

  test("power") {
    assert(power(3, "x") == "xxx")
    assert(power(3, List(1, 2)) == List(1, 2, 1, 2, 1, 2))
    assert(power(3, 4.0) == 4.0 * 4.0 * 4.0)

    assert(power(0, "x") == "")
    assert(power(0, 13.0) == 1.0)
    assert(power(0, List(1, 2)) == List())
  }

  test("factorial") {
    assert(factorial(0) == 1)
    assert(factorial(1) == 1)
    assert(factorial(3) == 6)
    assert(factorial(7) == 7 * factorial(6))
  }

  test("fixedSizeSubsets") {
    assert(fixedSizedSubsets(0, Set(1, 2, 3)) == Set(Set()))
    assert(fixedSizedSubsets(1, Set(1, 2, 3)) == Set(Set(1), Set(2), Set(3)))
    assert(
      fixedSizedSubsets(2, Set(1, 2, 3)) == Set(Set(1, 2), Set(1, 3), Set(2, 3))
    )
    assert(fixedSizedSubsets(3, Set(1, 2, 3)) == Set(Set(1, 2, 3)))
    assert(
      fixedSizedSubsets(3, Set(1, 2, 3, 4)) == Set(
        Set(1, 2, 3),
        Set(1, 2, 4),
        Set(1, 3, 4),
        Set(2, 3, 4)
      )
    )
    // how many subsets of size n of a set of size 5?  = C(5,n) = 5!/(n!(5-n)!)
    assert(
      5 * 4 * 3 * 2 / (1 * (5 * 4 * 3 * 2)) == fixedSizedSubsets(
        0,
        Set(1, 2, 3, 4, 5)
      ).size
    )
    assert(
      5 * 4 * 3 * 2 / (1 * (4 * 3 * 2)) == fixedSizedSubsets(
        1,
        Set(1, 2, 3, 4, 5)
      ).size
    )
    assert(
      5 * 4 * 3 * 2 / (2 * (3 * 2)) == fixedSizedSubsets(
        2,
        Set(1, 2, 3, 4, 5)
      ).size
    )
    assert(
      5 * 4 * 3 * 2 / (3 * 2 * 2) == fixedSizedSubsets(
        3,
        Set(1, 2, 3, 4, 5)
      ).size
    )
    assert(
      5 * 4 * 3 * 2 / (4 * 3 * 2 * 1) == fixedSizedSubsets(
        4,
        Set(1, 2, 3, 4, 5)
      ).size
    )
    assert(
      5 * 4 * 3 * 2 / (4 * 4 * 3 * 2 * 1) == fixedSizedSubsets(
        5,
        Set(1, 2, 3, 4, 5)
      ).size
    )

    for {
      k <- 0 to 6
      subsets = fixedSizedSubsets(k, Set(1, 2, 3, 4, 5, 6))
    } assert(subsets.size == factorial(6) / (factorial(k) * factorial(6 - k)))
  }

  test("fibonacci") {
    assert(fibonacci(0) == 1)
    assert(fibonacci(1) == 1)
    assert(fibonacci(2) == 2)
    assert(fibonacci(3) == 3)
    assert(fibonacci(4) == 5)
    assert(fibonacci(5) == 8)
    assert(fibonacci(6) == 13)
  }

  test("setUnion") {
    // ???
    assert(setEqual(setUnion(List(1, 2, 3), List(2, 1, 5)), List(1, 2, 3, 5)))
  }

  test("setIntersection") {
    // ???
    assert(setEqual(setIntersection(List(1, 2, 3), List(2, 1, 5)), List(1, 2)))
  }

  test("setMinus") {
    assert(setEqual(setMinus(List(1, 2, 3), List(2, 1, 5)), List(3)))
  }

  test("setEqual") {
    assert(setEqual(List(1, 2, 3), List(2, 1, 3)))
  }
}

package org.example
/*
  Lab 7 Count sum of positive numbers and multiply all negative numbers using matches and cases
 */
object SumAndMul {

  def getSumOfPosAndMulOfNeg(list: List[Int]):List[Int] = list match{
    case Nil => Nil
    case list => {
      def getSumOfPos(list: List[Int], res: Int): Int = list match {
        case Nil => res
        case h :: t => if (h >= 0) getSumOfPos(t, res.+(h)) else getSumOfPos(t, res)
      }

      def getMulOfNeg(list: List[Int], res: Int): Int = list match {
        case Nil => res
        case h :: t => if (h < 0) getMulOfNeg(t, res.*(h)) else getMulOfNeg(t, res)
      }

      val resList = List(getSumOfPos(list, 0), getMulOfNeg(list, 1))
      resList
    }
  }
}

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
        case head :: tail => {
          def cmpValue(x:Int): Int = res match {
            case x if (head >= 0) => getSumOfPos(tail, res.+(head))
            case x if (head < 0) => getSumOfPos(tail, res)
          }
          cmpValue(head)
        }
      }

      def getMulOfNeg(list: List[Int], res: Int): Int = list match {
        case Nil => res
        case head :: tail => {
          def cmpValue(x:Int):Int = res match{
            case x if (head < 0) => getMulOfNeg(tail, res.*(head))
            case x if (head >= 0) => getMulOfNeg(tail, res)
          }
          cmpValue(head)
        }
      }

      val resList = List(getSumOfPos(list, 0), getMulOfNeg(list, 1))
      resList
    }
  }
}

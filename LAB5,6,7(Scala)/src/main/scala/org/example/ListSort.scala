package org.example

import scala.annotation.tailrec
/*
  Lab 5 Implement list sorting: 1.using tailrec
                                2.without tailrec
 */

object ListSort {

  def sortListTailRec(lst:List[Double]):List[Double] = {
      def insert(x: Double, sorted:List[Double]): List[Double] = sorted match {
        case Nil => x :: Nil //пустой лист
        case h :: t => if (x < h) x :: sorted else h :: insert(x, t) //сравниваем позициюю с головой x
      }

      @tailrec
      def helper(sorted:List[Double], unsorted:List[Double]):List[Double] =
        unsorted match {
          case Nil => sorted
          case h::t => helper(insert(h, sorted), t)
        }

      helper(Nil, lst)
  }


  def sortList(list: List[Int]): List[Int] = list match {
    case head :: tail =>
      val left = tail.filter(_ < head)
      val right = tail.filter(_ >= head)
      sortList(left) ++ List(head) ++ sortList(right)
    case Nil => Nil
  }


  def main(args:Array[String]): Unit = {

    sortListTailRec(List(1,53,2,22,5,12))
    sortList(List(1,53,2,22,5,12))
  }
}

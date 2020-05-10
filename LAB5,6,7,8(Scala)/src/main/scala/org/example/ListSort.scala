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
      case head :: tail =>{
        def cmpValue(x:Double): List[Double] = sorted match {
          case head :: tail if(x < head) => x :: sorted
          case head :: tail if(x > head) => head :: insert(x, tail)
        }
        cmpValue(x)
      }
    }

    def getSortedList(sorted:List[Double], unsorted:List[Double]):List[Double] =
      unsorted match {
        case Nil => sorted
        case head::tail => getSortedList(insert(head, sorted), tail)
      }
    getSortedList(Nil, lst)
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

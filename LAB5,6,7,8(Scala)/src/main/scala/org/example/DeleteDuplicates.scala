package org.example
import scala.collection.mutable
/*
  Lab 6 Delete all duplicates in collections using high order functions
 */
object DeleteDuplicates {
  def check(list_h:Int,list_t:List[Int]):List[Int] ={
    list_t.filterNot(_==list_h)
  }

  def delAllDuplicates(elements:List[Int]):List[Int] = elements match {
    case Nil => elements
    case head::tail => head :: delAllDuplicates(check(head,tail))
  }
}

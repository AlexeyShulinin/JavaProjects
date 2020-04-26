package org.example.unit

import org.example.ListSort
import org.scalatest.{FlatSpec, Matchers}


class ExampleSpec extends FlatSpec with Matchers{

  behavior of "sortListTailRec"
  it should "sort List using tailrec" in {
    ListSort.sortListTailRec(List(1,53,2,22,5,12)) shouldEqual List(1,2,5,12,22,53)
  }

  behavior of "sortListTailRec"
  it should "sort List using tailrec 0" in {
    ListSort.sortListTailRec(Nil) shouldEqual Nil
  }

  behavior of "sortList"
  it should "sort List" in{
    ListSort.sortList(List(1,53,2,22,5,12)) shouldEqual List(1,2,5,12,22,53)
  }

  behavior of "sortList"
  it should "sort List 0" in{
    ListSort.sortList(Nil) shouldEqual Nil
  }

}

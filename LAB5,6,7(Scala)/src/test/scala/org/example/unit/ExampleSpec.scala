package org.example.unit

import org.example.{DeleteDuplicates, ListSort, SumAndMul}
import org.scalatest.{FlatSpec, Matchers}


class ExampleSpec extends FlatSpec with Matchers{
  //------------LAB 5-----------TESTS------------------------------------------------
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
  //------------LAB 6-----------TESTS------------------------------------------------
  behavior of "DeleteDuplicates"
  it should "delete all duplicates in collection" in{
    DeleteDuplicates.delAllDuplicates(List(1,3,3,3,5,6,7,8,5,3,5)) shouldEqual List(1,3,5,6,7,8)
  }

  behavior of "DeleteDuplicates without any numbers"
  it should "it should be Nil" in{
    DeleteDuplicates.delAllDuplicates(Nil) shouldEqual Nil
  }

  //------------LAB 7-----------TESTS------------------------------------------------
  behavior of "Getting sum of positive and multiply of negative"
  it should "It should be list with two results" in{
    SumAndMul.getSumOfPosAndMulOfNeg(List(1,3,-10,15,-200,300,-13)) shouldEqual(List(319,-26000))
  }

  behavior of "Getting sum of positive and multiply of negative"
  it should "It should be list with only sum result and mul res == 1" in{
    SumAndMul.getSumOfPosAndMulOfNeg(List(1,3,15,300)) shouldEqual(List(319,1))
  }

  behavior of "Getting sum of positive and multiply of negative"
  it should "It should be list with only mul result and sum res == 0" in{
    SumAndMul.getSumOfPosAndMulOfNeg(List(-10,-200,-13)) shouldEqual(List(0,-26000))
  }

  behavior of "Getting sum of positive and multiply of negative without any numbers"
  it should "It should be Nil" in{
    SumAndMul.getSumOfPosAndMulOfNeg(Nil) shouldEqual(Nil)
  }
}

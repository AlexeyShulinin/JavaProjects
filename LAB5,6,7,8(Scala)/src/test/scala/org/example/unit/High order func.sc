import scala.collection.generic.CanBuildFrom
import scala.collection.mutable
import scala.collection.mutable.ListBuffer

def math(x:Int,y:Int,f:(Int,Int)=>Int): Int = f(x,y);

math(4,70,(x,y) => x+y)
math(4,70,(x,y) => x*y)
math(4,70,(x,y) => x min y)

Set(1,1,2)



val l = List(1,3,3,3,5,6,7,8,5,3,5)

def check(list_h:Int,list_t:List[Int]):List[Int] ={
    list_t.filterNot(_==list_h)
}

def delAllDuplicates(elements:List[Int]):List[Int] = elements match {
  case Nil => elements
  case head::tail => head :: delAllDuplicates(check(head,tail))
}


delAllDuplicates(l)


def getSumOfPos(list: List[Int],res: Int):Int = list match{
  case Nil => res
  case h::t => if(h >= 0) getSumOfPos(t,res.+(h)) else getSumOfPos(t,res)
}

def getMulOfNeg(list: List[Int],res: Int):Int = list match {
  case Nil => res
  case h::t => if(h < 0) getMulOfNeg(t,res.*(h)) else getMulOfNeg(t,res)
}

val l1 = List(1,3,-10,15,-200,300,-13)
getSumOfPos(l1,0)
getMulOfNeg(l1,1)

getMulOfNeg(Nil,1)
getSumOfPos(Nil,0)
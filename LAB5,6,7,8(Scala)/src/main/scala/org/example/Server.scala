package org.example

import akka.actor.{Actor, ActorSystem, Props}

import scala.collection.mutable.ArrayBuffer

class User(log:String,pass:String){
  lazy val login = log
  lazy val password = pass
}

object Server extends App {
  class MyLog extends Actor {

    val users = ArrayBuffer.empty[User]

    def changePass(arrUsers:ArrayBuffer[User],login:String, newPassword:String,iter:Int):Boolean = users match {
      case users if (iter+1 == users.size) => false
      case users if(users(iter).login == login) => {
        users.update(iter, new User(login, newPassword))
        true
      }
      case users if(users(iter).login != login) => changePass(users.tail,login,newPassword,iter+1)
    }

    def printAllUsers(iter:Int):Unit = {
      if(iter != users.size) {
        println( users(iter).login + " " + users(iter).password)
        printAllUsers(iter+1)
      }
    }

    def authorization(login:String,pass:String,iter:Int):Boolean = users match{
      case users if(iter+1 == users.size) => false
      case users if(users(iter).login == login && users(iter).password == pass) => true
      case users if(users(iter).login != login || users(iter).password != pass) => authorization(login,pass,iter+1)
    }

    override def receive: Receive = {
      case AddNewUser(login, pass) => {
        val tmp = new User(login,pass)
        users += tmp
        println("User added: ", login + " " + pass)
      }
      case ChangePassword(login,newPassword) =>{
        changePass(users,login,newPassword,0)
        println("Password changed: ", login + " " + newPassword)
      }
      case GetUsers => printAllUsers(0)
      case Authorization(login,pass) => println(authorization(login,pass,0))
    }
  }
}
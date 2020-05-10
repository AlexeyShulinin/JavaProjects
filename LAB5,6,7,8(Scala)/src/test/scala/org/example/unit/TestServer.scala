package org.example.unit

import akka.actor.{ActorSystem, Props}
import org.example.Server.MyLog
import org.example.{AddNewUser, Authorization, ChangePassword, GetUsers}
import org.scalatest.{FlatSpec, Matchers}

class TestServer extends FlatSpec with Matchers{
  implicit val system = ActorSystem("ExampleSystem")

  val client = system.actorOf(Props(new MyLog))

  behavior of "AddUsers:test1"
  it should "Add new user with login and password" in {
    client ! AddNewUser("Aleksey", "qwerty")
  }

  behavior of "AddUsers:test2"
  it should "Add new user with login and password" in {
    client ! AddNewUser("Roman", "12345")
  }
  behavior of "AddUsers:test3"
  it should "Add new user with login and password" in {
    client ! AddNewUser("Evgenij", "qwer123")
  }

  behavior of "ChangePassword:test1"
  it should "It should change pass by login" in {
    client ! ChangePassword("Aleksey","11111")
  }

  behavior of "ChangePassword:test2"
  it should "It should change pass by login" in {
    client ! ChangePassword("XXXXX","11111")
  }

  behavior of "Authorization:test1"
  it should "Authorization of users by correct login and password" in {
    client ! Authorization("Aleksey","11111")
  }

  behavior of "Authorization:test2"
  it should "Authorization of users by correct login and password" in {
    client ! Authorization("Roman","12345")
  }

  behavior of "Authorization:test3"
  it should "Authorization of users by correct login and password: illegal authorization" in {
    client ! Authorization("Aleksey","123")
  }


}

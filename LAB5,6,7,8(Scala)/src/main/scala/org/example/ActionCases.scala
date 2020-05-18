package org.example

import akka.actor.{Actor, ActorSystem, Props}

case class AddNewUser(login:String, pass:String)
case class ChangePassword(login:String, newPassword:String)
case class GetUsers()
case class Authorization(login:String, pass:String)






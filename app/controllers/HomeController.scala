package controllers

import play.api.mvc._
import services.DummyService

import scala.concurrent.ExecutionContext

class HomeController(implicit ec: ExecutionContext) extends Controller {

  def index = Action.async {
    DummyService.doSomething.map(Ok(_))
  }

}

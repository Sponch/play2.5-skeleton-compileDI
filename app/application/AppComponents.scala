package application

import akka.actor.Scheduler
import application.filters.ExampleFilter
import com.typesafe.config.Config
import controllers.HomeController
import play.api.ApplicationLoader.Context
import play.api.BuiltInComponentsFromContext
import play.api.cache.EhCacheComponents
import router.Routes

import scala.concurrent.ExecutionContext

/**
  *
  */
class AppComponents(context: Context)(implicit val ec: ExecutionContext)
    extends BuiltInComponentsFromContext(context)
    with EhCacheComponents {

  val config: Config                = context.initialConfiguration.underlying
  implicit val scheduler: Scheduler = actorSystem.scheduler

  lazy val homeController = new HomeController()

  // order matters - should be the same as routes file
  lazy val router = new Routes(
    httpErrorHandler,
    homeController
  )

  val exampleFilter: ExampleFilter = new ExampleFilter()

  override lazy val httpFilters = Seq(exampleFilter)
}

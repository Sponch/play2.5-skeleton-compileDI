package commons

/**
  *
  */
import java.io.File

import akka.actor.{ActorSystem, Scheduler}
import akka.stream.ActorMaterializer
import application.{AppComponents, AppLoader}
import com.typesafe.config.Config
import play.api.ApplicationLoader.Context
import play.api.cache.CacheApi
import play.api.{Application, ApplicationLoader, Configuration, Environment, Mode}

import scala.concurrent.ExecutionContext

trait TestAppComponents {

  lazy implicit val actorSystem: ActorSystem = ActorSystem.create("test")
  lazy implicit val scheduler: Scheduler     = actorSystem.scheduler
  lazy implicit val ec: ExecutionContext     = play.api.libs.concurrent.Execution.defaultContext
  lazy val environment: Environment =
    new Environment(new File("."), ApplicationLoader.getClass.getClassLoader, Mode.Test)
  lazy val config: Config                           = Configuration.load(environment).underlying
  lazy implicit val materializer: ActorMaterializer = ActorMaterializer()
  lazy val context: Context                         = ApplicationLoader.createContext(environment)
  lazy val appLoader: AppLoader                     = new AppLoader()
  lazy val components: AppComponents                = new AppComponents(context)
  lazy val application: Application                 = appLoader.load(context)
  lazy val authCache: CacheApi                      = components.cacheApi("auth-cache-test")
}

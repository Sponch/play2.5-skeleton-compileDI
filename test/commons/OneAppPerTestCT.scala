package commons

import application.AppLoader
import org.scalatest.TestSuite
import org.scalatestplus.play.guice.GuiceOneAppPerSuite
import play.api.Application

trait OneAppPerSuiteCT extends GuiceOneAppPerSuite with TestAppComponents { this: TestSuite =>
  override def fakeApplication(): Application =
    (new AppLoader).load(context)
}

package gatlingtest

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class SequentialAccessSimulation extends Simulation {

  // Define the base URL
  val httpProtocol = http
    .baseUrl("http://localhost:8080") // Base URL
    .header("Accept", "application/json")

  // Define the scenario for accessing /product followed by /cart
  val userFlowScenario = scenario("User Flow Scenario")
    .exec(http("Request /product")
      .get("/product")
      .check(status.is(200)))
    .pause(1.second, 2.seconds) // Pause for a random duration between 1 and 2 seconds
    .exec(http("Request /cart")
      .get("/cart")
      .check(status.is(200)))
    .pause(1.second, 2.seconds) // Pause for a random duration between 1 and 2 seconds

  // Define user load
  setUp(
    userFlowScenario.inject(
      atOnceUsers(100)
    )
  ).protocols(httpProtocol) // Apply the HTTP configuration
}


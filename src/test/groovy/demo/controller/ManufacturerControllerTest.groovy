package demo.controller

import demo.service.ManufacturerService
import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.reactive.server.WebTestClient
import spock.lang.Specification

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ManufacturerControllerTest extends Specification {

  @SpringBean
  ManufacturerService manufacturerService = Mock(ManufacturerService)

  @Autowired
  WebTestClient webClient

  def "fetchManufacturer"() {
    expect:
    this.webClient.get().uri("/").exchange().expectBody(String).isEqualTo('["audi","ford"]')
  }
}


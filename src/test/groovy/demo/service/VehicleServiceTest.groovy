package demo.service

import demo.domain.Manufacturer
import grails.gorm.transactions.Transactional
import org.hibernate.HibernateException
import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
@Transactional
class VehicleServiceTest extends Specification {

  @Autowired
  VehicleService vehicleService
  @Autowired
  ManufacturerService manufacturerService
  @SpringBean
  DummyService1 dummyService1 = Mock(DummyService1)

  def "test"() {
    when:
    def manufacturer = new Manufacturer(name: "aldi", quantity: 200)
    manufacturer.save(flush: true, failOnError: true)
    vehicleService.saveOrUpdate("abc", 2022, manufacturer)

    then:
    notThrown(HibernateException)
  }

}

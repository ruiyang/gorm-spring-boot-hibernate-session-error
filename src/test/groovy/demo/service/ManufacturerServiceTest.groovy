package demo.service

import grails.gorm.transactions.Transactional
import org.hibernate.HibernateException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
@Transactional
class ManufacturerServiceTest extends Specification {

  @Autowired
  ManufacturerService manufacturerService
  def "test"() {
    when:
    manufacturerService.saveOrUpdate("abc", 200)
    then:
    notThrown(HibernateException)
  }

}

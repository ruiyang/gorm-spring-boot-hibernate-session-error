package demo.service

import demo.domain.Manufacturer
import grails.gorm.transactions.ReadOnly
import grails.gorm.transactions.Transactional
import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
@Transactional
class ManufacturerService {

  @Autowired
  DummyService1 dummyService1
  @Autowired
  DummyService2 dummyService2
  @Autowired
  VehicleService vehicleService

  def save(Manufacturer manufacturer) {
    manufacturer.save(flush: true, failOnError: true)
  }
  List<Manufacturer> findAll() {
    Manufacturer.findAll()
  }

  def saveOrUpdate(String name, Integer quantity) {
    dummyService1.print()
    dummyService2.print()
    def manufacturer = Manufacturer.saveOrUpdate(name, quantity)
    vehicleService.saveOrUpdate("ttt", 100, manufacturer)
  }
}

package demo.service

import demo.domain.Manufacturer
import demo.domain.Vehicle
import grails.gorm.services.Where
import grails.gorm.transactions.Transactional
import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
@Transactional
class VehicleService {

  @Autowired
  DummyService1 dummyService1
  @Autowired
  DummyService2 dummyService2

  List<Vehicle> findAll() {
    Vehicle.findAll()
  }

  void saveOrUpdate(String name, year, Manufacturer manufacturer) {
    dummyService1.print()
    dummyService2.print()

    Vehicle.saveOrUpdate(name, year, manufacturer)
  }


}

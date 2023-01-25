package demo.service

import grails.gorm.transactions.Transactional
import org.springframework.stereotype.Service

@Service
@Transactional
class DummyService2 {

  void print() {
    println "DummyService2"
  }

}

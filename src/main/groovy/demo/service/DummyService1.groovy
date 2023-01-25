package demo.service;

import org.springframework.stereotype.Service;
import grails.gorm.transactions.Transactional;

@Service
@Transactional
class DummyService1 {

  void print() {
    println "DummyService1"
  }

}

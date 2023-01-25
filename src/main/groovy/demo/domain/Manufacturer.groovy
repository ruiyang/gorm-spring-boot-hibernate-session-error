package demo.domain

import grails.gorm.annotation.Entity
import groovy.transform.ToString
import org.grails.datastore.gorm.GormEntity

@ToString
@Entity
class Manufacturer implements GormEntity<Manufacturer> {

    String name
    Integer quantity

    static hasMany = [vehicles: Vehicle]

    static constraints = {
        name blank: false
    }

    static saveOrUpdate(String name, quantity) {
        def man = Manufacturer.findOrCreateByName(name)
        man.quantity = quantity
        man.save(flush: true, failOnError: true)
    }
}

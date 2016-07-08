package com.dev.web.extr.app;

import com.dev.web.extr.model.entity.City;
import com.dev.web.extr.service.CityService;
import java.util.List;

/**
 *
 * @author javad
 */
public class TestModel {

    public static void main(String[] args) {
        CityService cityService = new CityService();
        City city1 = new City();
        city1.setName("Qom");
        City city2 = new City();
        city2.setName("Tehran");
        City city3 = new City();
        city3.setName("Iran");
        System.out.println("*** Persist - start ***");
        cityService.persist(city1);
        cityService.persist(city2);
        cityService.persist(city3);
        List<City> citys1 = cityService.findAll();
        System.out.println("Citys Persisted are :");
        for (City b : citys1) {
            System.out.println("-" + b.toString());
        }
        System.out.println("*** Persist - end ***");
        System.out.println("*** Update - start ***");
        city1.setName("The Idiot");
        cityService.update(city1);
        System.out.println("City Updated is =>" + cityService.findById(city1.getId()).toString());
        System.out.println("*** Update - end ***");
        System.out.println("*** Find - start ***");
        Integer id1 = city1.getId();
        City another = cityService.findById(id1);
        System.out.println("City found with id " + id1 + " is =>" + another.toString());
        System.out.println("*** Find - end ***");
        System.out.println("*** Delete - start ***");
        Integer id3 = city3.getId();
        cityService.delete(id3);
        System.out.println("Deleted city with id " + id3 + ".");
        System.out.println("Now all citys are " + cityService.findAll().size() + ".");
        System.out.println("*** Delete - end ***");
        System.out.println("*** FindAll - start ***");
        List<City> citys2 = cityService.findAll();
        System.out.println("Citys found are :");
        for (City b : citys2) {
            System.out.println("-" + b.toString());
        }
        System.out.println("*** FindAll - end ***");
        System.out.println("*** DeleteAll - start ***");
        cityService.deleteAll();
        System.out.println("Citys found are now " + cityService.findAll().size());
        System.out.println("*** DeleteAll - end ***");
        System.exit(0);
    }
}

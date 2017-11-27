//package com.assignment3.controller;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.assignment3.dao.PersonDAO;
//import com.assignment3.model.Person;
//
//@Controller
//@RequestMapping(value = "/person")
//public class PersonController {
//	@Autowired
//    private PersonDAO personDao;
//
//    @RequestMapping(value = "/delete")
//    @ResponseBody
//    public String delete(long id) {
//        try {
//            Person person = new Person();
//            person.setId(id);
//            personDao.delete(person);
//        } catch (Exception ex) {
//            return ex.getMessage();
//        }
//        return "Person succesfully deleted!";
//    }
//
//    @RequestMapping(value = "/save" ,method = RequestMethod.POST )
//    @ResponseBody
//    public Person create(@RequestBody Person person) {
//      
////            Person person = new Person();
////            person.setName(name);
////            person.setCity(city);
//            personDao.savePerson(person);
//        return person;
//    }
//    @RequestMapping(value = "/allPersons")
//    @ResponseBody
//    public List<Person> getAllPersons() {
//        try {
//            return personDao.getAllPersons();
//        } catch (Exception ex) {
//            return null;
//        }
//    }
//}

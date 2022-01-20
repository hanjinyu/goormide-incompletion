package iotnetwork.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import finaltest.model.EmpEntity;
import finaltest.repository.EmpRepository;
import finaltest.service.EmpService;
import finaltest.model.EmpParam;

import javax.validation.Valid;

@RestController
@RequestMapping(value="/dataProcess")
public class EmpController {
    
   @Autowired
   EmpService empService;
    
        

    @RequestMapping(value="/EmpCreate", method=RequestMethod.POST)
    public ResponseEntity createEmp(@Valid EmpParam ep) {
       empService.add(ep);
        return ResponseEntity.ok("Insert Success!!");
    }
    
    @RequestMapping(value="/empLists", method=RequestMethod.GET)
    public ResponseEntity listEmp() throws Exception {
        return ResponseEntity.ok(empService.getEmpList());
    }
    
    @RequestMapping(value="/empLists/{id}", method=RequestMethod.GET)
    public ResponseEntity listEmpItem(@PathVariable("id") Long id) throws Exception {
        return ResponseEntity.ok(empService.getEmpItem(id));
    }
    
    
    @RequestMapping(value="/empUpdate/{id}", method=RequestMethod.PUT)
    public ResponseEntity updateEmp(@Valid EmpParam ep,
                                    @PathVariable("id") Long id) throws Exception {
        ep.setId(id);
        empService.update(ep);
        return ResponseEntity.ok("Update Success");
    }
    
    @RequestMapping(value="/empDelete/{id}", method=RequestMethod.DELETE)
    public ResponseEntity deleteEmp(@PathVariable("id") Long id) throws Exception{
        empService.delete(id);
        return ResponseEntity.ok("Delete Success");
    }
}

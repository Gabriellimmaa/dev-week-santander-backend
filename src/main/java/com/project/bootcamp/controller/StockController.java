package com.project.bootcamp.controller;

import com.project.bootcamp.model.dto.StockDTO;
import com.project.bootcamp.service.StockService;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid; //Valida as informações recebidas

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin //Essencial para o front para nao da erro de crossOrigin
@RestController
@RequestMapping(value = "/stock")
public class StockController {

    @Autowired
    private StockService service;

    //consumes é o que vai receber e como
    //produces é o que vai retornar e como

    //POST
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> save(@Valid @RequestBody StockDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    //PUT
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> update(@Valid @RequestBody StockDTO dto){
        return ResponseEntity.ok(service.update(dto));
    }

    //GET
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StockDTO>> findALL(){
        return ResponseEntity.ok(service.findAll());

    }

    //GET
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    //DELETE
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> delete(@PathVariable Long id){
        return ResponseEntity.ok(service.delete(id));
    }

    //GET
    @GetMapping(value = "/today", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StockDTO>> findByToday(){
        return ResponseEntity.ok(service.findByToday());
    }

}

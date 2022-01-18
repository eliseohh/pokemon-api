package com.modyo;

import com.modyo.controller.BerriesController;
import com.modyo.response.berry.BerryResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/berry")
public class SpringBerryController {
    private final BerriesController controller;

    public SpringBerryController(BerriesController controller) {
        this.controller = controller;
    }

    @GetMapping("/{id}")
    public BerryResponse getBerries(@PathVariable("id") String id){
        return controller.berries(id);
    }

    @GetMapping("/")
    public ResponseEntity<Object> getBerries(){
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

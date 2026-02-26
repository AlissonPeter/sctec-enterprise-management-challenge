package sctec.enterprise.management.challenge.controller;

import org.springframework.web.bind.annotation.*;
import sctec.enterprise.management.challenge.model.Enterprise;

import java.util.List;

@RestController
@RequestMapping("/enterprises")
@CrossOrigin(origins = "*")
public class EnterpriseController {

    @GetMapping("{id}")
    public Enterprise getById(@PathVariable Integer id) {
        return null;
    }

    @PostMapping
    public Enterprise create(@RequestBody Enterprise enterprise) {
        return null;
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Integer id) {
    }

    @PutMapping("{id}")
    public void update(@RequestParam Enterprise enterprise) {
    }

    @GetMapping("/all")
    public List<Enterprise> getAll() {
        return null;
    }
}

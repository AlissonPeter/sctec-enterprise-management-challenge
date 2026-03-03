package sctec.enterprise.management.challenge.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sctec.enterprise.management.challenge.model.Enterprise;
import sctec.enterprise.management.challenge.service.EnterpriseService;

import java.util.List;

/**
 * REST API EnterpriseController class
 */
@RestController
@RequestMapping("/enterprises")
@CrossOrigin(origins = "*")
public class EnterpriseController {

    @Autowired
    private EnterpriseService service;

    /**
     * Return Enterprise by Id
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        try {
            Enterprise enterprise = service.findById(id);
            return ResponseEntity.ok(enterprise);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    /**
     * Save new Enterprise
     * @param enterprise
     * @return
     */
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Enterprise enterprise) {
        try {
            Enterprise saved = service.saveOrUpdate(enterprise);
            return ResponseEntity.status(HttpStatus.CREATED).body(saved);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    /**
     * Delete Enterprise by Id
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id) {
        try {
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            // Se o erro for de integridade (vínculo), o status 409 Conflict é bem adequado
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    /**
     * Update Enterprise existing in the DB
     * @param enterprise
     * @return
     */
    @PutMapping
    public ResponseEntity<?> update(@RequestBody Enterprise enterprise) {
        try {
            // 1. Validar se o ID foi enviado, senão o findById vai dar erro
            if (enterprise.getId() == null) {
                return ResponseEntity.badRequest().body("ID do empreendimento é obrigatório para atualização.");
            }

            // 2. Busca o registro atual no banco
            Enterprise enterpriseOld = service.findById(enterprise.getId());

            // 3. Copia as propriedades (exceto o ID, que já é o mesmo)
            BeanUtils.copyProperties(enterprise, enterpriseOld, "id");

            // 4. Salva a entidade atualizada
            Enterprise updated = service.saveOrUpdate(enterpriseOld);

            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            // Captura o "não encontrado" que vem do Service
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    /**
     * returns all enterprises registered in the DB.
     * @return
     */
    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        try {
            List<Enterprise> list = service.findAll();
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao listar empreendimentos.");
        }
    }
}
package sctec.enterprise.management.challenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;
import sctec.enterprise.management.challenge.model.Enterprise;
import sctec.enterprise.management.challenge.repository.EnterpriseRepository;

import java.util.List;

public class EnterpriseService {

    @Autowired
    private EnterpriseRepository repository;

    /**
     * Find Enterprise by id
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    public Enterprise findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("enterprise not found"));
    }

    /**
     * Save or update enterprise
     * @param enterprise
     */
    @Transactional
    public Enterprise saveOrUpdate(Enterprise enterprise) {
        try {
            // Aqui o Spring tenta persistir no banco
            return repository.save(enterprise);
        } catch (DataIntegrityViolationException e) {
            // Esse erro acontece se violar uma constraint do banco (ex: campo nulo)
            throw new RuntimeException("Erro de integridade: Verifique se todos os campos obrigatórios foram preenchidos.");
        } catch (Exception e) {
            // Captura qualquer outro erro inesperado
            throw new RuntimeException("Erro interno ao salvar o empreendimento: " + e.getMessage());
        }
    }

    /**
     * Delete enterprise by id
     * @param id
     */
    @Transactional
    public void deleteById(Integer id) {
        try {
            // 1. Verifica se o ID existe antes de tentar deletar (Evita erro 500 atoa)
            if (!repository.existsById(id)) {
                throw new RuntimeException("Não foi possível deletar: Empreendimento com ID " + id + " não encontrado.");
            }
            repository.deleteById(id);
        } catch (Exception e) {
            // Qualquer outro erro (banco fora do ar, etc)
            throw new RuntimeException("Ocorreu um erro inesperado ao tentar excluir o empreendimento.");
        }
    }

    /**
     * Return enterprise list
     * @return
     */
    @Transactional(readOnly = true)
    public List<Enterprise> findAll() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Ocorreu um erro inesperado ao tentar buscar os empreendimentos.");
        }
    }
}

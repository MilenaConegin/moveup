
package br.com.fiap.resource;

import br.com.fiap.bo.HistoricoBO;
import br.com.fiap.to.HistoricoTO;
import br.com.fiap.to.UsuarioTO;
import br.com.fiap.to.VoucherTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/moveup/historico")
public class HistoricoResource {

    private HistoricoBO historicoBO = new HistoricoBO();

    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid HistoricoTO historico) {
        try {
            HistoricoTO resultado = historicoBO.save(historico);
            return ResponseEntity.status(HttpStatus.CREATED).body(resultado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao salvar histórico");
        }
    }

    @GetMapping
    public ResponseEntity<List<HistoricoTO>> findAll() {
        List<HistoricoTO> historicos = historicoBO.findAll();
        if (historicos != null){
            return  ResponseEntity.status(HttpStatus.OK).body(historicos);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(historicos);
        }
    }

    @GetMapping("/{idHistorico}")
    public ResponseEntity<?> findById(@PathVariable Integer idHistorico) {
        HistoricoTO historico = historicoBO.findById(idHistorico);
        if (historico != null){
            return ResponseEntity.status(HttpStatus.OK).body(historico);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Histórico não encontrado!");
        }
    }

    @DeleteMapping("/{idHistorico}")
    public ResponseEntity<String> delete(@PathVariable Integer idHistorico) {
        if (historicoBO.delete(idHistorico)){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Histórico deletado com sucesso!");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Histórico não encontrado!");
        }
    }

    @PutMapping("/{idHistorico}")
    public ResponseEntity<?> update(@PathVariable Integer idHistorico, @RequestBody @Valid HistoricoTO historico) {
        try{
            historico.setIdHistorico(idHistorico);
            HistoricoTO resultado = historicoBO.update(historico);
            return ResponseEntity.status(HttpStatus.CREATED).body(resultado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao atualizar histórico");
        }
    }

}

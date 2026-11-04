package br.com.fiap.resource;

import br.com.fiap.bo.VoucherBO;
import br.com.fiap.to.VoucherTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/moveup/voucher")
public class VoucherResource {

    private VoucherBO voucherBO = new VoucherBO();

    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid VoucherTO voucher) {
        try {
            VoucherTO resultado = voucherBO.save(voucher);
            return ResponseEntity.status(HttpStatus.CREATED).body(resultado);
        } catch (Exception e) {
           // return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao salvar voucher");
            e.printStackTrace();

            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Erro ao salvar voucher: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<VoucherTO>> findAll(){
        List<VoucherTO> vouchers = voucherBO.findAll();
        if (vouchers != null){
            return  ResponseEntity.status(HttpStatus.OK).body(vouchers);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(vouchers);
        }
    }

    @GetMapping("/{cdCartao}")
    public ResponseEntity<?> findByCd(@PathVariable Integer cdCartao){
        VoucherTO voucher = voucherBO.findByCd(cdCartao);
        if (voucher != null){
            return ResponseEntity.status(HttpStatus.OK).body(voucher);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Voucher não encontrado!");
        }
    }

    @DeleteMapping ("/{cdCartao}")
    public ResponseEntity<String> delete(@PathVariable Integer cdCartao){
        if (voucherBO.delete(cdCartao)){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Voucher deletado com sucesso!");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Voucher não encontrado!");
        }
    }

    @PutMapping("/{cdCartao}")
    public ResponseEntity<?> update(@PathVariable Integer cdCartao, @RequestBody @Valid VoucherTO voucher){
        try{
            voucher.setCdCartao(cdCartao);
            VoucherTO resultado = voucherBO.update(voucher);
            return ResponseEntity.status(HttpStatus.CREATED).body(resultado);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao atualizar voucher");
        }
    }
}

package fit.controller;

import fit.domain.Person;
import fit.service.IrpfCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

@RestController
@RequestMapping("/irpf")
public class IrpfController {

    @Autowired
    private IrpfCalculatorService service;

    @PostMapping("/calculate/{year}")
    public String calculateImc(@RequestBody Person personInput, @PathVariable int year) {
        var valorImposto = service.calculate(personInput, year);
        return "O imposto do ano de " + year + " é de: "
                + BigDecimal.valueOf(valorImposto).setScale(2, RoundingMode.HALF_UP);
    }

}

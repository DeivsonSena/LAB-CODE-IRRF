package fit.service;

import fit.core.IrpfCalculator;
import fit.domain.Person;
import org.springframework.stereotype.Service;

@Service
public class IrpfCalculatorService {


    public double calculate(Person personInput, int year) {
        var valorIrpf = new IrpfCalculator(year, personInput).calculate();
        return valorIrpf <=0 ? 0.0 : valorIrpf;
    }
}

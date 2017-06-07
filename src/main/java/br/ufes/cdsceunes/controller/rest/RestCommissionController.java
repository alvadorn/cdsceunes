package br.ufes.cdsceunes.controller.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufes.cdsceunes.model.Commission;
import br.ufes.cdsceunes.repository.CommissionRepository;

@RequestMapping("/api/v1/commissions")
@RestController
public class RestCommissionController extends AbstractController<Commission, CommissionRepository> {

}

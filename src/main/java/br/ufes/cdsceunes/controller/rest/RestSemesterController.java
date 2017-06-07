package br.ufes.cdsceunes.controller.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufes.cdsceunes.model.Semester;
import br.ufes.cdsceunes.repository.SemesterRepository;

@RequestMapping("/api/v1/semesters")
@RestController
public class RestSemesterController extends AbstractController<Semester, SemesterRepository> {


}

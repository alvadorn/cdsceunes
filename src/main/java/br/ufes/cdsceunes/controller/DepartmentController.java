package br.ufes.cdsceunes.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufes.cdsceunes.dao.DepartmentDAO;
import br.ufes.cdsceunes.model.Department;

@Controller
@Transactional
@RequestMapping("/departments")
@RestController
public class DepartmentController extends AbstractController {

	@Autowired
	private DepartmentDAO departments;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<Department>> list() {
		List<Department> departs = departments.list();
		if (departs.isEmpty()) {
			return new ResponseEntity<List<Department>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Department>>(departs, HttpStatus.OK);
	}

	@RequestMapping(value = "/form", name = "addDepartment")
	public ModelAndView form(@ModelAttribute Department department) {
		ModelAndView mad = new ModelAndView("department/form");
		return mad;
	}

	@RequestMapping(method = RequestMethod.POST, name = "createDepartment", value = "save")
	public ModelAndView save(@ModelAttribute("department") @Valid Department department, BindingResult binding,
			RedirectAttributes redirectAttributes) {
		if (binding.hasErrors()) {
			return form(department);
		}
		departments.save(department);
		redirectAttributes.addFlashAttribute("sucess", "Departamento cadastrado com sucesso!");
		return new ModelAndView("redirect:");
	}
}

package br.ufes.cdsceunes.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Discipline extends AbstractModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String name;
	@NotBlank
	private String course;
	@NotBlank
	@OneToMany
	private List<String> semesters;
	@NotBlank
	private int teoricLoad;
	@NotBlank
	private int exerciseLoad;
	@NotBlank
	private int labLoad;
	
	
	/* Getters and Setters */
	
	public int getTeoricLoad() {
		return teoricLoad;
	}
	public void setTeoricLoad(int teoricLoad) {
		this.teoricLoad = teoricLoad;
	}
	public int getExerciseLoad() {
		return exerciseLoad;
	}
	public void setExerciseLoad(int exerciseLoad) {
		this.exerciseLoad = exerciseLoad;
	}
	public int getLabLoad() {
		return labLoad;
	}
	public void setLabLoad(int labLoad) {
		this.labLoad = labLoad;
	}
	public List<String> getSemesters() {
		return semesters;
	}
	public void setSemesters(List<String> semesters) {
		this.semesters = semesters;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	
	

}
package iso3.pt.service;

import java.util.List;
import java.util.Set;

import iso3.pt.dao.UserNotFoundException;
import iso3.pt.dao.IncorrectPasswordException;

import iso3.pt.model.Alumno;
import iso3.pt.model.Asignatura;
import iso3.pt.model.Evaluacion;
import iso3.pt.model.Profesor;
import iso3.pt.model.Unidad;

public interface PtService {
	public Profesor getProfesor(int idAsignatura);
	public Set<Alumno> getAlumnos(int idAsignatura);
	public List<Evaluacion> getEvaluacionesOrderedByAsignatura(int idAlumno);
	public Set<Evaluacion> getEvaluaciones(int idAsignatura, int idAlumno);
	public void addEvaluacion(String concepto, float nota, int idAsignatura, int idAlumno);
	public Set<Unidad> getUnidades(int idAsignatura);
	public Set<Asignatura> getAsignaturas();	
	public Alumno getAlumno(int id);
	public Asignatura getAsignatura(int id);
	public Alumno loginAlumno(int dni, String password) throws UserNotFoundException, IncorrectPasswordException;
	public Set<Asignatura> getAsignaturas(int idAlumno);
	public void matricular(int idAlumno, int idAsignatura);
	public void desmatricular(int idAlumno, int idAsignatura);
	public Profesor loginProfesor(int dni, String pass) throws UserNotFoundException, IncorrectPasswordException;
	public Set<Asignatura> getAsignaturasProfesor(int idProfesor);
	public Profesor getProfesorByDni(int dni) throws UserNotFoundException;
	public List<Evaluacion> getEvaluacionesAsignatura(int idAsignatura);
}

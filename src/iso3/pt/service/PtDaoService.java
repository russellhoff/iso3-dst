package iso3.pt.service;

import java.util.List;
import java.util.Set;

import iso3.pt.dao.PtDAO;
import iso3.pt.dao.UserNotFoundException;
import iso3.pt.dao.IncorrectPasswordException;

import iso3.pt.model.Alumno;
import iso3.pt.model.Asignatura;
import iso3.pt.model.Evaluacion;
import iso3.pt.model.Profesor;
import iso3.pt.model.Unidad;

public class PtDaoService implements PtService {
    private PtDAO dao;

    public PtDaoService() {
        this.dao = PtDAO.getPtDao();
    }
	
	public Set<Asignatura> getAsignaturas() {
		return dao.getAsignaturas();
	}
	
	public Set<Asignatura> getAsignaturas(int idAlumno) {
		return dao.getAsignaturas(idAlumno);
	}
	
	public Set<Unidad> getUnidades(int idAsignatura) {
		return dao.getUnidades(idAsignatura);
	}
	
	public Profesor getProfesor(int idAsignatura) {
		return dao.getProfesor(idAsignatura);
	}
	
	public void matricular(int idAlumno, int idAsignatura) {
		dao.matricular(idAlumno, idAsignatura);
	}
	
	public void desmatricular(int idAlumno, int idAsignatura) {
		dao.desmatricular(idAlumno, idAsignatura);
	}
	
	public Set<Alumno> getAlumnos(int idAsignatura) {
		return dao.getAlumnos(idAsignatura);
	}
	
	public Set<Evaluacion> getEvaluaciones(int idAsignatura, int idAlumno) {
		return dao.getEvaluaciones(idAsignatura, idAlumno);
	}
	
	public void addEvaluacion(String concepto, float nota, int idAsignatura, int idAlumno) {
		dao.addEvaluacion(concepto, nota, idAsignatura, idAlumno);
	}
	
	public List<Evaluacion> getEvaluacionesOrderedByAsignatura(int idAlumno) {
		return dao.getEvaluacionesOrderedByAsignatura(idAlumno);
	}
	
	public Alumno getAlumno(int id) {
		return dao.getAlumno(id);
	}
	
	public Asignatura getAsignatura(int id) {
		return dao.getAsignatura(id);
	}
	
	public Alumno loginAlumno(int dni, String password) throws UserNotFoundException, IncorrectPasswordException {
		return dao.loginAlumno(dni, password);
	}
	
	public Profesor loginProfesor(int dni, String password) throws UserNotFoundException, IncorrectPasswordException {
		return dao.loginProfesor(dni, password);
	}
	
	public Set<Asignatura> getAsignaturasProfesor(int idLecturer) {
		return dao.getAsignaturasProfesor(idLecturer);
	}
	
	public Profesor getProfesorByDni(int dni) throws UserNotFoundException {
		return dao.getProfesorByDni(dni);
	}
	
	
	public List<Evaluacion> getEvaluacionesAsignatura(int idAsignatura) {
		return dao.getEvaluacionesAsignatura(idAsignatura);
	}
}

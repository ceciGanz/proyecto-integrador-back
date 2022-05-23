package com.microservicio.app.test.backend.repository;

import java.util.List;

import com.microservicio.app.test.backend.entity.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservicio.app.test.backend.entity.CandidatoExperiencia;

@Repository
public interface CandidatoExperienciaRepository extends JpaRepository<CandidatoExperiencia, Long> {

	public List<CandidatoExperiencia> findByCandidato(Candidato candidadto);
}

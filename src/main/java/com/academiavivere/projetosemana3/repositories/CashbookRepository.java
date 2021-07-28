package com.academiavivere.projetosemana3.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.academiavivere.projetosemana3.entities.Cashbook;

public interface CashbookRepository extends JpaRepository<Cashbook, Integer> {

	public List<Cashbook> findByDataLancamentoBetween(Date dataLancamento, Date dataFinal);

	public List<Cashbook> findByClientId(Integer id);

	public List<Cashbook> findByClientIdAndDataLancamentoBetween(Integer id, Date dataLancamento, Date dataFinal);
}

package br.com.ideiascriativas.icbingo.repositories;

import br.com.ideiascriativas.icbingo.model.Bingo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BingoRepository extends JpaRepository<Bingo, Long> {
}

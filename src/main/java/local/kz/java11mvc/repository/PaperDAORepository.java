package local.kz.java11mvc.repository;

import local.kz.java11mvc.models.Paper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface PaperDAORepository extends JpaRepository<Paper, Long> {
}

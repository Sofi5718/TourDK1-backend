package template.springtemplate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import template.springtemplate.entity.ExampleEntity;

public interface ExampleEntityRepository extends JpaRepository<ExampleEntity, Integer> {
}

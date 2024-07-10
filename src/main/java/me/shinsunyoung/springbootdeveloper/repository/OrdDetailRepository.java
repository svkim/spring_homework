package me.shinsunyoung.springbootdeveloper.repository;

import me.shinsunyoung.springbootdeveloper.domain.OrdDetail;
import org.springframework.data.repository.CrudRepository;

public interface OrdDetailRepository extends CrudRepository<OrdDetail, Long> {
}

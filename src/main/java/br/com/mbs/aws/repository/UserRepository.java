package br.com.mbs.aws.repository;

import br.com.mbs.aws.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  UserRepository extends CrudRepository<User, Integer> {
}

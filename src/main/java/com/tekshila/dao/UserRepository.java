package com.tekshila.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.tekshila.domain.TekUser;

@Repository
public interface UserRepository extends MongoRepository<TekUser, String> {
       public TekUser findTekUserByUsername(String username);
       public boolean existsTekUserByUsernameAndPassword(String username, String password);
       public boolean existsTekUserByEmailAndPassword(String email, String password);
       public TekUser findTekUserByEmailAndPassword(String email, String password);
       public TekUser findTekUserByUserId(int userId);
       public TekUser findByUsername(String username);//used in spring security authentication

       TekUser findByEmail(String email); //find the user by his email id

}

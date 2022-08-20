package com.nextgen.movieAvailabilityAtTheatre.respository;

import com.nextgen.movieAvailabilityAtTheatre.model.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepository extends JpaRepository<UserCredentials,String> {
}

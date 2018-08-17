package com.jt.devicemanagement.user;

import com.jt.devicemanagement.user.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

//
//    @Query("select u from User u , Device d where u.devices = d and d.serialNumber = ?1")
//    List<User> getUserByDeviceSerialNumber(String serialNumber);

    @Query(value = "select u.* from User u, Device d  where d.user_id = u.id and d.serial_number = ?1", nativeQuery = true)
    Optional<User> getUserByDeviceSerialNumber(String serialNumber);

}

package com.project.repo;

import com.project.entities.Contact;
import com.project.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import jakarta.websocket.server.PathParam;
import java.util.List;

/**
 * @author Vikrant on 10-10-2023
 * @version V1.0
 * @Project SmartContactManager
 */
public interface ContactRepo extends JpaRepository <Contact, Integer> {

    @Query("from Contact as c WHERE c.user.id= :userId")
    Page<Contact> getContactsByUser(@PathParam("userId") int userId, Pageable pageable);

    //search
    List<Contact> findByNameContainingAndUser(String name, User user);

}

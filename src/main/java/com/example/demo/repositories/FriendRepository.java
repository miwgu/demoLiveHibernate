package com.example.demo.repositories;

import com.example.demo.models.Friend;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Miwa Guhrés
 * Date: 2021-04-15
 * Time: 10:46
 * Project: demoLiveHibernate
 * Copyright: MIT
 */
public interface FriendRepository extends CrudRepository<Friend,Integer> {
  List<Friend> findByName(String name);
  List<Friend> findByAddress(String address);
  List<Friend> findByTele(String tele);
  List<Friend> findByNameAndAddress(String name, String address);
  Friend findById (int id);
}

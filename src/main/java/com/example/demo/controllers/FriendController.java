package com.example.demo.controllers;

import com.example.demo.models.Friend;
import com.example.demo.repositories.FriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Miwa Guhrés
 * Date: 2021-04-15
 * Time: 11:20
 * Project: demoLiveHibernate
 * Copyright: MIT
 */
@RestController
@RequestMapping(path = "/friend")
public class FriendController {

    @Autowired
    private FriendRepository friendRepo;

    @GetMapping(path="/add")
    public  String addFriend(@RequestParam String name, @RequestParam String address, @RequestParam String tele){
        Friend f = new Friend();
        f.setName(name);
        f.setAddress(address);
        f.setTele(tele);
        friendRepo.save(f);
        return  "The friend was saved";
    }
    //http://localhost:8080/friend/add?name=Mika&address=osaka3&tele=3333333333

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Friend> getAllFriends(){
        return friendRepo.findAll();
    }
    //http://localhost:8080/friend/all

    @GetMapping(path="/find")
    public  @ResponseBody Iterable<Friend> getFriendByName_Adress_Tele(@RequestParam(required = false)String name,
                                                           @RequestParam(required = false)String address,
                                                           @RequestParam(required = false)String tele){
        if(name!=null&& address!=null){
            return friendRepo.findByNameAndAddress(name,address);
        }
        else if(name!=null){
            return  friendRepo.findByName(name);
        }
        else if(address!=null){
            return friendRepo.findByAddress(address);

        }else if(tele!=null){
            return friendRepo.findByTele(tele);
        }
        return null;
    }
    //http://localhost:8080/friend/find?name=Mika
    //http://localhost:8080/friend/find?name=Midori&address=alvgen4
    //http://localhost:8080/friend/find?tele=3333333333
    //http://localhost:8080/friend/find?address=takatsuki2 ->
}

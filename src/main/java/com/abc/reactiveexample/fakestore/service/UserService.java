package com.abc.reactiveexample.fakestore.service;

import com.abc.reactiveexample.fakestore.entity.Address;
import com.abc.reactiveexample.fakestore.entity.User;
import com.abc.reactiveexample.fakestore.vo.AddressVO;
import com.abc.reactiveexample.fakestore.vo.Geolocation;
import com.abc.reactiveexample.fakestore.vo.Name;
import com.abc.reactiveexample.fakestore.vo.UserVO;
import com.abc.reactiveexample.fakestore.repo.AddressRepository;
import com.abc.reactiveexample.fakestore.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressRepository addressRepository;

    public List<UserVO> getUsers(){
       return userRepository.findAll().stream().map(user -> {
           UserVO userVO = new UserVO();
           userVO.setId(user.getId());
           Name name = new Name();
           name.setFirstname(user.getFirstname());
           name.setLastname(user.getLastname());
           userVO.setName(name);
           userVO.setEmail(user.getEmail());
           userVO.setPassword(user.getPassword());
           userVO.setPhone(user.getPhone());
           userVO.set__v(user.get__v());
           userVO.setName(name);

           AddressVO addressVO = new AddressVO();
           addressVO.setNumber(user.getId());
           addressVO.setCity(user.getAddress().getCity());
           addressVO.setZipcode(user.getAddress().getZipcode());
           Geolocation geolocation = new Geolocation();
           geolocation.setLat(user.getAddress().getLatitude());
           geolocation.setMylong(user.getAddress().getLongitude());
           addressVO.setGeolocation(geolocation);
           addressVO.setStreet(user.getAddress().getStreet());

           userVO.setAddress(addressVO);
           return  userVO;
       }).collect(Collectors.toList());
    }

    public UserVO getUserById(Integer userId) {
         UserVO userVO = new UserVO();
         userRepository.findById(userId).ifPresent( user -> {
            userVO.setId(user.getId());
            Name name = new Name();
            name.setFirstname(user.getFirstname());
             name.setLastname(user.getLastname());
             userVO.setEmail(user.getEmail());
             userVO.setUsername(user.getUsername());
             userVO.setPassword(user.getPassword());
             userVO.setPhone(user.getPhone());
             userVO.set__v(user.get__v());
             userVO.setName(name);

             AddressVO addressVO = new AddressVO();
             addressVO.setNumber(user.getId());
             addressVO.setCity(user.getAddress().getCity());
             addressVO.setZipcode(user.getAddress().getZipcode());
             Geolocation geolocation = new Geolocation();
             geolocation.setLat(user.getAddress().getLatitude());
             geolocation.setMylong(user.getAddress().getLongitude());
             addressVO.setGeolocation(geolocation);
             addressVO.setStreet(user.getAddress().getStreet());

             userVO.setAddress(addressVO);

        });
         return userVO;

    }

    @Transactional
    public UserVO createOrUpdate(UserVO userVO) {
        User user = new User();
        user.setFirstname(userVO.getName().getFirstname());
        user.setLastname(userVO.getName().getLastname());
        user.setEmail(userVO.getEmail());
        userVO.setUsername(user.getUsername());
        user.setPassword(userVO.getPassword());
        user.setPhone(userVO.getPhone());
        user.set__v(userVO.get__v());

        Address address = new Address();
        address.setCity(userVO.getAddress().getCity());
        address.setStreet(userVO.getAddress().getStreet());
        address.setZipcode(userVO.getAddress().getZipcode());
        address.setLongitude(userVO.getAddress().getGeolocation().getMylong());
        address.setLatitude(userVO.getAddress().getGeolocation().getLat());
        user.setAddress(address);

        userRepository.save(user);

        userVO.setId(user.getId());
       return  userVO;
    }

    @Transactional
    public void deleteUser(Integer userId) {
        try {
            userRepository.deleteById(userId);
        }catch (EmptyResultDataAccessException exception){
            throw new RuntimeException("no user found with given user id");
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }

    }
}

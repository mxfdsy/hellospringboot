package com.coding.hellospringboot.respository;

import com.coding.hellospringboot.domain.User;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * {@link com.coding.hellospringboot.domain.User} {@link UserRespository}
 * Created by 平凡的世界 on 2018/4/26.
 */
@Repository
public class UserRespository {

    /**
     * 采用内存型的存储方式->map
     */
    private  final ConcurrentHashMap<Integer,User>  reponsitory
    = new ConcurrentHashMap<>();
    /**
     * 自增长的id
     */
    private final static AtomicInteger idGenerator =
            new AtomicInteger();
    /**
     * 保存用户对象
     *@param  user{@link User} 对象
     * @return  如果保存成功，返回 true
     * 否则 false
     */
    public  boolean save(User user){
        boolean sucess = false;
        //id从一开始
        Integer id = idGenerator.incrementAndGet();
        //保存id
        user.setId(id);
        return  reponsitory.put(id, user)== null;

    }
}

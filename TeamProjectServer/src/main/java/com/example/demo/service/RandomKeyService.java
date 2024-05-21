package com.example.demo.service;

import com.example.demo.mapper.RandomKeyMapper;
import com.example.demo.model.RandomKey;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RandomKeyService {
   
    private final RandomKeyMapper randomKeyMapper;

    public RandomKeyService(RandomKeyMapper randomKeyMapper) {
        this.randomKeyMapper = randomKeyMapper;
    }

    public void createAndStoreRandomKey(String lectureCode, String randomKey) {
        randomKeyMapper.insertRandomKey(lectureCode, randomKey);
    }

    public RandomKey getRandomKeyById(Integer randomKeyId) {
        return randomKeyMapper.getRandomKeyById(randomKeyId);
    }

    public void updateRandomKeyUsedStatus(Integer randomKeyId, Boolean used) {
        randomKeyMapper.updateRandomKeyUsedStatus(randomKeyId, used);
    }

    public void deleteRandomKey(Integer randomKeyId) {
        randomKeyMapper.deleteRandomKey(randomKeyId);
    }
    
    public RandomKey getLectureRk(String lectureCode) {
        return randomKeyMapper.getLectureRk(lectureCode);
    }
    
    public String makeRK() {
    	
    	int leftLimit = 48; // 0
        int rightLimit = 122; // z
        int targetStringLength = 8;
        Random random = new Random();
        String generatedString = random.ints(leftLimit, rightLimit + 1)
                                       .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                                       .limit(targetStringLength)
                                       .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                                       .toString();
    	return generatedString;
    	
    }
}

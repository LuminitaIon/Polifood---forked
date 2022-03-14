package com.poliFood.dto.convertor;

import com.poliFood.dto.UserDTO;
import com.poliFood.dto.UserLoginDTO;
import com.poliFood.model.User;
import com.poliFood.repository.UserRepository;
import org.modelmapper.ModelMapper;

import java.text.ParseException;

public class UserConvertor {
    private static ModelMapper modelMapper;
    private static UserRepository userRepository;

    public static User convertToEntity(UserDTO userDTO) throws ParseException {
        return modelMapper.map(userDTO, User.class);
    }

    public static UserDTO convertToDto(User user){
        return modelMapper.map(user, UserDTO.class);
    }

    public static User convertUserLoginToEntity(UserLoginDTO userLoginDTO) throws ParseException{
        return userRepository.findByEmail(userLoginDTO.getEmail());
    }
}

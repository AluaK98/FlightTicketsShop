package kz.g134.FlightTicketsShop.service;

import kz.g134.FlightTicketsShop.dto.request.UserRegisterRequestDTO;

public interface RegisterService {
    Void registerUser(UserRegisterRequestDTO request);
}

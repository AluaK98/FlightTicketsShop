package kz.g134.FlightTicketsShop.service;

import kz.g134.FlightTicketsShop.dto.request.ForgetPasswordDTO;

public interface ChangePasswordService {
    Void changePassword(ForgetPasswordDTO dto);

}

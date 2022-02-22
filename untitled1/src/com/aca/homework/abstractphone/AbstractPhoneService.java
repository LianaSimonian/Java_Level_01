package com.aca.homework.abstractphone;

public abstract class AbstractPhoneService {
    public abstract Phone create(String imei, Model model);

    public abstract Phone getByImei(String imei);
}

package spring.boot.dynamicdatasource.dao.model;

import java.io.Serializable;

/**
 * Created by 顷强强 on 2018/3/5.
 */
public class AppointmentStoreAreaBean implements Serializable {

    private static final long serialVersionUID = -1671407263537486246L;


    private Long appointmentClassId;

    private Long storeAreaId;

    /**
     * 地址
     */
    private String address;

    /**
     * 经度
     */
    private Float longitude;

    /**
     * 纬度
     */
    private Float latitude;


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Long getAppointmentClassId() {
        return appointmentClassId;
    }

    public void setAppointmentClassId(Long appointmentClassId) {
        this.appointmentClassId = appointmentClassId;
    }

    public Long getStoreAreaId() {
        return storeAreaId;
    }

    public void setStoreAreaId(Long storeAreaId) {
        this.storeAreaId = storeAreaId;
    }
}

package spring.boot.dynamicdatasource.dao.model;

import java.io.Serializable;

/**
 * Created by 顷强强 on 2018/3/5.
 */
public class QueryClassInfoDao implements Serializable {

    private static final long serialVersionUID = 265654325424L;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 用户昵称
     */
    private String userNick;

    /**
     * 用户权益id
     */
    private Long userAvailId;
    /**
     * 用户手机
     */
    private String userMobile;


    /**
     * 教练花名
     */
    private String coachStageName;

    /**
     * 教练登录手机号
     */
    private String coachLoginMobile;
    /**
     * 教练id
     */
    private Long coachId;
    /**
     * 教练id
     */
    private Long lessonId;

    /**
     * 城市id
     */
    private Integer cityId;

    /**
     * 场地id
     */
    private Long storeAreaId;

    /**
     * 场地ids
     */
    private String storeAreaIds;
    /**
     * 课程状态
     */
    private Integer status;

    /**
     * 当前页面起始记录行数（第一页从0开始）
     */
    private Integer start;
    /**
     * 分页size
     */
    private  Integer pageSize;

    /**
     * 查询日期（开始时间）
     */
    private Integer dateTimeBegin;

    /**
     * 查询日期（结束时间）
     */
    private Integer dateTimeEnd;


    public String getStoreAreaIds() {
        return storeAreaIds;
    }

    public void setStoreAreaIds(String storeAreaIds) {
        this.storeAreaIds = storeAreaIds;
    }

    public Long getLessonId() {
        return lessonId;
    }

    public void setLessonId(Long lessonId) {
        this.lessonId = lessonId;
    }

    public Long getUserAvailId() {
        return userAvailId;
    }

    public void setUserAvailId(Long userAvailId) {
        this.userAvailId = userAvailId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getDateTimeBegin() {
        return dateTimeBegin;
    }

    public void setDateTimeBegin(Integer dateTimeBegin) {
        this.dateTimeBegin = dateTimeBegin;
    }

    public Integer getDateTimeEnd() {
        return dateTimeEnd;
    }

    public void setDateTimeEnd(Integer dateTimeEnd) {
        this.dateTimeEnd = dateTimeEnd;
    }

    public String getUserNick() {
        return userNick;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getCoachStageName() {
        return coachStageName;
    }

    public void setCoachStageName(String coachStageName) {
        this.coachStageName = coachStageName;
    }

    public String getCoachLoginMobile() {
        return coachLoginMobile;
    }

    public void setCoachLoginMobile(String coachLoginMobile) {
        this.coachLoginMobile = coachLoginMobile;
    }

    public Long getCoachId() {
        return coachId;
    }

    public void setCoachId(Long coachId) {
        this.coachId = coachId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Long getStoreAreaId() {
        return storeAreaId;
    }

    public void setStoreAreaId(Long storeAreaId) {
        this.storeAreaId = storeAreaId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}

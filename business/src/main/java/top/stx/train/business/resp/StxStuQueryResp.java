package top.stx.train.business.resp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

public class StxStuQueryResp {

    /**
    * 
    */
        @JsonSerialize(using= ToStringSerializer.class)
    private String id;

    /**
    * 
    */
    private String account;

    /**
    * 
    */
    private String mobile;

    /**
    * 
    */
    private String nickname;

    /**
    * 
    */
    private String avatar;

    /**
    * 
    */
    private String description;

    /**
    * 
    */
    private String homepage;

    /**
    * 
    */
    private String skill;

    /**
    * 
    */
    private String createTime;

    /**
    * 
    */
    private String updateTime;


    public String getId() {
    return id;
    }

    public void setId(String id) {
    this.id = id;
    }

    public String getAccount() {
    return account;
    }

    public void setAccount(String account) {
    this.account = account;
    }

    public String getMobile() {
    return mobile;
    }

    public void setMobile(String mobile) {
    this.mobile = mobile;
    }

    public String getNickname() {
    return nickname;
    }

    public void setNickname(String nickname) {
    this.nickname = nickname;
    }

    public String getAvatar() {
    return avatar;
    }

    public void setAvatar(String avatar) {
    this.avatar = avatar;
    }

    public String getDescription() {
    return description;
    }

    public void setDescription(String description) {
    this.description = description;
    }

    public String getHomepage() {
    return homepage;
    }

    public void setHomepage(String homepage) {
    this.homepage = homepage;
    }

    public String getSkill() {
    return skill;
    }

    public void setSkill(String skill) {
    this.skill = skill;
    }

    public String getCreateTime() {
    return createTime;
    }

    public void setCreateTime(String createTime) {
    this.createTime = createTime;
    }

    public String getUpdateTime() {
    return updateTime;
    }

    public void setUpdateTime(String updateTime) {
    this.updateTime = updateTime;
    }

@Override
public String toString() {
StringBuilder sb = new StringBuilder();
sb.append(getClass().getSimpleName());
sb.append(" [");
sb.append("Hash = ").append(hashCode());
    sb.append(", id=").append(id);
    sb.append(", account=").append(account);
    sb.append(", mobile=").append(mobile);
    sb.append(", nickname=").append(nickname);
    sb.append(", avatar=").append(avatar);
    sb.append(", description=").append(description);
    sb.append(", homepage=").append(homepage);
    sb.append(", skill=").append(skill);
    sb.append(", createTime=").append(createTime);
    sb.append(", updateTime=").append(updateTime);
sb.append("]");
return sb.toString();
}
}

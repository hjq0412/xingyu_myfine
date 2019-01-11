package cn.xingyu.myfine.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author You
 * @since 2019-01-08
 */
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键列
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户唯一标识串
     */
    @TableField("userUnionId")
    private String userUnionId;

    /**
     * 用户昵称
     */
    @TableField("userNickName")
    private String userNickName;

    /**
     * 用户总积分
     */
    @TableField("totalIntegral")
    private Long totalIntegral;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getUserUnionId() {
        return userUnionId;
    }

    public void setUserUnionId(String userUnionId) {
        this.userUnionId = userUnionId;
    }
    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }
    public Long getTotalIntegral() {
        return totalIntegral;
    }

    public void setTotalIntegral(Long totalIntegral) {
        this.totalIntegral = totalIntegral;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "User{" +
        "id=" + id +
        ", userUnionId=" + userUnionId +
        ", userNickName=" + userNickName +
        ", totalIntegral=" + totalIntegral +
        "}";
    }
}

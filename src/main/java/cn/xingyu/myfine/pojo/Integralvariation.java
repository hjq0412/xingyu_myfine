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
public class Integralvariation extends Model<Integralvariation> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键列
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;


    /**
     * 用户id
     */
    @TableField("userId")
    private Long userId;

    /**
     * 积分变动备注
     */
    private String remark;

    /**
     * 类型
     */
    @TableField("type")
    private Integer type;


    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Integralvariation{" +
                "id=" + id +
                ", userId=" + userId +
                ", remark=" + remark +
                "}";
    }
}

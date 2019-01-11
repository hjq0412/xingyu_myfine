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
     * 增加
     */
    private Long increase;

    /**
     * 减少
     */
    private Long reduce;

    /**
     * 用户id
     */
    @TableField("userId")
    private Long userId;

    /**
     * 积分变动备注
     */
    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getIncrease() {
        return increase;
    }

    public void setIncrease(Long increase) {
        this.increase = increase;
    }
    public Long getReduce() {
        return reduce;
    }

    public void setReduce(Long reduce) {
        this.reduce = reduce;
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
        ", increase=" + increase +
        ", reduce=" + reduce +
        ", userId=" + userId +
        ", remark=" + remark +
        "}";
    }
}

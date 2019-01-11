package cn.xingyu.myfine.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDate;
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
public class Evaluate extends Model<Evaluate> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键列
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商品id
     */
    @TableField("productId")
    private Long productId;

    /**
     * 用户id
     */
    @TableField("userId")
    private Long userId;

    /**
     * 评价时间
     */
    @TableField("evaluateTime")
    private LocalDate evaluateTime;

    /**
     * 评价内容
     */
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public LocalDate getEvaluateTime() {
        return evaluateTime;
    }

    public void setEvaluateTime(LocalDate evaluateTime) {
        this.evaluateTime = evaluateTime;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Evaluate{" +
        "id=" + id +
        ", productId=" + productId +
        ", userId=" + userId +
        ", evaluateTime=" + evaluateTime +
        ", content=" + content +
        "}";
    }
}

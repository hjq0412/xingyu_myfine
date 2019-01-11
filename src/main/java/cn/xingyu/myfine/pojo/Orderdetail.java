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
public class Orderdetail extends Model<Orderdetail> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键列
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 订单id（外键）
     */
    @TableField("orderId")
    private Long orderId;

    /**
     * 商品id（外键）
     */
    @TableField("productId")
    private Long productId;

    /**
     * 购买商品的数量
     */
    @TableField("productNum")
    private Long productNum;

    /**
     * 订单总额
     */
    private Double total;

    /**
     * 订单付款状态1/2（付款/未付款）
     */
    @TableField("isPay")
    private Long isPay;

    /**
     * 订单运行状态 1/2（发货/未发货）
     */
    @TableField("isDelivery")
    private Long isDelivery;

    /**
     * 积分变动
     */
    @TableField("integralVariation")
    private Long integralVariation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
    public Long getProductNum() {
        return productNum;
    }

    public void setProductNum(Long productNum) {
        this.productNum = productNum;
    }
    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
    public Long getIsPay() {
        return isPay;
    }

    public void setIsPay(Long isPay) {
        this.isPay = isPay;
    }
    public Long getIsDelivery() {
        return isDelivery;
    }

    public void setIsDelivery(Long isDelivery) {
        this.isDelivery = isDelivery;
    }
    public Long getIntegralVariation() {
        return integralVariation;
    }

    public void setIntegralVariation(Long integralVariation) {
        this.integralVariation = integralVariation;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Orderdetail{" +
        "id=" + id +
        ", orderId=" + orderId +
        ", productId=" + productId +
        ", productNum=" + productNum +
        ", total=" + total +
        ", isPay=" + isPay +
        ", isDelivery=" + isDelivery +
        ", integralVariation=" + integralVariation +
        "}";
    }
}

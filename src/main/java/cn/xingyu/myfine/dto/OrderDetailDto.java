package cn.xingyu.myfine.dto;

/**
 * 订单详细
 * @author 何嘉琦
 * @date 2019-01-21-15:09
 */
public class OrderDetailDto {

    /**
     * 订单编号
     */
    private String orderNo;
    /**
     * 商品名称
     */
    private String productName;
    /**
     * 用户昵称
     */
    private String userNickName;
    /**
     * 收货地址
     */
    private String address;
    /**
     * 收货电话
     */
    private String phone;
    /**
     * 收货人
     */
    private String consignee;
    /**
     * 商品数量
     */
    private String productNum;
    /**
     * 订单总计
     */
    private Long total;
    /**
     * 积分变动
     */
    private Long integralVariation;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getIntegralVariation() {
        return integralVariation;
    }

    public void setIntegralVariation(Long integralVariation) {
        this.integralVariation = integralVariation;
    }
}

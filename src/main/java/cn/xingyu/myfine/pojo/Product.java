package cn.xingyu.myfine.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
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
public class Product extends Model<Product> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商品一级分类
     */
    @TableField("level1Id")
    private Long level1Id;

    /**
     * 商品二级分类
     */
    @TableField("level2Id")
    private Long level2Id;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品进价
     */
    private Double purchase;

    /**
     * 商品价格
     */
    private Double price;

    /**
     * 商品描述
     */
    private String description;

    /**
     * 商品规格（尺寸）
     */
    private String size;

    /**
     * 商品数量
     */
    private Long count;

    /**
     * 商品颜色
     */
    private String color;

    /**
     * 是否优惠 有则为具体优惠折数，无优惠则为0
     */
    @TableField("isDiscount")
    private Long isDiscount;

    /**
     * 商品图片位置
     */
    @TableField("fileAddress")
    private String fileAddress;

    /**
     * 上架时间
     */
    @TableField("launchTime")
    private LocalDateTime launchTime;

    /**
     * 是否删除 1/2（删除/存在）
     */
    @TableField("isDel")
    private Long isDel;

    /**
     * 购买次数
     */
    @TableField("buyCounts")
    private Long buyCounts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getLevel1Id() {
        return level1Id;
    }

    public void setLevel1Id(Long level1Id) {
        this.level1Id = level1Id;
    }
    public Long getLevel2Id() {
        return level2Id;
    }

    public void setLevel2Id(Long level2Id) {
        this.level2Id = level2Id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Double getPurchase() {
        return purchase;
    }

    public void setPurchase(Double purchase) {
        this.purchase = purchase;
    }
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public Long getIsDiscount() {
        return isDiscount;
    }

    public void setIsDiscount(Long isDiscount) {
        this.isDiscount = isDiscount;
    }
    public String getFileAddress() {
        return fileAddress;
    }

    public void setFileAddress(String fileAddress) {
        this.fileAddress = fileAddress;
    }
    public LocalDateTime getLaunchTime() {
        return launchTime;
    }

    public void setLaunchTime(LocalDateTime launchTime) {
        this.launchTime = launchTime;
    }
    public Long getIsDel() {
        return isDel;
    }

    public void setIsDel(Long isDel) {
        this.isDel = isDel;
    }
    public Long getBuyCounts() {
        return buyCounts;
    }

    public void setBuyCounts(Long buyCounts) {
        this.buyCounts = buyCounts;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Product{" +
        "id=" + id +
        ", level1Id=" + level1Id +
        ", level2Id=" + level2Id +
        ", name=" + name +
        ", purchase=" + purchase +
        ", price=" + price +
        ", description=" + description +
        ", size=" + size +
        ", count=" + count +
        ", color=" + color +
        ", isDiscount=" + isDiscount +
        ", fileAddress=" + fileAddress +
        ", launchTime=" + launchTime +
        ", isDel=" + isDel +
        ", buyCounts=" + buyCounts +
        "}";
    }
}

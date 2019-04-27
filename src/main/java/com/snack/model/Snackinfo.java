package com.snack.model;


import cn.afterturn.easypoi.excel.annotation.Excel;

public class Snackinfo {
    @Excel(name = "食品编号", needMerge = true)
    private Integer sId;

    private String sBatch;
    @Excel(name = "食品名称", needMerge = true)
    private String sName;
    @Excel(name = "食品价格", needMerge = true)
    private Double sPrice;
    @Excel(name = "折扣", needMerge = true)
    private String sDiscount;
    @Excel(name = "食品图片", needMerge = true)
    private String sPictureurl;
    @Excel(name = "食品品牌", needMerge = true)
    private String sBrand;
    @Excel(name = "食品产地", needMerge = true)
    private String sPlace;

    private Integer sImported;
    @Excel(name = "食品评分", needMerge = true)
    private Integer sScore;
    @Excel(name = "生产日期", format = "yyyy年MM月dd日HH时mm分ss秒", width = 50, needMerge = true)
    private String sPdate;
    @Excel(name = "保质期", format = "MM月")
    private String sQdate;

    private Integer state;
    @Excel(name = "入库日期", format = "yyyy年MM月dd日HH时mm分ss秒", width = 50, needMerge = true)
    private String sCreatedate;
    @Excel(name = "食品详情", needMerge = true)
    private String sDese;
    @Excel(name = "食品数量", needMerge = true)
    private Integer sNumber;
    @Excel(name = "食品类型", needMerge = true)
    private String sType;

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public String getsBatch() {
        return sBatch;
    }

    public void setsBatch(String sBatch) {
        this.sBatch = sBatch;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public Double getsPrice() {
        return sPrice;
    }

    public void setsPrice(Double sPrice) {
        this.sPrice = sPrice;
    }

    public String getsDiscount() {
        return sDiscount;
    }

    public void setsDiscount(String sDiscount) {
        this.sDiscount = sDiscount;
    }

    public String getsPictureurl() {
        return sPictureurl;
    }

    public void setsPictureurl(String sPictureurl) {
        this.sPictureurl = sPictureurl;
    }

    public String getsBrand() {
        return sBrand;
    }

    public void setsBrand(String sBrand) {
        this.sBrand = sBrand;
    }

    public String getsPlace() {
        return sPlace;
    }

    public void setsPlace(String sPlace) {
        this.sPlace = sPlace;
    }

    public Integer getsImported() {
        return sImported;
    }

    public void setsImported(Integer sImported) {
        this.sImported = sImported;
    }

    public Integer getsScore() {
        return sScore;
    }

    public void setsScore(Integer sScore) {
        this.sScore = sScore;
    }

    public String getsPdate() {
        return sPdate;
    }

    public void setsPdate(String sPdate) {
        this.sPdate = sPdate;
    }

    public String getsQdate() {
        return sQdate;
    }

    public void setsQdate(String sQdate) {
        this.sQdate = sQdate;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getsCreatedate() {
        return sCreatedate;
    }

    public void setsCreatedate(String sCreatedate) {
        this.sCreatedate = sCreatedate;
    }

    public String getsDese() {
        return sDese;
    }

    public void setsDese(String sDese) {
        this.sDese = sDese;
    }

    public Integer getsNumber() {
        return sNumber;
    }

    public void setsNumber(Integer sNumber) {
        this.sNumber = sNumber;
    }

    @Override
    public String toString() {
        return "Snackinfo [sId=" + sId + ", sBatch=" + sBatch + ", sName="
                + sName + ", sPrice=" + sPrice + ", sDiscount=" + sDiscount
                + ", sPictureurl=" + sPictureurl + ", sBrand=" + sBrand
                + ", sPlace=" + sPlace + ", sImported=" + sImported
                + ", sScore=" + sScore + ", sPdate=" + sPdate + ", sQdate="
                + sQdate + ", state=" + state + ", sCreatedate=" + sCreatedate
                + ", sDese=" + sDese + ", sNumber=" + sNumber + "]";
    }

    public String getsType() {
        return sType;
    }

    public void setsType(String sType) {
        this.sType = sType;
    }

}
package com.ycz.model.vo;

/**
 * @author admin
 */
public class RelationshipVoKey {
    private Integer aid;

    private Integer cid;

    public RelationshipVoKey() {
    }

    public RelationshipVoKey(Integer aid, Integer cid) {
        this.aid = aid;
        this.cid = cid;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }
}
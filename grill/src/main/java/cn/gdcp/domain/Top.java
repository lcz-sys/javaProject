package cn.gdcp.domain;

public class Top {

    private int id;//编号
    private int goodId;//商品编号

    private Good good;

    @Override
    public String toString() {
        return "Top{" +
                "id=" + id +
                ", goodId=" + goodId +
                ", good=" + good +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGoodId() {
        return goodId;
    }

    public void setGoodId(int goodId) {
        this.goodId = goodId;
    }

    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }
}

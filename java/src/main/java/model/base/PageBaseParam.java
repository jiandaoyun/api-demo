package model.base;

/**
 * 分页查询基参
 */
public class PageBaseParam {
    /**
     * 跳过数量
     */
    private Integer skip;
    /**
     * 查询数量
     */
    private Integer limit;

    public Integer getSkip() {
        return skip;
    }

    public void setSkip(Integer skip) {
        this.skip = skip;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public boolean isValid() {
        return this.getLimit() != null && this.getSkip() != null;
    }

    @Override
    public String toString() {
        return "PageBaseParam{" +
                "skip=" + skip +
                ", limit=" + limit +
                '}';
    }
}

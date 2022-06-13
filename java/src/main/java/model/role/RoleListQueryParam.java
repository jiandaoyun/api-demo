package model.role;


public class RoleListQueryParam {
    private Integer skip;
    private Integer limit;

    private boolean has_internal;
    private boolean has_sync;

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

    public boolean isHas_internal() {
        return has_internal;
    }

    public void setHas_internal(boolean has_internal) {
        this.has_internal = has_internal;
    }

    public boolean isHas_sync() {
        return has_sync;
    }

    public void setHas_sync(boolean has_sync) {
        this.has_sync = has_sync;
    }

    @Override
    public String toString() {
        return "RoleListQueryParam{" +
                "skip=" + skip +
                ", limit=" + limit +
                ", has_internal=" + has_internal +
                ", has_sync=" + has_sync +
                '}';
    }
}

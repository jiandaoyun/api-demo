package model.role;


import model.base.PageBaseParam;

public class RoleGroupListQueryParam extends PageBaseParam {
    private boolean has_internal;
    private boolean has_sync;

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
                "skip=" + super.getSkip() +
                ", limit=" + super.getLimit() +
                ", has_internal=" + has_internal +
                ", has_sync=" + has_sync +
                '}';
    }
}

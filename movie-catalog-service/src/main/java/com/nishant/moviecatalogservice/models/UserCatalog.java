package com.nishant.moviecatalogservice.models;

import java.util.List;

public class UserCatalog {

    private List<CatalogItem> userCatalog;

    public List<CatalogItem> getUserCatalog() {
        return userCatalog;
    }

    public void setUserCatalog(List<CatalogItem> userCatalog) {
        this.userCatalog = userCatalog;
    }
}

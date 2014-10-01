package com.lively.domain.entity;

import javax.persistence.MappedSuperclass;

/**
 * Created by franCiS on Sep 27, 2014.
 */

@MappedSuperclass
public abstract class MasterData extends AbstractEnhancedAuditable<Long> {
    private String number;
    private String code;
    private String name;
    private String alias;
    private String brief;
    private String searchText;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }
}

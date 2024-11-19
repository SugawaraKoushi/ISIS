package ru.bstu.itz212.fokin.lab5.utils;

import java.util.List;

public class CarSearchParams {
    private List<Integer> ids;
    private List<String> brands;
    private List<String> models;
    private List<String> colors;
    private List<String> licensePlates;
    private List<String> ownersLastNames;
    private List<String> ownersFirstNames;
    private List<String> ownersMiddleNames;

    public CarSearchParams() {

    }

    public CarSearchParams(List<Integer> ids, List<String> brands,
                           List<String> models, List<String> colors,
                           List<String> licensePlates, List<String> ownersLastNames,
                           List<String> ownersFirstNames, List<String> ownersMiddleNames) {
        this.ids = ids;
        this.brands = brands;
        this.models = models;
        this.colors = colors;
        this.licensePlates = licensePlates;
        this.ownersLastNames = ownersLastNames;
        this.ownersFirstNames = ownersFirstNames;
        this.ownersMiddleNames = ownersMiddleNames;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public List<String> getBrands() {
        return brands;
    }

    public void setBrands(List<String> brands) {
        this.brands = brands;
    }

    public List<String> getModels() {
        return models;
    }

    public void setModels(List<String> models) {
        this.models = models;
    }

    public List<String> getColors() {
        return colors;
    }

    public void setColors(List<String> colors) {
        this.colors = colors;
    }

    public List<String> getLicensePlates() {
        return licensePlates;
    }

    public void setLicensePlates(List<String> licensePlates) {
        this.licensePlates = licensePlates;
    }

    public List<String> getOwnersLastNames() {
        return ownersLastNames;
    }

    public void setOwnersLastNames(List<String> ownersLastNames) {
        this.ownersLastNames = ownersLastNames;
    }

    public List<String> getOwnersFirstNames() {
        return ownersFirstNames;
    }

    public void setOwnersFirstNames(List<String> ownersFirstNames) {
        this.ownersFirstNames = ownersFirstNames;
    }

    public List<String> getOwnersMiddleNames() {
        return ownersMiddleNames;
    }

    public void setOwnersMiddleNames(List<String> ownersMiddleNames) {
        this.ownersMiddleNames = ownersMiddleNames;
    }
}

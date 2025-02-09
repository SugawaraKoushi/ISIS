/**
 * CarSearchParams
 *
 * version 1.0
 *
 * (с) Фокин Владислав
 */

package ru.bstu.itz212.fokin.lab5.utils;

import java.util.List;

/**
 * Параметры поиска сущности автомобиля в БД
 */
public class CarSearchParams {
    private List<Integer> ids;
    private List<String> brands;
    private List<String> models;
    private List<String> colors;
    private List<String> licensePlates;
    private List<String> ownersLastNames;
    private List<String> ownersFirstNames;
    private List<String> ownersMiddleNames;

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

    public List<String> getBrands() {
        return brands;
    }

    public List<String> getModels() {
        return models;
    }

    public List<String> getColors() {
        return colors;
    }

    public List<String> getLicensePlates() {
        return licensePlates;
    }

    public List<String> getOwnersLastNames() {
        return ownersLastNames;
    }

    public List<String> getOwnersFirstNames() {
        return ownersFirstNames;
    }

    public List<String> getOwnersMiddleNames() {
        return ownersMiddleNames;
    }
}

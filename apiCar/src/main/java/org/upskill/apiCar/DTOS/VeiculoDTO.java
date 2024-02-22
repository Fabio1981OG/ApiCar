package org.upskill.apiCar.DTOS;


import org.upskill.apiCar.models.Color;
import org.upskill.apiCar.models.Condition;
import org.upskill.apiCar.models.FuelType;
import org.upskill.apiCar.models.Type;

public class VeiculoDTO {

    private Long id;
    private String licensePlate;
    private int numberOfSeats;
    private int doors;
    private Color color;
    private Type type;
    private FuelType fuelType;
    private Condition condition;
    public String getLicensePlate() {
        return licensePlate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

}

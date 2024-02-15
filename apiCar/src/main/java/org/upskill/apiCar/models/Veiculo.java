package org.upskill.apiCar.models;

import jakarta.persistence.*;

/**
 * Entidade que representa um veículo.
 */
@Entity
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String licensePlate; // Placa do veículo
    private int numberOfSeats;  // Número de assentos
    private int doors;          // Número de portas

    @Enumerated(EnumType.STRING)
    private Color color;        // Cor do veículo

    @Enumerated(EnumType.STRING)
    private Type type;          // Tipo de veículo

    @Enumerated(EnumType.STRING)
    private FuelType fuelType;  // Tipo de combustível

    @Enumerated(EnumType.STRING)
    private Condition condition; // Condição do veículo

    // Construtor vazio
    public Veiculo() {
    }

    // Construtor com todos os campos
    public Veiculo(String licensePlate, int numberOfSeats, int doors, Color color, Type type, FuelType fuelType, Condition condition) {
        this.licensePlate = licensePlate;
        this.numberOfSeats = numberOfSeats;
        this.doors = doors;
        this.color = color;
        this.type = type;
        this.fuelType = fuelType;
        this.condition = condition;
    }

    // Getters e Setters

    /**
     * Obtém o ID do veículo.
     * @return O ID do veículo.
     */
    public Long getId() {
        return id;
    }

    /**
     * Define o ID do veículo.
     * @param id O ID do veículo.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtém a placa do veículo.
     * @return A placa do veículo.
     */
    public String getLicensePlate() {
        return licensePlate;
    }

    /**
     * Define a placa do veículo.
     * @param licensePlate A placa do veículo.
     */
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    /**
     * Obtém o número de assentos do veículo.
     * @return O número de assentos do veículo.
     */
    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    /**
     * Define o número de assentos do veículo.
     * @param numberOfSeats O número de assentos do veículo.
     */
    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    /**
     * Obtém o número de portas do veículo.
     * @return O número de portas do veículo.
     */
    public int getDoors() {
        return doors;
    }

    /**
     * Define o número de portas do veículo.
     * @param doors O número de portas do veículo.
     */
    public void setDoors(int doors) {
        this.doors = doors;
    }

    /**
     * Obtém a cor do veículo.
     * @return A cor do veículo.
     */
    public Color getColor() {
        return color;
    }

    /**
     * Define a cor do veículo.
     * @param color A cor do veículo.
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Obtém o tipo de veículo.
     * @return O tipo de veículo.
     */
    public Type getType() {
        return type;
    }

    /**
     * Define o tipo de veículo.
     * @param type O tipo de veículo.
     */
    public void setType(Type type) {
        this.type = type;
    }

    /**
     * Obtém o tipo de combustível do veículo.
     * @return O tipo de combustível do veículo.
     */
    public FuelType getFuelType() {
        return fuelType;
    }

    /**
     * Define o tipo de combustível do veículo.
     * @param fuelType O tipo de combustível do veículo.
     */
    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    /**
     * Obtém a condição do veículo.
     * @return A condição do veículo.
     */
    public Condition getCondition() {
        return condition;
    }

    /**
     * Define a condição do veículo.
     * @param condition A condição do veículo.
     */
    public void setCondition(Condition condition) {
        this.condition = condition;
    }
}

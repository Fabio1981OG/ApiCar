package org.upskill.apiCar.models;


import jakarta.persistence.*;
import org.upskill.apiCar.DTOS.VeiculoDTO;

@Entity
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String licensePlate;
    private int numberOfSeats;
    private int doors;


    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;

    @Enumerated(EnumType.STRING)
    private Color color;

    @Enumerated(EnumType.STRING)
    private Type type;

    @Enumerated(EnumType.STRING)
    private FuelType fuelType;

    @Enumerated(EnumType.STRING)
    private Condition condition;


    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
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

    public Veiculo() {
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "licensePlate='" + licensePlate + '\'' +
                ", numberOfSeats=" + numberOfSeats +
                ", doors=" + doors +
                ", color=" + color +
                ", type=" + type +
                ", fuelType=" + fuelType +
                ", condition=" + condition +
                '}';
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Seller getSeller(){
        return  seller;
    }

    public void setSeller(Seller seller){
        this.seller = seller;
    }


    public VeiculoDTO toDTO() {
        VeiculoDTO veiculoDTO = new VeiculoDTO();
        veiculoDTO.setId(this.id);
        veiculoDTO.setLicensePlate(this.licensePlate);
        veiculoDTO.setNumberOfSeats(this.numberOfSeats);
        veiculoDTO.setDoors(this.doors);
        veiculoDTO.setColor(this.color);
        veiculoDTO.setType(this.type);
        veiculoDTO.setFuelType(this.fuelType);
        veiculoDTO.setCondition(this.condition);

        return veiculoDTO;
    }

    public static Veiculo fromDTO(VeiculoDTO veiculoDTO) {
        Veiculo veiculo = new Veiculo();

        veiculo.setLicensePlate(veiculoDTO.getLicensePlate());
        veiculo.setNumberOfSeats(veiculoDTO.getNumberOfSeats());
        veiculo.setDoors(veiculoDTO.getDoors());
        veiculo.setColor(veiculoDTO.getColor());
        veiculo.setType(veiculoDTO.getType());
        veiculo.setFuelType(veiculoDTO.getFuelType());
        veiculo.setCondition(veiculoDTO.getCondition());


        return veiculo;
    }


}